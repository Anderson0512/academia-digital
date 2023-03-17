package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.dto.AlunoRequestDTO;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.exception.BusinessException;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.AlunoService;
import me.dio.academia.digital.utils.MethodsUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository repository;
    @Autowired
    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Aluno create(AlunoRequestDTO request) {
        Aluno aluno = new Aluno();
        aluno.setNome(request.getNome());
        aluno.setCpf(request.getCpf());
        aluno.setBairro(request.getBairro());
        aluno.setDataDeNascimento(request.getDataDeNascimento());

        return repository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {

        return repository.findById(id).orElseThrow(() -> new BusinessException(id));
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        if (StringUtils.isEmpty(dataDeNascimento)){
            return repository.findAll();
        }
        LocalDate localDate = LocalDate.parse(dataDeNascimento, MethodsUtils.LOCAL_DATE_FORMATTER);
        return repository.findByDataDeNascimento(localDate);
    }

    @Override
    public Aluno update(Long id, AlunoRequestDTO request) {
        Aluno aluno = repository.findById(id).orElseThrow(() -> new BusinessException(id));
        aluno.setNome(request.getNome());
        aluno.setBairro(request.getBairro());
        aluno.setDataDeNascimento(request.getDataDeNascimento());

        return repository.save(aluno);
    }

    @Override
    public void delete(Long id) {
        Aluno aluno = repository.findById(id).orElseThrow(() -> new BusinessException(id));
        repository.delete(aluno);
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

        Aluno aluno = repository.findById(id).orElseThrow(() -> new BusinessException(id));
        return aluno.getAvaliacoes();
    }
}
