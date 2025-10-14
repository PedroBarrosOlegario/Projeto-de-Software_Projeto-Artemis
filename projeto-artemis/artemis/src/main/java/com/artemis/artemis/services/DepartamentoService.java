package com.artemis.artemis.services;

import com.artemis.artemis.entities.Departamento;
import com.artemis.artemis.repositories.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    private final DepartamentoRepository repository;

    public DepartamentoService(DepartamentoRepository repository) {
        this.repository = repository;
    }

    public List<Departamento> findAll() {
        return repository.findAll();
    }

    public Optional<Departamento> findById(Integer id) {
        return repository.findById(id);
    }

    public Departamento save(Departamento departamento) {
        return repository.save(departamento);
    }

    public Departamento update(Integer id, Departamento departamentoAtualizado) {
        return repository.findById(id)
                .map(dep -> {
                    dep.setNome(departamentoAtualizado.getNome());
                    dep.setSigla(departamentoAtualizado.getSigla());
                    dep.setTelefone(departamentoAtualizado.getTelefone());
                    dep.setUrlSite(departamentoAtualizado.getUrlSite());
                    dep.setChefeDepartamento(departamentoAtualizado.getChefeDepartamento());
                    return repository.save(dep);
                })
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
