package com.oficina.carrepair.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "veiculo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "A marca do veículo é obrigatória")
    private String marca;
    
    @NotBlank(message = "O modelo do veículo é obrigatório")
    @NotNull
    @NotEmpty
    private String modelo;
    
    @NotBlank(message = "O ano do veículo é obrigatório")
    @Pattern(regexp = "\\d{4}", message = "O ano deve estar no formato 'xxxx'")
    @NotNull
    @NotEmpty
    private String ano;

    private String cor;



}