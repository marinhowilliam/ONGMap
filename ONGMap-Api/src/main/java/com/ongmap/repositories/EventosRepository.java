package com.ongmap.repositories;

import com.ongmap.models.evento.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventosRepository extends JpaRepository<Eventos, Long> {
    Eventos findByObjetivo(String objetivo);
    Eventos findByLocal(String local);
}
