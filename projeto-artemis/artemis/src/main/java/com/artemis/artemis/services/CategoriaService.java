package com.artemis.artemis.services;

import com.artemis.artemis.entities.Categoria;
import com.artemis.artemis.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Optional<Categoria> findById(Integer id) {
        return repository.findById(id);
    }

    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria update(Integer id, Categoria categoriaAtualizada) {
        return repository.findById(id)
                .map(categoria -> {
                    categoria.setNome(categoriaAtualizada.getNome());
                    return repository.save(categoria);
                })
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
