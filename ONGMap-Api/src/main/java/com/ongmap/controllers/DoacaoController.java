package com.ongmap.controllers;

import com.ongmap.models.doacao.*;
import com.ongmap.models.ong.OngDetails;
import com.ongmap.models.ong.OngRequest;
import com.ongmap.services.DoacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id){
        var doacao = doacaoService.getByID(id);
        return ResponseEntity.ok(new DoacaoResponse(doacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        doacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity findAll(@PageableDefault Pageable page){
        var aux = doacaoService.findAll(page);
        return ResponseEntity.ok(aux.stream().map(DoacaoResponse::new));
    }

    @GetMapping("/dinheiro")
    public ResponseEntity findAllDinheiro(@PageableDefault Pageable page){
        var aux = doacaoService.findAllDinheiro(page);
        return ResponseEntity.ok(aux);
    }

    @PutMapping("/dinheiro")
    public ResponseEntity update(@RequestBody DoacaoRequest doacaoRequest){
        return ResponseEntity.ok(doacaoService.atualizar(doacaoRequest.toDoacaoDinheiro()));


    }
}
