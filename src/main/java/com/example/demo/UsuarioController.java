package com.example.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    List<Usuario> usuarios = new ArrayList<>();
    private int id;

    //Buscar Usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>>listar() {
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuarios);
    }

    //Buscar Usuarios - Ordem Alfabética:
    //http://localhost:8080/usuarios/ordemAlfabetica
    @GetMapping("/ordemAlfabetica")
    public ResponseEntity<List<Usuario>>listarOrdemAlfabetica() {

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        Collections.sort(usuarios, Comparator.comparing(Usuario::getNome));
        return ResponseEntity.status(200).body(usuarios);
    }

    //Buscar Usuarios - por status do Usuario:
    //http://localhost:8080/usuarios/statusUsuario/true
    //http://localhost:8080/usuarios/statusUsuario/false
    @GetMapping("/statusUsuario/{contaAtiva}")
    public ResponseEntity<List<Usuario>>listarStatusUsuario(@PathVariable Boolean contaAtiva) {
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        List<Usuario> usuariosFiltrados = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getContaAtiva() == contaAtiva) {
                usuariosFiltrados.add(usuario);
            }
        }

        if (usuariosFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(usuariosFiltrados);
    }

    //Cadastrar
    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {

        if (emailExiste(usuario.getEmail())) { // Verificar se a já existe Email
            return ResponseEntity.status(409).build();
        }

        if (emailValido(usuario.getEmail())){ // Verificar se email possui "@"
            return ResponseEntity.status(409).build();
        }
        usuario.setContaAtiva(true);
        usuario.setId(++id);
        usuarios.add(usuario);
        return ResponseEntity.status(201).body(usuario);
    }

    //Atualizar
    //http://localhost:8080/usuarios/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario, @PathVariable int id) {

        // Verifica se a email existe
        if (emailExisteOutroUsuario(usuario.getEmail(), id)) {
            return ResponseEntity.status(409).build();
        }

        // Busca o usuario pelo id e atualiza os dados
        Usuario usuarioAtualizado = buscarPorId(id);

        if (usuarioAtualizado == null) {
            return ResponseEntity.status(404).build();
        }

        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setDtNasc(usuario.getDtNasc());
        usuarioAtualizado.setGenero(usuario.getGenero());
        usuarioAtualizado.setPeso(usuario.getPeso());
        usuarioAtualizado.setNivelCondicao(usuario.getNivelCondicao());
        usuarioAtualizado.setEmail(usuario.getEmail());
        usuarioAtualizado.setSenha(usuario.getSenha());
        usuarioAtualizado.setContaAtiva(true);

        return ResponseEntity.status(200).body(usuarioAtualizado);
    }

    //Status da conta: Ativa ou Inativa (True/False)
    //http://localhost:8080/usuarios/{id}/inativar/{false/true}
    @PutMapping("/{id}/inativar/{contaAtiva}")
    public ResponseEntity<Usuario> statusConta(@PathVariable int id, @PathVariable Boolean contaAtiva) {

        Usuario usuario = buscarPorId(id);

        if (usuario == null) {
            return ResponseEntity.status(404).build();
        }

        usuario.setContaAtiva(contaAtiva);
        return ResponseEntity.status(200).body(usuario);
    }

    //Deletar conta totalmente
    //http://localhost:8080/usuarios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deletarTotal(@PathVariable int id) {

        // Buscar o usuario pelo ID
        Usuario usuario = buscarPorId(id);

        // Se o carro não existir, retorna 404
        if (usuario == null) {
            return ResponseEntity.status(404).build();
        }

        // Remove o usuario da lista
        usuarios.remove(usuario);
        return ResponseEntity.status(204).body(usuario);
    }


    //Métodos para Validação
    private Usuario buscarPorId(int id) {

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
    private boolean emailExisteOutroUsuario(String email, int id) {

        return usuarios
                .stream()
                .anyMatch(usuario -> usuario.getEmail().equals(email) && usuario.getId() != id);
    }
    private boolean emailExiste(String email) {

        return usuarios
                .stream()
                .anyMatch(usuario -> usuario.getEmail().equals(email));
    }

    public static boolean emailValido(String email){
        int validarEmail = email.indexOf("@");
        int validarEmailCom = email.indexOf(".com");

        if (validarEmail != -1 && validarEmailCom != -1){
            return false;
        }
        return true;
    }
}

//  Exemplo de Criação:
// {
//      "nome": "Gabriel",
//      "dtNasc": "2002-05-03",
//      "genero": "Masculino",
//      "peso": "68.5",
//      "nivelCondicao": "Básico",
//      "email": "gabriel@hotmail.com",
//      "senha": "123321"
// }


// -> FUTURO
//    public boolean cpfValido(String cpf){
//        if (cpf.matches("[0-9]+") && cpf.length() == 10){
//            return true;
//        }
//        return false;
//    }
//
//    private boolean cpfExiste(String cpf) {
//
//        if (cpf.matches("[0-9]+")){
//            //Pq só funciona com 9 digitos? e não com 11
//            for (Usuario usuario : usuarios) {
//                if (usuario.getCpf().equals(cpf)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }