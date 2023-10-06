package com.ongmap.repositories;

import com.ongmap.models.voluntario.Voluntarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoluntariosRepository extends JpaRepository<Voluntarios, String> {
    Voluntarios findByNome(String nome);
}
