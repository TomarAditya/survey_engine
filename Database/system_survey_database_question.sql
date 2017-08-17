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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `ques_id` int(11) NOT NULL,
  `survey_id` int(11) NOT NULL,
  `text` varchar(1000) DEFAULT NULL,
  `ch1` varchar(100) DEFAULT NULL,
  `ch2` varchar(100) DEFAULT NULL,
  `ch3` varchar(100) DEFAULT NULL,
  `ch4` varchar(100) DEFAULT NULL,
  `ques_type` int(11) NOT NULL,
  PRIMARY KEY (`ques_id`),
  KEY `survey_id_idx` (`survey_id`),
  CONSTRAINT `FK_survey_id` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (4,362381,'Is Nasscom fruitful?','Yes','NO',NULL,NULL,2),(5,362381,'Rate this Survey!',NULL,NULL,NULL,NULL,3),(6,362381,'Which language is better?','Java','Python','C++','Swift',1),(7,362381,'Which IDE will you prefer?','Eclipse','Netbeans','Codeblocks','IntelliJ',1),(8,362381,'Which one will you prefer?','One+ 5','iPhone 7s','Galaxy S8','Mi 5',1),(9,362381,'Which one is the best singer from the below options?','Eminem','Adele','Taylor Swift','Enrique Iglesias',1),(10,362381,'Who is the Best Actor in Hollywood?','Leonardo Di Caprio','Robert Downey Junior','Tom Cruise','Johnny Depp',1),(11,362381,'Does Indian education system lacks in nurishing young talents?','Yes','NO',NULL,NULL,2),(12,362381,'Is GST good ?','Yes','NO',NULL,NULL,2),(13,185833,'Which type of movies you watch','Horror','Action','Comedy','Drama',1),(14,185833,'Are you satisfied?','Yes','NO',NULL,NULL,2),(15,362381,'Is MSD the best finisher in cricket?','Yes','NO',NULL,NULL,2),(16,362381,'Questions Goes Here !','','','','',1),(17,362381,'asdsda	','1','2','d ','f',1),(18,362381,'02602602','1','1','13','rt',1),(19,362381,'Which game is best?','COC','Dota2','CS Go','FIFA',1),(20,362381,'Is Abhinav Noob?','Yes','NO',NULL,NULL,2),(21,362381,'Rate Abhinav',NULL,NULL,NULL,NULL,3),(22,362381,'bwahaha',NULL,NULL,NULL,NULL,3),(23,362381,'Questions Goes Here !',NULL,NULL,NULL,NULL,3),(24,362381,'alelola',NULL,NULL,NULL,NULL,3),(25,185833,'Group Name',NULL,NULL,NULL,NULL,3),(26,1206301,'MCQ1','1','2','3','4',1),(27,1206301,'MCQ2','1','2','3','4',1),(28,1206301,'Yes1','Yes','NO',NULL,NULL,2),(29,185833,'Questions Goes Here !','','','','',1),(31,185833,'Questions Goes Here !',NULL,NULL,NULL,NULL,3),(32,185833,'ABCDDDD	',NULL,NULL,NULL,NULL,3),(33,185833,'Questions Goes Here !',NULL,NULL,NULL,NULL,3),(34,362381,'Questions Goes Here !',NULL,NULL,NULL,NULL,3);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-13 11:00:59
