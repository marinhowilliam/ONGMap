package com.ongmap.models.doacao;


import java.math.BigDecimal;
import java.util.Date;

public record DoacaoRequest(Date dataDoacao, String informacaoRelevante, TipoDoacao tipoDoacao, BigDecimal valor) {
    public Doacao toDoacao(){
        return new Doacao(null, dataDoacao, informacaoRelevante,tipoDoacao, valor);
    }
}

