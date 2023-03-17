package me.dio.academia.digital.controller;

import me.dio.academia.digital.dto.AvaliacaoFisicaRequestDTO;
import me.dio.academia.digital.dto.AvaliacaoFisicaResponseDTO;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaServiceImpl service;

    public AvaliacaoFisicaController(AvaliacaoFisicaServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaRequestDTO request) throws Exception {
        return service.create(request);
    }

    @GetMapping
    public AvaliacaoFisicaResponseDTO getAll(){
        return service.getAll();
    }
}
