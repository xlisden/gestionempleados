CREATE DATABASE  IF NOT EXISTS `gestionempleados` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestionempleados`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tem
-- ------------------------------------------------------
-- Server version	9.1.0

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
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `areas` (
  `id_area` int NOT NULL AUTO_INCREMENT,
  `area_cod` varchar(5) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  PRIMARY KEY (`id_area`),
  UNIQUE KEY `UKnye8l6fgyoh7n7jbxj6qpnv3h` (`area_cod`),
  UNIQUE KEY `UKoxiafm7kisksgy3pncc6e458d` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES (1,'A01','supervicion',1600),(2,'A02','desarrollo',1800),(3,'A03','soporte tecnico',1400),(4,'A04','limpieza',1200);
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datosbancarios`
--

DROP TABLE IF EXISTS `datosbancarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datosbancarios` (
  `id_cuenta` int NOT NULL AUTO_INCREMENT,
  `cci` varchar(20) DEFAULT NULL,
  `id_empleado` int DEFAULT NULL,
  `id_entidad` int DEFAULT NULL,
  PRIMARY KEY (`id_cuenta`),
  UNIQUE KEY `UK7ygrnw0r0gew4q2f7l51rxmom` (`cci`),
  KEY `fk_Datos_empleado` (`id_empleado`),
  KEY `fk_Datos_entidad` (`id_entidad`),
  CONSTRAINT `fk_Datos_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`),
  CONSTRAINT `fk_Datos_entidad` FOREIGN KEY (`id_entidad`) REFERENCES `entidadbancaria` (`id_entidad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datosbancarios`
--

LOCK TABLES `datosbancarios` WRITE;
/*!40000 ALTER TABLE `datosbancarios` DISABLE KEYS */;
INSERT INTO `datosbancarios` VALUES (1,'121212121',1,3);
/*!40000 ALTER TABLE `datosbancarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `id_empleado` int NOT NULL AUTO_INCREMENT,
  `ap_materno` varchar(15) DEFAULT NULL,
  `ap_paterno` varchar(15) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `empleado_cod` varchar(10) DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL,
  `fecha_ingreso` date DEFAULT NULL,
  `fecha_naci` date DEFAULT NULL,
  `foto` varchar(30) DEFAULT NULL,
  `genero` bit(1) DEFAULT NULL,
  `nombres` varchar(20) DEFAULT NULL,
  `id_area` int DEFAULT NULL,
  `est_civil_cod` int DEFAULT NULL,
  `jlab_codigo` int DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  UNIQUE KEY `empleado_cod_UNIQUE` (`empleado_cod`),
  UNIQUE KEY `foto_UNIQUE` (`foto`),
  KEY `fk_empleado_area` (`id_area`),
  KEY `fk_empleado_estadoc` (`est_civil_cod`),
  KEY `fk_empleado_jornada` (`jlab_codigo`),
  CONSTRAINT `fk_empleado_area` FOREIGN KEY (`id_area`) REFERENCES `areas` (`id_area`),
  CONSTRAINT `fk_empleado_estadoc` FOREIGN KEY (`est_civil_cod`) REFERENCES `estadosciviles` (`est_civil_cod`),
  CONSTRAINT `fk_empleado_jornada` FOREIGN KEY (`jlab_codigo`) REFERENCES `jorandaslaborales` (`jlab_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'tolen','espim','7555','C001',_binary '','2025-04-23','2004-04-22','ddd.png',_binary '','sas',1,1,1);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entidadbancaria`
--

DROP TABLE IF EXISTS `entidadbancaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entidadbancaria` (
  `id_entidad` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_entidad`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entidadbancaria`
--

LOCK TABLES `entidadbancaria` WRITE;
/*!40000 ALTER TABLE `entidadbancaria` DISABLE KEYS */;
INSERT INTO `entidadbancaria` VALUES (1,'BCP'),(2,'BBVA'),(3,'Scotiabank'),(4,'Interbank'),(5,'Banco Pichincha'),(6,'Citibank Peru'),(7,'MiBanco'),(8,'Banco Falabella'),(9,'Banco de comercio'),(10,'BanBif'),(11,'Banco Ripley');
/*!40000 ALTER TABLE `entidadbancaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadosciviles`
--

DROP TABLE IF EXISTS `estadosciviles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadosciviles` (
  `est_civil_cod` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`est_civil_cod`),
  UNIQUE KEY `UKhv5o2504nhj6vbio9qt4bbjun` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadosciviles`
--

LOCK TABLES `estadosciviles` WRITE;
/*!40000 ALTER TABLE `estadosciviles` DISABLE KEYS */;
INSERT INTO `estadosciviles` VALUES (2,'Casado'),(3,'Divorsiado'),(1,'Soltero'),(4,'Viudo');
/*!40000 ALTER TABLE `estadosciviles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturacion`
--

DROP TABLE IF EXISTS `facturacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturacion` (
  `facturacion_cod` int NOT NULL AUTO_INCREMENT,
  `fecha_pago` date DEFAULT NULL,
  `sueldo_neto` double DEFAULT NULL,
  `id_empleado` int DEFAULT NULL,
  PRIMARY KEY (`facturacion_cod`),
  KEY `fk_facturacion_empleado` (`id_empleado`),
  CONSTRAINT `fk_facturacion_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturacion`
--

LOCK TABLES `facturacion` WRITE;
/*!40000 ALTER TABLE `facturacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `facturacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jorandaslaborales`
--

DROP TABLE IF EXISTS `jorandaslaborales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jorandaslaborales` (
  `jlab_codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`jlab_codigo`),
  UNIQUE KEY `UKnvaslv4tv319u6cgufo2sdo9d` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jorandaslaborales`
--

LOCK TABLES `jorandaslaborales` WRITE;
/*!40000 ALTER TABLE `jorandaslaborales` DISABLE KEYS */;
INSERT INTO `jorandaslaborales` VALUES (1,'Tiempo Completo'),(2,'Tiempo Parcial');
/*!40000 ALTER TABLE `jorandaslaborales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id_login` int NOT NULL AUTO_INCREMENT,
  `contrasena` varchar(15) DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL,
  `horas` time(6) DEFAULT NULL,
  `usuario` varchar(15) DEFAULT NULL,
  `id_empleado` int DEFAULT NULL,
  PRIMARY KEY (`id_login`),
  UNIQUE KEY `UKl4ftqaam486ltfcs5mdsxyffo` (`usuario`),
  KEY `fk_login_empleado` (`id_empleado`),
  CONSTRAINT `fk_login_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'123',_binary '','01:37:11.515000','wolf',1);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modalidadescontrato`
--

DROP TABLE IF EXISTS `modalidadescontrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modalidadescontrato` (
  `id_modalidad` int NOT NULL AUTO_INCREMENT,
  `fecha_fin` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `id_empleado` int DEFAULT NULL,
  `id_tipo_modalidad` int DEFAULT NULL,
  PRIMARY KEY (`id_modalidad`),
  KEY `fk_modalidad_empleado` (`id_empleado`),
  KEY `fk_modalidad_tipomodalidad` (`id_tipo_modalidad`),
  CONSTRAINT `fk_modalidad_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`),
  CONSTRAINT `fk_modalidad_tipomodalidad` FOREIGN KEY (`id_tipo_modalidad`) REFERENCES `tipomodalidad` (`id_tipo_modalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalidadescontrato`
--

LOCK TABLES `modalidadescontrato` WRITE;
/*!40000 ALTER TABLE `modalidadescontrato` DISABLE KEYS */;
INSERT INTO `modalidadescontrato` VALUES (1,NULL,'2025-04-23',1,1);
/*!40000 ALTER TABLE `modalidadescontrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipomodalidad`
--

DROP TABLE IF EXISTS `tipomodalidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipomodalidad` (
  `id_tipo_modalidad` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_modalidad`),
  UNIQUE KEY `UK6bqtmgg6i5xehudh6valc3x33` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipomodalidad`
--

LOCK TABLES `tipomodalidad` WRITE;
/*!40000 ALTER TABLE `tipomodalidad` DISABLE KEYS */;
INSERT INTO `tipomodalidad` VALUES (2,'definido'),(1,'Imdefinido');
/*!40000 ALTER TABLE `tipomodalidad` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-29 11:49:19
