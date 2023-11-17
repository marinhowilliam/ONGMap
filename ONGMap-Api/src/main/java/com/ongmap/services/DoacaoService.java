package com.ongmap.services;

import com.ongmap.models.doacao.Doacao;
import com.ongmap.repositories.DoacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DoacaoService {

    private DoacaoRepository doacaoRepository;

    private ModelMapper mapper;

    @Autowired
    public DoacaoService(DoacaoRepository doacaoRepository, ModelMapper mapper){
        this.doacaoRepository = doacaoRepository;
        this.mapper = mapper;
    }

    public Doacao create(Doacao doacao){
        return doacaoRepository.save(doacao);
    }

    public Doacao getByID(Long id){
        return doacaoRepository.getReferenceById(id);
    }

    public Page<Doacao> findAll(Pageable page){
        return doacaoRepository.findAll(page);
    }

    public void delete(Long id){
        doacaoRepository.deleteById(id);
    }

    public Doacao atualizar(Doacao doacao){
        var doacaoAux = doacaoRepository.findById(doacao.getId()).orElse(null);
        if(doacaoAux != null){
            mapper.map(doacao, doacaoAux);
            return doacaoRepository.save(doacaoAux);
        }else {
            throw new RuntimeException("Doação não encontrada");
        }
    }
}
