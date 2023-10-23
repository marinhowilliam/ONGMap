package com.ongmap.models.doacao;

import java.util.Date;

public record DiversosRequest(Date dataDoacao, String informacaoRelevante, TipoDoacao doacao) {
}
