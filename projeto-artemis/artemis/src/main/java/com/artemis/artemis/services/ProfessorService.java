package com.artemis.artemis.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.artemis.artemis.entities.Professor;
import com.artemis.artemis.repositories.ProfessorRepository;

@Service
public class ProfessorService {

    private final ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<Professor> findAll() {
        return repository.findAll();
    }

    public Optional<Professor> findById(Integer id) {
        return repository.findById(id);
    }

    public Professor save(Professor professor) {
        return repository.save(professor);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Professor update(Integer id, Professor professorAtualizado) {
        return repository.findById(id).map(p -> {
            p.setMatricula(professorAtualizado.getMatricula());
            p.setCpf(professorAtualizado.getCpf());
            p.setCarteiraIdentidade(professorAtualizado.getCarteiraIdentidade());
            p.setNome(professorAtualizado.getNome());
            p.setDataNascimento(professorAtualizado.getDataNascimento());
            p.setNacionalidade(professorAtualizado.getNacionalidade());
            p.setNaturalidade(professorAtualizado.getNaturalidade());
            p.setGenero(professorAtualizado.getGenero());
            p.setCertificadoReservista(professorAtualizado.getCertificadoReservista());
            p.setEndereco(professorAtualizado.getEndereco());
            p.setTelefone(professorAtualizado.getTelefone());
            p.setEmail(professorAtualizado.getEmail());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }
}
