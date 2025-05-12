-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gestionempleados
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
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `AreaId` int NOT NULL AUTO_INCREMENT,
  `AreaCod` varchar(5) DEFAULT NULL,
  `AreaNombre` varchar(20) DEFAULT NULL,
  `AreaSueldoBasico` double DEFAULT NULL,
  PRIMARY KEY (`AreaId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `banco`
--

DROP TABLE IF EXISTS `banco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banco` (
  `BancoId` int NOT NULL AUTO_INCREMENT,
  `BancoNombre` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`BancoId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato` (
  `ContId` int NOT NULL AUTO_INCREMENT,
  `fechaEmision` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `ContArea` int DEFAULT NULL,
  `ContEmpleado` int DEFAULT NULL,
  `ContJLaboral` int DEFAULT NULL,
  `ContModalidadCont` int DEFAULT NULL,
  `ContActivo` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ContId`),
  KEY `fk_contrato_area` (`ContArea`),
  KEY `fk_contrato_empleado` (`ContEmpleado`),
  KEY `fk_contrato_jord_laboral` (`ContJLaboral`),
  KEY `fk_contrato_modalidad_cont` (`ContModalidadCont`),
  CONSTRAINT `fk_contrato_area` FOREIGN KEY (`ContArea`) REFERENCES `area` (`AreaId`),
  CONSTRAINT `fk_contrato_empleado` FOREIGN KEY (`ContEmpleado`) REFERENCES `empleado` (`EmpId`),
  CONSTRAINT `fk_contrato_jord_laboral` FOREIGN KEY (`ContJLaboral`) REFERENCES `jornadalaboral` (`JLabId`),
  CONSTRAINT `fk_contrato_modalidad_cont` FOREIGN KEY (`ContModalidadCont`) REFERENCES `modalidadcontrato` (`ModContId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cuentabancaria`
--

DROP TABLE IF EXISTS `cuentabancaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentabancaria` (
  `CuentaId` int NOT NULL AUTO_INCREMENT,
  `CuentaCci` varchar(20) DEFAULT NULL,
  `CuentaBanco` int DEFAULT NULL,
  `CuentaEmpleado` int DEFAULT NULL,
  PRIMARY KEY (`CuentaId`),
  UNIQUE KEY `UKpe9prlh77w5camsids48jus0x` (`CuentaCci`),
  KEY `fk_cuenta_banco` (`CuentaBanco`),
  KEY `fk_cuenta_empleado` (`CuentaEmpleado`),
  CONSTRAINT `fk_cuenta_banco` FOREIGN KEY (`CuentaBanco`) REFERENCES `banco` (`BancoId`),
  CONSTRAINT `fk_cuenta_empleado` FOREIGN KEY (`CuentaEmpleado`) REFERENCES `empleado` (`EmpId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `EmpId` int NOT NULL AUTO_INCREMENT,
  `EmpActivo` bit(1) DEFAULT NULL,
  `EmpApMaterno` varchar(20) DEFAULT NULL,
  `EmpApPaterno` varchar(20) DEFAULT NULL,
  `EmpCod` varchar(6) DEFAULT NULL,
  `EmpDni` varchar(8) DEFAULT NULL,
  `EmpFechaNac` date DEFAULT NULL,
  `EmpFoto` varchar(30) DEFAULT NULL,
  `EmpGenero` bit(1) DEFAULT NULL,
  `EmpNombre` varchar(50) DEFAULT NULL,
  `EmpEstadoCivil` int DEFAULT NULL,
  PRIMARY KEY (`EmpId`),
  UNIQUE KEY `UKd02xp6h2o0p74utiqqygtepif` (`EmpCod`),
  UNIQUE KEY `UKhmubb9dxuicrqs21u1eb56io0` (`EmpDni`),
  KEY `fk_empleado_estado_civil` (`EmpEstadoCivil`),
  CONSTRAINT `fk_empleado_estado_civil` FOREIGN KEY (`EmpEstadoCivil`) REFERENCES `estadocivil` (`EstCivilId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `estadocivil`
--

DROP TABLE IF EXISTS `estadocivil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadocivil` (
  `EstCivilId` int NOT NULL AUTO_INCREMENT,
  `EstCivilNombre` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`EstCivilId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `facturacion`
--

DROP TABLE IF EXISTS `facturacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturacion` (
  `FactId` int NOT NULL AUTO_INCREMENT,
  `FactFechaPago` date DEFAULT NULL,
  `FactSueldoNeto` double DEFAULT NULL,
  `FactEmpleado` int DEFAULT NULL,
  PRIMARY KEY (`FactId`),
  KEY `fk_facturacion_empleado` (`FactEmpleado`),
  CONSTRAINT `fk_facturacion_empleado` FOREIGN KEY (`FactEmpleado`) REFERENCES `empleado` (`EmpId`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jornadalaboral`
--

DROP TABLE IF EXISTS `jornadalaboral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jornadalaboral` (
  `JLabId` int NOT NULL AUTO_INCREMENT,
  `JLabNombre` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`JLabId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `IdLogin` int NOT NULL AUTO_INCREMENT,
  `Contrasena` varchar(15) DEFAULT NULL,
  `Estado` bit(1) DEFAULT NULL,
  `Horas` datetime(6) DEFAULT NULL,
  `Usuario` varchar(15) DEFAULT NULL,
  `IdEmpleado` int DEFAULT NULL,
  PRIMARY KEY (`IdLogin`),
  UNIQUE KEY `UKbad359hchqqnct8e4vcllitko` (`Usuario`),
  KEY `fk_login_empleado` (`IdEmpleado`),
  CONSTRAINT `fk_login_empleado` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleado` (`EmpId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `modalidadcontrato`
--

DROP TABLE IF EXISTS `modalidadcontrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modalidadcontrato` (
  `ModContId` int NOT NULL AUTO_INCREMENT,
  `ModContNombre` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ModContId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-12 17:09:56
