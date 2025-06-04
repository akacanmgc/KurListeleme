package com.kurdurum.dolar.Repository;

import com.kurdurum.dolar.Entities.Kur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KurRepository extends JpaRepository<Kur, Long> {
    Kur findTopByOrderByCreatedAtDesc();
}
