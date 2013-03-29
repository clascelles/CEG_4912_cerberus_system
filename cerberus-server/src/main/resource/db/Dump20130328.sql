CREATE DATABASE  IF NOT EXISTS `cerberus` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cerberus`;
-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cerberus
-- ------------------------------------------------------
-- Server version	5.6.10

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
-- Table structure for table `connection_event`
--

DROP TABLE IF EXISTS `connection_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `connection_event` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `OUTLET_ID` int(11) NOT NULL,
  `EVENT_ID` int(11) NOT NULL,
  `TIMESTAMP` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CONNECTION_EVENT_FKIndex1` (`EVENT_ID`),
  KEY `CONNECTION_EVENT_FKIndex2` (`OUTLET_ID`),
  CONSTRAINT `fk_{3AD07AA9-3F08-406A-AA34-C28B9486A2BB}` FOREIGN KEY (`EVENT_ID`) REFERENCES `event` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{0905D9E0-F215-41D3-9D86-75BC8BF3A8A4}` FOREIGN KEY (`OUTLET_ID`) REFERENCES `outlet` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connection_event`
--

LOCK TABLES `connection_event` WRITE;
/*!40000 ALTER TABLE `connection_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `connection_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumption_profile`
--

DROP TABLE IF EXISTS `consumption_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consumption_profile` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `RFID_TAG_ID` int(11) NOT NULL,
  `AVERAGE_HOURLY_CONSUMPTION` int(11) DEFAULT NULL,
  `INSTANTANEOUS_CONSUMPTION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CONSUMPTION_PROFILE_FKIndex1` (`RFID_TAG_ID`),
  CONSTRAINT `fk_{2373581E-4EE3-407D-8B8A-CBE2D572DC28}` FOREIGN KEY (`RFID_TAG_ID`) REFERENCES `rfid_tag` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumption_profile`
--

LOCK TABLES `consumption_profile` WRITE;
/*!40000 ALTER TABLE `consumption_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumption_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `current`
--

DROP TABLE IF EXISTS `current`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `current` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `RFID_TAG_ID` int(11) NOT NULL,
  `USERS_ID` int(11) NOT NULL,
  `SOCKET_ID` int(11) NOT NULL,
  `TIMESTAMP` timestamp NULL DEFAULT NULL,
  `CURRENT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CURRENT_FKIndex1` (`SOCKET_ID`),
  KEY `CURRENT_FKIndex2` (`USERS_ID`),
  KEY `CURRENT_FKIndex3` (`RFID_TAG_ID`),
  CONSTRAINT `fk_{98F77DA9-88D3-44E2-809F-A02D07A0174E}` FOREIGN KEY (`SOCKET_ID`) REFERENCES `socket` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{620A4C79-2344-4454-B471-0E8D01FE0A66}` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{01A8162B-8EAC-4B02-A493-867D7E7F7719}` FOREIGN KEY (`RFID_TAG_ID`) REFERENCES `rfid_tag` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `current`
--

