package com.ongmap.models.Eventos;

public record EventosDertails(String nome,
                              String objetivo,
                              String local,
                              String data) {
    public EventosDertails(Eventos eventos){
        this(eventos.getNome(),
                eventos.getObjetvo(),
                eventos.getLocal(),
                eventos.getData()
        );
    }
}
