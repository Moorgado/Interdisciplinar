CREATE DATABASE InterSoftDB

use InterSoftDB

-- Tabela Usuario
CREATE TABLE Usuario (
    login VARCHAR(20) PRIMARY KEY,
    senha VARCHAR(20) NOT NULL,
	permissao VARCHAR(20) NOT NULL
);

-- Inserção de usuários
INSERT INTO Usuario (login, senha, permissao) VALUES ('Fabio', 'senha123', 'Administrador');
INSERT INTO Usuario (login, senha, permissao) VALUES ('Pedro', 'senha123', 'Funcionário');
INSERT INTO Usuario (login, senha, permissao) VALUES ('Raphael', 'senha123', 'Gerente');
INSERT INTO Usuario (login, senha, permissao) VALUES ('Ian', 'senha123', 'Operador');

Select * from Usuario;

-- Tabela Cliente
CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY IDENTITY,
    nomeCliente VARCHAR(100) NOT NULL,
    cpfCliente VARCHAR(14) NOT NULL,
    contatoCliente VARCHAR(50),
    dividaCli CHAR(1),
    valorDivida MONEY
);

-- Inserção de clientes
INSERT INTO Cliente (nomeCliente, cpfCliente, contatoCliente, dividaCli, valorDivida) 
VALUES ('Carlos Silva', '123.456.789-00', '1111-1111', 'N', 0.0);
INSERT INTO Cliente (nomeCliente, cpfCliente, contatoCliente, dividaCli, valorDivida) 
VALUES ('Maria Souza', '987.654.321-01', '2222-2222', 'S', 150.50);
INSERT INTO Cliente (nomeCliente, cpfCliente, contatoCliente, dividaCli, valorDivida) 
VALUES ('João Pereira', '456.123.789-02', '3333-3333', 'N', 0.0);
INSERT INTO Cliente (nomeCliente, cpfCliente, contatoCliente, dividaCli, valorDivida) 
VALUES ('Ana Lima', '789.123.456-03', '4444-4444', 'S', 200.75);
INSERT INTO Cliente (nomeCliente, cpfCliente, contatoCliente, dividaCli, valorDivida) 
VALUES ('Paulo Oliveira', '321.654.987-04', '5555-5555', 'N', 0.0);

Select * from Cliente;

-- Tabela Funcionario
CREATE TABLE Funcionario (
    idFuncionario INT PRIMARY KEY IDENTITY,
    nomeFuncionario VARCHAR(100) NOT NULL,
    cpfFuncionario VARCHAR(14) NOT NULL,
    cargoFuncionario VARCHAR(20),
    contatoFuncionario VARCHAR(20),
	login VARCHAR(20) NOT NULL
	FOREIGN KEY (login) REFERENCES Usuario(login)
);

--Inserção de funcionários
INSERT INTO Funcionario (nomeFuncionario, cpfFuncionario, cargoFuncionario, contatoFuncionario, login) 
VALUES ('Fabio Souza', '123.456.789-10', 'Administrador', '1111-1111', 'Fabio');
INSERT INTO Funcionario (nomeFuncionario, cpfFuncionario, cargoFuncionario, contatoFuncionario, login) 
VALUES ('Pedro', '987.654.321-11', 'Aux.Geral', '2222-2222', 'Pedro');
INSERT INTO Funcionario (nomeFuncionario, cpfFuncionario, cargoFuncionario, contatoFuncionario, login) 
VALUES ('Raphael', '987.654.321-11', 'Gerente', '2222-2222', 'Raphael');
INSERT INTO Funcionario (nomeFuncionario, cpfFuncionario, cargoFuncionario, contatoFuncionario, login) 
VALUES ('Fernanda Alves', '987.654.321-11', 'Operador', '2222-2222', 'Ian');

Select * from Funcionario;

-- Tabela Fornecedor
CREATE TABLE Fornecedor (
    idFornecedor INT PRIMARY KEY IDENTITY,
    razaoSocial VARCHAR(100) NOT NULL,
    cnpjFornecedor VARCHAR(18) NOT NULL,
    nomeFantasia VARCHAR(100),
    tipoFornecedor VARCHAR(50),
    emailFornecedor VARCHAR(100),
    contatoFornec VARCHAR(20)
);

