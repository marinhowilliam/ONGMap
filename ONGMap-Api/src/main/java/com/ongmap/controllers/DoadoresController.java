package com.ongmap.controllers;


import com.ongmap.models.doadores.Doadores;
import com.ongmap.models.doadores.DoadoresDetails;
import com.ongmap.models.doadores.DoadoresRequest;
import com.ongmap.models.evento.EventosDetails;
import com.ongmap.services.DoadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{cpf}")
    public ResponseEntity get(@PathVariable String cpf) {
        var doadores = doadoresService.getByCpf(cpf);
        return ResponseEntity.ok(new DoadoresDetails(doadores));

    }
    @DeleteMapping("/{nome}")
    public ResponseEntity delete(@PathVariable String cpf) {
        doadoresService.delete(cpf);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity findAll(@PageableDefault Pageable page) {
        var doador = doadoresService.findAll(page);
        return ResponseEntity.ok(doador.stream().map(DoadoresDetails::new));
    }

}
