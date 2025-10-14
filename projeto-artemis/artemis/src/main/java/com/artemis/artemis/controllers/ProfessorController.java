package com.artemis.artemis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.artemis.artemis.entities.Professor;
import com.artemis.artemis.services.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Professor> create(@RequestBody Professor professor) {
        return ResponseEntity.ok(service.save(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> update(@PathVariable Integer id, @RequestBody Professor professor) {
        return ResponseEntity.ok(service.update(id, professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

