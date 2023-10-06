package com.ongmap.services;

import com.ongmap.repositories.DinheiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DinheiroService {

    @Autowired
    private DinheiroRepository dinheiroRepository;

}
