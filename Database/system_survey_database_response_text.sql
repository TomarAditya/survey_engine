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
-- Table structure for table `response_text`
--

DROP TABLE IF EXISTS `response_text`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `response_text` (
  `survey_id` int(11) DEFAULT NULL,
  `ques_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `answer` varchar(1000) DEFAULT NULL,
  KEY `FK_ques_idx` (`ques_id`),
  KEY `FK_survey_idx` (`survey_id`),
  KEY `FK_user_idx` (`user_id`),
  KEY `FK_userID_idx` (`user_id`),
  CONSTRAINT `FK_ques` FOREIGN KEY (`ques_id`) REFERENCES `question` (`ques_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_survey` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `us` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response_text`
--

LOCK TABLES `response_text` WRITE;
/*!40000 ALTER TABLE `response_text` DISABLE KEYS */;
INSERT INTO `response_text` VALUES (362381,5,1,'1'),(185833,25,1,'ABD	'),(362381,5,33,'21'),(362381,21,33,'21'),(362381,22,33,'12'),(362381,23,33,'12'),(362381,24,33,'S'),(362381,5,34,'hgfds'),(185833,25,34,'23e'),(362381,5,1,'	s		\n		'),(362381,5,1,'as');
/*!40000 ALTER TABLE `response_text` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-13 11:00:58
