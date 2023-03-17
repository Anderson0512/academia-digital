package me.dio.academia.digital.controller;

import me.dio.academia.digital.dto.AlunoRequestDTO;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoServiceImpl service;


    @Autowired
    public AlunoController(AlunoServiceImpl service) {
        this.service = service;
    }



    @PostMapping
    public Aluno create(@RequestBody AlunoRequestDTO request) {
        return service.create(request);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(
            value = "dataDeNascimento", required = false)
            String dataDeNacimento){
        return service.getAll(dataDeNacimento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws Exception {
        service.delete(id);
        return ResponseEntity.ok().body("Arquivo Deletado");
    }
    @GetMapping("/{id}")
    public Aluno getAluno(@PathVariable Long id) throws Exception {
        return service.get(id);
    }
    @PutMapping("/{id}")
    public Aluno getUpdate(@PathVariable Long id, @RequestBody AlunoRequestDTO request) throws Exception {
        return service.update(id,request);
    }
}
