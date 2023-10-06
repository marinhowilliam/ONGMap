package com.ongmap.models.ong;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "ongs")
public class Ong {
    @Id
    private String cnpj;
    private String nome;
    private String telefone;
    @Embedded
    private Endereco endereco;
    private String missao;
    @Enumerated(EnumType.STRING)
    private AreaAtuacao areaAtuacao;
    private boolean ativo;

}
