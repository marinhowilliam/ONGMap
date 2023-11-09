package com.ongmap.models.evento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "eventos")

public class Eventos {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String objetivo;
    private String local;
    private String data;
}
