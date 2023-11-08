package com.ongmap.models.doacao;

import java.math.BigDecimal;
import java.util.Date;

public record DinheiroResponse(Long id, Date dataDoacao, String informacaoRelevante, BigDecimal valor) {
    public DinheiroResponse(Dinheiro doacao){
        this(doacao.getId(), doacao.getDataDoacao(), doacao.getInformacaoRelevante(), doacao.getValor());
    }
}