LOCK TABLES `current` WRITE;
/*!40000 ALTER TABLE `current` DISABLE KEYS */;
/*!40000 ALTER TABLE `current` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `current_hour`
--

DROP TABLE IF EXISTS `current_hour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `current_hour` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERS_ID` int(11) NOT NULL,
  `SOCKET_ID` int(11) NOT NULL,
  `TIMESTAMP` timestamp NULL DEFAULT NULL,
  `CURRENT_HOUR` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CURRENT_HOUR_FKIndex1` (`SOCKET_ID`),
  KEY `CURRENT_HOUR_FKIndex2` (`USERS_ID`),
  CONSTRAINT `fk_{C7FD20AE-A7FE-48ED-8288-858441651AF2}` FOREIGN KEY (`SOCKET_ID`) REFERENCES `socket` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{F59B3C95-713E-45DB-AA76-F24A2D182DB1}` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `current_hour`
--

LOCK TABLES `current_hour` WRITE;
/*!40000 ALTER TABLE `current_hour` DISABLE KEYS */;
/*!40000 ALTER TABLE `current_hour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EVENT_NAME` tinytext,
  `EVENT_DESCRIPTION` tinytext,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'Connection Opened','Connection Opened'),(2,'Connection Closed','Connection Closed'),(3,'Connection Binded','Connection Binded'),(4,'Intermitent Connection','Intermitent Connection'),(5,'Could not find Connection','Could not find Connection');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `general_profile`
--

DROP TABLE IF EXISTS `general_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `general_profile` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE_OF_DEVICE` tinytext,
  `CONSUMPTION_RANGE` int(11) DEFAULT NULL,
  `AVERAGE_HOURLY_CONSUMPTION` int(11) DEFAULT NULL,
  `INSTANTANEOUS_CONSUMPTION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_profile`
--

LOCK TABLES `general_profile` WRITE;
/*!40000 ALTER TABLE `general_profile` DISABLE KEYS */;
INSERT INTO `general_profile` VALUES (1,'Very large appliance',4,6,6),(2,'Large appliance',3,5,5),(3,'Medium appliance',3,4,4),(4,'Small appliance',2,3,3),(5,'Very small appliance',1,2,2);
/*!40000 ALTER TABLE `general_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` tinytext,
  `PASSWORD_VAL` tinytext,
  `CREATED_DATE` date DEFAULT NULL,
  `CREATED_USER_ID` int(11) DEFAULT NULL,
  `LAST_UPDATED_DATE` date DEFAULT NULL,
  `LAST_UPDATED_USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'admin','cerberus','2013-03-27',NULL,'2013-03-27',NULL),(2,'dvezina','cerberus','2013-03-27',NULL,'2013-03-27',NULL),(3,'clascelles','cerberus','2013-03-27',NULL,'2013-03-27',NULL),(4,'mwoods','cerberus','2013-03-27',NULL,'2013-03-27',NULL),(5,'fvezina','cerberus','2013-03-27',NULL,'2013-03-27',NULL),(6,'jquan','cerberus','2013-03-27',NULL,'2013-03-27',NULL);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outlet`
--

DROP TABLE IF EXISTS `outlet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `outlet` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `OUTLET_OPERATION_MODE_ID` int(11) NOT NULL,
  `ROOM_ID` int(11) NOT NULL,
  `SERIAL_NUM` varchar(10) NOT NULL,
  `SYSTEM_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `SERIAL_NUM_UNIQUE` (`SERIAL_NUM`),
  KEY `OUTLET_FKIndex1` (`ROOM_ID`),
  KEY `OUTLET_FKIndex2` (`OUTLET_OPERATION_MODE_ID`),
  KEY `fk_OUTLET_SYSTEM1_idx` (`SYSTEM_ID`),
  CONSTRAINT `fk_{63AA46EC-AF1C-4006-86C3-726864F1DC65}` FOREIGN KEY (`ROOM_ID`) REFERENCES `room` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{E5461FC8-5077-4C52-853B-F22D3C58FE98}` FOREIGN KEY (`OUTLET_OPERATION_MODE_ID`) REFERENCES `outlet_operation_mode` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OUTLET_SYSTEM1` FOREIGN KEY (`SYSTEM_ID`) REFERENCES `system` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outlet`
--

LOCK TABLES `outlet` WRITE;
/*!40000 ALTER TABLE `outlet` DISABLE KEYS */;
INSERT INTO `outlet` VALUES (1,1,1,'0000000001',1),(2,1,2,'0000000002',1),(3,1,3,'0000000003',1),(4,1,4,'0000000004',2),(5,1,5,'0000000005',2),(6,1,6,'0000000006',2),(7,1,7,'0000000007',3),(8,1,8,'0000000008',3),(9,1,1,'0000000009',1),(10,1,1,'0000000010',2),(11,1,2,'0000000011',3),(12,1,3,'0000000012',3);
/*!40000 ALTER TABLE `outlet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outlet_operation_mode`
--

DROP TABLE IF EXISTS `outlet_operation_mode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `outlet_operation_mode` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` tinytext,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outlet_operation_mode`
--

LOCK TABLES `outlet_operation_mode` WRITE;
/*!40000 ALTER TABLE `outlet_operation_mode` DISABLE KEYS */;
INSERT INTO `outlet_operation_mode` VALUES (1,'Enabled'),(2,'Disabled'),(3,'Monitoring'),(4,'Child Safety'),(5,'Authentication');
/*!40000 ALTER TABLE `outlet_operation_mode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_information`
--

DROP TABLE IF EXISTS `personal_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal_information` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` tinytext,
  `LAST_NAME` tinytext,
  `PHONE_NUMBER` tinytext,
  `ADDRESS` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_information`
--

LOCK TABLES `personal_information` WRITE;
/*!40000 ALTER TABLE `personal_information` DISABLE KEYS */;
INSERT INTO `personal_information` VALUES (1,'Cerberus','Cerberus','None','None'),(2,'David','Vezina','613-897-7811','6257 Ravine Way'),(3,'Charles','Lascelles','613-677-9541','Unknown'),(4,'Micheal','Woods','613-324-3899','Unknown'),(5,'Frederik','Vezina','613-898-7811','6257 Ravine Way'),(6,'Josephine','Quan','613-858-1228','Unknown');
/*!40000 ALTER TABLE `personal_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rfid_authentication`
--

DROP TABLE IF EXISTS `rfid_authentication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rfid_authentication` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `RFID_TAG_ID` int(11) NOT NULL,
  `USERS_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `RFID_AUTHENTICATION_FKIndex1` (`USERS_ID`),
  KEY `RFID_AUTHENTICATION_FKIndex2` (`RFID_TAG_ID`),
  CONSTRAINT `fk_{A6EB1914-11DD-4133-96A3-61550B77EB73}` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{F5A69B10-3132-4778-8CD3-3A9622D55F73}` FOREIGN KEY (`RFID_TAG_ID`) REFERENCES `rfid_tag` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rfid_authentication`
--

LOCK TABLES `rfid_authentication` WRITE;
/*!40000 ALTER TABLE `rfid_authentication` DISABLE KEYS */;
/*!40000 ALTER TABLE `rfid_authentication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rfid_tag`
--

DROP TABLE IF EXISTS `rfid_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rfid_tag` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NUMBER` varchar(10) NOT NULL,
  `DESCRIPTION` text,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NUMBER_UNIQUE` (`NUMBER`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rfid_tag`
--

LOCK TABLES `rfid_tag` WRITE;
/*!40000 ALTER TABLE `rfid_tag` DISABLE KEYS */;
INSERT INTO `rfid_tag` VALUES (1,'356AC37692','Toaster'),(2,'6538B2349D','Laptop'),(3,'845A3F5673','Kettle'),(4,'761239DCF1','Television'),(5,'628D23A853','Computer'),(6,'3849C32683','Light'),(7,'22568A5638','Phone Charger'),(8,'7538632468','Vaccum'),(9,'AA3578B34F','Radio'),(10,'479A347B31','Alarm Clock');
/*!40000 ALTER TABLE `rfid_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROOM_TYPE_ID` int(11) NOT NULL,
  `NAME` tinytext,
  PRIMARY KEY (`ID`,`ROOM_TYPE_ID`),
  KEY `ROOM_FKIndex1` (`ROOM_TYPE_ID`),
  CONSTRAINT `fk_{57C41637-4A56-4C24-8C6A-7B99B6CD9BB1}` FOREIGN KEY (`ROOM_TYPE_ID`) REFERENCES `room_type` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,7,'Kitchen'),(2,10,'Master Bathroom'),(3,10,'Kid\'s Bathroom'),(4,14,'Master Bedroom'),(5,14,'David\'s Bedroom'),(6,14,'Fred Bedroom'),(7,9,'Main Hallway'),(8,5,'Laundry Room');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_type`
--

DROP TABLE IF EXISTS `room_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` tinytext,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_type`
--

LOCK TABLES `room_type` WRITE;
/*!40000 ALTER TABLE `room_type` DISABLE KEYS */;
INSERT INTO `room_type` VALUES (1,'Foyer'),(2,'Front hall'),(3,'Living room'),(4,'Dining room'),(5,'Laundry room'),(6,'Sitting room'),(7,'Kitchen'),(8,'Stairwell'),(9,'Hallway'),(10,'Bathroom'),(11,'Half bath'),(12,'Ensuite bathroom'),(13,'Master bedroom'),(14,'Bedroom'),(15,'Guest bedroom'),(16,'Balcony');
/*!40000 ALTER TABLE `room_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule`
--

DROP TABLE IF EXISTS `rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rule` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
/*!40000 ALTER TABLE `rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule_tip_xref`
--

DROP TABLE IF EXISTS `rule_tip_xref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rule_tip_xref` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TIP_ID` int(11) NOT NULL,
  `RULE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `TIPS_FKIndex1` (`RULE_ID`),
  KEY `TIPS_FKIndex2` (`TIP_ID`),
  CONSTRAINT `fk_{98B92FAF-94B6-412E-840D-CAD887C4CD04}` FOREIGN KEY (`RULE_ID`) REFERENCES `rule` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{441E7FCC-889E-45AA-B46E-B768C2F35E91}` FOREIGN KEY (`TIP_ID`) REFERENCES `tip` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule_tip_xref`
--

LOCK TABLES `rule_tip_xref` WRITE;
/*!40000 ALTER TABLE `rule_tip_xref` DISABLE KEYS */;
/*!40000 ALTER TABLE `rule_tip_xref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_end_mode`
--

DROP TABLE IF EXISTS `schedule_end_mode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_end_mode` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SOCKET_OPERATION_MODE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `SCHEDULE_END_MODE_FKIndex1` (`SOCKET_OPERATION_MODE_ID`),
  CONSTRAINT `fk_{EDE32FA4-0D2A-4AA0-AAD5-F117E91A7CAC}` FOREIGN KEY (`SOCKET_OPERATION_MODE_ID`) REFERENCES `socket_operation_mode` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_end_mode`
--

LOCK TABLES `schedule_end_mode` WRITE;
/*!40000 ALTER TABLE `schedule_end_mode` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule_end_mode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_start_mode`
--

DROP TABLE IF EXISTS `schedule_start_mode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_start_mode` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SOCKET_OPERATION_MODE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `SCHEDULE_START_MODE_FKIndex1` (`SOCKET_OPERATION_MODE_ID`),
  CONSTRAINT `fk_{7E3A34D7-58D7-4D66-9717-4B01DDEC431B}` FOREIGN KEY (`SOCKET_OPERATION_MODE_ID`) REFERENCES `socket_operation_mode` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_start_mode`
--

LOCK TABLES `schedule_start_mode` WRITE;
/*!40000 ALTER TABLE `schedule_start_mode` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule_start_mode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scheduled_event`
--

DROP TABLE IF EXISTS `scheduled_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scheduled_event` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SCHEDULE_END_MODE_ID` int(11) NOT NULL,
  `SCHEDULE_START_MODE_ID` int(11) NOT NULL,
  `SOCKET_ID` int(11) NOT NULL,
  `USERS_ID` int(11) NOT NULL,
  `START_TIME` time DEFAULT NULL,
  `END_TIME` time DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `SCHEDULED_EVENT_FKIndex1` (`USERS_ID`),
  KEY `SCHEDULED_EVENT_FKIndex2` (`SOCKET_ID`),
  KEY `SCHEDULED_EVENT_FKIndex3` (`SCHEDULE_START_MODE_ID`),
  KEY `SCHEDULED_EVENT_FKIndex4` (`SCHEDULE_END_MODE_ID`),
  CONSTRAINT `fk_{0A5185F2-CAED-41C8-9B0A-6E94C01D710B}` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{C343C72D-38FA-408C-AFF7-D7F371EDABC7}` FOREIGN KEY (`SOCKET_ID`) REFERENCES `socket` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{2E6ACAC5-E156-416D-A13F-735E87ADB060}` FOREIGN KEY (`SCHEDULE_START_MODE_ID`) REFERENCES `schedule_start_mode` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{1D49F5A7-D149-4ACB-9C8D-B8DE2C97CA6A}` FOREIGN KEY (`SCHEDULE_END_MODE_ID`) REFERENCES `schedule_end_mode` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheduled_event`
--

LOCK TABLES `scheduled_event` WRITE;
/*!40000 ALTER TABLE `scheduled_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `scheduled_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socket`
--

DROP TABLE IF EXISTS `socket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socket` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SOCKET_OPERATION_STATUS_ID` int(11) NOT NULL,
  `SOCKET_OPERATION_MODE_ID` int(11) NOT NULL,
  `OUTLET_ID` int(11) NOT NULL,
  `SERIAL_NUM` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `SERIAL_NUM_UNIQUE` (`SERIAL_NUM`),
  KEY `SOCKET_FKIndex1` (`OUTLET_ID`),
  KEY `SOCKET_FKIndex2` (`SOCKET_OPERATION_MODE_ID`),
  KEY `SOCKET_FKIndex3` (`SOCKET_OPERATION_STATUS_ID`),
  CONSTRAINT `fk_{F61548DC-550F-4EC3-AC6C-5D3F97DA104C}` FOREIGN KEY (`OUTLET_ID`) REFERENCES `outlet` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{42C4695B-2ECA-4B8F-9A9C-0B6AC6BB5B03}` FOREIGN KEY (`SOCKET_OPERATION_MODE_ID`) REFERENCES `socket_operation_mode` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{E5A5CFB9-41A8-4166-A790-47FA4AEB7303}` FOREIGN KEY (`SOCKET_OPERATION_STATUS_ID`) REFERENCES `socket_operation_status` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socket`
--

LOCK TABLES `socket` WRITE;
/*!40000 ALTER TABLE `socket` DISABLE KEYS */;
INSERT INTO `socket` VALUES (1,1,4,1,'4500006701'),(2,1,3,1,'4500006702'),(3,1,4,2,'4500006703'),(4,1,3,3,'4500006704'),(5,1,2,4,'4500006705'),(6,1,3,4,'4500006706'),(7,1,3,5,'4500006707'),(8,1,4,6,'4500006708'),(9,1,3,6,'4500006709'),(10,1,3,7,'4500006710'),(11,1,3,8,'4500006711'),(12,1,4,9,'4500006712'),(13,1,3,10,'4500006713'),(14,1,2,10,'4500006714'),(15,1,3,11,'4500006715'),(16,1,3,11,'4500006716'),(17,1,3,12,'4500006717');
/*!40000 ALTER TABLE `socket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socket_assignment`
--

DROP TABLE IF EXISTS `socket_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socket_assignment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SOCKET_ID` int(11) NOT NULL,
  `USERS_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ASSIGNMENTS_FKIndex1` (`USERS_ID`),
  KEY `ASSIGNMENTS_FKIndex2` (`SOCKET_ID`),
  CONSTRAINT `fk_{4A324159-B8D3-45F2-8F72-05686A4C6CA3}` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{23BD712B-7922-4593-BB1D-63D9BB7EE508}` FOREIGN KEY (`SOCKET_ID`) REFERENCES `socket` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socket_assignment`
--

LOCK TABLES `socket_assignment` WRITE;
/*!40000 ALTER TABLE `socket_assignment` DISABLE KEYS */;
INSERT INTO `socket_assignment` VALUES (1,1,2),(2,2,3),(3,3,4),(4,4,5),(5,5,6),(6,6,2),(7,7,3),(8,8,4),(9,9,5),(10,10,6),(11,11,2),(12,12,3),(13,13,4),(14,14,5),(15,15,6),(16,16,2),(17,17,3);
/*!40000 ALTER TABLE `socket_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socket_operation_mode`
--

DROP TABLE IF EXISTS `socket_operation_mode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socket_operation_mode` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `OUTLET_OPERATION_MODE` int(11) DEFAULT NULL,
  `DESCRIPTION` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socket_operation_mode`
--

LOCK TABLES `socket_operation_mode` WRITE;
/*!40000 ALTER TABLE `socket_operation_mode` DISABLE KEYS */;
INSERT INTO `socket_operation_mode` VALUES (1,1,'Disabled'),(2,3,'Monitoring'),(3,5,'Authentication'),(4,4,'Child Safety');
/*!40000 ALTER TABLE `socket_operation_mode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socket_operation_status`
--

DROP TABLE IF EXISTS `socket_operation_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socket_operation_status` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STATUS_VALUE` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socket_operation_status`
--

LOCK TABLES `socket_operation_status` WRITE;
/*!40000 ALTER TABLE `socket_operation_status` DISABLE KEYS */;
INSERT INTO `socket_operation_status` VALUES (1,'Good'),(2,'Errors'),(3,'Disabled');
/*!40000 ALTER TABLE `socket_operation_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system`
--

DROP TABLE IF EXISTS `system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERS_ID` int(11) NOT NULL,
  `NAME` tinytext,
  PRIMARY KEY (`ID`),
  KEY `SYSTEM_FKIndex1` (`USERS_ID`),
  CONSTRAINT `fk_{DBABFD7F-D1BC-49AC-A144-883A68EA2FA7}` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system`
--

LOCK TABLES `system` WRITE;
/*!40000 ALTER TABLE `system` DISABLE KEYS */;
INSERT INTO `system` VALUES (1,2,'David\'s System'),(2,3,'Charles\' System'),(3,4,'Michael\'s System');
/*!40000 ALTER TABLE `system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tip`
--

DROP TABLE IF EXISTS `tip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tip` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tip`
--

LOCK TABLES `tip` WRITE;
/*!40000 ALTER TABLE `tip` DISABLE KEYS */;
/*!40000 ALTER TABLE `tip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_setting`
--

DROP TABLE IF EXISTS `user_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_setting` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEFAULT_OPERATION` int(11) DEFAULT NULL,
  `DEFAULT_ASSIGNMENT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_setting`
--

LOCK TABLES `user_setting` WRITE;
/*!40000 ALTER TABLE `user_setting` DISABLE KEYS */;
INSERT INTO `user_setting` VALUES (1,0,0),(2,0,1),(3,1,0),(4,1,1);
/*!40000 ALTER TABLE `user_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_type`
--

DROP TABLE IF EXISTS `user_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE_NAME` tinytext,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_type`
--

LOCK TABLES `user_type` WRITE;
/*!40000 ALTER TABLE `user_type` DISABLE KEYS */;
INSERT INTO `user_type` VALUES (1,'System Administrator'),(2,'System Owner'),(3,'Consumer');
/*!40000 ALTER TABLE `user_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_SETTING_ID` int(11) DEFAULT NULL,
  `USER_TYPE_ID` int(11) NOT NULL,
  `LOGIN_ID` int(11) NOT NULL,
  `PERSONAL_INFORMATION_ID` int(11) NOT NULL,
  `CREATED_DATE` date DEFAULT NULL,
  `CREATED_USER_ID` int(11) DEFAULT NULL,
  `LAST_UPDATED_DATE` date DEFAULT NULL,
  `LAST_UPDATED_USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `USER_TABLE_FKIndex1` (`PERSONAL_INFORMATION_ID`),
  KEY `USER_TABLE_FKIndex2` (`LOGIN_ID`),
  KEY `USER_TABLE_FKIndex3` (`USER_TYPE_ID`),
  KEY `USER_TABLE_FKIndex4` (`USER_SETTING_ID`),
  CONSTRAINT `fk_{4D9BD4AC-9A1F-4DB6-9E8A-9CB2C2ACBDF7}` FOREIGN KEY (`PERSONAL_INFORMATION_ID`) REFERENCES `personal_information` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{F5F29746-0833-41D8-AB8D-D2F76D6888A2}` FOREIGN KEY (`LOGIN_ID`) REFERENCES `login` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{46C82E7A-345E-48BB-9ED4-648E3F3405AD}` FOREIGN KEY (`USER_TYPE_ID`) REFERENCES `user_type` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_{15088E1B-AC75-4136-BE48-8B120B01B952}` FOREIGN KEY (`USER_SETTING_ID`) REFERENCES `user_setting` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,1,1,1,'2013-03-27',1,'2013-03-27',1),(2,1,2,2,2,'2013-03-27',1,'2013-03-27',1),(3,1,2,3,3,'2013-03-27',1,'2013-03-27',1),(4,1,2,4,4,'2013-03-27',1,'2013-03-27',1),(5,1,3,5,5,'2013-03-27',1,'2013-03-27',1),(6,1,3,6,6,'2013-03-27',1,'2013-03-27',1);
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

-- Dump completed on 2013-03-28 21:08:01
