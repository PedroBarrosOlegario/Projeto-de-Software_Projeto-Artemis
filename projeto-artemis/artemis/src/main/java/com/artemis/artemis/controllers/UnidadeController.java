package com.artemis.artemis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.artemis.artemis.entities.Unidade;
import com.artemis.artemis.services.UnidadeService;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    private final UnidadeService service;

    public UnidadeController(UnidadeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Unidade>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Unidade> create(@RequestBody Unidade unidade) {
        return ResponseEntity.ok(service.save(unidade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidade> update(@PathVariable Integer id, @RequestBody Unidade unidade) {
        return ResponseEntity.ok(service.update(id, unidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
