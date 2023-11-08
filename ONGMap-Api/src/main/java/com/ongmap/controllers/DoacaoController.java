package com.ongmap.controllers;

import com.ongmap.models.doacao.*;
import com.ongmap.models.ong.OngDetails;
import com.ongmap.models.ong.OngRequest;
import com.ongmap.services.DoacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doacao")
public class DoacaoController {

    @Autowired
    private DoacaoService doacaoService;

    @PostMapping("/dinheiro")
    public ResponseEntity create(@RequestBody @Valid DoacaoRequest doacao, UriComponentsBuilder uriBuilder){
        var doacaoAux = doacao.toDoacaoDinheiro();
        var aux = doacaoService.create(doacaoAux);
        var uri = uriBuilder.path("/doacao/{cpf}").buildAndExpand(aux.getId()).toUri();
        return ResponseEntity.created(uri).body(new DinheiroResponse((Dinheiro) aux));
    }

    @PostMapping("/diversos")
    public ResponseEntity createD(@RequestBody @Valid DoacaoRequest doacao, UriComponentsBuilder uriBuilder){
        var doacaoAux = doacao.toDoacaoDiversos();
        var aux = doacaoService.create(doacaoAux);
        var uri = uriBuilder.path("/doacao/{cpf}").buildAndExpand(aux.getId()).toUri();
        return ResponseEntity.created(uri).body(new DinheiroResponse((Dinheiro) doacaoAux));
    }
}