--Inserção de fornecedores
INSERT INTO Fornecedor (razaoSocial, cnpjFornecedor, nomeFantasia, tipoFornecedor, emailFornecedor, contatoFornec) 
VALUES ('Distribuidora ABC', '12.345.678/0001-00', 'ABC Distribuidora', 'Alimentos', 'contato@abc.com', '1111-1111');
INSERT INTO Fornecedor (razaoSocial, cnpjFornecedor, nomeFantasia, tipoFornecedor, emailFornecedor, contatoFornec) 
VALUES ('Mercado XYZ', '12.345.678/0001-01', 'XYZ Atacado', 'Bebidas', 'contato@xyz.com', '2222-2222');
INSERT INTO Fornecedor (razaoSocial, cnpjFornecedor, nomeFantasia, tipoFornecedor, emailFornecedor, contatoFornec) 
VALUES ('Importadora Global', '12.345.678/0001-02', 'Global Import', 'Importados', 'contato@global.com', '3333-3333');
INSERT INTO Fornecedor (razaoSocial, cnpjFornecedor, nomeFantasia, tipoFornecedor, emailFornecedor, contatoFornec) 
VALUES ('Distribuidora Nacional', '12.345.678/0001-03', 'Nacional Distrib', 'Produtos Gerais', 'contato@nacional.com', '4444-4444');
INSERT INTO Fornecedor (razaoSocial, cnpjFornecedor, nomeFantasia, tipoFornecedor, emailFornecedor, contatoFornec) 
VALUES ('Atacado Central', '12.345.678/0001-04', 'Central Atacado', 'Papelaria', 'contato@central.com', '5555-5555');

Select * from Fornecedor;

-- Tabela PDV
CREATE TABLE PDV (
    idPDV INT PRIMARY KEY IDENTITY
);

--Inserção PDV
INSERT INTO PDV DEFAULT VALUES;

--Acrescentando chave estrangeira de Funcionario no PDV, para registrar quem "iniciou o PDV"
ALTER TABLE PDV ADD idFuncionario int not null
ALTER TABLE PDV ADD CONSTRAINT FK_FUNC_PDV FOREIGN KEY (idFuncionario) REFERENCES Funcionario(idFuncionario);

UPDATE PDV SET idFuncionario = 2 WHERE idPDV = 1;

Select * from PDV;

-- Tabela Produto
CREATE TABLE Produto (
    idProduto INT PRIMARY KEY IDENTITY,
    descProduto VARCHAR(100) NOT NULL,
    precoProdVenda FLOAT,	
    categoriaProd VARCHAR(20),
    embProd FLOAT,
	tipoEmbProd VARCHAR (10),
    embMasterProd INT,
	tipoMaster VARCHAR (10),
    descontoProduto FLOAT
);

--Inserção produtos
INSERT INTO Produto (descProduto, precoProdVenda, categoriaProd, embProd, tipoEmbProd, embMasterProd, tipoMaster, descontoProduto) 
VALUES ('Arroz 5kg', 20.50, 'Alimentos', 5.0, 'KG', 6, 'FD' ,0.00);
INSERT INTO Produto (descProduto, precoProdVenda, categoriaProd, embProd, tipoEmbProd, embMasterProd, tipoMaster, descontoProduto) 
VALUES ('Desinfetante Suprema Azul', 7.00, 'Limpeza', 2.0, 'LT', 6, 'CX' , 0.00);
INSERT INTO Produto (descProduto, precoProdVenda, categoriaProd, embProd, tipoEmbProd, embMasterProd, tipoMaster, descontoProduto) 
VALUES ('Papel Aluminio', 5.75, 'Bazar', 3, 'MT', 24, 'CX', 0.00);
INSERT INTO Produto (descProduto, precoProdVenda, categoriaProd, embProd, tipoEmbProd, embMasterProd, tipoMaster, descontoProduto) 
VALUES ('Óleo 900ml', 8.50, 'Alimentos', 900, 'ML', 24, 'CX', 0.00);
INSERT INTO Produto (descProduto, precoProdVenda, categoriaProd, embProd, tipoEmbProd, embMasterProd, tipoMaster, descontoProduto) 
VALUES ('Sabonete Lux', 2.50, 'Higiene', 130, 'GR', 72, 'FD' , 0.00);

