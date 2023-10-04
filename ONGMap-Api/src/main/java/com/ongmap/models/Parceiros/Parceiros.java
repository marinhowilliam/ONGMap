package com.ongmap.models.Parceiros;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Parceiros {

    @Id
    private String cnpj;
    private String nome;
    private String tipoDeParceria;

}
