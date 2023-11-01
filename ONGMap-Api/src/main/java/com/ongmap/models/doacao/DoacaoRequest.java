package com.ongmap.models.doacao;


import java.math.BigDecimal;
import java.util.Date;

public record DoacaoRequest(Date dataDoacao, String informacaoRelevante) {
}

