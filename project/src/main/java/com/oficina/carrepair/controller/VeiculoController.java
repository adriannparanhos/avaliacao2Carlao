package com.oficina.carrepair.controller;

import com.oficina.carrepair.model.Veiculo;
import com.oficina.carrepair.repository.VeiculoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private final VeiculoRepository repository;

    @Autowired
    public VeiculoController(VeiculoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Veiculo> create(@Valid @RequestBody Veiculo veiculo) {
        Veiculo saved = repository.save(veiculo);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> update(
            @PathVariable Long id,
            @Valid @RequestBody Veiculo veiculoData
    ) {
        return repository.findById(id).map(existing -> {
            existing.setMarca(veiculoData.getMarca());
            existing.setModelo(veiculoData.getModelo());
            existing.setAno(veiculoData.getAno());
            existing.setCor(veiculoData.getCor());
            Veiculo updated = repository.save(existing);
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
