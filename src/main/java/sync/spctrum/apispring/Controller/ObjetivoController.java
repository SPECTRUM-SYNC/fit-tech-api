package sync.spctrum.apispring.Controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Objetivo.repository.ObjetivoRepository;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.service.objetivo.dto.modelMapper.ObjetivoMapper;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoCreateDTO;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoResponseDTO;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/objetivos")
public class ObjetivoController {

    private final ObjetivoRepository objetivoRepository;

    public ObjetivoController(ObjetivoRepository objetivoRepository) {this.objetivoRepository = objetivoRepository;}

    @GetMapping
    public ResponseEntity<List<ObjetivoResponseDTO>> listar() {
        List<Objetivo> objetivoList = objetivoRepository.findAll();

        if (objetivoList.isEmpty()) {
            throw new ResourceNotFound("Lista está vazia");
        }
        return ResponseEntity.status(201).body(ObjetivoMapper.toListRespostaDTO(objetivoList));
    }

    @PostMapping
    public ResponseEntity<ObjetivoResponseDTO> cadastrar(@Valid @RequestBody ObjetivoCreateDTO objetivoCreateDTO) {

        Objetivo objetivo = ObjetivoMapper.toEntity(objetivoCreateDTO);
        Objetivo novoObjetivo = objetivoRepository.save(objetivo);

        return ResponseEntity.status(201).body(findByUser(novoObjetivo.getId()).getBody());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ObjetivoResponseDTO> findByUser(@PathVariable Long id) {
        Optional<Objetivo> objetivo = objetivoRepository.findById(id);

        if (objetivo.isPresent()) {
            return ResponseEntity.status(200).body(ObjetivoMapper.toObjetivoDTO(objetivo.get()));
        }
        throw new ResourceNotFound(id);
    }
}
