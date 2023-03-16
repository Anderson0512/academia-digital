package me.dio.academia.digital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.dto.vo.AvaliacaoFisicaVO;
import me.dio.academia.digital.entity.Aluno;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaResponseDTO {

    private Aluno aluno;
    private List<AvaliacaoFisicaVO> avaliacaoFisicas;
}
