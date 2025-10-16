package com.artemis.artemis.services;

import com.artemis.artemis.entities.Curso;
import com.artemis.artemis.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Curso> findAll() {
        return repository.findAll();
    }

    public Optional<Curso> findById(Integer id) {
        return repository.findById(id);
    }

    public Curso save(Curso curso) {
        return repository.save(curso);
    }

    public Curso update(Integer id, Curso cursoAtualizado) {
        return repository.findById(id)
                .map(curso -> {
                    curso.setNome(cursoAtualizado.getNome());
                    curso.setSigla(cursoAtualizado.getSigla());
                    curso.setDescricao(cursoAtualizado.getDescricao());
                    curso.setCoordenador(cursoAtualizado.getCoordenador());
                    curso.setTelefoneContato(cursoAtualizado.getTelefoneContato());
                    curso.setUrlSite(cursoAtualizado.getUrlSite());
                    return repository.save(curso);
                })
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}