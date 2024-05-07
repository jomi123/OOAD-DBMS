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
-- Table structure for table `userstory`
--

DROP TABLE IF EXISTS `userstory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userstory` (
  `userstory_id` int NOT NULL AUTO_INCREMENT,
  `sprint_id` int NOT NULL,
  `userstory_name` varchar(50) DEFAULT NULL,
  `userstory_description` varchar(500) DEFAULT NULL,
  `allocation_amount` double NOT NULL,
  `completion_status` enum('to_do','in_progress','done') NOT NULL,
  `emp_assigned` int NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `created_by` int NOT NULL,
  `updated_by` int NOT NULL,
  PRIMARY KEY (`userstory_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  KEY `emp_assigned` (`emp_assigned`),
  KEY `sprint_id` (`sprint_id`),
  CONSTRAINT `userstory_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `userstory_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `userstory_ibfk_3` FOREIGN KEY (`emp_assigned`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `userstory_ibfk_4` FOREIGN KEY (`sprint_id`) REFERENCES `sprint` (`sprint_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userstory`
--

LOCK TABLES `userstory` WRITE;
/*!40000 ALTER TABLE `userstory` DISABLE KEYS */;
INSERT INTO `userstory` VALUES (1,1,'Design','Set up project environment (React and Node.js),Design UI components',1000,'done',1,'2024-04-03','2024-04-07',2,1),(2,1,'Implement Authentication','Implement user authentication using JWT for Reactify project.',1200,'done',2,'2024-04-07','2024-04-10',2,1),(3,2,'Develop User Interface','Develop the user interface components for Reactify project.',1500,'in_progress',1,'2024-04-24','2024-04-30',3,1),(4,2,'Implement Backend Services','Implement backend services and APIs for Reactify project.',1800,'in_progress',2,'2024-04-24','2024-05-01',4,1),(5,3,'Conduct Testing','Conduct comprehensive testing of Reactify project.',1500,'to_do',1,'2024-05-15','2024-05-21',2,1),(6,4,'Optimize Performance','Optimize performance and address any performance-related issues for Reactify project.',1200,'to_do',2,'2024-06-05','2024-06-10',3,1),(7,5,'Design Database Schema','Design and implement the database schema for PyReactStore project.',1200,'done',6,'2024-05-20','2024-05-24',1,1),(8,6,'Implement Product CRUD','Implement basic CRUD operations for products in PyReactStore project.',1500,'in_progress',7,'2024-06-10','2024-06-15',2,1),(9,7,'Develop Checkout Process','Develop the checkout process and implement frontend validation for PyReactStore project.',1800,'to_do',8,'2024-07-01','2024-07-10',3,1),(10,8,'Set up Development Environment','Set up the development environment and install necessary tools for PHPower project.',1000,'to_do',3,'2024-06-21','2024-06-25',1,1),(11,9,'Develop Core Functionality','Develop core functionality and integrate frontend with backend for PHPower project.',1500,'to_do',3,'2024-07-11','2024-07-15',2,1),(12,10,'Implement Additional Features','Implement additional features and conduct testing and debugging for PHPower project.',1800,'to_do',3,'2024-08-01','2024-08-10',3,1),(13,11,'Set up Project Environment','implement basic functionality for EncrypTorch project.',1200,'to_do',5,'2024-07-23','2024-07-28',1,1),(14,12,'Design Database Schema','integrate encryption for EncrypTorch project.',1500,'to_do',5,'2024-08-03','2024-08-08',2,1),(15,13,'Finalize Testing and Optimization','Finalize testing, debugging, for EncrypTorch project.',1800,'to_do',5,'2024-08-24','2024-08-29',3,1),(16,4,'Optimization','Optimization of final code',1000,'to_do',3,'2024-05-25','2024-06-25',3,3),(17,11,'test','testing project',1000,'to_do',3,'2024-05-25','2024-05-25',2,2);
/*!40000 ALTER TABLE `userstory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 15:15:10
