package com.ongmap.controllers;

import com.ongmap.models.parceiros.ParceiroDetails;
import com.ongmap.models.parceiros.ParceirosRequest;
import com.ongmap.services.ParceirosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parceiros")

public class ParceirosController {
    @Autowired
    private ParceirosService parceirosService;

    @PostMapping
    public ResponseEntity create(ParceirosRequest parceiros){
        var parceirosAux = parceiros.toParceiros();
        var aux = parceirosService.create(parceirosAux);
        return ResponseEntity.ok(new ParceiroDetails(aux));
    }
}
