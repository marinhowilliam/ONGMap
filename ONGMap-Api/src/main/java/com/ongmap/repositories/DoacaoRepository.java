package com.ongmap.repositories;

import com.ongmap.models.doacao.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoacaoRepository extends JpaRepository<Doacao, Long>{
}
