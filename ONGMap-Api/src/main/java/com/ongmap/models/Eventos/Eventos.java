package com.ongmap.models.Eventos;

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
@Table(name = "eventos")

public class Eventos {

    @Id
    private String nome;
    private String objetivo;
    private String local;
    private String data;
}
