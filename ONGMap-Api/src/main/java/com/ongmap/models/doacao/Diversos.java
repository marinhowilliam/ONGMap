package com.ongmap.models.doacao;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@DiscriminatorValue("OUTRO")
@Data
@NoArgsConstructor
public class Diversos extends Doacao{
    private TipoDoacao doacao;

    public Diversos(Date dataDoacao, String informacaoRelevante, TipoDoacao doacao) {
        super(null, dataDoacao, informacaoRelevante);
        this.doacao = doacao;
    }
}
