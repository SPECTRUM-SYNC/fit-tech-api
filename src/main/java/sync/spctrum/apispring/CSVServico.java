package sync.spctrum.apispring;

import sync.spctrum.apispring.domain.Usuario.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;

public class CSVServico {
    public FileWriter gravaArquivoCsv (List<Usuario> usuarioResponseDTOS, String nomeArq) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            erro.printStackTrace();
            System.exit(1);
        }

        try {
            for (Usuario usuario : usuarioResponseDTOS) {
                saida.format("%d;%s;%s;%s;%s;%s;%s;%s;%s;%b\n",
                        usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(),
                        usuario.getDataNascimento(), usuario.getGenero(), usuario.getPeso(),
                        usuario.getNivelCondicao(), usuario.getContaAtiva(), usuario.getObjetivo());
            }
        }
        catch (FormatterClosedException erro) {
            erro.printStackTrace();
            deuRuim= true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {

                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
        return arq;
    }
}
