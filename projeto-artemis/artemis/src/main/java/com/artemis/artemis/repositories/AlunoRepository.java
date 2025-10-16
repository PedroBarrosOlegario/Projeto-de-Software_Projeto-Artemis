package com.artemis.artemis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artemis.artemis.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
