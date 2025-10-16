package com.artemis.artemis.services;

import com.artemis.artemis.entities.Historico;
import com.artemis.artemis.repositories.HistoricoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoService {

    private final HistoricoRepository repository;

    public HistoricoService(HistoricoRepository repository) {
        this.repository = repository;
    }

    public List<Historico> findAll() {
        return repository.findAll();
    }

    public Optional<Historico> findById(Integer id) {
        return repository.findById(id);
    }

    public Historico save(Historico historico) {
        return repository.save(historico);
    }

    public Historico update(Integer id, Historico historicoAtualizado) {
        return repository.findById(id)
                .map(h -> {
                    h.setIdDisciplina(historicoAtualizado.getIdDisciplina());
                    h.setNota(historicoAtualizado.getNota());
                    return repository.save(h);
                })
                .orElseThrow(() -> new RuntimeException("Histórico não encontrado"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
