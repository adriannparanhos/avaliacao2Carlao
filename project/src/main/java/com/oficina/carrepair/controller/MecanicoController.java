package com.oficina.carrepair.controller;

import com.oficina.carrepair.model.Mecanico;
import com.oficina.carrepair.repository.MecanicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mecanicos")
public class MecanicoController {

    private final MecanicoRepository repository;

    @Autowired
    public MecanicoController(MecanicoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Mecanico>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mecanico> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mecanico> create(@Valid @RequestBody Mecanico mecanico) {
        Mecanico saved = repository.save(mecanico);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mecanico> update(
            @PathVariable Long id,
            @Valid @RequestBody Mecanico mecanicoData
    ) {
        return repository.findById(id).map(existing -> {
            existing.setNome(mecanicoData.getNome());
            existing.setAnos_experiencia(mecanicoData.getAnos_experiencia());
            Mecanico updated = repository.save(existing);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return repository.findById(id).map(existing -> {
            repository.delete(existing);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
