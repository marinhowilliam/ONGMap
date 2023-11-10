package com.ongmap.controllers;

import com.ongmap.models.evento.EventosDetails;
import com.ongmap.models.evento.EventosRequest;
import com.ongmap.services.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/eventos")
public class EventosController {


    private final EventosService eventosService;

    public EventosController(EventosService eventosService) {
        this.eventosService = eventosService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody EventosRequest eventos, UriComponentsBuilder builder){
        var eventosAux = eventos.ToEventos();
        var aux = eventosService.create(eventosAux);
        var uri = builder.path("/eventos/{id}").buildAndExpand(aux.getId()).toUri();
        return ResponseEntity.created(uri).body(new EventosDetails(aux));
    }


}
