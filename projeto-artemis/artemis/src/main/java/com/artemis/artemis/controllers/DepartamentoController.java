package com.artemis.artemis.controllers;

import com.artemis.artemis.entities.Departamento;
import com.artemis.artemis.services.DepartamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService service;

    public DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Departamento> create(@RequestBody Departamento departamento) {
        return ResponseEntity.ok(service.save(departamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> update(@PathVariable Integer id, @RequestBody Departamento departamento) {
        return ResponseEntity.ok(service.update(id, departamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
