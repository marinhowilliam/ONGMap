package com.ongmap.models.doacao;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("OUTRO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diversos extends Doacao{
    private TipoDoacao doacao;
}
