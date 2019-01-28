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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` text,
  `password` text,
  `firstname` text,
  `lastname` text,
  `email` text,
  `phoneNum` text,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('DustyOregeno','MTwU7b','Dean','Orrell','DustyOregeno@email.com','202-555-0194','2017-10-18 19:03:45'),('BuckleKuckle','wKDq6F','Brandit','Kole','BuckleKuckle@email.com','202-555-0169','2017-10-18 19:03:45'),('ApacalypseMartyr','5WVZgy','Alycia','Mort','ApacalypseMartyr@email.com','303-350-7462','2017-10-18 19:03:45'),('AllCool','5EdcHX','Arron','Christholm','AllCool@email.com','347-618-5679','2017-10-18 19:03:45'),('AshamedWallnut','V5QBnF','Alma','Wilbur','AshamedWallnut@email.com','318-258-8647','2017-10-18 19:03:45'),('EditedWalker','g7RyzE','Elyse','Woody','EditedWalker@email.com','618-342-1938','2017-10-18 19:03:45'),('RisenTalker','9D4zgz','Rita','Tyrone','RisenTalker@email.com','661-538-8255','2017-10-18 19:03:45'),('BahefulExpert','EhRL8c','Buddy','Essence','BahefulExpert@email.com','360-735-4402','2017-10-18 19:03:45'),('CommunistKilljoy','QpG8Ga','Christine','Kaeden','CommunistKilljoy@email.com','713-815-9851','2017-10-18 19:03:45'),('KrampusDeject','4Bd7eX','Kameron','Dorretta','KrampusDeject@email.com','414-758-1868','2017-10-18 19:03:45'),('BrusqueJanitor','3pwQ7Y','Bristol','Jason','BrusqueJanitor@email.com','205-913-1518','2017-10-18 19:03:45'),('AquaticMummy','eeKs2R','Alger','Makayla','AquaticMummy@email.com','561-275-0896','2017-10-18 19:03:45'),('LoralMockups','A5Rc2d','Lorettal','Mortemer','LoralMockups@email.com','314-660-2421','2017-10-18 19:03:45'),('StupidMarxist','55jnDN','Stefani','Mortemer','StupidMarxist@email.com','618-779-5115','2017-10-18 19:03:45'),('EvillPotter','QDL5zw','Evelyn','Phebe','EvillPotter@email.com','661-859-1580','2017-10-18 19:03:45'),('ArenoidSubject','4Ljp8A','Annie','Stacey','ArenoidSubject@email.com','256-867-3904','2017-10-18 19:03:45'),('KindMeddler','2vDXwz','Kelsi','Moria','KindMeddler@email.com','828-245-5448','2017-10-18 19:03:45'),('TakenProctor','L3uNWJ','Tamara','Phil','TakenProctor@email.com','760-367-6794','2017-10-18 19:03:45'),('ToxicAbjured','raTU8F','Tracie','Amilia','ToxicAbjured@email.com','218-538-2551','2017-10-18 19:03:45'),('LyminalTaxing','cm3Uvf','Lynnette','Tristen','LyminalTaxing@email.com','361-576-4676','2017-10-18 19:03:45'),('UltimatumHero','3xkDtB','Urbana','Herminia','UltimatumHero@email.com','213-200-4930','2017-10-18 19:03:45'),('GlossyLier','7fvMEg','Grover','Lynette','GlossyLier@email.com','574-505-8933','2017-10-18 19:03:45'),('ExoticPeacock','8NnaMV','Elosia','Philippa','ExoticPeacock@email.com','317-364-2622','2017-10-18 19:03:45'),('AmorphusAlchemy','s9ThhY','Avice','Amyletta','AmorphusAlchemy@email.com','660-553-9208','2017-10-18 19:03:45'),('DazedDuck','7gnHVe','Doris','Danica','DazedDuck@email.com','417-737-6552','2017-10-18 19:03:45'),('ExemptJabberwocky','k27hQk','Eula','Jayla','ExemptJabberwocky@email.com','832-570-7255','2017-10-18 19:03:45'),('AllEtudes','9LKx6j','Alexandra','Eladio','AllEtudes@email.com','661-859-1580','2017-10-18 19:03:45'),('SubtleAroma','dPve9g','Sandie','Alene','SubtleAroma@email.com','256-867-3904','2017-10-18 19:03:45'),('DilapidatedIsotope','Zs4JuS','Dayna','Issy','DilapidatedIsotope@email.com','828-245-5448','2017-10-18 19:03:45'),('GreenJuggleer','4aMhRW','Grabriella','Jasia','GreenJuggleer@email.com','760-367-6794','2017-10-18 19:03:45'),('TatteredTaker','DT9jwc','Terenzio','Tucker','TatteredTaker@email.com','419-482-3356','2017-10-18 19:03:45'),('ShatteredGardener','Eqk6Jz','Shelton','Gwen','ShatteredGardener@email.com','850-492-7390','2017-10-18 19:03:45'),('ZaggingZeebra','S5gw9J','Zachery','Zachariah','ZaggingZeebra@email.com','337-678-2173','2017-10-18 19:03:45'),('EndlessOrchid','UW2wmV','Erica','Oli','EndlessOrchid@email.com','719-302-3011','2017-10-18 19:03:45'),('YodelingKench','Y6naVA','Yolanda','Kathleen','YodelingKench@email.com','703-579-6450','2017-10-18 19:03:45'),('NeatCutter','7adYrQ','Nate','Charley','NeatCutter@email.com','214-855-9728','2017-10-18 19:03:45'),('AloofVindicator','jRBa7j','Amatore','Valentine','AloofVindicator@email.com','559-536-7723','2017-10-18 19:03:45'),('JadeReject','xy49GJ','Jacinda','Raegan','JadeReject@email.com','213-200-9777','2017-10-18 19:03:45'),('GreatDaedalus','2mfGQB','George','Dorretta','GreatDaedalus@email.com','909-827-6166','2017-10-18 19:03:45'),('KineticArmorer','we5Eme','Kristie','Ambrose','KineticArmorer@email.com','440-539-5487','2017-10-18 19:03:45');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
