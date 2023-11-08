package com.ongmap.models.doacao;

import java.math.BigDecimal;
import java.util.Date;

public record DoacaoResponse(Date dataDoacao, String informacaoRelevante, TipoDoacao tipoDoacao, BigDecimal valor) {


}

