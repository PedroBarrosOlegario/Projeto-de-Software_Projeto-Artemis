package com.artemis.artemis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artemis.artemis.entities.Turno;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
}
