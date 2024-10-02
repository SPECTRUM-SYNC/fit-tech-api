package sync.spctrum.apispring.service.receita;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sync.spctrum.apispring.domain.Receita.Receita;
import sync.spctrum.apispring.domain.Receita.repository.ReceitaRepository;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.service.dallE.ImageGenerator;
import sync.spctrum.apispring.service.dallE.dto.ImageRequest;
import sync.spctrum.apispring.service.usuario.dto.modelMapper.UsuarioMapper;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReceitaService {

    private final UsuarioRepository usuarioRepository;
    private final ReceitaRepository receitaRepository;
    private final Gson gson;

    @Value("${spring.cloud.azure.storage.blob.container-name}")
    private String containerName;

    @Value("${azure.blob-storage.connection-string}")
    private String connectionString;

    private BlobServiceClient blobServiceClient;


    private final ImageGenerator imageGenerator;

    @PostConstruct
    public void init() {
        blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
    }


    public Receita desserializarReceita(String json) {
        return gson.fromJson(json, Receita.class);
    }

    public List<Receita> desserializarListaReceitas(String json) {
        Type listType = new TypeToken<List<Receita>>() {
        }.getType();
        return gson.fromJson(json, listType);
    }

    public List<Receita> desserializarListaReceitas(String json, Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFound("ID : " + id));
        UsuarioResponseDTO response = UsuarioMapper.toRespostaDTO(usuario);
        List<Receita> receitas = desserializarListaReceitas(json);

        if (receitas.isEmpty()) {
            throw new ResourceNotFound("Nenhuma receita encontrada para o JSON fornecido");
        }

        for (Receita receita : receitas) {
            receita.setUsuario(UsuarioMapper.toEntity(response));
        }
        return receitas;
    }

    public Receita desserializarReceitaExtra(String json, Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFound("ID : " + id));
        UsuarioResponseDTO response = UsuarioMapper.toRespostaDTO(usuario);

        JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
        if (jsonArray.isEmpty()) {
            throw new ResourceNotFound("Nenhum objeto encontrado no JSON fornecido");
        }

        JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
        Receita receita = gson.fromJson(jsonObject, Receita.class);

        receita.setDataCriacao(LocalDate.now());
        receita.setUsuario(UsuarioMapper.toEntity(response));
        receita.setQtdSelecionada(1);
        try {
            String imageUrl = cadastrarImage(receita);
            receita.setImage(imageUrl);
        } catch (IOException e) {
            log.error("Erro ao atualizar imagem da receita. Detalhes: {}", e.getMessage(), e);
        }

        return receitaRepository.save(receita);
    }

    public String cadastrarImage(Receita receita) throws IOException {
        String blobFileName = StringUtils.cleanPath(String.format("%s.png", receita.getNome()));
        BlobClient blobClient = blobServiceClient.getBlobContainerClient(containerName).getBlobClient(blobFileName);

        ImageRequest imageRequest = new ImageRequest(receita.getNome(), 1, "512x512");
        String imageUrl = imageGenerator.generateImage(imageRequest);

        if (imageUrl != null) {
            BufferedImage image = ImageIO.read(new URL(imageUrl));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            byte[] imageData = baos.toByteArray();

            try (InputStream imageStream = new ByteArrayInputStream(imageData)) {
                blobClient.upload(imageStream, imageData.length, true);
            }

            return blobClient.getBlobUrl();
        } else {
            return null;
        }
    }


    public List<Receita> findByReceitasWhereUsuarioId(Long id) {
        return receitaRepository.findAllByUsuario_IdAndDataCriacao(id, LocalDate.now());
    }
}
