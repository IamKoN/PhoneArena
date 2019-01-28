CREATE DATABASE  IF NOT EXISTS `dbms_phone1` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dbms_phone1`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: dbms_phone1
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `make` text,
  `model` text,
  `price($)` text,
  `RAM(GB)` text,
  `screen(in)` text,
  `mem(GB)` text,
  `avgRating` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES ('Samsung','Galaxy Note8','960','8','6.3','128',41),('Apple','iphone 8 ','960','2','4.7','256',51),('Sony','Xperia XZ1','600','4','5.2','64',43),('LG','V30','500','4','6','64',46),('HTC','U11','649','6','5.5','63',54),('Motorolla','X4','350','3','5.2','32',47),('Huawie','Mate 10','499','4','5.9','64',58),('Microsoft','Lumia 650','120','1','5','16',37),('Nokia','8x','600','6','5.3','64',57),('OnePlus','oneplus 5','500','8','5.5','64',36),('Blackberry','Motion','650','4','5.5','32',63),('Alcatel','Idol 5s','350','3','5.2','32',51),('ZTE','Nubia Z17s','600','8','5.73','64',49),('Xiaomi','MI Mix2','600','8','5.99','64',53),('Google','Pixel 2','649','4','5','64',50),('Acer','Liquid Z6 Plus','649','3','5.5','32',50),('Oppo','A77 ','350','4','5.5','64',47),('Blu','Grand XL','120','2','5.5','16',47),('Vivo','X20','590','4','6.43','64',49),('Meizu','M6 note','240','4','5.5','16',52);
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-19 23:27:09
