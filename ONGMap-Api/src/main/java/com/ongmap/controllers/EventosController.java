package com.ongmap.controllers;

import com.ongmap.models.evento.EventosDetails;
import com.ongmap.models.evento.EventosRequest;
import com.ongmap.services.EventosService;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/eventos")
public class EventosController {


    private final EventosService eventosService;

    public EventosController(EventosService eventosService) {
        this.eventosService = eventosService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid EventosRequest eventos, UriComponentsBuilder builder){
        var eventosAux = eventos.ToEventos();
        var aux = eventosService.create(eventosAux);
        var uri = builder.path("/eventos/{id}").buildAndExpand(aux.getId()).toUri();
        return ResponseEntity.created(uri).body(new EventosDetails(aux));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id){
        var eventos = eventosService.getById(id);
        return ResponseEntity.ok(new EventosDetails(eventos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        eventosService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity findAll(){
        var eventos = eventosService.findAll();
        return ResponseEntity.ok(eventos.stream().map(EventosDetails::new));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody EventosRequest eventosRequest){
        return ResponseEntity.ok(eventosService.update(eventosRequest.ToEventos()));
    }
}
