package com.ongmap.services;

import com.ongmap.models.Ongs.Ong;
import com.ongmap.repositories.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class    OngService {
    @Autowired
    public OngRepository ongRepository;

    public Ong create(Ong ong) {
        return ongRepository.save(ong);
    }

    public Ong getBycpnj(String cnpj){
        return ongRepository.getReferenceById(cnpj);
    }

    public void delete(String cnpj){
        ongRepository.deleteById(cnpj);
    }

    public List<Ong> findAll(){
        return ongRepository.findAll();
    }

    public Ong update(Ong ong){
        var ongAux = ongRepository.getReferenceById(ong.getCnpj());
        if(ong.getNome() != null){
            ongAux.setNome(ong.getNome());
        }
        if(ong.getTelefone() != null){
            ongAux.setTelefone(ong.getTelefone());
        }
        if(ong.getMissao() != null){
            ongAux.setMissao(ong.getMissao());
        }
    return ongAux;
    }

}
