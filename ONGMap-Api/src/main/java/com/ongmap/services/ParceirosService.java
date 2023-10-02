package com.ongmap.services;

import com.ongmap.models.parceiros.Parceiros;
import com.ongmap.repositories.ParceirosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ParceirosService {
    @Autowired
    public ParceirosRepository parceirosRepository;
    public Parceiros create (Parceiros parceiros){
        return parceirosRepository.save(parceiros);
    }

    public Parceiros getBycnpj(String cnpj){
        return parceirosRepository.getReferenceById(cnpj);
    }

    public void delete(String cnpj){
        parceirosRepository.deleteById(cnpj);
    }

    public List<Parceiros> findAll(){
        return parceirosRepository.findAll();
    }

    public Parceiros updade(Parceiros parceiros){
        var parceirosAux = parceirosRepository.getReferenceById(parceiros.getCnpj());
        if(parceiros.getNome() != null){
            parceirosAux.setNome(parceiros.getNome());
        }
        if(parceiros.getTipoDeParceria() != null){
            parceirosAux.setTipoDeParceria(parceiros.getTipoDeParceria());
        }
    return parceirosAux;
    }
}


