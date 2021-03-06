-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: system_survey_database
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `response`
--

DROP TABLE IF EXISTS `response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `response` (
  `survey_id` int(11) NOT NULL,
  `ques_id` int(11) NOT NULL,
  `ques_type` int(11) NOT NULL,
  `ch1` int(11) DEFAULT NULL,
  `ch2` int(11) DEFAULT NULL,
  `ch3` int(11) DEFAULT NULL,
  `ch4` int(11) DEFAULT NULL,
  PRIMARY KEY (`ques_id`),
  CONSTRAINT `FK_ques_id` FOREIGN KEY (`ques_id`) REFERENCES `question` (`ques_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response`
--

LOCK TABLES `response` WRITE;
/*!40000 ALTER TABLE `response` DISABLE KEYS */;
INSERT INTO `response` VALUES (362381,4,2,10,2,0,0),(362381,5,3,0,0,0,0),(362381,6,1,2,0,1,3),(362381,7,1,0,0,2,4),(362381,8,1,2,0,1,2),(362381,9,1,0,0,3,2),(362381,10,1,0,0,0,5),(362381,11,2,3,1,0,0),(362381,12,2,2,0,0,0),(185833,13,1,8,5,9,10),(185833,14,2,11,12,0,0),(362381,15,2,0,1,0,0),(362381,18,1,0,0,0,1),(362381,19,1,0,0,0,1),(362381,20,2,0,1,0,0),(362381,21,3,0,0,0,0),(362381,22,3,0,0,0,0),(362381,23,3,0,0,0,0),(362381,24,3,0,0,0,0),(185833,25,3,0,0,0,0),(1206301,26,1,0,0,0,0),(1206301,27,1,0,0,0,0),(1206301,28,2,0,0,0,0),(185833,29,1,0,0,0,0);
/*!40000 ALTER TABLE `response` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-13 11:01:00
