package com.artemis.artemis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.artemis.artemis.entities.Titulacao;
import com.artemis.artemis.services.TitulacaoService;

@RestController
@RequestMapping("/titulacoes")
public class TitulacaoController {

    private final TitulacaoService service;

    public TitulacaoController(TitulacaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Titulacao>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Titulacao> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Titulacao> create(@RequestBody Titulacao titulacao) {
        return ResponseEntity.ok(service.save(titulacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Titulacao> update(@PathVariable Integer id, @RequestBody Titulacao titulacao) {
        return ResponseEntity.ok(service.update(id, titulacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
