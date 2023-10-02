package com.ongmap.repositories;

import com.ongmap.models.Eventos.Eventos;
import com.ongmap.models.parceiros.Parceiros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventosRepository extends JpaRepository<Eventos, String> {
    Eventos findByObjetivo(String objetivo);
    Eventos findByLocal(String local);
}
