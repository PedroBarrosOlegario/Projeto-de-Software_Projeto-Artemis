package com.artemis.artemis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artemis.artemis.entities.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Integer> {
}
