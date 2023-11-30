package com.ongmap.models.doacao;

import java.math.BigDecimal;
import java.util.Date;

public record DoacaoResponse(Date dataDoacao, String informacaoRelevante) {
    public DoacaoResponse(Doacao doacao) {
        this(doacao.getDataDoacao(), doacao.getInformacaoRelevante());
    }
}

