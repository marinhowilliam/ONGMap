package com.ongmap.controllers;

import com.ongmap.models.Voluntarios.VoluntarioDetails;
import com.ongmap.models.Voluntarios.VoluntarioRequest;
import com.ongmap.services.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voluntarios")

public class VoluntariosController {
    @Autowired
    private VoluntarioService voluntariosService;

    @PostMapping
    public ResponseEntity crate(VoluntarioRequest voluntarios){
        var voluntariosAux = voluntarios.ToVoluntario();
        var aux = voluntariosService.create(voluntariosAux);
        return ResponseEntity.ok(new VoluntarioDetails(aux));
    }
}
