package com.ongmap.models.doacao;


import java.math.BigDecimal;
import java.util.Date;

public record DoacaoRequest(Date dataDoacao, String informacaoRelevante, TipoDoacao tipoDoacao, BigDecimal valor) {
    public Doacao toDoacaoDinheiro(){
        return new Dinheiro(dataDoacao, informacaoRelevante, valor);
    }
    public Doacao toDoacaoDiversos(){
        return new Diversos(dataDoacao, informacaoRelevante, tipoDoacao);
    }
}

