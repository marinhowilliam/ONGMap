package com.ongmap.repositories;

import com.ongmap.models.Ongs.Ong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OngRepository  extends JpaRepository<Ong, String> {
    Ong findByEmail(String email);
}
