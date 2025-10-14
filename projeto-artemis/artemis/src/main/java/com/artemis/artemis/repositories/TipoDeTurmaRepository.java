package com.artemis.artemis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artemis.artemis.entities.TipoDeTurma;

@Repository
public interface TipoDeTurmaRepository extends JpaRepository<TipoDeTurma, Integer> {
}
