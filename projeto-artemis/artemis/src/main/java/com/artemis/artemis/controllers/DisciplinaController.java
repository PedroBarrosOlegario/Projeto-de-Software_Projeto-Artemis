package com.artemis.artemis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.artemis.artemis.entities.Disciplina;
import com.artemis.artemis.services.DisciplinaService;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Disciplina> create(@RequestBody Disciplina disciplina) {
        return ResponseEntity.ok(service.save(disciplina));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> update(@PathVariable Integer id, @RequestBody Disciplina disciplina) {
        return ResponseEntity.ok(service.update(id, disciplina));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
