package com.ongmap.models.doacao;

import java.util.Date;

public record DiversosResponse(Long id, Date dataDoacao, String informacaoRelevante, TipoDoacao doacao) {
}
