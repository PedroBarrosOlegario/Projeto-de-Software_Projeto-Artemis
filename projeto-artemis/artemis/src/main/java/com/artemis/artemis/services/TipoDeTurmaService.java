package com.artemis.artemis.services;

import com.artemis.artemis.entities.TipoDeTurma;
import com.artemis.artemis.repositories.TipoDeTurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDeTurmaService {

    private final TipoDeTurmaRepository repository;

    public TipoDeTurmaService(TipoDeTurmaRepository repository) {
        this.repository = repository;
    }

    public List<TipoDeTurma> findAll() {
        return repository.findAll();
    }

    public Optional<TipoDeTurma> findById(Integer id) {
        return repository.findById(id);
    }

    public TipoDeTurma save(TipoDeTurma tipoTurma) {
        return repository.save(tipoTurma);
    }

    public TipoDeTurma update(Integer id, TipoDeTurma tipoTurmaAtualizado) {
        return repository.findById(id)
                .map(tipo -> {
                    tipo.setDescricao(tipoTurmaAtualizado.getDescricao());
                    return repository.save(tipo);
                })
                .orElseThrow(() -> new RuntimeException("Tipo de turma não encontrado"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
