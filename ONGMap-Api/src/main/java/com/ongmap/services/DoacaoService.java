package com.ongmap.services;

import com.ongmap.repositories.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class DoacaoService {
    @Autowired
    private DoacaoRepository doacaoRepository;

}
