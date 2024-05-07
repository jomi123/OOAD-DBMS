-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: resourceforprojects
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `sprint`
--

DROP TABLE IF EXISTS `sprint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sprint` (
  `sprint_id` int NOT NULL AUTO_INCREMENT,
  `sprint_name` varchar(50) NOT NULL,
  `sprint_goal` varchar(500) NOT NULL,
  `project_id` int NOT NULL,
  `sprint_status` enum('plan','active','completed') DEFAULT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `created_by` int NOT NULL,
  `updated_by` int NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` date DEFAULT NULL,
  PRIMARY KEY (`sprint_id`),
  KEY `project_id` (`project_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `sprint_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`),
  CONSTRAINT `sprint_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `sprint_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sprint`
--

LOCK TABLES `sprint` WRITE;
/*!40000 ALTER TABLE `sprint` DISABLE KEYS */;
INSERT INTO `sprint` VALUES (1,'Sprint Reactify 1','Establish the foundational structure and setup for the Reactify project.',1,'completed','2024-04-03','2024-04-23',1,1,'2024-04-03',NULL),(2,'Sprint Reactify 2','Implement core features for Reactify ',1,'plan','2024-04-24','2024-05-14',2,4,'2024-04-20','2024-04-22'),(3,'Sprint Reactify 3','Finalize main functionality for Reactify',1,'plan','2024-05-15','2024-06-04',3,1,'2024-05-10','2024-05-14'),(4,'Sprint Reactify 4','Conduct testing, debugging, and optimization for Reactify',1,'plan','2024-06-05','2024-06-20',4,2,'2024-06-01','2024-06-04'),(5,'Sprint PyReactStore 1','Set up project environment and design database schema for PyReactStore',2,'active','2024-05-20','2024-06-09',1,1,'2024-05-20',NULL),(6,'Sprint PyReactStore 2','Implement basic CRUD operations for products in PyReactStore',2,'plan','2024-06-10','2024-06-30',2,3,'2024-06-05','2024-06-09'),(7,'Sprint PyReactStore 3','Develop checkout process and implement frontend validation for PyReactStore',2,'plan','2024-07-01','2024-07-21',3,2,'2024-06-30','2024-07-03'),(8,'Sprint PHPower 1','Set up project environment and design UI/UX for PHPower',3,'active','2024-06-21','2024-07-10',1,1,'2024-06-21',NULL),(9,'Sprint PHPower 2','Develop core functionality and integrate frontend with backend for PHPower',3,'plan','2024-07-11','2024-07-31',2,3,'2024-07-10','2024-07-14'),(10,'Sprint PHPower 3','Implement additional features and conduct testing and debugging for PHPower',3,'plan','2024-08-01','2024-08-21',3,2,'2024-07-31','2024-08-03'),(11,'Sprint EncrypTorch 1','Set up project environment and implement basic functionality for EncrypTorch',4,'active','2024-07-23','2024-08-02',1,1,'2024-07-23',NULL),(12,'Sprint EncrypTorch 2','Design database schema and integrate encryption for EncrypTorch',4,'plan','2024-08-03','2024-08-23',2,4,'2024-08-02','2024-08-06'),(13,'Sprint EncrypTorch 3','Finalize testing, debugging, and optimization for EncrypTorch',4,'plan','2024-08-24','2024-09-03',3,1,'2024-08-23','2024-08-26'),(14,'','develop data analysis tool',1,'plan','2024-05-25','2024-06-25',3,3,'2024-05-20','2024-05-26'),(18,'ab','abcd',1,'active','2024-04-03','2024-04-23',1,1,'2024-04-03','2024-04-03'),(23,'','develop data analysis tool',4,'plan','2024-05-25','2024-06-25',3,3,'2024-05-20','2024-05-26'),(24,'Datashield2','develop data analysis tool',4,'plan','2024-05-25','2024-06-25',3,3,'2024-05-20','2024-05-26');
/*!40000 ALTER TABLE `sprint` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 15:15:09
