package com.ongmap.controllers;

import com.ongmap.models.doacao.DoacaoRequest;
import com.ongmap.models.ong.OngDetails;
import com.ongmap.models.ong.OngRequest;
import com.ongmap.services.OngService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/ongs")
public class OngController {
    @Autowired
    private OngService ongService;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid OngRequest ong, UriComponentsBuilder uriBuilder) {
        var ongAux = ong.toOng();
        var aux = ongService.create(ongAux);
        var uri = uriBuilder.path("/ongs/{cnpj}").buildAndExpand(aux.getCnpj()).toUri();
        return ResponseEntity.created(uri).body(new OngDetails(aux));
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity get(@PathVariable String cnpj) {
        var ong = ongService.getBycpnj(cnpj);
        return ResponseEntity.ok(new OngDetails(ong));
    }
    @DeleteMapping("/{cnpj}")
    public ResponseEntity delete(@PathVariable String cnpj) {
        ongService.delete(cnpj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity findAll(@PageableDefault Pageable page) {
        var ongs = ongService.findAll(page);
        return ResponseEntity.ok(ongs.stream().map(OngDetails::new));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody OngRequest ongRequest){
        return ResponseEntity.ok(ongService.update(ongRequest.toOng()));
    }
}
