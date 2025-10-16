package com.artemis.artemis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.artemis.artemis.entities.Oferta;
import com.artemis.artemis.services.OfertaService;

@RestController
@RequestMapping("/ofertas")
public class OfertaController {

    private final OfertaService service;

    public OfertaController(OfertaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Oferta>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oferta> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Oferta> create(@RequestBody Oferta oferta) {
        return ResponseEntity.ok(service.save(oferta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Oferta> update(@PathVariable Integer id, @RequestBody Oferta oferta) {
        return ResponseEntity.ok(service.update(id, oferta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
