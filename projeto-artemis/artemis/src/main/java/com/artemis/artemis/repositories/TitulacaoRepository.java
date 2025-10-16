package com.artemis.artemis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artemis.artemis.entities.Titulacao;

@Repository
public interface TitulacaoRepository extends JpaRepository<Titulacao, Integer> {
}
