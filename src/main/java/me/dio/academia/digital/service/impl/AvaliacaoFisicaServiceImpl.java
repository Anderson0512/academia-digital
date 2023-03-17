package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.dto.AvaliacaoFisicaRequestDTO;
import me.dio.academia.digital.dto.AvaliacaoFisicaResponseDTO;
import me.dio.academia.digital.dto.mapper.AvaliacaoFisicaResponseMapper;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.exception.BusinessException;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements AvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    private final AlunoRepository alunoRepository;
    @Autowired
    public AvaliacaoFisicaServiceImpl(
            AvaliacaoFisicaRepository avaliacaoFisicaRepository,
            AlunoRepository alunoRepository) {
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
        this.alunoRepository = alunoRepository;
    }

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaRequestDTO request) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(request.getAlunoId()).orElseThrow(() -> new BusinessException(request.getAlunoId()));

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(request.getPeso());
        avaliacaoFisica.setAltura(request.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return null;
    }

    @Override
    public AvaliacaoFisicaResponseDTO getAll() {

        List<AvaliacaoFisica> responseData =  avaliacaoFisicaRepository.findAll();
        return new AvaliacaoFisicaResponseMapper(responseData).getResponseDTO();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaRequestDTO request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