--Acrescentando PreçoCusto via update
UPDATE Produto SET precoProdCusto = 18.99 WHERE idProduto = 1;
UPDATE Produto SET precoProdCusto = 5.99 WHERE idProduto = 2;
UPDATE Produto SET precoProdCusto = 4.00 WHERE idProduto = 3;
UPDATE Produto SET precoProdCusto = 7.69 WHERE idProduto = 4;
UPDATE Produto SET precoProdCusto = 1.63 WHERE idProduto = 5;

--Vinculando produto com figura tributária
UPDATE Produto SET idFigura = 1 WHERE idProduto = 1;
UPDATE Produto SET idFigura = 1 WHERE idProduto = 2;
UPDATE Produto SET idFigura = 2 WHERE idProduto = 3;
UPDATE Produto SET idFigura = 3 WHERE idProduto = 4;
UPDATE Produto SET idFigura = 2 WHERE idProduto = 5;

DELETE FROM Produto WHERE idProduto = 6;
DELETE FROM Produto WHERE idProduto = 7;
DELETE FROM Produto WHERE idProduto = 8;

ALTER TABLE Produto ADD idFigura int
ALTER TABLE Produto ADD CONSTRAINT FK_FIGURA_PROD FOREIGN KEY (idFigura) REFERENCES ClassificacaoFiscal(idFigura);

SELECT * FROM VW_CONSULTA_PRODUTO;

-- Tabela Estoque
CREATE TABLE Estoque (
    idEstoque INT PRIMARY KEY IDENTITY,
    idProduto INT,
    quantProdutoUnit INT,
    FOREIGN KEY (idProduto) REFERENCES Produto(idProduto)
);

--Inserção produtos na tabela estoque
INSERT INTO Estoque (idProduto, quantProdutoUnit) VALUES (1, 60);
INSERT INTO Estoque (idProduto, quantProdutoUnit) VALUES (2, 120);
INSERT INTO Estoque (idProduto, quantProdutoUnit) VALUES (3, 240);
INSERT INTO Estoque (idProduto, quantProdutoUnit) VALUES (4, 72);
INSERT INTO Estoque (idProduto, quantProdutoUnit) VALUES (5, 288);

--SOMENTE EXEMPLO: ESTOQUE JÁ ESTÁ COM VALORES CORRETOS, PÓIS, TEM TRIGGER ATIVA PARA O MESMO
UPDATE Estoque SET quantProdutoUnit = 57 WHERE idProduto = 1;
UPDATE Estoque SET quantProdutoUnit = 118 WHERE idProduto = 2;
UPDATE Estoque SET quantProdutoUnit = 238 WHERE idProduto = 3;
UPDATE Produto SET quantProdutoUnit = 67 WHERE idProduto = 4;
UPDATE Produto SET quantProdutoUnit = 271 WHERE idProduto = 5;

Select * from Estoque

-- Tabela PedidoCompra
CREATE TABLE PedidoCompra (
    idPedidoCompra INT PRIMARY KEY IDENTITY,
    dataPedido DATE,
    statusPedido VARCHAR(50),	
);

-- Acrescentando coluna idFornecedor, idFuncionario e Chaves estranjeiras na tabela PedidoCompra, havia esquecido.
ALTER TABLE PedidoCompra add idFornecedor int not null;
ALTER TABLE PedidoCompra ADD CONSTRAINT FK_FORN_PEDIDO FOREIGN KEY (idFornecedor) REFERENCES Fornecedor(idFornecedor);

ALTER TABLE PedidoCompra add idFuncionario int not null;
ALTER TABLE PedidoCompra ADD CONSTRAINT FK_FUNC_PEDIDO FOREIGN KEY (idFuncionario) REFERENCES Funcionario(idFuncionario);

