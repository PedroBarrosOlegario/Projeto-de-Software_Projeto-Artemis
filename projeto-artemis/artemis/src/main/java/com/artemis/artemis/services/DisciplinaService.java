package com.artemis.artemis.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.artemis.artemis.entities.Disciplina;
import com.artemis.artemis.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {

    private final DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    public List<Disciplina> findAll() {
        return repository.findAll();
    }

    public Optional<Disciplina> findById(Integer id) {
        return repository.findById(id);
    }

    public Disciplina save(Disciplina disciplina) {
        return repository.save(disciplina);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Disciplina update(Integer id, Disciplina disciplinaAtualizada) {
        return repository.findById(id).map(d -> {
            d.setSigla(disciplinaAtualizada.getSigla());
            d.setName(disciplinaAtualizada.getName());
            d.setCargaHoraria(disciplinaAtualizada.getCargaHoraria());
            d.setSigla(disciplinaAtualizada.getSigla());
            return repository.save(d);
        }).orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
    }
}
