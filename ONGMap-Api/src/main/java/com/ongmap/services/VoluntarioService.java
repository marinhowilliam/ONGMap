package com.ongmap.services;

import com.ongmap.models.voluntario.Voluntarios;
import com.ongmap.repositories.VoluntariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VoluntarioService {
    @Autowired
    public VoluntariosRepository voluntariosRepository;
    public Voluntarios create (Voluntarios voluntarios){
        return voluntariosRepository.save(voluntarios);
    }

    public Voluntarios getBycpf(String cpf){
        return voluntariosRepository.getReferenceById(cpf);
    }

    public void delete(String cpf){
        voluntariosRepository.deleteById(cpf);
    }

    public Page<Voluntarios> findAll(Pageable page){
        return voluntariosRepository.findAll(page);
    }

    public Voluntarios update(Voluntarios voluntarios){
        var voluntariosAux = voluntariosRepository.getReferenceById(voluntarios.getCpf());
        if (voluntarios.getNome() != null){
            voluntariosAux.setNome(voluntarios.getNome());
        }
        if (voluntarios.getContato() != null){
            voluntariosAux.setContato(voluntarios.getContato());
        }
        if (voluntarios.getDisponibilidade() != null){
            voluntariosAux.setDisponibilidade(voluntarios.getDisponibilidade());
        }
        if (voluntarios.getHabilidades() != null){
            voluntariosAux.setHabilidades(voluntarios.getHabilidades());
        }
        return voluntariosAux;
    }
}
