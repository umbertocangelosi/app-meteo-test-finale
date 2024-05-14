CREATE DATABASE  IF NOT EXISTS `react_meteo_app` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `react_meteo_app`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: react_meteo_app
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS utente;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE utente (
  ID_U int NOT NULL AUTO_INCREMENT,
  Nome varchar(255) DEFAULT NULL,
  Cognome varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  citta varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID_U),
  UNIQUE KEY email_UNIQUE (email)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES utente WRITE;
/*!40000 ALTER TABLE utente DISABLE KEYS */;
INSERT INTO utente VALUES (2,'Mario','Rossi','mario.rossi@gmail.com','0e503b9b0316619a04506e808a0f3dc26136dced64b05887e75a85c0078188e7','Palermo');
/*!40000 ALTER TABLE utente ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weather_forecast`
--

DROP TABLE IF EXISTS weather_forecast;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE weather_forecast (
  ID_W int NOT NULL AUTO_INCREMENT,
  FK_U int DEFAULT NULL,
  city varchar(255) DEFAULT NULL,
  temperature decimal(5,2) DEFAULT NULL,
  feels_like decimal(5,2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  cloudiness decimal(5,2) DEFAULT NULL,
  humidity decimal(5,2) DEFAULT NULL,
  pressure decimal(7,2) DEFAULT NULL,
  wind_speed decimal(6,2) DEFAULT NULL,
  wind_direction decimal(6,2) DEFAULT NULL,
  sunrise datetime DEFAULT NULL,
  sunset datetime DEFAULT NULL,
  forecast_date datetime DEFAULT NULL,
  created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID_W),
  KEY FK_U (FK_U),
  CONSTRAINT weather_forecast_ibfk_1 FOREIGN KEY (FK_U) REFERENCES utente (ID_U)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weather_forecast`
--

LOCK TABLES weather_forecast WRITE;
/*!40000 ALTER TABLE weather_forecast DISABLE KEYS */;
INSERT INTO weather_forecast VALUES (1,2,'Palermo',24.92,24.59,'broken clouds',56.00,43.00,1008.00,1.35,192.00,'2024-05-14 05:56:28','2024-05-14 20:07:43','2024-05-14 17:05:18','2024-05-14 15:05:18'),(2,2,'Palermo',24.92,24.62,'broken clouds',56.00,44.00,1008.00,1.35,192.00,'2024-05-14 05:56:28','2024-05-14 20:07:43','2024-05-14 17:22:15','2024-05-14 15:22:15'),(3,2,'Palermo',25.22,24.97,'scattered clouds',44.00,45.00,1008.00,0.79,181.00,'2024-05-14 05:56:28','2024-05-14 20:07:43','2024-05-14 17:37:14','2024-05-14 15:37:14');
/*!40000 ALTER TABLE weather_forecast ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-14 17:51:41
