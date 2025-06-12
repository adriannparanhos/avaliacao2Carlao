
CREATE TABLE conserto (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          data_entrada VARCHAR(10) NOT NULL,
                          data_saida VARCHAR(10),
                          ativo BOOLEAN DEFAULT TRUE,

                          nome VARCHAR(255) NOT NULL,
                          anos_experiencia INT NOT NULL,

                          veiculo_marca VARCHAR(255) NOT NULL,
                          veiculo_modelo VARCHAR(255) NOT NULL,
                          veiculo_ano VARCHAR(4) NOT NULL,
                          veiculo_cor VARCHAR(255)
);