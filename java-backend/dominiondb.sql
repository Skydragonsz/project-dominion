CREATE DATABASE  IF NOT EXISTS `dominiondb` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `dominiondb`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 192.168.0.177    Database: dominiondb
-- ------------------------------------------------------
-- Server version	5.5.44-0+deb8u1

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `won` int(11) DEFAULT NULL,
  `lost` int(11) DEFAULT NULL,
  `accountTypeID` int(11) NOT NULL DEFAULT '1',
  `pass` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `username` (`username`),
  KEY `accountTypeID` (`accountTypeID`),
  CONSTRAINT `accountTypeID` FOREIGN KEY (`accountTypeID`) REFERENCES `accounttype` (`accountTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'root',NULL,NULL,2,'toor'),(2,'Sky_Dragonsz',23,15,1,'dominion');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_game-gameSave`
--

DROP TABLE IF EXISTS `account_game-gameSave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_game-gameSave` (
  `accountID` int(11) NOT NULL,
  `gameID` int(11) NOT NULL,
  PRIMARY KEY (`accountID`,`gameID`),
  KEY `game_idx` (`gameID`),
  CONSTRAINT `account` FOREIGN KEY (`accountID`) REFERENCES `account` (`ID`),
  CONSTRAINT `GameID` FOREIGN KEY (`gameID`) REFERENCES `game` (`gameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_game-gameSave`
--

LOCK TABLES `account_game-gameSave` WRITE;
/*!40000 ALTER TABLE `account_game-gameSave` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_game-gameSave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accounttype`
--

DROP TABLE IF EXISTS `accounttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accounttype` (
  `accountTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `accountType` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`accountTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounttype`
--

LOCK TABLES `accounttype` WRITE;
/*!40000 ALTER TABLE `accounttype` DISABLE KEYS */;
INSERT INTO `accounttype` VALUES (1,'Normal'),(2,'Admin');
/*!40000 ALTER TABLE `accounttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board` (
  `boardID` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `index` int(11) DEFAULT NULL,
  PRIMARY KEY (`boardID`,`name`),
  KEY `card_idx` (`name`),
  CONSTRAINT `board_ibfk_1` FOREIGN KEY (`boardID`) REFERENCES `game` (`gameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (33,'Cellar',10,7),(33,'Copper',32,0),(33,'Curse',10,6),(33,'Duchy',8,4),(33,'Estate',8,3),(33,'Gold',30,2),(33,'Market',10,8),(33,'Militia',10,9),(33,'Mine',10,10),(33,'Moat',10,11),(33,'Province',8,5),(33,'Remodel',10,12),(33,'Silver',40,1),(33,'Smithy',10,13),(33,'Village',10,14),(33,'Woodcutter',10,15),(33,'Workshop',10,16),(34,'Cellar',10,7),(34,'Copper',32,0),(34,'Curse',10,6),(34,'Duchy',8,4),(34,'Estate',8,3),(34,'Gold',30,2),(34,'Market',10,8),(34,'Militia',10,9),(34,'Mine',10,10),(34,'Moat',10,11),(34,'Province',8,5),(34,'Remodel',10,12),(34,'Silver',40,1),(34,'Smithy',10,13),(34,'Village',10,14),(34,'Woodcutter',10,15),(34,'Workshop',10,16);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card` (
  `ID` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `cost` int(1) NOT NULL,
  `cardTypeID` int(1) NOT NULL,
  `info` text NOT NULL,
  `addMoney` int(1) NOT NULL DEFAULT '0',
  `addBuy` int(1) NOT NULL DEFAULT '0',
  `addAction` int(1) NOT NULL DEFAULT '0',
  `addCard` int(1) NOT NULL DEFAULT '0',
  `hasSpecialAction` tinyint(1) NOT NULL DEFAULT '0',
  `value` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `cardTypeID` (`cardTypeID`),
  CONSTRAINT `cardTypeID` FOREIGN KEY (`cardTypeID`) REFERENCES `cardtype` (`cardTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (1,'Copper',0,2,'+1 Coin',1,0,0,0,0,0),(2,'Silver',3,2,'+2 Coin',2,0,0,0,0,0),(3,'Gold',6,2,'+3 Coin',3,0,0,0,0,0),(4,'Curse',0,3,'-1 Victory point',0,0,0,0,0,-1),(5,'Estate',2,3,'+1 Victory point',0,0,0,0,0,1),(6,'Duchy',5,3,'+3 Victory point',0,0,0,0,0,3),(7,'Province',8,3,'+6 Victory point',0,0,0,0,0,6),(8,'Cellar',2,1,'+1 Action\r\n\r\nDiscard any number of cards. +1 Card per card discarded.',0,0,1,0,1,0),(9,'Chapel',2,1,'Trash up to 4 cards from your hand.',0,0,0,0,1,0),(10,'Moat',2,5,'+2 Cards\r\n \r\nWhen another player plays an Attack card, you may reveal this from your hand. \r\nIf you do, you are unaffected by that Attack.',0,0,0,2,0,0),(11,'Chancellor',3,1,'+2 Coins\r\n \r\nYou may immediately put your deck into your discard pile.',2,0,0,0,1,0),(12,'Village',3,1,'+1 Card\r\n \r\n+2 Actions',0,0,2,1,0,0),(13,'Woodcutter',3,1,'',2,1,0,0,0,0),(14,'Workshop',3,1,'',0,0,0,0,1,0),(15,'Bureaucrat',4,4,'',0,0,0,0,1,0),(16,'Feast',4,1,'',0,0,0,0,1,0),(17,'Garden',4,3,'',0,0,0,0,0,0),(18,'Militia',4,4,'',2,0,0,0,1,0),(19,'Moneylender',4,1,'',0,0,0,0,1,0),(20,'Remodel',4,1,'',0,0,0,0,1,0),(21,'Smithy',4,1,'',0,0,0,3,0,0),(22,'Spy',4,4,'',0,0,1,1,1,0),(23,'Thief',4,4,'',0,0,0,0,1,0),(24,'Throne room',4,1,'',0,0,0,0,1,0),(25,'Council room',5,1,'',0,1,0,4,1,0),(26,'Festival',5,1,'',2,1,2,0,0,0),(27,'Laboratory',5,1,'',0,0,1,2,0,0),(28,'Library',5,1,'',0,0,0,0,1,0),(29,'Market',5,1,'',1,1,1,1,0,0),(30,'Mine',5,1,'',0,0,0,0,1,0),(31,'Witch',5,4,'',0,0,0,2,1,0),(32,'Adventurer',6,1,'',0,0,0,0,1,0);
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cardtype`
--

DROP TABLE IF EXISTS `cardtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cardtype` (
  `cardTypeID` int(1) NOT NULL AUTO_INCREMENT,
  `cardType` varchar(10) NOT NULL,
  PRIMARY KEY (`cardTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardtype`
--

LOCK TABLES `cardtype` WRITE;
/*!40000 ALTER TABLE `cardtype` DISABLE KEYS */;
INSERT INTO `cardtype` VALUES (1,'Action'),(2,'Treasure'),(3,'Victory'),(4,'Attack'),(5,'Reaction');
/*!40000 ALTER TABLE `cardtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `gameID` int(11) NOT NULL AUTO_INCREMENT,
  `amountOfPlayers` int(11) NOT NULL,
  `turn` int(11) NOT NULL,
  `currentPlayer` int(11) NOT NULL,
  `date` date NOT NULL,
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`gameID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (33,4,1,1,'2016-05-25','2016-05-25 18:04:10'),(34,4,1,1,'2016-05-25','Test game save');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kingdomset`
--

DROP TABLE IF EXISTS `kingdomset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kingdomset` (
  `kingdomSetID` int(11) NOT NULL AUTO_INCREMENT,
  `accountID` int(11) DEFAULT '0',
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`kingdomSetID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kingdomset`
--

LOCK TABLES `kingdomset` WRITE;
/*!40000 ALTER TABLE `kingdomset` DISABLE KEYS */;
INSERT INTO `kingdomset` VALUES (1,0,'First game'),(2,0,'Big money'),(3,0,'Interaction'),(4,0,'Size distortion'),(5,0,'Village Square'),(6,0,'Victory + Treasure cards');
/*!40000 ALTER TABLE `kingdomset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kingdomset_cards`
--

DROP TABLE IF EXISTS `kingdomset_cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kingdomset_cards` (
  `ID` int(11) NOT NULL,
  `cardID` int(11) NOT NULL,
  PRIMARY KEY (`ID`,`cardID`),
  KEY `cardID` (`cardID`),
  CONSTRAINT `kingdomset_cards_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `kingdomset` (`kingdomSetID`),
  CONSTRAINT `kingdomset_cards_ibfk_2` FOREIGN KEY (`cardID`) REFERENCES `card` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kingdomset_cards`
--

LOCK TABLES `kingdomset_cards` WRITE;
/*!40000 ALTER TABLE `kingdomset_cards` DISABLE KEYS */;
INSERT INTO `kingdomset_cards` VALUES (6,1),(6,2),(6,3),(6,4),(6,5),(6,6),(6,7),(1,8),(4,8),(5,8),(2,9),(4,9),(1,10),(3,10),(2,11),(3,11),(1,12),(3,12),(4,12),(5,12),(1,13),(4,13),(5,13),(1,14),(4,14),(2,15),(3,15),(5,15),(2,16),(4,16),(4,17),(1,18),(3,18),(2,19),(1,20),(5,20),(1,21),(5,21),(3,22),(3,23),(4,23),(2,24),(5,24),(3,25),(3,26),(5,26),(2,27),(4,27),(3,28),(5,28),(1,29),(2,29),(5,29),(1,30),(2,30),(4,31),(2,32);
/*!40000 ALTER TABLE `kingdomset_cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `playerID` int(11) NOT NULL,
  `gameID` int(11) NOT NULL,
  `deck` text COLLATE utf8_unicode_ci,
  `hand` text COLLATE utf8_unicode_ci,
  `discardPile` text COLLATE utf8_unicode_ci,
  `playingField` text COLLATE utf8_unicode_ci,
  `name` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`playerID`,`gameID`),
  KEY `game_idx` (`gameID`),
  CONSTRAINT `game` FOREIGN KEY (`gameID`) REFERENCES `game` (`gameID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (1,33,'Estate,Copper,Estate,Copper,Copper','Estate,Copper,Copper,Copper,Copper','','','testPlayerOne'),(1,34,'Copper,Copper,Copper,Copper,Estate','Copper,Copper,Estate,Estate,Copper','','','Quinten'),(2,33,'Estate,Copper,Copper,Copper,Estate','Copper,Copper,Copper,Copper,Estate','','','testPlayerTwo'),(2,34,'Estate,Copper,Copper,Copper,Copper','Copper,Estate,Estate,Copper,Copper','','','Arthur'),(3,33,'Copper,Copper,Copper,Estate,Estate','Copper,Copper,Estate,Copper,Copper','','','testPlayerThree'),(3,34,'Copper,Copper,Copper,Copper,Estate','Estate,Copper,Copper,Estate,Copper','','','Coene'),(4,33,'Copper,Estate,Copper,Copper,Estate','Copper,Estate,Copper,Copper,Copper','','','testPlayerFour'),(4,34,'Copper,Estate,Copper,Estate,Copper','Copper,Copper,Copper,Estate,Copper','','','Tim');
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-02 17:35:15
