package com.ongmap.controllers;

import com.ongmap.models.doacao.DinheiroRequest;
import com.ongmap.models.doacao.DoacaoRequest;
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
    public ResponseEntity create(@RequestBody @Valid DinheiroRequest doacao, UriComponentsBuilder uriBuilder){
        var doacaoAux = doacao.toDoacao();
        var aux = doacaoService.create(doacaoAux);
        var uri = uriBuilder.path("/doacao/{cpf}").buildAndExpand(aux.getCpf()).toUri();
        return ResponseEntity.created(uri).body(new OngDetails(aux));
    }

    @PostMapping("/diversos")
    public ResponseEntity create(@RequestBody @Valid DoacaoRequest doacao, UriComponentsBuilder uriBuilder){
        var doacaoAux = doacao.
                var aux = doacaoService.create(doacaoAux);
        var uri = uriBuilder.path("/doacao/{cpf}").buildAndExpand(aux.getCpf()).toUri();
        return ResponseEntity.created(uri).body(new OngDetails(aux));
    }
}
