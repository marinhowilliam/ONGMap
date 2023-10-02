package com.ongmap.repositories;

import com.ongmap.models.Voluntarios.Voluntarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoluntariosRepository extends JpaRepository<Voluntarios, String> {
    Voluntarios findByNome(String nome);
}
