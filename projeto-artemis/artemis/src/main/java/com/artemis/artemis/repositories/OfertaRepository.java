package com.artemis.artemis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artemis.artemis.entities.Oferta;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {
}