--Inserção pedidos de compra
INSERT INTO PedidoCompra (dataPedido, statusPedido) VALUES ('06-06-2024', 'Pendente');
INSERT INTO PedidoCompra (dataPedido, statusPedido) VALUES ('31-05-2024', 'Concluído');
INSERT INTO PedidoCompra (dataPedido, statusPedido) VALUES ('01-03-2024', 'Cancelado');
INSERT INTO PedidoCompra (dataPedido, statusPedido) VALUES ('01-06-2024', 'Pendente');
INSERT INTO PedidoCompra (dataPedido, statusPedido) VALUES ('17-05-2024', 'Concluído');

-- Atualização na tabela PedidoCompra por ter esquecido o idFornecedor
UPDATE PedidoCompra SET idFornecedor = 1 WHERE idPedidoCompra = 1;
UPDATE PedidoCompra SET idFornecedor = 2 WHERE idPedidoCompra = 2;
UPDATE PedidoCompra SET idFornecedor = 3 WHERE idPedidoCompra = 3;
UPDATE PedidoCompra SET idFornecedor = 4 WHERE idPedidoCompra = 4;
UPDATE PedidoCompra SET idFornecedor = 5 WHERE idPedidoCompra = 5;

UPDATE PedidoCompra SET idFuncionario = 1 WHERE idPedidoCompra = 1;
UPDATE PedidoCompra SET idFuncionario = 2 WHERE idPedidoCompra = 2;
UPDATE PedidoCompra SET idFuncionario = 3 WHERE idPedidoCompra = 3;
UPDATE PedidoCompra SET idFuncionario = 4 WHERE idPedidoCompra = 4;
UPDATE PedidoCompra SET idFuncionario = 1 WHERE idPedidoCompra = 5;

Select * from PedidoCompra

-- Tabela ItensPedido
CREATE TABLE ItensPedido (
    numTransCompra INT PRIMARY KEY IDENTITY,
    idPedidoCompra INT,
    idProduto INT,
    quantidadeCompraUnit INT,
    FOREIGN KEY (idPedidoCompra) REFERENCES PedidoCompra(idPedidoCompra),
    FOREIGN KEY (idProduto) REFERENCES Produto(idProduto)
);

--Inserção itens do pedido de compra
--pedido 1 Pendente
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (1, 1, 6);
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (1, 3, 24);
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (1, 5, 72);
--pedido 2 Concluído
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (2, 1, 30);
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (2, 2, 60);
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (2, 3, 120);
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (2, 4, 36);
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (2, 5, 144);
--pedido 3 Cancelado
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (3, 2, 60);
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (3, 4, 24);
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (3, 5, 72);
--pedido 4 Pendente
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (4, 1, 12);
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (4, 3, 48);
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (4, 5, 144);
--pedido 5 Concluído
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (5, 1, 30);
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (5, 2, 60);
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (5, 3, 120);
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (5, 4, 36);
INSERT INTO ItensPedido (idPedidoCompra, idProduto, quantidadeCompraUnit) VALUES (5, 5, 144);

Select * from ItensPedido

-- Tabela Vendas
CREATE TABLE Vendas (
    idVenda INT PRIMARY KEY IDENTITY,    
);

--Acrescentando coluna para que seja possível controle de saída de estoque.
ALTER TABLE Vendas ADD confirmaVenda varchar(3) not null;

--Inserção de vendas
INSERT INTO Vendas (confirmaVenda) VALUES ('SIM');
INSERT INTO Vendas (confirmaVenda) VALUES ('SIM');

Select * from Vendas

-- Tabela ItemVenda
CREATE TABLE ItemVenda (
    numTransVenda INT PRIMARY KEY IDENTITY, 
    idVenda INT, 
    idProduto INT, 
    quantVendaUnit INT, 
    FOREIGN KEY (idVenda) REFERENCES Vendas(idVenda),
    FOREIGN KEY (idProduto) REFERENCES Produto(idProduto)
);

