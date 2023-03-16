package me.dio.academia.digital.dto.mapper;

import me.dio.academia.digital.dto.AvaliacaoFisicaResponseDTO;
import me.dio.academia.digital.dto.vo.AvaliacaoFisicaVO;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.utils.MethodsUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AvaliacaoFisicaResponseMapper {

    private final AvaliacaoFisicaResponseDTO responseDTO = new AvaliacaoFisicaResponseDTO();

    public AvaliacaoFisicaResponseMapper(List<AvaliacaoFisica> responseData){

        List<AvaliacaoFisicaVO> avaliacaoFisicas = new ArrayList<>();

        String docMask = StringUtils.left(responseData.get(0).getAluno().getCpf(),2) + "*.***.***-" + StringUtils.right(responseData.get(0).getAluno().getCpf(),2);

        responseDTO.setAluno(responseData.get(0).getAluno());
        responseDTO.getAluno().setCpf(docMask);

        for (AvaliacaoFisica list : responseData){
            AvaliacaoFisicaVO fisicaVO = new AvaliacaoFisicaVO();
            fisicaVO.setId(list.getId());
            fisicaVO.setPeso(list.getPeso());
            fisicaVO.setAltura(list.getAltura());
            fisicaVO.setDataDaAvaliacao(MethodsUtils.LOCAL_DATE_TIME_FORMATTER.format(list.getDataDaAvaliacao()));
            avaliacaoFisicas.add(fisicaVO);
        }
        responseDTO.setAvaliacaoFisicas(avaliacaoFisicas);
    }

    public AvaliacaoFisicaResponseDTO getResponseDTO() {
        return responseDTO;
    }
}
