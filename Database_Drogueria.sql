-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mercado
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `almacen`
--

DROP TABLE IF EXISTS `almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `almacen` (
  `codigo_alm` varchar(15) NOT NULL,
  `nombre_alm` varchar(50) NOT NULL,
  `id_lot` varchar(15) DEFAULT NULL,
  `id_pro` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`codigo_alm`),
  KEY `almacen_id_lot_fk_idx` (`id_lot`),
  KEY `almacen_id_pro_idx` (`id_pro`),
  CONSTRAINT `almacen_id_lot_fk` FOREIGN KEY (`id_lot`) REFERENCES `lote` (`id_lot`),
  CONSTRAINT `almacen_id_pro` FOREIGN KEY (`id_pro`) REFERENCES `lote` (`id_pro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacen`
--

LOCK TABLES `almacen` WRITE;
/*!40000 ALTER TABLE `almacen` DISABLE KEYS */;
INSERT INTO `almacen` VALUES ('1','ALEMANA','1','5'),('12','Esquina','12','3'),('2','Bogota','14','10'),('20','UIS','13','9'),('23','Dragon','5','1'),('5','CRUZ ROJA','10','10');
/*!40000 ALTER TABLE `almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `almacen_farmacia`
--

DROP TABLE IF EXISTS `almacen_farmacia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `almacen_farmacia` (
  `nit_far` varchar(15) NOT NULL,
  `codigo_alm` varchar(15) NOT NULL,
  PRIMARY KEY (`nit_far`,`codigo_alm`),
  KEY `almacen_farmacia_codigo_farm_fk_idx` (`codigo_alm`),
  CONSTRAINT `almacen_farmacia_codigo_alm_fk` FOREIGN KEY (`codigo_alm`) REFERENCES `almacen` (`codigo_alm`),
  CONSTRAINT `almacen_farmacia_nit _farm_fk` FOREIGN KEY (`nit_far`) REFERENCES `farmacia` (`nit_far`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacen_farmacia`
--

LOCK TABLES `almacen_farmacia` WRITE;
/*!40000 ALTER TABLE `almacen_farmacia` DISABLE KEYS */;
INSERT INTO `almacen_farmacia` VALUES ('200','1'),('195','23');
/*!40000 ALTER TABLE `almacen_farmacia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farmacia`
--

DROP TABLE IF EXISTS `farmacia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `farmacia` (
  `nit_far` varchar(15) NOT NULL,
  `nombre_far` varchar(50) NOT NULL,
  `direccion_far` varchar(50) DEFAULT NULL,
  `codigo_alm` varchar(15) DEFAULT NULL,
  `id_pro` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`nit_far`),
  KEY `farmacia_codigo_alm_fk_idx` (`codigo_alm`),
  KEY `farmacia_id_pro_fk_idx` (`id_pro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farmacia`
--

LOCK TABLES `farmacia` WRITE;
/*!40000 ALTER TABLE `farmacia` DISABLE KEYS */;
INSERT INTO `farmacia` VALUES ('195','JOYA','Ave 152-85','23','1'),('200','CANA','carrera 26 # 12-15','1','10');
/*!40000 ALTER TABLE `farmacia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lote`
--

DROP TABLE IF EXISTS `lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lote` (
  `id_lot` varchar(15) NOT NULL,
  `id_pro` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_lot`),
  KEY `lote_id_pro_fk_idx` (`id_pro`),
  CONSTRAINT `lote_id_pro_fk` FOREIGN KEY (`id_pro`) REFERENCES `producto` (`id_pro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
INSERT INTO `lote` VALUES ('5','1'),('14','10'),('2','100'),('11','12'),('21','13'),('99','14'),('95','2'),('10','20'),('98','23'),('12','3'),('1','5'),('13','9');
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id_pro` varchar(15) NOT NULL,
  `nombre_pro` varchar(50) NOT NULL,
  `temperatura_pro` double NOT NULL,
  `valorBase_pro` double NOT NULL,
  `costo_pro` double DEFAULT NULL,
  PRIMARY KEY (`id_pro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES ('1','Acetaminifem',17,10000,1000),('10','Teriparatida',14,1900,190),('100','NNN',12,500,NULL),('12','Raltegravir',20,70,7),('13','Palivizumab',20,30500,3050),('14','Temozolomida',-10,1500,150),('16','Capecitabina',31,12,1),('19','Cetuximab',24,6600,660),('2','Vitamina C',15,20000,2000),('20','Sorafenib',20,480,48),('21','Dasatinib',13,3000,300),('22','Bortezomib',-5,650000,65000),('23','Bevacizumab',24,10700,NULL),('3','Systane',12,10000,NULL),('4','Calciforte',21,25000,NULL),('5','Imiglucerasa',30,8700,870),('546','Alprostadil',20,14800,1480),('6','Iloprost',-5,2745000,274500),('7','Factor VIII Inhibidor Activado Por Bypass',6,3000,300),('75','Bosentan',29,850,85),('8','Ambrisentan',10,37700,3770),('9','Coagulacion Factor VII Recombinante',19,41000,4100);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_farmacia`
--

DROP TABLE IF EXISTS `producto_farmacia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_farmacia` (
  `id_pro` varchar(15) NOT NULL,
  `nit_far` varchar(15) NOT NULL,
  PRIMARY KEY (`id_pro`,`nit_far`),
  KEY `producto_farmacia_nit_far_fk_idx` (`nit_far`),
  CONSTRAINT `producto_farmacia_id_pro_fk` FOREIGN KEY (`id_pro`) REFERENCES `producto` (`id_pro`),
  CONSTRAINT `producto_farmacia_nit_far_fk` FOREIGN KEY (`nit_far`) REFERENCES `farmacia` (`nit_far`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_farmacia`
--

LOCK TABLES `producto_farmacia` WRITE;
/*!40000 ALTER TABLE `producto_farmacia` DISABLE KEYS */;
INSERT INTO `producto_farmacia` VALUES ('10','195'),('12','200');
/*!40000 ALTER TABLE `producto_farmacia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-29 14:47:26
