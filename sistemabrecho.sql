-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 07-Nov-2020 às 18:08
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sistemabrecho`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `rg` varchar(20) NOT NULL,
  `dataNascimento` varchar(10) NOT NULL,
  `rua` varchar(30) NOT NULL,
  `bairro` varchar(30) NOT NULL,
  `numero` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`id`, `nome`, `email`, `cpf`, `rg`, `dataNascimento`, `rua`, `bairro`, `numero`) VALUES
(1, 'Andriw', 'filipe@gmail.com', '082.502.521-21', '2.121.522', '27/07/1991', 'Avencal', 'Comasa', 399),
(2, 'Andriw', 'filipe@gmail.com', '082.502.521-21', '2.121.522', '27/07/1991', 'Avencal', 'Comasa', 399),
(3, 'Fonseca', 'fsfs', '555.555.555-55', '1.111.111', '27/11/5155', 'XV de Março', 'Centro', 520),
(11, 'Alan', 'alan@gmail.com', '555.555.555-55', '5.555.555', '24/05/2000', 'pucarana', 'Comasa', 50),
(12, 'Amauri', 'amauri@gmail.com', '161.515.151-51', '2.515.151', '25/05/1995', 'avencal', 'comasa', 55),
(14, 'Charles', 'ca@g.com', '555.555.555-55', '5.555.555', '20/05/1500', 'tal', 'tal', 300),
(15, 'Adiel', 'adiel@unisociesc.com.br', '551.555.552-25', '5.112.151', '20/05/1987', 'Não sei', 'Aquele', 120),
(16, 'João Paulo', 'joao@gmail.com', '545.255.252-52', '5.155.551', '21/02/1994', 'Tal', 'ass', 20),
(17, 'Andriw', 'filipe@gmail.com', '082.055.545-45', '5.151.515', '27/07/1991', 'Avencal', 'Comasa', 399);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `id` int(11) NOT NULL,
  `genero` varchar(10) NOT NULL,
  `cor` varchar(10) NOT NULL,
  `tamanho` varchar(2) NOT NULL,
  `preco` decimal(5,2) NOT NULL,
  `quantidade` int(4) NOT NULL,
  `tipo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`id`, `genero`, `cor`, `tamanho`, `preco`, `quantidade`, `tipo`) VALUES
(1, 'Masculino', 'Preto', '40', '200.00', 400, 'Blusa'),
(2, 'Feminino', 'Azul', '44', '150.00', 42, 'Vestido'),
(3, 'Feminino', 'Azul', '40', '168.00', 1, 'Vestido'),
(4, 'Feminino', 'Rosa', '38', '120.00', 99, 'Vestido'),
(7, 'Masculino', 'Preto', '20', '20.00', 22, 'Blusa'),
(8, 'Feminino', 'Azul', '38', '80.00', 8, 'Calça'),
(9, 'Masculino', 'Azul', '20', '80.00', 10, 'Blusa'),
(10, 'Masculino', 'Rosa', '20', '200.00', 59, 'Calça'),
(11, 'Feminino', 'Azul', '38', '80.00', 9, 'Calça'),
(13, 'Feminino', 'Azul', '38', '80.00', 10, 'Calça'),
(14, 'Feminino', 'Azul', '38', '80.00', 0, 'Calça'),
(15, 'Feminino', 'Azul', '38', '80.00', 8, 'Calça'),
(17, 'Feminino', 'Azul', '38', '80.00', 10, 'Calça'),
(18, 'Masculino', 'Azul', '37', '55.00', 91, 'Calça'),
(19, 'Feminino', 'Verde', '50', '100.00', 90, 'Saia'),
(20, 'Feminino', 'Azul', '38', '80.00', 5, 'Calça'),
(21, 'Masculino', 'Laranja', '34', '320.00', 10, 'Calçado'),
(22, 'Masculino', 'Marrom', '50', '50.00', 0, 'Calça'),
(23, 'Feminino', 'Rosa', '28', '200.00', 4, 'Blusa'),
(25, 'Masculino', 'Preto', '20', '30.00', 10, 'Calça'),
(26, 'Masculino', 'Preto', '40', '100.00', 2, 'Calça'),
(27, 'Feminino', 'Azul', '38', '200.00', 10, 'Blusa'),
(28, 'Feminino', 'Amarelo', '30', '80.00', 98, 'Calçado'),
(31, 'Masculino', 'Branco', '30', '30.00', 20, 'Blusa'),
(33, 'Masculino', 'Branco', '50', '50.00', 13, 'Blusa'),
(34, 'Masculino', 'Branco', '30', '200.00', 10, 'Blusa'),
(35, 'Masculino', 'Branco', '30', '40.00', 3, 'Blusa'),
(37, 'Masculino', 'Marrom', '42', '100.00', 20, 'Calça'),
(38, 'Feminino', 'Rosa', '40', '150.00', 30, 'Calça'),
(39, 'Masculino', 'Azul', '30', '25.00', 2, 'Blusa'),
(40, 'Masculino', 'Azul', '40', '100.00', 2, 'Calça'),
(41, 'Masculino', 'Branco', '50', '100.00', 1, 'Blusa'),
(42, 'Masculino', 'Marrom', '30', '100.00', 0, 'Calçado'),
(43, 'Masculino', 'Branco', '2', '20.00', 1, 'Blusa');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `login` varchar(10) NOT NULL,
  `senha` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`login`, `senha`) VALUES
('admin', 'admin'),
('fonseca', 'fonseca');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
