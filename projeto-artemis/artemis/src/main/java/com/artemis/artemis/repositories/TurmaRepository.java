package com.artemis.artemis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artemis.artemis.entities.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
}
