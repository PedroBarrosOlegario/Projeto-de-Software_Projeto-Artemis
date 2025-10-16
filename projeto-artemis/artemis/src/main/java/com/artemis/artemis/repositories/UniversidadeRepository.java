package com.artemis.artemis.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artemis.artemis.entities.Universidade;

	@Repository
	public interface UniversidadeRepository extends JpaRepository<Universidade, Integer> {
}

