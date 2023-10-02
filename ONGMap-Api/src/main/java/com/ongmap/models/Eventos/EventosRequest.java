package com.ongmap.models.Eventos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EventosRequest(@NotBlank
                             String nome,
                             @NotBlank
                             String objetivo,
                             @NotBlank
                             String local,
                             @NotBlank
                             String data) {
    public Eventos ToEventos(){
        return new Eventos(nome, objetivo,local, data);
    }
}
