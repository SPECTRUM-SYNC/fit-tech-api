package com.example.demo.api.Controller.Usuario;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.domain.Usuario.Usuario;
import com.example.demo.service.QuickSortNomeUsuario;
import com.example.demo.service.Usuario.UsuarioService;
import com.example.demo.service.Usuario.dto.UsuarioCriacaoDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();
    private int id;

    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/criar")
    public ResponseEntity<UsuarioCriacaoDTO> criar(@RequestBody @Valid UsuarioCriacaoDTO usuarioCriacaoDTO) {
        usuarioService.criar(usuarioCriacaoDTO);
        return ResponseEntity.status(201).body(usuarioCriacaoDTO);
    }


    //---> Buscar Usuarios <---
    @GetMapping
    public ResponseEntity<List<Usuario>>listar() {
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(201).body(usuarios);
    }


    /*
    ---> Buscar Usuarios - Ordem Alfabética: <---
    //http://localhost:8080/usuarios/ordemAlfabetica                                                        */
    @GetMapping("/ordemAlfabetica")
    public ResponseEntity<List<Usuario>>listarOrdemAlfabetica() {

        List<Usuario> usuarioOrdenados = new ArrayList<>(usuarios);
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        QuickSortNomeUsuario.quickSort(usuarioOrdenados, 0, usuarioOrdenados.size() -1);

        return ResponseEntity.status(200).body(usuarioOrdenados);
    }


    /*
    ---> Buscar Usuarios - por status do Usuario: <---
    http://localhost:8080/usuarios/statusUsuario/true
    http://localhost:8080/usuarios/statusUsuario/false                                                            */
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


    //---> Cadastrar usuários <---
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

    /*
   ---> Atualizar Usuário <---
    http://localhost:8080/usuarios/{id}                                                                         */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario, @PathVariable int id) {

        if (emailExisteOutroUsuario(usuario.getEmail(), id)) {
            return ResponseEntity.status(409).build();
        }

        Usuario usuarioAtualizado = buscarPorId(id);

        if (usuarioAtualizado == null) {
            return ResponseEntity.status(404).build();
        }

        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setDataNascimento(usuario.getDataNascimento());
        usuarioAtualizado.setGenero(usuario.getGenero());
        usuarioAtualizado.setPeso(usuario.getPeso());
        usuarioAtualizado.setNivelCondicao(usuario.getNivelCondicao());
        usuarioAtualizado.setEmail(usuario.getEmail());
        usuarioAtualizado.setSenha(usuario.getSenha());
        usuarioAtualizado.setContaAtiva(true);

        return ResponseEntity.status(200).body(usuarioAtualizado);
    }

    /*
    ---> Status da conta: Ativa ou Inativa <---
    http://localhost:8080/usuarios/{id}/inativar/{false/true}                                                                    */
    @PutMapping("/{id}/inativar/{contaAtiva}")
    public ResponseEntity<Usuario> statusConta(@PathVariable int id, @PathVariable Boolean contaAtiva) {
        Usuario usuario = buscarPorId(id);

        if (usuario == null) {
            return ResponseEntity.status(404).build();
        }

        usuario.setContaAtiva(contaAtiva);
        return ResponseEntity.status(200).body(usuario);
    }

    /*
    ---> Deletar conta totalmente <---
    http://localhost:8080/usuarios/{id}
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTotal(@PathVariable int id) {
        Usuario usuario = buscarPorId(id);

        if (usuario == null) {
            return ResponseEntity.status(404).build();
        }
        usuarios.remove(usuario);
        return ResponseEntity.status(200).build();
    }


//---> Métodos para Validação <---
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


/*
 ----> Exemplo de JSON:
 {
      "nome": "Gabriel",
      "dtNasc": "2002-05-03",
      "genero": "Masculino",
      "peso": "68.5",
      "nivelCondicao": "Básico",
      "email": "gabriel@hotmail.com",
      "senha": "123321"
 }

{
      "nome": "Winycios",
      "dtNasc": "2008-2-12",
      "genero": "Masculino",
      "peso": "64.5",
      "nivelCondicao": "Básico",
      "email": "gabriel@hotmail.com",
      "senha": "123321"
 }









    public boolean cpfValido(String cpf){
        if (cpf.matches("[0-9]+") && cpf.length() == 10){
            return true;
        }
        return false;
    }

     private boolean cpfExiste(String cpf) {

        if (cpf.matches("[0-9]+")){
            //Pq só funciona com 9 digitos? e não com 11
            for (Usuario usuario : usuarios) {
                if (usuario.getCpf().equals(cpf)) {
                    return true;
                }
            }
        }
        return false;
    }
 */
