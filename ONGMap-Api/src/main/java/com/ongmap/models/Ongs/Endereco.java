package com.ongmap.models.Ongs;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Endereco {
    private String rua;
    private String cep;
    private String numero;
    private String logradouro;

}
