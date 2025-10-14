package com.artemis.artemis.services;

import com.artemis.artemis.entities.Turno;
import com.artemis.artemis.repositories.TurnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private final TurnoRepository repository;

    public TurnoService(TurnoRepository repository) {
        this.repository = repository;
    }

    public List<Turno> findAll() {
        return repository.findAll();
    }

    public Optional<Turno> findById(Integer id) {
        return repository.findById(id);
    }

    public Turno save(Turno turno) {
        return repository.save(turno);
    }

    public Turno update(Integer id, Turno turnoAtualizado) {
        return repository.findById(id)
                .map(t -> {
                    t.setNomeclatura(turnoAtualizado.getNomeclatura());
                    t.setHorarioInicio(turnoAtualizado.getHorarioInicio());
                    t.setHorarioFim(turnoAtualizado.getHorarioFim());
                    return repository.save(t);
                })
                .orElseThrow(() -> new RuntimeException("Turno não encontrado"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
