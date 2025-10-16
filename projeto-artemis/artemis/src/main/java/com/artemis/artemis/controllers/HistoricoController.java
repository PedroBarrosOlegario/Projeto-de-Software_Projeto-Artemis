package com.artemis.artemis.controllers;

import com.artemis.artemis.entities.Historico;
import com.artemis.artemis.services.HistoricoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historicos")
public class HistoricoController {

    private final HistoricoService service;

    public HistoricoController(HistoricoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Historico>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historico> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Historico> create(@RequestBody Historico historico) {
        return ResponseEntity.ok(service.save(historico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Historico> update(@PathVariable Integer id, @RequestBody Historico historico) {
        return ResponseEntity.ok(service.update(id, historico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
