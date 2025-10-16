package com.artemis.artemis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artemis.artemis.entities.PlanoDeEnsino;

@Repository
public interface PlanoDeEnsinoRepository extends JpaRepository<PlanoDeEnsino, Integer> {
}
