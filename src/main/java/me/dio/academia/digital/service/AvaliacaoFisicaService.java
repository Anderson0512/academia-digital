package me.dio.academia.digital.service;

import me.dio.academia.digital.dto.AvaliacaoFisicaRequestDTO;
import me.dio.academia.digital.dto.AvaliacaoFisicaResponseDTO;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoFisicaService {
    /**
     * Cria uma Avaliação Física e salva no banco de dados.
     * @param form - formulário referente aos dados para criação da Avaliação Física no banco de dados.
     * @return - Avaliação Física recém-criada.
     */
    AvaliacaoFisica create(AvaliacaoFisicaRequestDTO form) throws Exception;

    /**
     * Retorna uma Avaliação Física que está no banco de dados de acordo com seu Id.
     * @param id - id da Avaliação Física que será exibida.
     * @return - Avaliação Física de acordo com o Id fornecido.
     */
    AvaliacaoFisica get(Long id);

    /**
     * Retorna todas as Avaliações Física que estão no banco de dados.
     * @return - Uma lista com todas as Avaliações Física que estão salvas no DB.
     */
    AvaliacaoFisicaResponseDTO getAll();

    /**
     * Atualiza a avaliação física.
     * @param id - id da Avaliação Física que será atualizada.
     * @param requestUpdate - formulário referente aos dados necessários para atualização da Avaliação
     * Física no banco de dados.
     * @return - Avaliação Física recém-atualizada.
     */
    AvaliacaoFisica update(Long id, AvaliacaoFisicaRequestDTO requestUpdate);

    /**
     * Deleta uma Avaliação Física específica.
     * @param id - id da Avaliação Física que será removida.
     */
    void delete(Long id);
}
