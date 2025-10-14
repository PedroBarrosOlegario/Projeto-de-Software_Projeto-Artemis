package com.artemis.artemis.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.artemis.artemis.entities.Universidade;
import com.artemis.artemis.repositories.UniversidadeRepository;

@Service
public class UniversidadeService {

    private final UniversidadeRepository repository;

    public UniversidadeService(UniversidadeRepository repository) {
        this.repository = repository;
    }

    public List<Universidade> findAll() {
        return repository.findAll();
    }

    public Optional<Universidade> findById(Integer id) {
        return repository.findById(id);
    }

    public Universidade save(Universidade universidade) {
        return repository.save(universidade);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Universidade update(Integer id, Universidade universidadeAtualizada) {
        return repository.findById(id).map(u -> {
            u.setTelefone(universidadeAtualizada.getTelefone());
            u.setCnpj(universidadeAtualizada.getCnpj());
            u.setNome(universidadeAtualizada.getNome());
            u.setSigla(universidadeAtualizada.getSigla());
            u.setEndereco(universidadeAtualizada.getEndereco());
            u.setUrl(universidadeAtualizada.getUrl());
            u.setLogo(universidadeAtualizada.getLogo());
            return repository.save(u);
        }).orElseThrow(() -> new RuntimeException("Universidade não encontrada"));
    }
}
