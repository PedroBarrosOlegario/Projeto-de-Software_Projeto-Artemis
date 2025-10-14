package com.artemis.artemis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artemis.artemis.entities.RegimeDeTrabalho;

@Repository
public interface RegimeDeTrabalhoRepository extends JpaRepository<RegimeDeTrabalho, Integer> {
}
