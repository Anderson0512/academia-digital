package me.dio.academia.digital.dto.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AvaliacaoFisicaVO {

    private Long id;
    private double peso;
    private double altura;
    private String dataDaAvaliacao;
}
