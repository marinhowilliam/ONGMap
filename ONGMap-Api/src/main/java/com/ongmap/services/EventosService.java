package com.ongmap.services;

import com.ongmap.models.evento.Eventos;
import com.ongmap.repositories.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventosService {

    @Autowired
    public EventosRepository eventosRepository;

    public Eventos create (Eventos eventos){
        return eventosRepository.save(eventos);
    }

    public Eventos getById(Long id){
        return eventosRepository.getReferenceById(id);
    }

    public void delete(Long id){
        eventosRepository.getReferenceById(id);
    }

    public List<Eventos> findAll() {
        return eventosRepository.findAll();
    }

    public Eventos updade(Eventos eventos) {
        var eventosAux = eventosRepository.getReferenceById(eventos.getId());
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

    public Object update(Eventos eventos) {
        return eventos;
    }

}
