package com.artemis.artemis.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.artemis.artemis.entities.Aluno;
import com.artemis.artemis.repositories.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Optional<Aluno> findById(Integer id) {
        return repository.findById(id);
    }

    public Aluno save(Aluno aluno) {
        return repository.save(aluno);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Aluno update(Integer id, Aluno alunoAtualizado) {
        return repository.findById(id).map(a -> {
            a.setMatricula(alunoAtualizado.getMatricula());
            a.setCpf(alunoAtualizado.getCpf());
            a.setCarteiraIdentidade(alunoAtualizado.getCarteiraIdentidade());
            a.setNome(alunoAtualizado.getNome());
            a.setDataNascimento(alunoAtualizado.getDataNascimento());
            a.setNacionalidade(alunoAtualizado.getNacionalidade());
            a.setNaturalidade(alunoAtualizado.getNaturalidade());
            a.setGenero(alunoAtualizado.getGenero());
            a.setCertificadoReservista(alunoAtualizado.getCertificadoReservista());
            a.setEndereco(alunoAtualizado.getEndereco());
            a.setTelefone(alunoAtualizado.getTelefone());
            a.setEmail(alunoAtualizado.getEmail());
            return repository.save(a);
        }).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }
}
