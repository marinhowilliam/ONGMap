package com.ongmap.services;

import com.ongmap.models.doadores.Doadores;
import com.ongmap.repositories.DoadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoadoresService {

    @Autowired
    public DoadoresRepository doadoresRepository;

    public Doadores create(Doadores doadores){
        return doadoresRepository.save(doadores);
    }

    public Doadores getByCpf(String cpf){
        return doadoresRepository.getReferenceById(cpf);
    }
    public void delete(String cpf){
        doadoresRepository.deleteById(cpf);
    }

    public List<Doadores> findAll(){
        return doadoresRepository.findAll();
    }

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
