package com.ongmap.repositories;

import com.ongmap.models.ong.Ong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OngRepository  extends JpaRepository<Ong, String> {
    Ong findByEmail(String email);
}