--Inserção itens da venda
--venda 1
INSERT INTO ItemVenda (idVenda, idProduto, quantVendaUnit) VALUES (1, 1, 1);
INSERT INTO ItemVenda (idVenda, idProduto, quantVendaUnit) VALUES (1, 3, 1);
INSERT INTO ItemVenda (idVenda, idProduto, quantVendaUnit) VALUES (1, 5, 5);
--venda 2
INSERT INTO ItemVenda (idVenda, idProduto, quantVendaUnit) VALUES (2, 1, 2);
INSERT INTO ItemVenda (idVenda, idProduto, quantVendaUnit) VALUES (2, 2, 2);
INSERT INTO ItemVenda (idVenda, idProduto, quantVendaUnit) VALUES (2, 3, 1);
INSERT INTO ItemVenda (idVenda, idProduto, quantVendaUnit) VALUES (2, 4, 5);
INSERT INTO ItemVenda (idVenda, idProduto, quantVendaUnit) VALUES (2, 5, 12);

Select * from ItemVenda

-- Tabela Caixa
CREATE TABLE Caixa (
    idCaixa INT PRIMARY KEY IDENTITY,
	idVenda INT,
    subTotal FLOAT,
    dtMovimentacao DATETIME DEFAULT GETDATE()
	FOREIGN KEY (idVenda) REFERENCES Vendas(idVenda)
);

--Inserção da movimentação do caixa
INSERT INTO Caixa (idVenda, subTotal) VALUES (1, 28.75);
INSERT INTO Caixa (idVenda, subTotal) VALUES (2, 133.25);

Select * from Caixa

-- Tabela ClassificacaoFiscal --ainda não associada com produtos
CREATE TABLE ClassificacaoFiscal (
    idFigura INT PRIMARY KEY IDENTITY,
    tipoClassificacao VARCHAR(20),
    icmsEntrada FLOAT,
    icmsSaida FLOAT,
    cfop INT,
    cst INT,
    ipi FLOAT,
    st CHAR (1),
    iva FLOAT,
    reduzBaseIcms FLOAT,
    reduzIpi FLOAT,
    reduzAliquota FLOAT
);

--Inserçao de figuras tributárias 
INSERT INTO ClassificacaoFiscal (tipoClassificacao, icmsEntrada, icmsSaida, cfop, cst, ipi, st, iva, reduzBaseIcms, reduzIpi, reduzAliquota) 
VALUES ('Industria', 18.0, 12.0, 5102, 102, 3.25, 'N', 0.0, 33.3, 0.0, 0.0);
INSERT INTO ClassificacaoFiscal (tipoClassificacao, icmsEntrada, icmsSaida, cfop, cst, ipi, st, iva, reduzBaseIcms, reduzIpi, reduzAliquota) 
VALUES ('Atacadista', 18.0, 18.0, 6101, 202, 0.0, 'S', 26.30, 0.0, 0.0, 0.0);
INSERT INTO ClassificacaoFiscal (tipoClassificacao, icmsEntrada, icmsSaida, cfop, cst, ipi, st, iva, reduzBaseIcms, reduzIpi, reduzAliquota) 
VALUES ('Isento', 0.0, 0.0, 7103, 302, 0.0, 'N', 0.0, 0.0, 0.0, 0.0);

Select * from ClassificacaoFiscal

--Trigger incrementar estoque
CREATE TRIGGER Incrementa_QuantEstoque
ON PedidoCompra
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    IF UPDATE(statusPedido)
    BEGIN
        UPDATE Estoque
        SET quantProdutoUnit = quantProdutoUnit + IP.quantidadeCompraUnit
        FROM Estoque E
        INNER JOIN ItensPedido IP ON E.idProduto = IP.idProduto
        INNER JOIN inserted i ON IP.idPedidoCompra = I.idPedidoCompra
        WHERE I.statusPedido = 'CONCLUIDO';
    END
END;

--Trigger decrementar estoque
CREATE TRIGGER Decrementa_QuantEstoque
ON Vendas
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    IF UPDATE(confirmaVenda)
    BEGIN
        UPDATE Estoque
        SET quantProdutoUnit = quantProdutoUnit - IV.quantVendaUnit
        FROM Estoque E
        INNER JOIN ItemVenda IV ON E.idProduto = IV.idProduto
        INNER JOIN inserted I ON IV.idVenda = I.idVenda
        WHERE I.confirmaVenda = 'SIM';
    END
