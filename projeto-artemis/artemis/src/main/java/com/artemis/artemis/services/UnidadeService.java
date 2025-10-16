package com.artemis.artemis.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.artemis.artemis.entities.Unidade;
import com.artemis.artemis.repositories.UnidadeRepository;

@Service
public class UnidadeService {

    private final UnidadeRepository repository;

    public UnidadeService(UnidadeRepository repository) {
        this.repository = repository;
    }

    public List<Unidade> findAll() {
        return repository.findAll();
    }

    public Optional<Unidade> findById(Integer id) {
        return repository.findById(id);
    }

    public Unidade save(Unidade unidade) {
        return repository.save(unidade);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Unidade update(Integer id, Unidade unidadeAtualizada) {
        return repository.findById(id).map(u -> {
            u.setNome(unidadeAtualizada.getNome());
            u.setSigla(unidadeAtualizada.getSigla());
            u.setEndereco(unidadeAtualizada.getEndereco());
            u.setTelefone(unidadeAtualizada.getTelefone());
            u.setUrl(unidadeAtualizada.getUrl());
            return repository.save(u);
        }).orElseThrow(() -> new RuntimeException("Unidade não encontrada"));
    }
}
