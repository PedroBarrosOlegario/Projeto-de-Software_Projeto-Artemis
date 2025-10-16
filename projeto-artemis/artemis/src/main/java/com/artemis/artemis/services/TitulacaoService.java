package com.artemis.artemis.services;

import com.artemis.artemis.entities.Titulacao;
import com.artemis.artemis.repositories.TitulacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitulacaoService {

    private final TitulacaoRepository repository;

    public TitulacaoService(TitulacaoRepository repository) {
        this.repository = repository;
    }

    public List<Titulacao> findAll() {
        return repository.findAll();
    }

    public Optional<Titulacao> findById(Integer id) {
        return repository.findById(id);
    }

    public Titulacao save(Titulacao titulacao) {
        return repository.save(titulacao);
    }

    public Titulacao update(Integer id, Titulacao titulacaoAtualizada) {
        return repository.findById(id)
                .map(t -> {
                    t.setNome(titulacaoAtualizada.getNome());
                    t.setDescricao(titulacaoAtualizada.getDescricao());
                    return repository.save(t);
                })
                .orElseThrow(() -> new RuntimeException("Titulação não encontrada"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
