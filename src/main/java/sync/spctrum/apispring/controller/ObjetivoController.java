package sync.spctrum.apispring.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Objetivo.repository.ObjetivoRepository;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.exception.TransactionNotAcceptable;
import sync.spctrum.apispring.service.objetivo.dto.modelMapper.ObjetivoMapper;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoCreateDTO;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/objetivos")
public class ObjetivoController {

    private final ObjetivoRepository objetivoRepository;

    public ObjetivoController(ObjetivoRepository objetivoRepository) {
        this.objetivoRepository = objetivoRepository;
    }

    @ApiResponse(responseCode = "201", description = "Mostrando todos os objetivos cadastrados.")
    @GetMapping
    public ResponseEntity<List<ObjetivoResponseDTO>> getTodosObjetivos() {
        List<Objetivo> objetivoList = objetivoRepository.findAll();

        if (objetivoList.isEmpty()) {
            throw new ResourceNotFound("Lista está vazia");
        }
        return ResponseEntity.status(201).body(ObjetivoMapper.toListRespostaDTO(objetivoList));
    }

    @ApiResponse(responseCode = "200", description = "Objetivo encontrado com sucesso.")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ObjetivoResponseDTO> getObjetivoPorId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(ObjetivoMapper.toObjetivoDTO(procurarObjetivoPorId(id)));
    }

    @ApiResponse(responseCode = "200", description = "Objetivo atualizado com sucesso.")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ObjetivoResponseDTO> putObjetivo(@PathVariable Long id, @Valid @RequestBody ObjetivoCreateDTO objetivoCreateDTO) {
        Objetivo objetivo = procurarObjetivoPorId(id);
        objetivo.setObjetivo(objetivoCreateDTO.getObjetivo());
        return ResponseEntity.status(200).body(ObjetivoMapper.toObjetivoDTO(objetivoRepository.save(objetivo)));
    }

    @ApiResponse(responseCode = "200", description = "Objetivo deletado com sucesso.")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> limparObjetivo(@PathVariable Long id) {
        Objetivo objetivo = procurarObjetivoPorId(id);

        if (objetivo.getObjetivo() == null) {
            throw new TransactionNotAcceptable("Objetivo já está apagado");
        }
        objetivo.setObjetivo(null);
        objetivoRepository.save(objetivo);

        return ResponseEntity.status(200).build();
    }

    private Objetivo procurarObjetivoPorId(Long id) {
        return objetivoRepository.findById(id).orElseThrow(() -> new ResourceNotFound("ID : " + id));
    }
}