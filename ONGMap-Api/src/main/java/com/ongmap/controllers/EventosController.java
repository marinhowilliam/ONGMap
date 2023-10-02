package com.ongmap.controllers;

import com.ongmap.models.Eventos.EventosDetails;
import com.ongmap.models.Eventos.EventosRequest;
import com.ongmap.services.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventos")

public class EventosController {

    @Autowired
    private EventosService eventosService;

    @PostMapping
    public ResponseEntity create(EventosRequest eventos){
        var eventosAux = eventos.ToEventos();
        var aux = eventosService.create(eventosAux);
        return ResponseEntity.ok(new EventosDetails(aux));
    }
}
