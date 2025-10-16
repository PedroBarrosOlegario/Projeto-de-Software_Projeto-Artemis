package com.artemis.artemis.controllers;

import com.artemis.artemis.entities.RegimeDeTrabalho;
import com.artemis.artemis.services.RegimeDeTrabalhoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regimes-trabalho")
public class RegimeDeTrabalhoController {

    private final RegimeDeTrabalhoService service;

    public RegimeDeTrabalhoController(RegimeDeTrabalhoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RegimeDeTrabalho>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegimeDeTrabalho> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RegimeDeTrabalho> create(@RequestBody RegimeDeTrabalho regimeTrabalho) {
        return ResponseEntity.ok(service.save(regimeTrabalho));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegimeDeTrabalho> update(@PathVariable Integer id, @RequestBody RegimeDeTrabalho regimeTrabalho) {
        return ResponseEntity.ok(service.update(id, regimeTrabalho));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
