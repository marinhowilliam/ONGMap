package com.ongmap.repositories;

import com.ongmap.models.Doadores.Doadores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoadoresRepository extends JpaRepository<Doadores, String> {
    Doadores findByNome(String nome);
}
