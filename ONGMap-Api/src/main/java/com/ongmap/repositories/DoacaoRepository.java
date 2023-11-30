package com.ongmap.repositories;

import com.ongmap.models.doacao.Dinheiro;
import com.ongmap.models.doacao.Doacao;
import com.ongmap.models.doacao.TipoDoacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoacaoRepository extends JpaRepository<Doacao, Long> {

    // Método para buscar todas as doações do tipo Dinheiro
    Page<Doacao> findByTipoDoacao(String tipoDoacao);
}

    // Método para buscar todas as doações do tipo Diversos

