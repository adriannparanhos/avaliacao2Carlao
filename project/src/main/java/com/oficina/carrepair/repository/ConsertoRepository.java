package com.oficina.carrepair.repository;

import com.oficina.carrepair.model.Conserto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    
    @Query("SELECT c FROM Conserto c")
    Page<Conserto> findAllConsertos(Pageable pageable);
    
    @Query("SELECT new com.oficina.carrepair.dto.ConsertoSummaryDTO(c.dataEntrada, c.dataSaida, " +
           "c.mecanico.nome, c.veiculo.marca, c.veiculo.modelo) FROM Conserto c")
    List<com.oficina.carrepair.dto.ConsertoSummaryDTO> findAllConsertosSummary();
}