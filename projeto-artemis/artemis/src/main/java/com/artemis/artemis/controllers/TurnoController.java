package com.artemis.artemis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.artemis.artemis.entities.Turno;
import com.artemis.artemis.services.TurnoService;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final TurnoService service;

    public TurnoController(TurnoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Turno> create(@RequestBody Turno turno) {
        return ResponseEntity.ok(service.save(turno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turno> update(@PathVariable Integer id, @RequestBody Turno turno) {
        return ResponseEntity.ok(service.update(id, turno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
