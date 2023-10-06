package com.ongmap.services;

import com.ongmap.models.evento.Eventos;
import com.ongmap.repositories.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EventosService {

    @Autowired
    public EventosRepository eventosRepository;

    public Eventos create (Eventos eventos){
        return eventosRepository.save(eventos);
    }

    public Eventos getBynome(String nome){
        return eventosRepository.getReferenceById(nome);
    }

    public void delate(String nome){
        eventosRepository.getReferenceById(nome);
    }

    public List<Eventos> findAll() {
        return eventosRepository.findAll();
    }

    public Eventos updade(Eventos eventos) {
        var eventosAux = eventosRepository.getReferenceById(eventos.getNome());
        if (eventos.getNome() != null) {
            eventosAux.setNome(eventos.getNome());
        }
        if (eventos.getLocal() != null) {
            eventosAux.setLocal(eventos.getLocal());
        }
        if (eventos.getObjetivo() != null) {
            eventosAux.setObjetivo(eventos.getObjetivo());
        }

        if (eventos.getData() != null) {
            eventosAux.setData(eventos.getData());
        }
        return eventosAux;
    }
}
