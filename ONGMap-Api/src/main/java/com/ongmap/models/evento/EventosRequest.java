package com.ongmap.models.evento;

import jakarta.validation.constraints.NotBlank;

public record EventosRequest(@NotBlank
                             String nome,
                             @NotBlank
                             String objetivo,
                             @NotBlank
                             String local,
                             @NotBlank
                             String data) {
    public Eventos ToEventos(){
        return new Eventos(null, nome, objetivo,local, data);
    }
}
