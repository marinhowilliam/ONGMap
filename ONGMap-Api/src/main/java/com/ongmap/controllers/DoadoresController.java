package com.ongmap.controllers;


import com.ongmap.models.Doadores.DoadoresDetails;
import com.ongmap.models.Doadores.DoadoresRequest;
import com.ongmap.services.DoadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doadores")

public class DoadoresController {

    @Autowired
    private DoadoresService doadoresService;

    @PostMapping
    public ResponseEntity create(DoadoresRequest doadores){
        var doadoresAux = doadores.ToDoadores();
        var aux = doadoresService.create(doadoresAux);
        return ResponseEntity.ok(new DoadoresDetails(aux));
    }
}
