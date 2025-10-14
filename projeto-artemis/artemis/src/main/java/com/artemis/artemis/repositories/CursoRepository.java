package com.artemis.artemis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artemis.artemis.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
