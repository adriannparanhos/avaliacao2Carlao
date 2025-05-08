package com.oficina.carrepair.dto;

public record ConsertoSummaryDTO(
        String dataEntrada,
        String dataSaida,
        String nomeMecanico,
        String marcaVeiculo,
        String modeloVeiculo
) {}
