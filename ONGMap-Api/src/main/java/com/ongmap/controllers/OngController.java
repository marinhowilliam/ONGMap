package com.ongmap.controllers;

import com.ongmap.models.Ongs.OngDetails;
import com.ongmap.models.Ongs.OngRequest;
import com.ongmap.services.OngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ongs")
public class OngController {
    @Autowired
    private OngService ongService;

    @PostMapping
    public ResponseEntity create(OngRequest ong) {
        var ongAux = ong.toOng();
        var aux = ongService.create(ongAux);
        return ResponseEntity.ok(new OngDetails(aux));
    }


}