END;

SELECT * FROM sys.triggers

-- INNER JOIN 
--Consulta 1 - Produtos presentes em pedidos com status pendente no período da ultima semana (data atual do sistema -7 dias)

SELECT P.idProduto, P.descProduto, IP.quantidadeCompraUnit, IP.idPedidoCompra, FORMAT (PC.dataPedido, 'dd/MM/yyyy') as dataPedido, PC.statusPedido
FROM ItensPedido IP
INNER JOIN Produto P ON IP.idProduto = p.idProduto
INNER JOIN PedidoCompra PC ON IP.idPedidoCompra = PC.idPedidoCompra
WHERE PC.dataPedido BETWEEN DATEADD(DAY, -7, GETDATE()) AND GETDATE() AND PC.statusPedido = 'PENDENTE'

--Consulta 2 - Produtos com Estoque Baixo (unidade)

SELECT 
    P.idProduto,
	P.descProduto,
    E.quantProdutoUnit
FROM 
    Estoque E
INNER JOIN 
    Produto P ON E.idProduto = P.idProduto
WHERE 
    E.quantProdutoUnit < 100;

-- Consulta 3: Relatório de Funcionários com seus Logins
SELECT 
    F.nomeFuncionario,
    F.cargoFuncionario,
    U.login,
    U.permissao
FROM 
    Funcionario F
INNER JOIN 
    Usuario U ON F.login = U.login;

--Criando e consultando índices

CREATE NONCLUSTERED INDEX id_categoriaProd
ON Produto (categoriaProd);

CREATE NONCLUSTERED INDEX id_itensPedido
ON ItensPedido (idPedidoCompra, idProduto);


SELECT 
    name AS IndexName,
    object_id AS TableObjectId,
    OBJECT_NAME(object_id) AS TableName,
    type_desc AS IndexType,
    is_unique AS IsUnique,
    is_primary_key AS IsPrimaryKey
FROM 
    sys.indexes
WHERE 
    OBJECT_NAME(object_id) = 'Produto';

SELECT 
    name AS IndexName,
    object_id AS TableObjectId,
    OBJECT_NAME(object_id) AS TableName,
    type_desc AS IndexType,
    is_unique AS IsUnique,
    is_primary_key AS IsPrimaryKey
FROM 
    sys.indexes
WHERE 
    OBJECT_NAME(object_id) = 'itensPedido';

--RELATÓRIOS UTILIZADOS COM VIEW + INNER JOIN
CREATE VIEW VW1_RelatorioVendasPorProduto AS
SELECT 
    P.descProduto,
    SUM(IV.quantVendaUnit) AS QuantidadeVendida,
    SUM(IV.quantVendaUnit * P.precoProdVenda) AS TotalVendas
FROM 
    ItemVenda IV
INNER JOIN 
    Produto P ON IV.idProduto = P.idProduto
GROUP BY 
    P.descProduto

SELECT * from VW1_RelatorioVendasPorProduto;

CREATE VIEW VW2_RelatorioPedidos AS
SELECT 
    PC.idPedidoCompra,
    PC.dataPedido,
    PC.statusPedido,
    F.razaoSocial AS Fornecedor,
    P.descProduto,
    P.precoProdCusto,
    IP.quantidadeCompraUnit,
	(P.precoProdCusto * IP.quantidadeCompraUnit) as Total
FROM 
    PedidoCompra PC
INNER JOIN 
    ItensPedido IP ON PC.idPedidoCompra = IP.idPedidoCompra
INNER JOIN 
    Produto P ON IP.idProduto = P.idProduto
INNER JOIN 
    Fornecedor F ON PC.idFornecedor = F.idFornecedor

SELECT * FROM VW2_RelatorioPedidos ORDER BY dataPedido;

-- View para organizar ordem do select da tabela Produto.
Create view VW_CONSULTA_PRODUTO AS 
SELECT idProduto, descProduto, categoriaProd, embProd, tipoEmbProd, embMasterProd, tipoMaster, precoProdCusto, precoProdVenda, idFigura 
FROM PRODUTO;





	