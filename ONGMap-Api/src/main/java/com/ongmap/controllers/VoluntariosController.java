package com.ongmap.controllers;

import com.ongmap.models.parceiro.ParceiroDetails;
import com.ongmap.models.voluntario.VoluntarioDetails;
import com.ongmap.models.voluntario.VoluntarioRequest;
import com.ongmap.services.VoluntarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/voluntarios")

public class VoluntariosController {
    @Autowired
    private VoluntarioService voluntariosService;

    @PostMapping
    public ResponseEntity crate(@RequestBody @Valid VoluntarioRequest voluntarios, UriComponentsBuilder uriBuilder){
        var voluntariosAux = voluntarios.ToVoluntario();
        var aux = voluntariosService.create(voluntariosAux);
        var uri = uriBuilder.path("/valuntarios/{cpf}").buildAndExpand(voluntarios.cpf()).toUri();
        return ResponseEntity.created(uri).body(new VoluntarioDetails(aux));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity get(@PathVariable String cpf) {
        var voluntario = voluntariosService.getBycpf(cpf);
        return ResponseEntity.ok(new VoluntarioDetails(voluntario));
    }
    @DeleteMapping("/{cnpj}")
    public ResponseEntity delete(@PathVariable String cpf) {
        voluntariosService.delete(cpf);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity findAll(@PageableDefault Pageable page) {
        var voluntarios = voluntariosService.findAll(page);
        return ResponseEntity.ok(voluntarios.stream().map(VoluntarioDetails::new));
    }


}
