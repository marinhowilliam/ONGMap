package com.ongmap.services;

import com.ongmap.models.ong.Ong;
import com.ongmap.repositories.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OngService {
    @Autowired
    public OngRepository ongRepository;

    @Cacheable(value = "ong", key = "#ong.cnpj")
    public Ong create(Ong ong) {
        return ongRepository.save(ong);
    }

    @Cacheable(value = "ong", key = "#cnpj")
    public Ong getBycpnj(String cnpj){
        return ongRepository.getReferenceById(cnpj);
    }

    @CacheEvict(value = "ong", key = "#cnpj")
    public void delete(String cnpj){
        ongRepository.deleteById(cnpj);
    }


    public Page<Ong> findAll(Pageable page){
        return ongRepository.findAll(page);
    }

    @CachePut(value = "ong", key = "#ong.cnpj")
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
