package com.artemis.artemis.services;

import com.artemis.artemis.entities.RegimeDeTrabalho;
import com.artemis.artemis.repositories.RegimeDeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegimeDeTrabalhoService {

    private final RegimeDeTrabalhoRepository repository;

    public RegimeDeTrabalhoService(RegimeDeTrabalhoRepository repository) {
        this.repository = repository;
    }

    public List<RegimeDeTrabalho> findAll() {
        return repository.findAll();
    }

    public Optional<RegimeDeTrabalho> findById(Integer id) {
        return repository.findById(id);
    }

    public RegimeDeTrabalho save(RegimeDeTrabalho regimeTrabalho) {
        return repository.save(regimeTrabalho);
    }

    public RegimeDeTrabalho update(Integer id, RegimeDeTrabalho regimeAtualizado) {
        return repository.findById(id)
                .map(regime -> {
                    regime.setNome(regimeAtualizado.getNome());
                    return repository.save(regime);
                })
                .orElseThrow(() -> new RuntimeException("Regime de trabalho não encontrado"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
