package com.artemis.artemis.controllers;

import com.artemis.artemis.entities.Curso;
import com.artemis.artemis.services.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        return ResponseEntity.ok(service.save(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Integer id, @RequestBody Curso curso) {
        return ResponseEntity.ok(service.update(id, curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
