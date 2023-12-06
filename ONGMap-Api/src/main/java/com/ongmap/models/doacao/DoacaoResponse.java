package com.ongmap.models.doacao;

import java.math.BigDecimal;
import java.util.Date;

public record DoacaoResponse(Long id, Date dataDoacao, String informacaoRelevante, TipoDoacao doacao, BigDecimal valor) {
    public DoacaoResponse(Doacao doacao){
        this(doacao.getId(), doacao.getDataDoacao(), doacao.getInformacaoRelevante(), doacao.getDoacao(), doacao.getValor());
    }
}
