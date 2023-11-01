package com.ongmap.models.doacao;

import java.math.BigDecimal;
import java.util.Date;

public record DinheiroRequest(Date dataDoacao, String informacaoRelevante, BigDecimal valor) {

    public Dinheiro toDoacao(){
        return new Dinheiro(dataDoacao, informacaoRelevante, valor);
    }
}
