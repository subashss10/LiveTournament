-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: subash
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `tbl_match_type`
--

DROP TABLE IF EXISTS `tbl_match_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_match_type` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `MatchType` varchar(30) NOT NULL,
  `CreatedBy` int NOT NULL,
  `CreatedOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_match_type`
--

LOCK TABLES `tbl_match_type` WRITE;
/*!40000 ALTER TABLE `tbl_match_type` DISABLE KEYS */;
INSERT INTO `tbl_match_type` VALUES (1,'International',2,'2020-08-20 21:05:37'),(2,'T20',2,'2020-08-20 21:05:37'),(3,'Test',2,'2020-08-20 21:05:37');
/*!40000 ALTER TABLE `tbl_match_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_player`
--

DROP TABLE IF EXISTS `tbl_player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_player` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `PlayerName` varchar(30) NOT NULL,
  `TeamId` int NOT NULL,
  `PlayerRoleId` int NOT NULL,
  `DOB` date NOT NULL,
  `BattingStyle` varchar(30) NOT NULL,
  `BowlingStyle` varchar(30) DEFAULT NULL,
  `CreatedBy` int NOT NULL,
  `CreatedOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `LogoPath` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `TeamId` (`TeamId`),
  KEY `PlayerRoleId` (`PlayerRoleId`),
  CONSTRAINT `tbl_player_ibfk_1` FOREIGN KEY (`TeamId`) REFERENCES `tbl_team` (`Id`),
  CONSTRAINT `tbl_player_ibfk_2` FOREIGN KEY (`PlayerRoleId`) REFERENCES `tbl_player_role` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_player`
--

LOCK TABLES `tbl_player` WRITE;
/*!40000 ALTER TABLE `tbl_player` DISABLE KEYS */;
INSERT INTO `tbl_player` VALUES (1,'Sachin Tendulkar',1,1,'1973-04-24','Right-hand bat','Right-arm offbreak',2,'2020-08-05 13:05:44',0,'sachintendulkar.png'),(2,'Rohit Sharma',1,1,'1987-04-30','Right-hand bat','Right-arm offbreak',2,'2020-08-05 13:10:40',0,'rohitsharma.png'),(3,'Virat Kohli',1,1,'1988-11-05','Right-hand bat','Right-arm medium',2,'2020-08-05 13:12:25',0,'viratkohli.png'),(4,'Mahendra Singh Dhoni',1,4,'1981-07-07','Right-hand bat','Right-arm medium',2,'2020-08-05 13:14:48',0,'mahendrasinghdhoni.png'),(5,'Shikhar Dhawan',1,1,'1985-12-05','Left-hand bat','Right-arm offbreak',2,'2020-08-05 13:19:20',0,'shikhardhawan.png'),(6,'Hardik Pandya',1,3,'1993-10-11','Right-hand bat','Right-arm fast-medium',2,'2020-08-05 13:20:35',0,'hardikpandya.png'),(7,'Vijay Shankar',1,3,'1991-01-26','Right-hand bat','Right-arm medium',2,'2020-08-05 13:22:19',0,'vijayshankar.png'),(9,'Kedar Jadhav',1,3,'1985-03-26','Right-hand bat','Right-arm offbreak',2,'2020-08-05 13:24:06',0,'kedarjadhav.png'),(10,'Ravindra Jadeja',1,3,'1988-12-06','Left-hand bat','Left-arm orthodox',2,'2020-08-05 13:25:49',0,'ravindrajadeja.png'),(11,'Dinesh Karthik',1,4,'1985-06-01','Right-hand bat',NULL,2,'2020-08-05 13:31:25',0,'dineshkarthik.png'),(12,'Lokesh Rahul',1,4,'1992-04-18','Right-hand bat',NULL,2,'2020-08-05 13:33:06',0,'lokeshrahul.png'),(13,'Bhuvneshwar Kumar',1,3,'1990-02-05','Right-hand bat','Right-arm fast-medium',2,'2020-08-05 13:34:17',0,'bhuvneshwarkumar.png'),(14,'Mohammed Shami',1,2,'1990-02-05','Right-hand bat','Right-arm fast-medium',2,'2020-08-05 13:35:28',0,'mohammedshami.png'),(15,'Jasprit Bumrah',1,2,'1993-12-06','Right-hand bat','Right-arm fast',2,'2020-08-05 22:22:17',0,'jaspritbumrah.png'),(16,'Mohammed Shami',1,2,'1990-02-05','Right-hand bat','Right-arm fast-medium',2,'2020-08-05 22:36:43',0,'mohammedshami.png'),(18,'Fakhar Zaman',2,1,'1990-04-10','Left-Hand Bat','Left-arm orthodox',2,'2020-08-16 14:49:16',0,'fakharzaman.png'),(19,'Imam-ul-Haq',2,1,'1995-12-12','Left-Hand Bat',NULL,2,'2020-08-16 14:49:16',0,'imam-ul-haq.png'),(20,'Babar Azam',2,1,'1994-10-15','Right-Hand Bat','Right-arm offbreak',2,'2020-08-16 14:49:16',0,'babarazam.png'),(21,'Asif Ali',2,1,'1991-10-01','Right-Hand Bat','Right-arm medium',2,'2020-08-16 14:49:16',0,'asifali.png'),(22,'Haris Sohail',2,3,'1989-01-09','Left-Hand Bat','Left-arm orthodox',2,'2020-08-16 14:49:16',0,'harissohail.png'),(23,'Mohammad Hafeez',2,3,'1980-10-17','Right-Hand Bat','Right-arm offbreak',2,'2020-08-16 14:49:16',0,'mohammadhafeez.png'),(24,'Shoaib Malik',2,3,'1982-02-01','Right-Hand Bat','Right-arm offbreak',2,'2020-08-16 14:49:16',0,'shoaibmalik.png'),(25,'Shadab Khan',2,3,'1998-10-04','Right-Hand Bat','Right-arm legbreak',2,'2020-08-16 14:49:16',0,'shadabkhan.png'),(26,'Imad Wasim',2,3,'1988-12-18','Left-Hand Bat','Left-arm orthodox',2,'2020-08-16 14:49:16',0,'imadwasim.png'),(27,'Sarfarax Ahmed',2,4,'1987-05-22','Right-Hand Bat',NULL,2,'2020-08-16 14:49:16',0,'sarfaraxahmed.png'),(28,'Wahab Riaz',2,2,'1985-06-28','Right-Hand Bat','Left-arm fast',2,'2020-08-16 14:49:16',0,'wahabriaz.png'),(29,'Shaheen Afridi',2,2,'2000-04-06','Left-Hand Bat','Left-arm fast-medium',2,'2020-08-16 14:49:16',0,'shaheenafridi.png'),(30,'Hasan Ali',2,2,'1994-07-02','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-16 14:49:16',0,'hasanali.png'),(31,'Mohammad Hasnain',2,2,'2000-04-05','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-16 14:49:16',0,'mohammadhasnain.png'),(32,'Mohammad Amir',2,2,'1992-04-13','Left-Hand Bat','Left-arm fast-medium',2,'2020-08-16 14:49:16',0,'mohammadamir.png'),(33,'Lahiru Thirimanne',3,1,'1989-08-09','Left-Hand Bat','Right-arm medium',2,'2020-08-18 12:45:46',0,'lahiruthirimanne.png'),(34,'Dimuth Karunaratne',3,1,'1988-04-21','Left-Hand Bat','Right-arm medium',2,'2020-08-18 12:45:46',0,'dimuthkarunaratne.png'),(35,'Avishka Fernando',3,1,'1998-04-05','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-18 12:45:46',0,'avishkafernando.png'),(36,'Kusal Mendis',3,1,'1995-02-02','Right-Hand Bat',NULL,2,'2020-08-18 12:45:46',0,'kusalmendis.png'),(37,'Angelo Mathews',3,3,'1987-06-02','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-18 12:45:46',0,'angelomathews.png'),(38,'Dhananjaya de Silva',3,3,'1991-09-06','Right-Hand Bat','Right-arm offbreak',2,'2020-08-18 12:45:46',0,'dhananjayadesilva.png'),(39,'Milinda Siriwardana',3,3,'1985-12-04','Left-Hand Bat','Left-arm orthodox',2,'2020-08-18 12:45:46',0,'milindasiriwardana.png'),(40,'Thisara Perera',3,3,'1989-04-03','Left-Hand Bat','Right-arm fast-medium',2,'2020-08-18 12:45:46',0,'thisaraperera.png'),(41,'Isuru Udana',3,3,'1988-02-17','Right-Hand Bat','Left-arm fast-medium',2,'2020-08-18 12:45:46',0,'isuruudana.png'),(42,'Jeevan Mendis',3,3,'1983-01-15','Left-Hand Bat','Right-arm legbreak',2,'2020-08-18 12:45:46',0,'jeevanmendis.png'),(43,'Kusal Perera',3,4,'1990-08-17','Left-Hand Bat',NULL,2,'2020-08-18 12:45:46',0,'kusalperera.png'),(44,'Suranga Lakmal',3,2,'1987-03-10','Right-Hand Bat','Right-arm medium',2,'2020-08-18 12:45:46',0,'surangalakmal.png'),(45,'Lasith Malinga',3,2,'1983-08-28','Right-Hand Bat','Right-arm fast',2,'2020-08-18 12:45:46',0,'lasithmalinga.png'),(46,'Jeffrey Vandersay',3,2,'1990-02-05','Right-Hand Bat','Right-arm legbreak',2,'2020-08-18 12:45:46',0,'jeffreyvandersay.png'),(47,'Nuwan Pradeep',3,2,'1986-10-19','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-18 12:45:46',0,'nuwanpradeep.png'),(48,'Eoin Morgan',4,1,'1986-09-10','Left-Hand Bat','Right-arm medium',2,'2020-08-18 14:24:09',0,'eoinmorgan.png'),(49,'Joe Root',4,1,'1990-12-30','Right-Hand Bat','Right-arm offbreak',2,'2020-08-18 14:24:09',0,'joeroot.png'),(50,'Jason Roy',4,1,'1990-07-21','Right-Hand Bat',NULL,2,'2020-08-18 14:24:09',0,'jasonroy.png'),(51,'James Vince',4,1,'1991-03-14','Right-Hand Bat','Right-arm medium',2,'2020-08-18 14:24:09',0,'jamesvince.png'),(52,'Moeen Ali',4,3,'1987-06-18','Left-Hand Bat','Right-arm offbreak',2,'2020-08-18 14:24:09',0,'moeenali.png'),(53,'Ben Stokes',4,3,'1991-06-04','Left-Hand Bat','Right-arm fast-medium',2,'2020-08-18 14:24:09',0,'benstokes.png'),(54,'Chris Woakes',4,3,'1989-03-02','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-18 14:24:09',0,'chriswoakes.png'),(55,'Tom Curran',4,3,'1995-03-12','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-18 14:24:09',0,'tomcurran.png'),(56,'Liam Dawson',4,3,'1990-03-01','Right-Hand Bat','Left-arm orthodox',2,'2020-08-18 14:24:09',0,'liamdawson.png'),(57,'Jofra Archer',4,3,'1995-04-01','Right-Hand Bat','Right-arm fast',2,'2020-08-18 14:24:09',0,'jofraarcher.png'),(58,'Jonny Baristow',4,4,'1989-09-26','Right-Hand Bat','Right-arm medium',2,'2020-08-18 14:24:09',0,'jonnybaristow.png'),(59,'Jos Buttler',4,4,'1990-09-08','Right-Hand Bat',NULL,2,'2020-08-18 14:24:09',0,'josbuttler.png'),(60,'Liam Plunkett',4,2,'1985-04-06','Right-Hand Bat','Right-arm fast',2,'2020-08-18 14:24:09',0,'liamplunkett.png'),(61,'Adil Rashid',4,2,'1988-02-17','Right-Hand Bat','Right-arm legbreak',2,'2020-08-18 14:24:09',0,'adilrashid.png'),(62,'Mark Wood',4,2,'1990-01-11','Right-Hand Bat','Right-arm fast',2,'2020-08-18 14:24:09',0,'markwood.png'),(63,'Faf du Plessis',5,1,'1984-07-13','Right-Hand Bat','Right-arm legbreak',2,'2020-08-30 14:38:59',0,'fafduplessis.png'),(64,'David Miller',5,1,'1989-06-10','Left-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'davidmiller.png'),(65,'Aiden Markram',5,1,'1994-10-04','Right-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'aidenmarkram.png'),(66,'Rassie van der Dussen',5,1,'1989-02-07','Right-Hand Bat','Right-arm legbreak',2,'2020-08-30 14:38:59',0,'rassievanderdussen.png'),(67,'Jean-Paul Duminy',5,3,'1984-04-14','Left-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'jean-paulduminy.png'),(68,'Andile Phehlukwayo',5,3,'1996-03-03','Left-Hand Bat','Right-arm medium',2,'2020-08-30 14:38:59',0,'andilephehlukwayo.png'),(69,'Dwaine Pretorius',5,3,'1989-03-29','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-30 14:38:59',0,'dwainepretorius.png'),(70,'Chris Morris',5,3,'1987-04-30','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-30 14:38:59',0,'chrismorris.png'),(71,'Quinton de Kock',5,4,'1992-12-17','Left-Hand Bat',NULL,2,'2020-08-30 14:38:59',0,'quintondekock.png'),(72,'Imran Tahir',5,2,'1979-03-27','Right-Hand Bat','Right-arm legbreak',2,'2020-08-30 14:38:59',0,'imrantahir.png'),(73,'Kagiso Rabada',5,2,'1995-05-25','Left-Hand Bat','Right-arm fast',2,'2020-08-30 14:38:59',0,'kagisorabada.png'),(74,'Lungi Ngidi',5,2,'1996-03-29','Right-Hand Bat','Right-arm fast',2,'2020-08-30 14:38:59',0,'lungingidi.png'),(75,'Tabraiz Shamsi',5,2,'1990-02-18','Right-Hand Bat','Left-arm chinaman',2,'2020-08-30 14:38:59',0,'tabraizshamsi.png'),(76,'Beuran Hendricks',5,2,'1990-06-08','Left-Hand Bat','Left-arm fast-medium',2,'2020-08-30 14:38:59',0,'beuranhendricks.png'),(77,'Martin Guptill',6,1,'1986-09-30','Right-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'martinguptill.png'),(78,'Ross Taylor',6,1,'1984-03-08','Right-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'rosstaylor.png'),(79,'Kane Williamson',6,1,'1990-08-08','Right-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'kanewilliamson.png'),(80,'Henry Nicholls',6,1,'1991-11-15','Left-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'henrynicholls.png'),(81,'James Neesham',6,3,'1990-09-17','Left-Hand Bat','Right-arm medium',2,'2020-08-30 14:38:59',0,'jamesneesham.png'),(82,'Colin de Grandhomme',6,3,'1986-07-22','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-30 14:38:59',0,'colindegrandhomme.png'),(83,'Colin Munro',6,3,'1987-03-11','Left-Hand Bat','Right-arm medium',2,'2020-08-30 14:38:59',0,'colinmunro.png'),(84,'Mitchell Santner',6,3,'1992-02-05','Left-Hand Bat','Left-arm orthodox',2,'2020-08-30 14:38:59',0,'mitchellsantner.png'),(85,'Tom Latham',6,4,'1992-04-02','Left-Hand Bat','Right-arm medium',2,'2020-08-30 14:38:59',0,'tomlatham.png'),(86,'Tom Blundell',6,4,'1990-09-01','Right-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'tomblundell.png'),(87,'Trent Boult',6,2,'1989-07-22','Right-Hand Bat','Left-arm fast-medium',2,'2020-08-30 14:38:59',0,'trentboult.png'),(88,'Matt Henry',6,2,'1991-12-14','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-30 14:38:59',0,'matthenry.png'),(89,'Tim Southee',6,2,'1988-12-11','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-30 14:38:59',0,'timsouthee.png'),(90,'Ish Sodhi',6,2,'1992-10-31','Right-Hand Bat','Right-arm legbreak',2,'2020-08-30 14:38:59',0,'ishsodhi.png'),(91,'Lockie Ferguson',6,2,'1991-06-13','Right-Hand Bat','Right-arm fast',2,'2020-08-30 14:38:59',0,'lockieferguson.png'),(92,'Aaron Finch',7,1,'1986-11-17','Right-Hand Bat','Left-arm orthodox',2,'2020-08-30 14:38:59',0,'aaronfinch.png'),(93,'Shaun Marsh',7,1,'1983-07-09','Left-Hand Bat','Left-arm orthodox',2,'2020-08-30 14:38:59',0,'shaunmarsh.png'),(94,'Steven Smith',7,1,'1989-06-02','Right-Hand Bat','Right-arm legbreak',2,'2020-08-30 14:38:59',0,'stevensmith.png'),(95,'David Warner',7,1,'1986-10-27','Left-Hand Bat','Right-arm legbreak',2,'2020-08-30 14:38:59',0,'davidwarner.png'),(96,'Glenn Maxwell',7,3,'1988-10-14','Right-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'glennmaxwell.png'),(97,'Marcus Stoinis',7,3,'1989-08-16','Right-Hand Bat','Right-arm medium',2,'2020-08-30 14:38:59',0,'marcusstoinis.png'),(98,'Alex Carey',7,4,'1991-08-27','Left-Hand Bat',NULL,2,'2020-08-30 14:38:59',0,'alexcarey.png'),(99,'Pat Cummins',7,2,'1993-05-08','Right-Hand Bat','Right-arm fast',2,'2020-08-30 14:38:59',0,'patcummins.png'),(100,'Nathan Lyon',7,2,'1987-11-20','Right-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'nathanlyon.png'),(101,'Mitchell Starc',7,2,'1990-01-30','Left-Hand Bat','Left-arm fast',2,'2020-08-30 14:38:59',0,'mitchellstarc.png'),(102,'Kane Richardson',7,2,'1991-02-12','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-30 14:38:59',0,'kanerichardson.png'),(103,'Nathan Coulter-Nile',7,2,'1987-10-11','Right-Hand Bat','Right-arm fast',2,'2020-08-30 14:38:59',0,'nathancoulter-nile.png'),(104,'Jason Behrendorff',7,2,'1990-04-20','Right-Hand Bat','Left-arm fast-medium',2,'2020-08-30 14:38:59',0,'jasonbehrendorff.png'),(105,'Adam Zampa',7,2,'1992-03-31','Right-Hand Bat','Right-arm legbreak',2,'2020-08-30 14:38:59',0,'adamzampa.png'),(106,'Craig Ervine',10,1,'1985-08-19','Left-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'craigervine.png'),(107,'Hamilton Masakadza',10,3,'1983-08-09','Right-Hand Bat','Right-arm medium',2,'2020-08-30 14:38:59',0,'hamiltonmasakadza.png'),(108,'Sikandar Raza',10,3,'1986-04-24','Right-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'sikandarraza.png'),(109,'Solomon Mire',10,3,'1989-08-21','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-30 14:38:59',0,'solomonmire.png'),(110,'Timycen Maruma',10,3,'1988-04-19','Right-Hand Bat','Right-arm legbreak',2,'2020-08-30 14:38:59',0,'timycenmaruma.png'),(111,'Elton Chigumbura',10,3,'1986-03-14','Right-Hand Bat','Right-arm medium',2,'2020-08-30 14:38:59',0,'eltonchigumbura.png'),(112,'Regis Chakabva',10,4,'1987-09-20','Right-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'regischakabva.png'),(113,'Brendan Taylor',10,4,'1986-02-06','Right-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'brendantaylor.png'),(114,'Peter Moor',10,4,'1991-02-02','Right-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'petermoor.png'),(115,'Tendai Chatara',10,2,'1991-02-28','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-30 14:38:59',0,'tendaichatara.png'),(116,'Donald Tiripano',10,2,'1988-03-17','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-30 14:38:59',0,'donaldtiripano.png'),(117,'Kyle Jarvis',10,2,'1989-02-16','Right-Hand Bat','Right-arm fast',2,'2020-08-30 14:38:59',0,'kylejarvis.png'),(118,'Chris Mpofu',10,2,'1985-11-27','Right-Hand Bat','Right-arm medium',2,'2020-08-30 14:38:59',0,'chrismpofu.png'),(119,'Brandon Mavuta',10,2,'1997-03-04','Right-Hand Bat','Right-arm legbreak',2,'2020-08-30 14:38:59',0,'brandonmavuta.png'),(120,'Asghar Afghan',11,1,'1987-11-22','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-30 14:38:59',0,'asgharafghan.png'),(121,'Hashmatullah Shahidi',11,1,'1994-11-04','Left-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'hashmatullahshahidi.png'),(122,'Hazratullah Zazai',11,1,'1998-03-23','Left-Hand Bat','Left-arm orthodox',2,'2020-08-30 14:38:59',0,'hazratullahzazai.png'),(123,'Najbullah Zadran',11,1,'1993-02-28','Left-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:38:59',0,'najbullahzadran.png'),(124,'Noor Ali Zadran',11,1,'1988-07-10','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-30 14:38:59',0,'nooralizadran.png'),(125,'Rahmat Shah',11,3,'1993-07-06','Right-Hand Bat','Right-arm legbreak',2,'2020-08-30 14:39:00',0,'rahmatshah.png'),(126,'Samiullah Shinwari',11,3,'1987-02-03','Right-Hand Bat','Right-arm legbreak',2,'2020-08-30 14:39:00',0,'samiullahshinwari.png'),(127,'Gulbadin Naib',11,3,'1991-03-16','Right-Hand Bat','Right-arm medium',2,'2020-08-30 14:39:00',0,'gulbadinnaib.png'),(128,'Mohammad Nabi',11,3,'1985-01-01','Right-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:39:00',0,'mohammadnabi.png'),(129,'Mohammad Shahzad',11,4,'1988-01-31','Right-Hand Bat',NULL,2,'2020-08-30 14:39:00',0,'mohammadshahzad.png'),(130,'Aftab Alam',11,2,'1992-11-30','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-30 14:39:00',0,'aftabalam.png'),(131,'Dawlat Zadran',11,2,'1988-03-19','Right-Hand Bat','Right-arm fast-medium',2,'2020-08-30 14:39:00',0,'dawlatzadran.png'),(132,'Hamid Hassan',11,2,'1987-06-01','Right-Hand Bat','Right-arm fast',2,'2020-08-30 14:39:00',0,'hamidhassan.png'),(133,'Rashid Khan',11,2,'1998-09-20','Right-Hand Bat','Right-arm legbreak',2,'2020-08-30 14:39:00',0,'rashidkhan.png'),(134,'Mujeeb Ur Rahman',11,2,'2001-03-28','Right-Hand Bat','Right-arm offbreak',2,'2020-08-30 14:39:00',0,'mujeeburrahman.png'),(135,'Tamim Iqbal',8,1,'1989-03-20','Left-hand bat',NULL,2,'2020-08-31 16:58:03',0,'tamimiqbal.png'),(136,'Soumya Sarkar',8,1,'1993-02-25','Left-hand bat','Right-arm medium',2,'2020-08-31 16:58:03',0,'soumyasarkar.png'),(137,'Sabbir Rahman',8,1,'1991-11-22','Right-hand bat','Right-arm legbreak',2,'2020-08-31 16:58:03',0,'sabbirrahman.png'),(138,'Mahmudullah',8,3,'1986-02-04','Right-hand bat','Right-arm offbreak',2,'2020-08-31 16:58:03',0,'mahmudullah.png'),(139,'Shakib Al Hasan',8,3,'1987-03-24','Left-hand bat','Left-arm orthodox',2,'2020-08-31 16:58:03',0,'shakibalhasan.png'),(140,'Mohammad Saifuddin',8,3,'1996-11-01','Left-hand bat','Right-arm fast-medium',2,'2020-08-31 16:58:03',0,'mohammadsaifuddin.png'),(141,'Mosaddek Hossain',8,3,'1995-12-10','Right-hand bat','Right-arm offbreak',2,'2020-08-31 16:58:03',0,'mosaddekhossain.png'),(142,'Mehidy Hasan',8,3,'1997-10-25','Right-hand bat','Right-arm offbreak',2,'2020-08-31 16:58:03',0,'mehidyhasan.png'),(143,'Mushfiqur Rahim',8,4,'1987-06-09','Right-hand bat',NULL,2,'2020-08-31 16:58:03',0,'mushfiqurrahim.png'),(144,'Liton Das',8,4,'1994-10-13','Right-hand bat',NULL,2,'2020-08-31 16:58:03',0,'litondas.png'),(145,'Mohammad Mithun',8,4,'1991-03-02','Right-hand bat',NULL,2,'2020-08-31 16:58:03',0,'mohammadmithun.png'),(146,'Mashrafe Mortaza',8,2,'1983-10-05','Right-hand bat','Right-arm fast-medium',2,'2020-08-31 16:58:03',0,'mashrafemortaza.png'),(147,'Rubel Hossain',8,2,'1990-01-01','Right-hand bat','Right-arm fast',2,'2020-08-31 16:58:03',0,'rubelhossain.png'),(148,'Mustafizur Rahman',8,2,'1995-09-06','Left-hand bat','Left-arm fast-medium',2,'2020-08-31 16:58:03',0,'mustafizurrahman.png'),(149,'Abu Jayed',8,2,'1993-08-02','Right-hand bat','Right-arm fast-medium',2,'2020-08-31 16:58:03',0,'abujayed.png'),(150,'Darren Bravo',9,1,'1989-02-06','Left-hand bat','Right-arm fast-medium',2,'2020-08-31 17:17:24',0,'darrenbravo.png'),(151,'Chris Gayle',9,1,'1979-09-21','Left-hand bat','Right-arm offbreak',2,'2020-08-31 17:17:24',0,'chrisgayle.png'),(152,'Evin Lewis',9,1,'1991-12-27','Left-hand bat',NULL,2,'2020-08-31 17:17:24',0,'evinlewis.png'),(153,'Shimron Hetmyer',9,1,'1996-12-26','Left-hand bat',NULL,2,'2020-08-31 17:17:24',0,'shimronhetmyer.png'),(154,'Fabian Allen',9,3,'1995-05-07','Right-hand bat','Left-arm orthodox',2,'2020-08-31 17:17:24',0,'fabianallen.png'),(155,'Jason Holder',9,3,'1991-11-05','Right-hand bat','Right-arm fast-medium',2,'2020-08-31 17:17:24',0,'jasonholder.png'),(156,'Andre Russell',9,3,'1988-04-29','Right-hand bat','Right-arm fast',2,'2020-08-31 17:17:24',0,'andrerussell.png'),(157,'Carlos Brathwaite',9,3,'1988-07-18','Right-hand bat','Right-arm fast-medium',2,'2020-08-31 17:17:24',0,'carlosbrathwaite.png'),(158,'Shai Hope',9,4,'1993-11-10','Right-hand bat',NULL,2,'2020-08-31 17:17:24',0,'shaihope.png'),(159,'Nicholas Pooran',9,4,'1995-10-02','Left-hand bat',NULL,2,'2020-08-31 17:17:24',0,'nicholaspooran.png'),(160,'Sheldon Cottrell',9,2,'1989-08-19','Right-hand bat','Left-arm fast-medium',2,'2020-08-31 17:17:24',0,'sheldoncottrell.png'),(161,'Shannon Gabriel',9,2,'1988-04-28','Right-hand bat','Right-arm fast-medium',2,'2020-08-31 17:17:24',0,'shannongabriel.png'),(162,'Kemar Roach',9,2,'1988-06-30','Right-hand bat','Right-arm fast',2,'2020-08-31 17:17:24',0,'kemarroach.png'),(163,'Ashley Nurse',9,2,'1988-12-22','Right-hand bat','Right-arm offbreak',2,'2020-08-31 17:17:24',0,'ashleynurse.png'),(164,'Oshane Thomas',9,2,'1997-02-18','Left-hand bat','Right-arm fast',2,'2020-08-31 17:17:24',0,'oshanethomas.png'),(165,'Darren Bravo',9,1,'1989-02-06','Left-hand bat','Right-arm fast-medium',2,'2020-08-31 17:46:15',0,'darrenbravo.png'),(166,'Chris Gayle',9,1,'1979-09-21','Left-hand bat','Right-arm offbreak',2,'2020-08-31 17:46:15',0,'chrisgayle.png'),(167,'Evin Lewis',9,1,'1991-12-27','Left-hand bat',NULL,2,'2020-08-31 17:46:15',0,'evinlewis.png'),(168,'Shimron Hetmyer',9,1,'1996-12-26','Left-hand bat',NULL,2,'2020-08-31 17:46:15',0,'shimronhetmyer.png'),(169,'Fabian Allen',9,3,'1995-05-07','Right-hand bat','Left-arm orthodox',2,'2020-08-31 17:46:15',0,'fabianallen.png'),(170,'Jason Holder',9,3,'1991-11-05','Right-hand bat','Right-arm fast-medium',2,'2020-08-31 17:46:15',0,'jasonholder.png'),(171,'Andre Russell',9,3,'1988-04-29','Right-hand bat','Right-arm fast',2,'2020-08-31 17:46:15',0,'andrerussell.png'),(172,'Carlos Brathwaite',9,3,'1988-07-18','Right-hand bat','Right-arm fast-medium',2,'2020-08-31 17:46:15',0,'carlosbrathwaite.png'),(173,'Shai Hope',9,4,'1993-11-10','Right-hand bat',NULL,2,'2020-08-31 17:46:15',0,'shaihope.png'),(174,'Nicholas Pooran',9,4,'1995-10-02','Left-hand bat',NULL,2,'2020-08-31 17:46:15',0,'nicholaspooran.png'),(175,'Sheldon Cottrell',9,2,'1989-08-19','Right-hand bat','Left-arm fast-medium',2,'2020-08-31 17:46:15',0,'sheldoncottrell.png'),(176,'Shannon Gabriel',9,2,'1988-04-28','Right-hand bat','Right-arm fast-medium',2,'2020-08-31 17:46:15',0,'shannongabriel.png'),(177,'Kemar Roach',9,2,'1988-06-30','Right-hand bat','Right-arm fast',2,'2020-08-31 17:46:15',0,'kemarroach.png'),(178,'Ashley Nurse',9,2,'1988-12-22','Right-hand bat','Right-arm offbreak',2,'2020-08-31 17:46:15',0,'ashleynurse.png'),(179,'Oshane Thomas',9,2,'1997-02-18','Left-hand bat','Right-arm fast',2,'2020-08-31 17:46:15',0,'oshanethomas.png'),(180,'William Porterfield',14,1,'1984-09-06','Left-hand bat','Right-arm offbreak',2,'2020-08-31 17:49:11',0,'williamporterfield.png'),(181,'James McCollum',14,1,'1995-08-01','Right-hand bat','Right-arm medium',2,'2020-08-31 17:49:11',0,'jamesmccollum.png'),(182,'Andrew Balbirnie',14,1,'1990-12-28','Right-hand bat','Right-arm offbreak',2,'2020-08-31 17:49:11',0,'andrewbalbirnie.png'),(183,'Tyrone Kane',14,3,'1994-07-08','Right-hand bat','Right-arm fast-medium',2,'2020-08-31 17:49:11',0,'tyronekane.png'),(184,'Kevin O Brien',14,3,'1984-03-04','Right-hand bat','Right-arm fast-medium',2,'2020-08-31 17:49:11',0,'kevinobrien.png'),(185,'Paul Stirling',14,3,'1990-09-03','Right-hand bat','Right-arm offbreak',2,'2020-08-31 17:49:11',0,'paulstirling.png'),(186,'Stuart Thompson',14,3,'1991-08-15','Left-hand bat','Right-arm fast-medium',2,'2020-08-31 17:49:11',0,'stuartthompson.png'),(187,'Lorcan Tucker',14,4,'1996-09-10','Right-hand bat',NULL,2,'2020-08-31 17:49:11',0,'lorcantucker.png'),(188,'Peter Chase',14,2,'1993-10-09','Right-hand bat','Right-arm fast-medium',2,'2020-08-31 17:49:11',0,'peterchase.png'),(189,'George Dockrell',14,2,'1992-07-22','Right-hand bat','Left-arm orthodox',2,'2020-08-31 17:49:11',0,'georgedockrell.png'),(190,'Tim Murtagh',14,2,'1981-08-02','Left-hand bat','Right-arm fast-medium',2,'2020-08-31 17:49:11',0,'timmurtagh.png'),(191,'Mark Adair',14,2,'1996-03-27','Right-hand bat','Right-arm fast',2,'2020-08-31 17:49:11',0,'markadair.png'),(192,'Andy McBrine',14,2,'1993-04-30','Left-hand bat','Right-arm offbreak',2,'2020-08-31 17:49:11',0,'andymcbrine.png'),(193,'Barry McCarthy',14,2,'1992-09-13','Right-hand bat','Right-arm medium',2,'2020-08-31 17:49:11',0,'barrymccarthy.png'),(194,'Boyd Rankin',14,2,'1984-07-05','Left-hand bat','Right-arm fast-medium',2,'2020-08-31 17:49:11',0,'boydrankin.png');
/*!40000 ALTER TABLE `tbl_player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_player_role`
--

DROP TABLE IF EXISTS `tbl_player_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_player_role` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `PlayerRole` varchar(20) NOT NULL,
  `CreatedBy` int NOT NULL,
  `CreatedOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_player_role`
--

LOCK TABLES `tbl_player_role` WRITE;
/*!40000 ALTER TABLE `tbl_player_role` DISABLE KEYS */;
INSERT INTO `tbl_player_role` VALUES (1,'Batsman',2,'2020-08-05 09:56:51',0),(2,'Bowler',2,'2020-08-05 09:57:17',0),(3,'All Rounder',2,'2020-08-05 10:41:21',0),(4,'Wicket Keeper',2,'2020-08-05 13:26:59',0);
/*!40000 ALTER TABLE `tbl_player_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_role`
--

DROP TABLE IF EXISTS `tbl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_role` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `RoleName` char(50) NOT NULL,
  `RoleDescription` char(50) NOT NULL,
  `CreatedBy` int DEFAULT NULL,
  `CreatedOn` datetime NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_role`
--

LOCK TABLES `tbl_role` WRITE;
/*!40000 ALTER TABLE `tbl_role` DISABLE KEYS */;
INSERT INTO `tbl_role` VALUES (1,'Admin','Administrator',NULL,'2020-07-19 18:45:22'),(2,'User','User',NULL,'2020-07-19 18:45:22');
/*!40000 ALTER TABLE `tbl_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_schedule`
--

DROP TABLE IF EXISTS `tbl_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_schedule` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `MatchTypeId` int NOT NULL,
  `Team1` varchar(50) NOT NULL,
  `Team2` varchar(50) NOT NULL,
  `Time` time NOT NULL,
  `Venue` varchar(50) NOT NULL,
  `CreatedBy` int NOT NULL,
  `CreatedOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `MatchTypeId` (`MatchTypeId`),
  CONSTRAINT `tbl_schedule_ibfk_1` FOREIGN KEY (`MatchTypeId`) REFERENCES `tbl_match_type` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_schedule`
--

LOCK TABLES `tbl_schedule` WRITE;
/*!40000 ALTER TABLE `tbl_schedule` DISABLE KEYS */;
INSERT INTO `tbl_schedule` VALUES (1,'2020-08-22',1,'India','Australia','02:00:00','Australia',2,'2020-08-21 20:57:25',0),(2,'2020-10-23',2,'Sri Lanka','Ireland','23:00:00','Ireland',2,'2020-08-21 22:47:33',1),(3,'2020-10-23',1,'Sri Lanka','Ireland','22:00:00','Ireland',2,'2020-08-31 16:07:42',0);
/*!40000 ALTER TABLE `tbl_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_team`
--

DROP TABLE IF EXISTS `tbl_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_team` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `TeamName` varchar(20) NOT NULL,
  `TeamDescription` varchar(50) DEFAULT NULL,
  `CreatedBy` int NOT NULL,
  `CreatedOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `LogoPath` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_team`
--

LOCK TABLES `tbl_team` WRITE;
/*!40000 ALTER TABLE `tbl_team` DISABLE KEYS */;
INSERT INTO `tbl_team` VALUES (1,'India','Indian Team2',2,'2020-08-05 06:16:59',0,'india.png'),(2,'Pakistan','Pakistan Team',2,'2020-08-05 06:22:07',0,'pakistan.png'),(3,'Sri Lanka','Sri Lankan Team',2,'2020-08-05 06:22:07',0,'srilanka.png'),(4,'England','England Team',2,'2020-08-05 06:22:07',0,'england.png'),(5,'South Africa','South African Team',2,'2020-08-05 06:22:07',0,'southafrica.png'),(6,'New Zealand','New Zealand Team',2,'2020-08-05 06:22:07',0,'newzealand.png'),(7,'Australia','Australia Team',2,'2020-08-05 06:22:07',0,'australia.png'),(8,'Bangladesh','Bangladesh Team',2,'2020-08-05 06:22:07',0,'bangladesh.png'),(9,'West Indies','West Indies Team',2,'2020-08-05 06:22:07',0,'westindies.png'),(10,'Zimbabwe','Zimbabwe Team',2,'2020-08-05 06:22:07',0,'zimbabwe.png'),(11,'Afghanistan','Afghanistan Team',2,'2020-08-05 09:25:35',0,'afghanistan.png'),(14,'Ireland','Ireland Team',2,'2020-08-05 09:32:14',0,'ireland.png'),(16,'TEST TES','TEST DES',2,'2020-08-11 21:15:25',1,'testtes.png'),(17,'Howai','Howai Team',2,'2020-08-11 22:55:02',1,'howai.png'),(18,'Hello','test team',2,'2020-08-12 11:42:08',1,'hello.png'),(19,'helo','Helo team',2,'2020-08-12 14:00:37',1,'helo.png'),(20,'Test','Test Desc',2,'2020-08-23 13:06:46',1,NULL);
/*!40000 ALTER TABLE `tbl_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `UserName` char(50) NOT NULL,
  `FirstName` char(50) NOT NULL,
  `LastName` char(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `CreatedOn` datetime NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (1,'Subash S','Subash','S','ssubash201@50hands.org','2020-07-27 20:06:37'),(2,'Subash Senthil Kumar','Subash','Senthil Kumar','subashss10@gmail.com','2020-08-30 12:44:20'),(3,'Sandhiya Venkatesh','Sandhiya','Venkatesh','sandyvenkat2000@gmail.com','2020-08-04 19:36:20'),(4,'Parkavi Sa','Parkavi','Sa','parkavi8324@gmail.com','2020-08-02 15:44:21');
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user_role`
--

DROP TABLE IF EXISTS `tbl_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user_role` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `UserId` int NOT NULL,
  `RoleId` int NOT NULL,
  `CreatedBy` int DEFAULT NULL,
  `createdOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `UserId` (`UserId`),
  KEY `RoleId` (`RoleId`),
  CONSTRAINT `tbl_user_role_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `tbl_user` (`Id`),
  CONSTRAINT `tbl_user_role_ibfk_2` FOREIGN KEY (`RoleId`) REFERENCES `tbl_role` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user_role`
--

LOCK TABLES `tbl_user_role` WRITE;
/*!40000 ALTER TABLE `tbl_user_role` DISABLE KEYS */;
INSERT INTO `tbl_user_role` VALUES (1,1,2,NULL,'2020-07-24 21:36:12'),(2,2,2,NULL,'2020-07-24 21:44:56'),(3,3,2,NULL,'2020-07-29 12:03:46'),(4,4,2,NULL,'2020-08-02 15:44:21');
/*!40000 ALTER TABLE `tbl_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'subash'
--

--
-- Dumping routines for database 'subash'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-31 18:43:45
