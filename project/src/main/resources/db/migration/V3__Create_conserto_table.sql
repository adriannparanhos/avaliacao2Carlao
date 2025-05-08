CREATE TABLE conserto (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      data_entrada VARCHAR(10) NOT NULL,
      data_saida VARCHAR(10),

      mecanico_id BIGINT NOT NULL,
      veiculo_id BIGINT NOT NULL,

      CONSTRAINT fk_conserto_mecanico
          FOREIGN KEY (mecanico_id)
              REFERENCES mecanico (id)
              ON DELETE RESTRICT,

      CONSTRAINT fk_conserto_veiculo
          FOREIGN KEY (veiculo_id)
              REFERENCES veiculo (id)
              ON DELETE RESTRICT
);
