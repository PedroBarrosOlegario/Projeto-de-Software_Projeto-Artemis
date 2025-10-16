package com.artemis.artemis.controllers;

import com.artemis.artemis.entities.PlanoDeEnsino;
import com.artemis.artemis.services.PlanoDeEnsinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos-ensino")
public class PlanoDeEnsinoController {

    private final PlanoDeEnsinoService service;

    public PlanoDeEnsinoController(PlanoDeEnsinoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PlanoDeEnsino>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDeEnsino> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PlanoDeEnsino> create(@RequestBody PlanoDeEnsino planoDeEnsino) {
        return ResponseEntity.ok(service.save(planoDeEnsino));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoDeEnsino> update(@PathVariable Integer id, @RequestBody PlanoDeEnsino planoDeEnsino) {
        return ResponseEntity.ok(service.update(id, planoDeEnsino));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
