package com.artemis.artemis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.artemis.artemis.entities.Oferta;
import com.artemis.artemis.repositories.OfertaRepository;

@Service
public class OfertaService {

    private final OfertaRepository repository;

    public OfertaService(OfertaRepository repository) {
        this.repository = repository;
    }

    public List<Oferta> findAll() {
        return repository.findAll();
    }

    public Optional<Oferta> findById(Integer id) {
        return repository.findById(id);
    }

    public Oferta save(Oferta oferta) {
        return repository.save(oferta);
    }

    public Oferta update(Integer id, Oferta updatedOferta) {
        return repository.findById(id).map(oferta -> {
            oferta.setUnidade(updatedOferta.getUnidade());
            oferta.setDisciplina(updatedOferta.getDisciplina());
            oferta.setProfessor(updatedOferta.getProfessor());
            oferta.setTurno(updatedOferta.getTurno());
            return repository.save(oferta);
        }).orElseThrow(() -> new RuntimeException("Oferta não encontrada com ID: " + id));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
