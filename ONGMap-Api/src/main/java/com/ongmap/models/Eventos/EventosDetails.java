package com.ongmap.models.Eventos;

public record EventosDetails(String nome,
                             String objetivo,
                             String local,
                             String data) {
    public EventosDetails(Eventos eventos){
        this(eventos.getNome(),
                eventos.getObjetivo(),
                eventos.getLocal(),
                eventos.getData()
        );
    }
}
