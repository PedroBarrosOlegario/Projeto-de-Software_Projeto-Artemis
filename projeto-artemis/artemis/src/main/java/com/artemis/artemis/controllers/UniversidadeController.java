package com.artemis.artemis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.artemis.artemis.entities.Universidade;
import com.artemis.artemis.services.UniversidadeService;

@RestController
@RequestMapping("/universidades")
public class UniversidadeController {

    private final UniversidadeService service;

    public UniversidadeController(UniversidadeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Universidade>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Universidade> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Universidade> create(@RequestBody Universidade universidade) {
        return ResponseEntity.ok(service.save(universidade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Universidade> update(@PathVariable Integer id, @RequestBody Universidade universidade) {
        return ResponseEntity.ok(service.update(id, universidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
