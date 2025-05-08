package com.oficina.carrepair.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ConsertoRequestDTO(

        @NotBlank(message = "A data de entrada é obrigatória")
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "A data de entrada deve estar no formato 'xx/xx/xxxx'")
        String dataEntrada,

        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "A data de saída deve estar no formato 'xx/xx/xxxx'")
        String dataSaida,

        @NotNull(message = "O ID do mecânico é obrigatório")
        Long mecanicoId,

        @NotNull(message = "O ID do veículo é obrigatório")
        Long veiculoId

) {}
