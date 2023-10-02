package com.ongmap.models.Voluntarios;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Voluntarios {
    @Id
    private String cpf;
    private String nome;
    private String disponibilidade;
    private String habilidades;
    private String contato;
}
