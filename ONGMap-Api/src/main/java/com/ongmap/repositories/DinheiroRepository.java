package com.ongmap.repositories;

import com.ongmap.models.doacao.Dinheiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DinheiroRepository extends JpaRepository<Dinheiro, Long> {
}
