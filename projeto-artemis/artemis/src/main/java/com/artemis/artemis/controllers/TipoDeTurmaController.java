package com.artemis.artemis.controllers;

import com.artemis.artemis.entities.TipoDeTurma;
import com.artemis.artemis.services.TipoDeTurmaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-turma")
public class TipoDeTurmaController {

    private final TipoDeTurmaService service;

    public TipoDeTurmaController(TipoDeTurmaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TipoDeTurma>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDeTurma> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoDeTurma> create(@RequestBody TipoDeTurma tipoTurma) {
        return ResponseEntity.ok(service.save(tipoTurma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDeTurma> update(@PathVariable Integer id, @RequestBody TipoDeTurma tipoTurma) {
        return ResponseEntity.ok(service.update(id, tipoTurma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
