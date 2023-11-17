package com.ongmap.services;

import com.ongmap.models.doadores.Doadores;
import com.ongmap.repositories.DoadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoadoresService {

    @Autowired
    public DoadoresRepository doadoresRepository;

    @Cacheable(value = "doadores", key = "#doadores.cpf")
    public Doadores create(Doadores doadores){
        return doadoresRepository.save(doadores);
    }

    @Cacheable(value = "doadores", key = "#cpf")
    public Doadores getByCpf(String cpf){
        return doadoresRepository.getReferenceById(cpf);
    }
    @CacheEvict(value = "doadores", key = "#cpf")
    public void delete(String cpf){
        doadoresRepository.deleteById(cpf);
    }


    public Page<Doadores> findAll(Pageable page){
        return doadoresRepository.findAll(page);
    }

    @CachePut(value = "doadores", key = "#doadores.cpf")
    public Doadores update(Doadores doadores){
        var doadoresAux = doadoresRepository.getReferenceById(doadores.getCpf());
        if (doadores.getNome() != null){
            doadoresAux.setNome(doadores.getNome());
        }
        if (doadores.getContato() != null){
            doadoresAux.setContato(doadores.getContato());
        }
        if (doadores.getEndereco() != null){
            doadoresAux.setEndereco(doadores.getEndereco());
        }
        return doadoresAux;
    }
}
