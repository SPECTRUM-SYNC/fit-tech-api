package com.example.demo.api.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.api.domain.Dono.Dono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/donos")
public class DonoController {
    private List<Dono> donosAcademia = new ArrayList<>();
    private int id;

    //Cadastrar Dono da academia
    @PostMapping()
    public ResponseEntity<Dono>cadastrarDono(@RequestBody Dono donoAcademia ) {

        if (emailExiste(donoAcademia.getEmail())) { // Verificar se a já existe Email
            return ResponseEntity.status(409).build();
        }

        if (emailValido(donoAcademia.getEmail())){ // Verificar se email possui "@"
            return ResponseEntity.status(409).build();
        }
        donoAcademia.setId(++id);
        donosAcademia.add(donoAcademia);
        return ResponseEntity.status(201).body(donoAcademia);
    }

    //Listar donos
    @GetMapping
    public ResponseEntity<List<Dono>>listarDonos() {
        if (donosAcademia.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(201).body(donosAcademia);
    }

    //Buscar por academia
    @GetMapping("/{academia}")
    public ResponseEntity<List<Dono>>buscarDonosPorAcademia(@PathVariable String academia) {
        List<Dono> donosPorAcademia = new ArrayList<>();

        for (Dono dono : donosAcademia) {
            if (dono.getAcademia().equalsIgnoreCase(academia)) {
                donosPorAcademia.add(dono);
            }
        }
        if (donosPorAcademia.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(201).body(donosPorAcademia);
    }

    /*
    Métodos de validações
     */
    private boolean emailExiste(String email) {

        return donosAcademia
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
