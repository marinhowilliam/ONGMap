package com.ongmap.models.Doadores;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String historicoDoacoes;
    private String contato;
    @Embedded
    private String endereco;
}
