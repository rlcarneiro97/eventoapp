-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 23-Dez-2022 às 00:41
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `eventosapp`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `convidado`
--

CREATE TABLE `convidado` (
  `rg` varchar(255) NOT NULL,
  `nome_convidado` varchar(255) NOT NULL,
  `evento_codigo` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `convidado`
--

INSERT INTO `convidado` (`rg`, `nome_convidado`, `evento_codigo`) VALUES
('10456206756', 'Rafael Lima', 1),
('23184659094', 'Fernanda Souza', 7),
('46549863434', 'Samira Duarte', 1),
('8491564985', 'Eduardo Campos', 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `evento`
--

CREATE TABLE `evento` (
  `codigo` bigint(20) NOT NULL,
  `data` varchar(255) NOT NULL,
  `horario` varchar(255) NOT NULL,
  `local` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `evento`
--

INSERT INTO `evento` (`codigo`, `data`, `horario`, `local`, `nome`) VALUES
(1, '2022-11-05', '20:30', 'Teatro Pedra do Reino', 'Show de Tiago Iorc'),
(6, '2022-12-26', '07:00', 'Parque Solon de Lucena', 'Evento Beneficente'),
(7, '2022-12-31', '20:30', 'Busto de Tamandaré', 'Festa de Ano Novo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `role`
--

CREATE TABLE `role` (
  `nome_role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `role`
--

INSERT INTO `role` (`nome_role`) VALUES
('ROLE_ADMIN'),
('ROLE_USER');

-- --------------------------------------------------------

--
-- Estrutura da tabela `role_usuarios`
--

CREATE TABLE `role_usuarios` (
  `role_nome_role` varchar(255) NOT NULL,
  `usuarios_login` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `login` varchar(255) NOT NULL,
  `nome_completo` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`login`, `nome_completo`, `senha`) VALUES
('admin', 'Administrador', '$2a$10$QOxrT6D6vZ1/UIoM.Upq6OY2Xcp8qVlFghsFtZmuGVSeJSYdRjUqC'),
('rafael', 'Rafael Carneiro', '$2a$10$9PHQDAUtSwV7LYa/E1ObYe3V2j.UzKIqXmcf2lBBjNuaBJ/uWRHzq');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios_roles`
--

CREATE TABLE `usuarios_roles` (
  `usuario_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuarios_roles`
--

INSERT INTO `usuarios_roles` (`usuario_id`, `role_id`) VALUES
('rafael', 'ROLE_USER'),
('admin', 'ROLE_ADMIN');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `convidado`
--
ALTER TABLE `convidado`
  ADD PRIMARY KEY (`rg`),
  ADD KEY `FK4tlkcowf3oxi1u8wmjd9bhes4` (`evento_codigo`);

--
-- Índices para tabela `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`codigo`);

--
-- Índices para tabela `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`nome_role`);

--
-- Índices para tabela `role_usuarios`
--
ALTER TABLE `role_usuarios`
  ADD KEY `FKh0maiyq0mkm4ljt7i1obov7m6` (`usuarios_login`),
  ADD KEY `FK4021ish78hu63a0vuyhrqven0` (`role_nome_role`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`login`);

--
-- Índices para tabela `usuarios_roles`
--
ALTER TABLE `usuarios_roles`
  ADD KEY `FKefntoswg8cckktsk0ha1wpm0i` (`role_id`),
  ADD KEY `FKebiaxjbamgu326glxo1fbysuh` (`usuario_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `evento`
--
ALTER TABLE `evento`
  MODIFY `codigo` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `convidado`
--
ALTER TABLE `convidado`
  ADD CONSTRAINT `FK4tlkcowf3oxi1u8wmjd9bhes4` FOREIGN KEY (`evento_codigo`) REFERENCES `evento` (`codigo`);

--
-- Limitadores para a tabela `role_usuarios`
--
ALTER TABLE `role_usuarios`
  ADD CONSTRAINT `FK4021ish78hu63a0vuyhrqven0` FOREIGN KEY (`role_nome_role`) REFERENCES `role` (`nome_role`),
  ADD CONSTRAINT `FKh0maiyq0mkm4ljt7i1obov7m6` FOREIGN KEY (`usuarios_login`) REFERENCES `usuario` (`login`);

--
-- Limitadores para a tabela `usuarios_roles`
--
ALTER TABLE `usuarios_roles`
  ADD CONSTRAINT `FKebiaxjbamgu326glxo1fbysuh` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`login`),
  ADD CONSTRAINT `FKefntoswg8cckktsk0ha1wpm0i` FOREIGN KEY (`role_id`) REFERENCES `role` (`nome_role`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
