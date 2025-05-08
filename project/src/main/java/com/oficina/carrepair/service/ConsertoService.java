package com.oficina.carrepair.service;

import com.oficina.carrepair.dto.ConsertoRequestDTO;
import com.oficina.carrepair.dto.ConsertoResponseDTO;
import com.oficina.carrepair.dto.ConsertoSummaryDTO;
import com.oficina.carrepair.model.Conserto;
import com.oficina.carrepair.model.Mecanico;
import com.oficina.carrepair.model.Veiculo;
import com.oficina.carrepair.repository.ConsertoRepository;
import com.oficina.carrepair.repository.MecanicoRepository;
import com.oficina.carrepair.repository.VeiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsertoService {

    private static final Logger logger = LoggerFactory.getLogger(ConsertoService.class);

    private final ConsertoRepository consertoRepo;
    private final MecanicoRepository mecanicoRepo;
    private final VeiculoRepository veiculoRepo;

    @Autowired
    public ConsertoService(ConsertoRepository consertoRepo,
                           MecanicoRepository mecanicoRepo,
                           VeiculoRepository veiculoRepo) {
        this.consertoRepo = consertoRepo;
        this.mecanicoRepo = mecanicoRepo;
        this.veiculoRepo = veiculoRepo;
    }

    public ConsertoResponseDTO criarConserto(ConsertoRequestDTO requestDTO) {
        logger.info("Iniciando criação de conserto com dados: {}", requestDTO);

        // Buscar entidades por ID
        Mecanico mecanico = mecanicoRepo.findById(requestDTO.mecanicoId())
                .orElseThrow(() -> new EntityNotFoundException("Mecânico não encontrado, id: " + requestDTO.mecanicoId()));
        Veiculo veiculo = veiculoRepo.findById(requestDTO.veiculoId())
                .orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado, id: " + requestDTO.veiculoId()));

        try {
            Conserto conserto = new Conserto();
            conserto.setDataEntrada(requestDTO.dataEntrada());
            conserto.setDataSaida(requestDTO.dataSaida());
            conserto.setMecanico(mecanico);
            conserto.setVeiculo(veiculo);

            logger.info("Entidade Conserto criada: {}", conserto);

            Conserto saved = consertoRepo.save(conserto);

            logger.info("Conserto salvo com sucesso: {}", saved);

            return mapToResponseDTO(saved);
        } catch (Exception e) {
            logger.error("Erro ao criar conserto: {}", e.getMessage(), e);
            throw e;
        }
    }

    public Page<ConsertoResponseDTO> buscarTodosConsertos(Pageable pageable) {
        Page<Conserto> consertos = consertoRepo.findAllConsertos(pageable);
        return consertos.map(this::mapToResponseDTO);
    }

    public List<ConsertoSummaryDTO> buscarConsertosSumario() {
        return consertoRepo.findAllConsertosSummary();
    }

    private ConsertoResponseDTO mapToResponseDTO(Conserto conserto) {
        return new ConsertoResponseDTO(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanico(),
                conserto.getVeiculo()
        );
    }
}
