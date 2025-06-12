-- Insere registros completos na tabela 'conserto', incluindo os dados embutidos.

-- Conserto 1: Finalizado
INSERT INTO conserto (
    data_entrada, data_saida, ativo,
    nome, anos_experiencia,
    veiculo_marca, veiculo_modelo, veiculo_ano, veiculo_cor
) VALUES (
             '01/05/2025', '05/05/2025', true,
             'Carlos Silva', 15,
             'Honda', 'Civic', '2021', 'Preto'
         );

-- Conserto 2: Em andamento
INSERT INTO conserto (
    data_entrada, data_saida, ativo,
    nome, anos_experiencia,
    veiculo_marca, veiculo_modelo, veiculo_ano, veiculo_cor
) VALUES (
             '10/06/2025', NULL, true,
             'Ana Pereira', 8,
             'Volkswagen', 'Gol', '2022', 'Branco'
         );

-- Conserto 3: Finalizado e logicamente excluído
INSERT INTO conserto (
    data_entrada, data_saida, ativo,
    nome, anos_experiencia,
    veiculo_marca, veiculo_modelo, veiculo_ano, veiculo_cor
) VALUES (
             '15/04/2025', '25/04/2025', false,
             'Roberto Alves', 22,
             'Ford', 'Ranger', '2020', 'Prata'
         );