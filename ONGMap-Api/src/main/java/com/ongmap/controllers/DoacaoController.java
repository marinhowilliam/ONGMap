package com.ongmap.controllers;

import com.ongmap.services.DoacaoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doacao")
public class DoacaoController {

    private DoacaoService doacaoService;

}
