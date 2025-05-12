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
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'A001','Finanzas',1000),(2,'A002','Servicio Al Cliente',2000),(3,'A003','Marketing',1600),(4,'A004','Administración',1800);
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `banco`
--

LOCK TABLES `banco` WRITE;
/*!40000 ALTER TABLE `banco` DISABLE KEYS */;
INSERT INTO `banco` VALUES (1,'Banco Pichincha'),(2,'Banco de Guayaquil'),(3,'Banco del Austro'),(4,'Produbanco'),(5,'Banco Internacional');
/*!40000 ALTER TABLE `banco` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
INSERT INTO `contrato` VALUES (1,'2023-01-15','2023-12-31','2023-01-15',1,1,1,1,_binary ''),(2,'2023-03-01','2025-05-06','2023-03-01',2,2,2,2,_binary ''),(3,'2023-05-10','2025-05-06','2023-05-10',3,4,1,2,_binary '\0'),(4,'2024-11-13',NULL,'2025-05-06',4,5,2,1,_binary ''),(5,'2023-09-15','2025-05-06','2023-09-15',1,3,1,1,_binary '\0'),(6,'2025-05-09','2025-05-06','2025-05-04',1,6,1,1,_binary '\0'),(7,'2025-03-19',NULL,'2025-05-06',2,7,2,1,_binary ''),(8,'2025-03-19','2025-05-06','2025-05-06',3,9,1,2,_binary '\0'),(9,'2025-01-07',NULL,'2025-02-01',1,9,1,1,_binary ''),(10,'2025-03-07','2025-05-07','2025-02-25',2,3,2,1,_binary '\0'),(11,'2025-02-06',NULL,'2025-03-05',3,4,2,1,_binary ''),(12,'2025-03-19',NULL,'2025-05-06',1,10,1,1,_binary ''),(13,'2025-05-03',NULL,'2025-05-06',2,11,1,1,_binary ''),(14,'2025-05-10',NULL,'2024-12-12',2,3,1,1,_binary ''),(16,NULL,NULL,'2024-10-04',1,13,1,2,_binary '\0');
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `cuentabancaria`
--

LOCK TABLES `cuentabancaria` WRITE;
/*!40000 ALTER TABLE `cuentabancaria` DISABLE KEYS */;
INSERT INTO `cuentabancaria` VALUES (1,'00112233445566778899',1,1),(2,'99887766554433221100',2,2),(3,'11223344556677880099',3,3),(4,'00998877665544332211',4,4),(5,'22334455667788990011',5,5),(6,'11112222333344445555',2,6),(10,'11112222333344448787',2,11),(12,'11112222333344445566',2,7),(13,'11112222333344445577',3,9),(14,'11112222333344445588',3,10),(15,'11112222333344449191',2,13);
/*!40000 ALTER TABLE `cuentabancaria` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,_binary '','Vargas','Pérez','E0001','1710001','1990-05-15','foto1.jpg',_binary '\0','Juan',1),(2,_binary '\0','López','García','E0002','1720002','1985-12-01','foto2.jpg',_binary '','María',2),(3,_binary '','Torres','Ruiz','E0003','1730003','1992-08-22','foto3.jpg',_binary '\0','Carlos',3),(4,_binary '','Castro','Díaz','E0004','1740004','1988-03-10','foto4.jpg',_binary '','Ana',4),(5,_binary '','Guerrero','Sanchez','E0005','1750005','1995-07-04','foto5.jpg',_binary '\0','Luis',1),(6,_binary '\0','apm1','app1','E0006','12345678','2025-05-07','E0006.png',_binary '\0','name1',2),(7,_binary '','un Gato','Soy','E0007','87654321','2025-04-02','ddd.png',_binary '\0','Hola',4),(9,_binary '','qwwqeee','Soy','E0009','87234321','2025-04-02','ddd.png',_binary '\0','doc1',3),(10,_binary '','OIEWO','Soy','E0010','87234343','2007-01-10','ddd.png',_binary '\0','doc1',4),(11,_binary '','un Gato','app1','E0011','17202121','2022-01-06','ddd.png',_binary '\0','nionejo',2),(13,_binary '\0','Segunda','Alcachofa','E0013','87234349','2008-10-24','ddd.png',_binary '\0','Juanita',1);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `estadocivil`
--

LOCK TABLES `estadocivil` WRITE;
/*!40000 ALTER TABLE `estadocivil` DISABLE KEYS */;
INSERT INTO `estadocivil` VALUES (1,'Soltero'),(2,'Casado'),(3,'Divorciado'),(4,'Viudo');
/*!40000 ALTER TABLE `estadocivil` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `facturacion`
--

LOCK TABLES `facturacion` WRITE;
/*!40000 ALTER TABLE `facturacion` DISABLE KEYS */;
INSERT INTO `facturacion` VALUES (121,'2025-05-02',1000,1),(122,'2025-05-06',1400,2),(123,'2025-05-06',1800,5),(124,'2025-05-06',1200,3),(125,'2025-05-06',1200,6),(126,'2025-05-06',1400,7),(127,'2025-05-06',1200,1),(128,'2025-05-06',1200,1),(129,'2025-05-06',1200,1),(130,'2025-05-06',1200,1),(131,'2025-05-06',1200,1),(132,'2025-05-06',1600,9),(133,'2025-05-06',1600,4),(134,'2025-05-06',1200,10),(135,'2025-05-06',1400,11),(136,'2025-05-06',1400,11),(137,'2025-05-06',1400,11),(138,'2025-05-06',1400,3),(139,'2025-05-06',1400,3),(140,'2025-05-06',1400,3),(141,'2025-05-06',1400,3),(142,'2025-05-18',1400,3),(143,'2025-05-30',1400,3),(144,'2025-05-24',2000,3),(145,'2025-05-24',2000,3),(146,'2025-05-24',2000,3),(147,'2025-05-24',2000,3),(148,'2025-05-24',2000,3),(149,'2025-05-07',2000,3),(150,'2025-05-10',1000,13);
/*!40000 ALTER TABLE `facturacion` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `jornadalaboral`
--

LOCK TABLES `jornadalaboral` WRITE;
/*!40000 ALTER TABLE `jornadalaboral` DISABLE KEYS */;
INSERT INTO `jornadalaboral` VALUES (1,'Tiempo Completo'),(2,'Tiempo Parcial');
/*!40000 ALTER TABLE `jornadalaboral` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'SA%123',_binary '','2025-05-12 16:32:25.654242','sa',NULL);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Dumping data for table `modalidadcontrato`
--

LOCK TABLES `modalidadcontrato` WRITE;
/*!40000 ALTER TABLE `modalidadcontrato` DISABLE KEYS */;
INSERT INTO `modalidadcontrato` VALUES (1,'Plazo Indeterminado'),(2,'Plazo Determinado');
/*!40000 ALTER TABLE `modalidadcontrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'gestionempleados'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-12 17:09:03
