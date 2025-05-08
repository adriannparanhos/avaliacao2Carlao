package com.oficina.carrepair.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "conserto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A data de entrada é obrigatória")
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "A data de entrada deve estar no formato 'xx/xx/xxxx'")
    private String dataEntrada;

    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "A data de saída deve estar no formato 'xx/xx/xxxx'")
    private String dataSaida;

    @NotNull(message = "Os dados do mecânico são obrigatórios")
    @Valid
    @ManyToOne(optional = false)
    @JoinColumn(name = "mecanico_id", nullable = false)
    private Mecanico mecanico;

    @NotNull(message = "Os dados do veículo são obrigatórios")
    @Valid
    @ManyToOne(optional = false)
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;
}