package com.oficina.carrepair.controller;

import com.oficina.carrepair.dto.ConsertoRequestDTO;
import com.oficina.carrepair.dto.ConsertoResponseDTO;
import com.oficina.carrepair.dto.ConsertoSummaryDTO;
import com.oficina.carrepair.service.ConsertoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consertos")
public class ConsertoController {
    
    private final ConsertoService service;
    
    @Autowired
    public ConsertoController(ConsertoService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<ConsertoResponseDTO> criarConserto(@Valid @RequestBody ConsertoRequestDTO requestDTO) {
        ConsertoResponseDTO responseDTO = service.criarConserto(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<Page<ConsertoResponseDTO>> buscarTodosConsertos(Pageable pageable) {
        Page<ConsertoResponseDTO> consertos = service.buscarTodosConsertos(pageable);
        return ResponseEntity.ok(consertos);
    }
    
    @GetMapping("/sumario")
    public ResponseEntity<List<ConsertoSummaryDTO>> buscarConsertosSumario() {
        List<ConsertoSummaryDTO> consertos = service.buscarConsertosSumario();
        return ResponseEntity.ok(consertos);
    }
}