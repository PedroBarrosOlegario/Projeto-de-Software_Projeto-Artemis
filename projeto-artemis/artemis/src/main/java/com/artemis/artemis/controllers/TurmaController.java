package com.artemis.artemis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.artemis.artemis.entities.Turma;
import com.artemis.artemis.services.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService service;

    public TurmaController(TurmaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Turma>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Turma> create(@RequestBody Turma turma) {
        return ResponseEntity.ok(service.save(turma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> update(@PathVariable Integer id, @RequestBody Turma turma) {
        return ResponseEntity.ok(service.update(id, turma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
