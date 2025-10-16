package com.artemis.artemis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artemis.artemis.entities.Alocacao;

@Repository
public interface AlocacaoRepository extends JpaRepository<Alocacao, Integer> {
}
