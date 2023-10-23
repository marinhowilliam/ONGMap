package com.ongmap.models.doadores;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Doadores {

    @Id
    private String cpf;
    private String nome;
    private String contato;
    @Embedded
    private String endereco;
}
