package sync.spctrum.apispring.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sync.spctrum.apispring.service.treino.TreinoService;
import sync.spctrum.apispring.service.treino.dto.modelMapper.TreinoMapper;
import sync.spctrum.apispring.service.treino.dto.treino.TreinoCountDTO;
import sync.spctrum.apispring.service.treino.dto.treino.TreinoCreateDTO;
import sync.spctrum.apispring.service.treino.dto.treino.TreinoResponseDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/treinos")
@SecurityRequirement(name = "Bearer")
public class TreinoController {

    private final TreinoService treinoService;

    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @ApiResponse(responseCode = "200", description = "Listagem de todos os treinos")
    @GetMapping
    public ResponseEntity<List<TreinoResponseDTO>> getListarTudo() {
        List<TreinoResponseDTO> treinos = TreinoMapper.toListRespostaDTO(treinoService.findAll());
        return !treinos.isEmpty() ? ResponseEntity.status(200).body(treinos) : ResponseEntity.status(204).build();
    }

    @ApiResponse(responseCode = "200", description = "Listagem de todos os treinos")
    @GetMapping(value = "verificar/{id}")
    public ResponseEntity<Boolean> getVerificarDia(@PathVariable Long id) {
        return ResponseEntity.status(200).body(treinoService.findByTreinoAndUser(id));
    }

    @ApiResponse(responseCode = "200", description = "Verifica o treino diario")
    @GetMapping(value = "validar/{id}")
    public ResponseEntity<TreinoResponseDTO> getVerificarTreino(@PathVariable Long id) {
        return ResponseEntity.status(200).body(TreinoMapper.toRespostaDTO(treinoService.existsByDataTreinoAndId(id)));
    }

    @ApiResponse(responseCode = "200", description = "Listagem de todos os treinos por usuario")
    @GetMapping(value = "/usuario/{id}")
    public ResponseEntity<List<TreinoResponseDTO>> getListarTudoPorId(@PathVariable Long id) {
        List<TreinoResponseDTO> treinos = TreinoMapper.toListRespostaDTO(treinoService.findAllByUsuarioId(id));
        return !treinos.isEmpty() ? ResponseEntity.status(200).body(treinos) : ResponseEntity.status(204).build();
    }

    @GetMapping("/por-dia-da-semana/{id}")
    public ResponseEntity<List<TreinoCountDTO>> getTreinosPorDiaDaSemana(@PathVariable Long id) {
        return ResponseEntity.status(200).body(treinoService.getTreinosPorDiaDaSemana(id));
    }
    @ApiResponse(responseCode = "200", description = "Listagem de todos os treinos por em um determinado dia do usuario")
    @GetMapping(value = "/usuario/dia-atual/{id}")
    public ResponseEntity<List<TreinoResponseDTO>> getListarTudoPorDiaEId(@PathVariable Long id) {
        List<TreinoResponseDTO> treinos = TreinoMapper.toListRespostaDTO(treinoService.findByDataTreinoAndUsuarioId(id));
        return !treinos.isEmpty() ? ResponseEntity.status(200).body(treinos) : ResponseEntity.status(204).build();
    }

    @ApiResponse(responseCode = "200", description = "Treino encontrado com sucesso.")
    @GetMapping(value = "/{id}")
    public ResponseEntity<TreinoResponseDTO> getTreinoPorId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(TreinoMapper.toRespostaDTO(treinoService.findById(id)));
    }

    @ApiResponse(responseCode = "200", description = "Cadastrar treino")
    @PostMapping
    public ResponseEntity<TreinoResponseDTO> postTreino(@RequestBody TreinoCreateDTO treinoCreateDTO) {
        return ResponseEntity.status(201).body(TreinoMapper.toRespostaDTO(treinoService.save(TreinoMapper.toEntity(treinoCreateDTO), treinoCreateDTO.getUsuarioId())));
    }

    @ApiResponse(responseCode = "200", description = "Atualizar status treino")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TreinoResponseDTO> putStatusTreino(@PathVariable Long id) {
        return ResponseEntity.status(201).body(TreinoMapper.toRespostaDTO(treinoService.putStatusTreino(id)));
    }
}
