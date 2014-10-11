drop database if exists saei_db;
CREATE DATABASE  IF NOT EXISTS `saei_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `saei_db`;

-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: saei_db
-- ------------------------------------------------------
-- Server version 5.6.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_pessoa` char(1) DEFAULT NULL,
  `nome_interessado` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `valor_considerado_venda` decimal(20,0) DEFAULT NULL,
  `dimensao` decimal(20,0) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `data_avaliacao` timestamp NULL DEFAULT NULL,
  `valor_proposto` decimal(20,0) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faturas_pagamento`
--

DROP TABLE IF EXISTS `faturas_pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faturas_pagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_pagamento` int(11) DEFAULT NULL,
  `vencimento` timestamp NULL DEFAULT NULL,
  `valor` decimal(10,0) DEFAULT NULL,
  `link_boleto` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_fp_pagamento_idx` (`id_pagamento`),
  CONSTRAINT `fk_fp_pagamento` FOREIGN KEY (`id_pagamento`) REFERENCES `pagamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faturas_pagamento`
--

LOCK TABLES `faturas_pagamento` WRITE;
/*!40000 ALTER TABLE `faturas_pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `faturas_pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_compra`
--

DROP TABLE IF EXISTS `historico_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historico_compra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `compra_id` int(11) DEFAULT NULL,
  `vendedor_id` int(11) DEFAULT NULL,
  `data_registro` timestamp NULL DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `valor_considerado_venda` decimal(20,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_compra`
--

LOCK TABLES `historico_compra` WRITE;
/*!40000 ALTER TABLE `historico_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interesse_venda`
--

DROP TABLE IF EXISTS `interesse_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interesse_venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_cadastro` datetime DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `produto_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `produto_id_idx` (`produto_id`),
  KEY `fk_iv_cliente_id_idx` (`cliente_id`),
  CONSTRAINT `fk_iv_cliente_id` FOREIGN KEY (`cliente_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iv_produto_id` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interesse_venda`
--

LOCK TABLES `interesse_venda` WRITE;
/*!40000 ALTER TABLE `interesse_venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `interesse_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interesse_venda_historico`
--

DROP TABLE IF EXISTS `interesse_venda_historico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interesse_venda_historico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `situacao` varchar(45) DEFAULT NULL,  
  `descricao` varchar(100) DEFAULT NULL,
  `data_ocorrencia` datetime DEFAULT NULL,
  `interesse_venda_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_interesse_venda_id_idx` (`interesse_venda_id`),
  CONSTRAINT `fk_interesse_venda_id` FOREIGN KEY (`interesse_venda_id`) REFERENCES `interesse_venda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interesse_venda_historico`
--

LOCK TABLES `interesse_venda_historico` WRITE;
/*!40000 ALTER TABLE `interesse_venda_historico` DISABLE KEYS */;
/*!40000 ALTER TABLE `interesse_venda_historico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modalidade_negociacao`
--

DROP TABLE IF EXISTS `modalidade_negociacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modalidade_negociacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `produto_id` int(11) DEFAULT NULL,
  `tipo_negociacao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_mn_produto_idx` (`produto_id`),
  CONSTRAINT `fk_mn_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalidade_negociacao`
--

LOCK TABLES `modalidade_negociacao` WRITE;
/*!40000 ALTER TABLE `modalidade_negociacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `modalidade_negociacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `negocio`
--

DROP TABLE IF EXISTS `negocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `negocio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_vendedor` int(11) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `meio_pagamento` varchar(45) DEFAULT NULL,
  `valor_final_total` decimal(20,0) DEFAULT NULL,
  `data_negociacao` timestamp NULL DEFAULT NULL,
  `tipo_negocio` varchar(45) DEFAULT NULL,
  `id_produto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_n_vendedor_idx` (`id_vendedor`),
  KEY `fk_n_vendedor_idx1` (`id_cliente`),
  KEY `fk_n_produto_idx` (`id_produto`),
  CONSTRAINT `fk_n_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_n_produto` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_n_vendedor` FOREIGN KEY (`id_vendedor`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `negocio`
--

LOCK TABLES `negocio` WRITE;
/*!40000 ALTER TABLE `negocio` DISABLE KEYS */;
/*!40000 ALTER TABLE `negocio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inicio_pagamento` timestamp NULL DEFAULT NULL,
  `fim_pagamento` timestamp NULL DEFAULT NULL,
  `id_negocio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pg_negocio_idx` (`id_negocio`),
  CONSTRAINT `fk_pg_negocio` FOREIGN KEY (`id_negocio`) REFERENCES `negocio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_cadastro` timestamp NULL DEFAULT NULL,
  `dimensoes` decimal(10,0) DEFAULT NULL,
  `preco` decimal(10,0) DEFAULT NULL,
  `situacao` varchar(45) DEFAULT NULL,
  `endereco` varchar(2000) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `tipo_produto` varchar(45) DEFAULT NULL,
  `cidade` varchar(200) DEFAULT NULL,
  `estado` varchar(70) DEFAULT NULL,
  `descricao` varchar(3000) DEFAULT NULL,
  `link_foto` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_cadastro` timestamp NULL DEFAULT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `tipo_pessoa` varchar(45) DEFAULT NULL,
  `endereco` varchar(300) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `usuario` varchar(100) DEFAULT NULL,
  `senha` varchar(200) DEFAULT NULL,
  `tipo_usuario` varchar(45) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-08 20:08:32
