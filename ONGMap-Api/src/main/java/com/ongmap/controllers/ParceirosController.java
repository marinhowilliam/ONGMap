package com.ongmap.controllers;

import com.ongmap.models.ong.OngDetails;
import com.ongmap.models.parceiro.ParceiroDetails;
import com.ongmap.models.parceiro.ParceirosRequest;
import com.ongmap.services.ParceirosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{cnpj}")
    public ResponseEntity get(@PathVariable String cnpj) {
        var parceiro = parceirosService.getBycnpj(cnpj);
        return ResponseEntity.ok(new ParceiroDetails(parceiro));
    }
    @DeleteMapping("/{cnpj}")
    public ResponseEntity delete(@PathVariable String cnpj) {
        parceirosService.delete(cnpj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity findAll(@PageableDefault Pageable page) {
        var parceiros = parceirosService.findAll(page);
        return ResponseEntity.ok(parceiros.stream().map(ParceiroDetails::new));
    }

    //TODO: Fazer o metodo atualizar


}
