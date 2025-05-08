package com.oficina.carrepair.dto;

import com.oficina.carrepair.model.Mecanico;
import com.oficina.carrepair.model.Veiculo;

public record ConsertoResponseDTO(
        Long id,
        String dataEntrada,
        String dataSaida,
        Mecanico mecanico,
        Veiculo veiculo
) {}
