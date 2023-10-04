package com.ongmap.repositories;

import com.ongmap.models.Parceiros.Parceiros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParceirosRepository extends JpaRepository<Parceiros, String> {
    Parceiros findByNome(String nome);
}
