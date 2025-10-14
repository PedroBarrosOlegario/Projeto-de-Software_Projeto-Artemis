package com.artemis.artemis.services;

import com.artemis.artemis.entities.Turma;
import com.artemis.artemis.repositories.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    private final TurmaRepository repository;

    public TurmaService(TurmaRepository repository) {
        this.repository = repository;
    }

    public List<Turma> findAll() {
        return repository.findAll();
    }

    public Optional<Turma> findById(Integer id) {
        return repository.findById(id);
    }

    public Turma save(Turma turma) {
        return repository.save(turma);
    }

    public Turma update(Integer id, Turma turmaAtualizada) {
        return repository.findById(id)
                .map(t -> {
                    t.setNome(turmaAtualizada.getNome());
                    t.setCodigo(turmaAtualizada.getCodigo());
                    t.setTurno(turmaAtualizada.getTurno());
                    t.setCurso(turmaAtualizada.getCurso());
                    return repository.save(t);
                })
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
