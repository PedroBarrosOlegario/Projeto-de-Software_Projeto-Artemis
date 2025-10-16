package com.artemis.artemis.services;

import com.artemis.artemis.entities.PlanoDeEnsino;
import com.artemis.artemis.repositories.PlanoDeEnsinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoDeEnsinoService {

    private final PlanoDeEnsinoRepository repository;

    public PlanoDeEnsinoService(PlanoDeEnsinoRepository repository) {
        this.repository = repository;
    }

    public List<PlanoDeEnsino> findAll() {
        return repository.findAll();
    }

    public Optional<PlanoDeEnsino> findById(Integer id) {
        return repository.findById(id);
    }

    public PlanoDeEnsino save(PlanoDeEnsino planoDeEnsino) {
        return repository.save(planoDeEnsino);
    }

    public PlanoDeEnsino update(Integer id, PlanoDeEnsino planoAtualizado) {
        return repository.findById(id)
                .map(plano -> {
                    plano.setEmenta(planoAtualizado.getEmenta());
                    plano.setObjetivo(planoAtualizado.getObjetivo());
                    plano.setConteudo(planoAtualizado.getConteudo());
                    plano.setReferenciaBasica1(planoAtualizado.getReferenciaBasica1());
                    plano.setReferenciaBasica2(planoAtualizado.getReferenciaBasica2());
                    plano.setReferenciaBasica3(planoAtualizado.getReferenciaBasica3());
                    plano.setReferenciaBasica4(planoAtualizado.getReferenciaBasica4());
                    plano.setReferenciaBasica5(planoAtualizado.getReferenciaBasica5());
                    plano.setReferenciaComplementar1(planoAtualizado.getReferenciaComplementar1());
                    plano.setReferenciaComplementar2(planoAtualizado.getReferenciaComplementar2());
                    plano.setReferenciaComplementar3(planoAtualizado.getReferenciaComplementar3());
                    plano.setReferenciaComplementar4(planoAtualizado.getReferenciaComplementar4());
                    plano.setReferenciaComplementar5(planoAtualizado.getReferenciaComplementar5());
                    plano.setReferenciaComplementar6(planoAtualizado.getReferenciaComplementar6());
                    plano.setReferenciaComplementar7(planoAtualizado.getReferenciaComplementar7());
                    plano.setReferenciaComplementar8(planoAtualizado.getReferenciaComplementar8());
                    plano.setReferenciaComplementar9(planoAtualizado.getReferenciaComplementar9());
                    plano.setReferenciaComplementar10(planoAtualizado.getReferenciaComplementar10());
                    return repository.save(plano);
                })
                .orElseThrow(() -> new RuntimeException("Plano de ensino não encontrado"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

