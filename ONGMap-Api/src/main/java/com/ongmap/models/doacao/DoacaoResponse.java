package com.ongmap.models.doacao;

import java.math.BigDecimal;
import java.util.Date;

public record DoacaoResponse(Long id, Date dataDoacao, String informacaoRelevante) {}

