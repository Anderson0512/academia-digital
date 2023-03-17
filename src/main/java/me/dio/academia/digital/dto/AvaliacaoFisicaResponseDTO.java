package me.dio.academia.digital.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.dto.vo.AvaliacaoFisicaVO;
import me.dio.academia.digital.entity.Aluno;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AvaliacaoFisicaResponseDTO {

    private Aluno aluno;
    private List<AvaliacaoFisicaVO> avaliacaoFisicas;
}
