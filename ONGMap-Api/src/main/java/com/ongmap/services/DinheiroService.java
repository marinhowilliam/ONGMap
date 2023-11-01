package com.ongmap.services;

import com.ongmap.models.doacao.Dinheiro;
import com.ongmap.repositories.DinheiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DinheiroService {
    @Autowired
    public DinheiroRepository dinheiroRepository;

    @Cacheable(value = "dinheiro", key = "#dinheiro.id")
    public Dinheiro create (Dinheiro dinheiro){
        return dinheiroRepository.save(dinheiro);
    }

    @Cacheable(value = "dinheiro", key = "#id")
    public Dinheiro getById(Long id){
        return dinheiroRepository.getReferenceById(id);
    }

    @CacheEvict(value = "dinheiro", key = "#id")
    public void delete(Long id){
        dinheiroRepository.deleteById(id);
    }

    public Page<Dinheiro> findAll(Pageable page){
        return dinheiroRepository.findAll(page);
    }

    public Dinheiro update(Dinheiro dinheiro){
        var dinheiroAux = dinheiroRepository.getReferenceById(dinheiro.getId());
        if (dinheiro.getValor() != null){
            dinheiroAux.setValor(dinheiro.getValor());
        }
        if (dinheiro.getDataDoacao() != null){
            dinheiroAux.setDataDoacao(dinheiro.getDataDoacao());
        }
        if (dinheiro.getInformacaoRelevante() != null){
            dinheiroAux.setDataDoacao(dinheiro.getDataDoacao());
        }
        return dinheiroAux;
    }


}

