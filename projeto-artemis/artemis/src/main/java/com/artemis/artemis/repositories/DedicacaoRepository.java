package com.artemis.artemis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artemis.artemis.entities.Dedicacao;

@Repository
public interface DedicacaoRepository extends JpaRepository<Dedicacao, Integer> {
}
