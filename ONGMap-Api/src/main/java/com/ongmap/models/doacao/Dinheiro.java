package com.ongmap.models.doacao;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("DINHEIRO")
public class Dinheiro extends Doacao{

    public Dinheiro(Date dataDoacao, String informacaoRelevante, BigDecimal valor) {
        super(null,dataDoacao, informacaoRelevante);
        this.valor = valor;
    }

    private BigDecimal valor;
}
