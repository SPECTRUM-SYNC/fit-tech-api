package sync.spctrum.apispring.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sync.spctrum.apispring.service.historicoPeso.HistoricoPesoService;
import sync.spctrum.apispring.service.historicoPeso.dto.peso.HistoricoPesoCreateDTO;
import sync.spctrum.apispring.service.historicoPeso.dto.peso.HistoricoPesoResponseDTO;

import java.util.List;

@RestController
@RequestMapping(value = "pesos")
@SecurityRequirement(name = "Bearer")
public class HistoricoPesoController {

    private final HistoricoPesoService historicoPesoService;

    public HistoricoPesoController(HistoricoPesoService historicoPesoService) {
        this.historicoPesoService = historicoPesoService;
    }

    @ApiResponse(responseCode = "201", description = "Cadastrar peso.")
    @PostMapping(value = "/{id}")
    public ResponseEntity<HistoricoPesoResponseDTO> cadastrarPeso(@Valid @RequestBody HistoricoPesoCreateDTO createDTO, @PathVariable Long id) {
        HistoricoPesoResponseDTO responseDTO = historicoPesoService.postPeso(createDTO, id);

        return ResponseEntity.status(201).body(responseDTO);
    }

    @ApiResponse(responseCode = "200", description = "Listar todo o histórico a partir de um usuario.")
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<HistoricoPesoResponseDTO>> procurarPorId(@PathVariable Long id) {
        List<HistoricoPesoResponseDTO> responseDTOList = historicoPesoService.getId(id);

        if (responseDTOList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(responseDTOList);
    }

    @ApiResponse(responseCode = "200", description = "Listar os 3 ultimos dados a partir de um usuario.")
    @GetMapping(value = "/historico-grafico/{id}")
    public ResponseEntity<List<HistoricoPesoResponseDTO>> procurarPorIdLimit3(@PathVariable Long id) {
        List<HistoricoPesoResponseDTO> responseDTOList = historicoPesoService.getGrafics(id);

        if (responseDTOList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(responseDTOList);
    }

    @ApiResponse(responseCode = "200", description = "Lista os dados mais atualizados do usuario.")
    @GetMapping(value = "/ultima-insercao/{id}")
    public ResponseEntity<HistoricoPesoResponseDTO> procurarPorIdLimit1(@PathVariable Long id) {
        HistoricoPesoResponseDTO responseDTO = historicoPesoService.getUserId(id);

        return ResponseEntity.status(200).body(responseDTO);
    }
}
