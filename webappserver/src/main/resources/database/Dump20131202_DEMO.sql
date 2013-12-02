CREATE DATABASE  IF NOT EXISTS `cerberus` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cerberus`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: cerberus
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `consumption_profile`
--

DROP TABLE IF EXISTS `consumption_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consumption_profile` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROFILE_NAME` text NOT NULL,
  `AVERAGE_HOURLY_CONSUMPTION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumption_profile`
--

LOCK TABLES `consumption_profile` WRITE;
/*!40000 ALTER TABLE `consumption_profile` DISABLE KEYS */;
INSERT INTO `consumption_profile` VALUES (1,'Kitchen Appliance',NULL),(2,'Electronic Device',NULL),(3,'Home Appliance',NULL),(4,'Clothes Dryer',85),(5,'Freezer',147),(6,'Range (Oven)',22),(7,'Air Conditioner (12 000 BTU)',300),(8,'Computer (With monitor and printer)',30),(9,'Ceiling Fan',12),(10,'Hair Dryer',10),(11,'Portable Heater',60),(12,'Microwave Oven',17),(13,'Toaster',5),(14,'Clothes Iron',5),(15,'Satellite Dish (Including receiver)',66),(16,'Refrigerator',150),(17,'Dishwasher',30),(18,'Laptop',15),(19,'Clothes Washer',10);
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
  `RFID_TAG_ID` int(11) DEFAULT NULL,
  `USERS_ID` int(11) DEFAULT NULL,
  `SOCKET_ID` int(11) NOT NULL,
  `TIMESTAMP` timestamp NULL DEFAULT NULL,
  `CURRENT` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CURRENT_FKIndex1` (`SOCKET_ID`),
  KEY `CURRENT_FKIndex2` (`USERS_ID`),
  KEY `CURRENT_FKIndex3` (`RFID_TAG_ID`),
  CONSTRAINT `fk_?01A8162B?8EAC?4B02?A493?867D7E7F7719?` FOREIGN KEY (`RFID_TAG_ID`) REFERENCES `rfid_tag` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?620A4C79?2344?4454?B471?0E8D01FE0A66?` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?98F77DA9?88D3?44E2?809F?A02D07A0174E?` FOREIGN KEY (`SOCKET_ID`) REFERENCES `socket` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Temporary table structure for view `current_day_view`
--

DROP TABLE IF EXISTS `current_day_view`;
/*!50001 DROP VIEW IF EXISTS `current_day_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `current_day_view` (
  `ID` tinyint NOT NULL,
  `TIMESTAMP_DAY` tinyint NOT NULL,
  `DAY` tinyint NOT NULL,
  `SYSTEM_ID` tinyint NOT NULL,
  `CURRENT_DAY_KWH` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `current_hour`
--

DROP TABLE IF EXISTS `current_hour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `current_hour` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SYSTEM_ID` int(11) NOT NULL,
  `TIMESTAMP` timestamp NULL DEFAULT NULL,
  `CURRENT_HOUR` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CURRENT_HOUR_FKIndex2` (`SYSTEM_ID`),
  CONSTRAINT `fk_?JKIGUF7895HJH` FOREIGN KEY (`SYSTEM_ID`) REFERENCES `system` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `current_hour`
--

LOCK TABLES `current_hour` WRITE;
/*!40000 ALTER TABLE `current_hour` DISABLE KEYS */;
INSERT INTO `current_hour` VALUES (1,4,'2013-12-03 05:00:00',1.63),(2,4,'2013-12-03 06:00:00',0.87),(3,4,'2013-12-03 07:00:00',0.75),(4,4,'2013-12-03 08:00:00',0.32),(5,4,'2013-12-03 09:00:00',0.32),(6,4,'2013-12-03 10:00:00',0.6),(7,4,'2013-12-03 11:00:00',0.54),(8,4,'2013-12-03 12:00:00',1.54),(9,4,'2013-12-03 13:00:00',3.4),(10,4,'2013-12-03 14:00:00',1.67),(11,4,'2013-12-03 15:00:00',2.54),(12,4,'2013-12-03 16:00:00',1.44),(13,4,'2013-12-03 17:00:00',1.43),(14,4,'2013-12-03 18:00:00',0.99),(15,4,'2013-12-03 19:00:00',1.76),(16,4,'2013-12-03 20:00:00',1.44),(17,4,'2013-12-03 21:00:00',2.54),(18,4,'2013-12-03 22:00:00',4.12),(19,4,'2013-12-03 23:00:00',5.42),(25,4,'2013-12-02 05:00:00',27.42),(26,4,'2013-12-01 07:00:00',25.11),(27,4,'2013-11-30 05:00:00',23.87),(28,4,'2013-11-29 05:00:00',34.11),(29,4,'2013-11-28 05:00:00',37.39),(30,4,'2013-11-27 05:00:00',31.69),(31,4,'2013-11-26 05:00:00',26.01),(32,4,'2013-11-25 05:00:00',19.67),(33,4,'2013-11-24 05:00:00',22.86),(34,4,'2013-11-23 05:00:00',34.97),(35,4,'2013-11-22 05:00:00',33.22),(36,4,'2013-11-21 05:00:00',31),(37,4,'2013-11-20 05:00:00',28.57),(38,4,'2013-11-19 05:00:00',26.07),(39,4,'2013-11-18 05:00:00',22.45),(40,4,'2013-11-17 05:00:00',19.11),(41,4,'2013-11-16 05:00:00',37.23),(42,4,'2013-11-15 05:00:00',25.99),(43,4,'2013-11-14 05:00:00',21.83),(44,4,'2013-11-13 05:00:00',35.21),(45,4,'2013-11-12 05:00:00',31.98),(46,4,'2013-11-11 05:00:00',20),(47,4,'2013-11-10 05:00:00',38.11),(48,4,'2013-11-09 05:00:00',29.48),(49,4,'2013-11-08 05:00:00',26.06),(50,4,'2013-11-07 05:00:00',31.75),(51,4,'2013-11-06 05:00:00',36.21),(52,4,'2013-11-05 05:00:00',28.61),(53,4,'2013-11-04 05:00:00',21.85),(54,4,'2013-11-03 04:00:00',27.42),(55,4,'2013-11-02 04:00:00',21.25),(56,4,'2013-11-01 04:00:00',28.21),(57,4,'2013-10-31 04:00:00',31.31);
/*!40000 ALTER TABLE `current_hour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `current_hour_view`
--

DROP TABLE IF EXISTS `current_hour_view`;
/*!50001 DROP VIEW IF EXISTS `current_hour_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `current_hour_view` (
  `ID` tinyint NOT NULL,
  `TIMESTAMP_HOUR` tinyint NOT NULL,
  `HOUR` tinyint NOT NULL,
  `SYSTEM_ID` tinyint NOT NULL,
  `CURRENT_HOUR_KWH` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `current_system_view`
--

DROP TABLE IF EXISTS `current_system_view`;
/*!50001 DROP VIEW IF EXISTS `current_system_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `current_system_view` (
  `CURRENT_ID` tinyint NOT NULL,
  `SYSTEM_ID` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `current_view_by_hour`
--

DROP TABLE IF EXISTS `current_view_by_hour`;
/*!50001 DROP VIEW IF EXISTS `current_view_by_hour`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `current_view_by_hour` (
  `ID` tinyint NOT NULL,
  `TIMESTAMP_HOUR` tinyint NOT NULL,
  `HOUR` tinyint NOT NULL,
  `SYSTEM_ID` tinyint NOT NULL,
  `CURRENT_HOUR_KWH` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EVENT_NAME` tinytext NOT NULL,
  `EVENT_MESSAGE` text,
  `EVENT_LEVEL_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EVENT_LEVEL_ID` (`EVENT_LEVEL_ID`),
  CONSTRAINT `event_ibfk_1` FOREIGN KEY (`EVENT_LEVEL_ID`) REFERENCES `event_level` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'Connection Established','Outlet %s successfully connected',1),(2,'Connection Lost','Outlet %s disconnected',3),(3,'New Outlet','New outlet %s was added to the system',2),(4,'Scheduled Event Triggered','Outlet %s is now in %s mode',1),(5,'Device Plugged','Device %s was plugged in outlet %s',1),(6,'Device Unplugged','Device %s was unplugged from outlet %s',1),(7,'New RFID Tag','A new RFID tag was added to the system',2),(8,'RFID Tag Allowed','Outlet %s allowed an RFID-enabled device',1),(9,'RFID Tag Denied','Outlet %s denied an RFID-enabled device',1);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_level`
--

DROP TABLE IF EXISTS `event_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_level` (
  `ID` int(11) NOT NULL,
  `EVENT_LEVEL` tinytext NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_level`
--

LOCK TABLES `event_level` WRITE;
/*!40000 ALTER TABLE `event_level` DISABLE KEYS */;
INSERT INTO `event_level` VALUES (1,'Info'),(2,'Announcement'),(3,'Warning'),(4,'Error'),(5,'Debug');
/*!40000 ALTER TABLE `event_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_record`
--

DROP TABLE IF EXISTS `event_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `OUTLET_ID` int(11) NOT NULL,
  `EVENT_ID` int(11) NOT NULL,
  `TIMESTAMP` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EVENT_RECORD_FKIndex1` (`EVENT_ID`),
  KEY `EVENT_RECORD_FKIndex2` (`OUTLET_ID`),
  CONSTRAINT `fk_?0905D9E0?F215?41D3?9D86?75BC8BF3A8A4?` FOREIGN KEY (`OUTLET_ID`) REFERENCES `outlet` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?3AD07AA9?3F08?406A?AA34?C28B9486A2BB?` FOREIGN KEY (`EVENT_ID`) REFERENCES `event` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_record`
--

LOCK TABLES `event_record` WRITE;
/*!40000 ALTER TABLE `event_record` DISABLE KEYS */;
INSERT INTO `event_record` VALUES (1,14,3,'2013-12-02 18:37:19'),(2,15,3,'2013-12-02 18:37:35'),(3,16,3,'2013-12-02 18:37:52'),(4,17,3,'2013-12-02 18:38:06'),(5,18,3,'2013-12-02 18:38:30'),(6,19,3,'2013-12-02 18:38:46'),(7,15,2,'2013-12-02 23:54:32'),(8,15,1,'2013-12-02 23:55:25'),(9,17,7,'2013-12-03 01:03:51'),(10,17,8,'2013-12-03 01:05:21'),(11,15,9,'2013-12-03 02:03:44');
/*!40000 ALTER TABLE `event_record` ENABLE KEYS */;
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
  `SYSTEM_ID` int(11) NOT NULL,
  `IS_SYS_ADMIN` tinyint(1) NOT NULL,
  `CREATED_DATE` date DEFAULT NULL,
  `CREATED_USER_ID` int(11) DEFAULT NULL,
  `LAST_UPDATED_DATE` date DEFAULT NULL,
  `LAST_UPDATED_USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `LOGIN_FKIndex1` (`SYSTEM_ID`),
  CONSTRAINT `fk_?DBABFD7F?D1BC?49AC?A144?243A68EA2FA7?` FOREIGN KEY (`SYSTEM_ID`) REFERENCES `system` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'admin','cerberus',1,1,'2013-03-27',NULL,'2013-03-27',NULL),(2,'dvezina','cerberus',1,1,'2013-03-27',NULL,'2013-03-27',NULL),(3,'clascelles','cerberus',2,1,'2013-03-27',NULL,'2013-03-27',NULL),(4,'mwoods','cerberus',3,1,'2013-03-27',NULL,'2013-03-27',NULL),(5,'fvezina','cerberus',3,1,'2013-03-27',NULL,'2013-03-27',NULL),(6,'jquan','cerberus',3,1,'2013-03-27',NULL,'2013-03-27',NULL),(7,'fulldemo','cerberus',4,1,'2013-12-02',NULL,'2013-12-02',NULL);
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
  `SERIAL_NUM` varchar(12) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `SERIAL_NUM_UNIQUE` (`SERIAL_NUM`),
  KEY `OUTLET_FKIndex1` (`ROOM_ID`),
  KEY `OUTLET_FKIndex2` (`OUTLET_OPERATION_MODE_ID`),
  CONSTRAINT `fk_?63AA46EC?AF1C?4006?86C3?726864F1DC65?` FOREIGN KEY (`ROOM_ID`) REFERENCES `room` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?E5461FC8?5077?4C52?853B?F22D3C58FE98?` FOREIGN KEY (`OUTLET_OPERATION_MODE_ID`) REFERENCES `outlet_operation_mode` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outlet`
--

LOCK TABLES `outlet` WRITE;
/*!40000 ALTER TABLE `outlet` DISABLE KEYS */;
INSERT INTO `outlet` VALUES (14,1,31,'002DC924B98A'),(15,1,31,'021CD669B72F'),(16,1,41,'001BE642A76C'),(17,1,35,'001AB374B89F'),(18,1,37,'003EE997A35F'),(19,1,38,'001BB398F87C');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outlet_operation_mode`
--

LOCK TABLES `outlet_operation_mode` WRITE;
/*!40000 ALTER TABLE `outlet_operation_mode` DISABLE KEYS */;
INSERT INTO `outlet_operation_mode` VALUES (1,'Monitoring'),(2,'Safety'),(3,'Restricted');
/*!40000 ALTER TABLE `outlet_operation_mode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `outlet_system_view`
--

DROP TABLE IF EXISTS `outlet_system_view`;
/*!50001 DROP VIEW IF EXISTS `outlet_system_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `outlet_system_view` (
  `OUTLET_ID` tinyint NOT NULL,
  `SYSTEM_ID` tinyint NOT NULL,
  `SOCKET_ID` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_information`
--

LOCK TABLES `personal_information` WRITE;
/*!40000 ALTER TABLE `personal_information` DISABLE KEYS */;
INSERT INTO `personal_information` VALUES (1,'Cerberus','Cerberus','None','None'),(2,'David','Vezina','613-897-7811','6257 Ravine Way'),(3,'Charles','Lascelles','613-677-9541','Unknown'),(4,'Michael','Woods','613-324-1234','Unknown'),(5,'Frederik','Vezina','613-898-7811','6257 Ravine Way'),(6,'Josephine','Quan','613-858-1228','Unknown'),(7,'Nicolas','Cage',NULL,NULL);
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
  `PERMISSION` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `RFID_AUTHENTICATION_FKIndex1` (`USERS_ID`),
  KEY `RFID_AUTHENTICATION_FKIndex2` (`RFID_TAG_ID`),
  CONSTRAINT `fk_?A6EB1914?11DD?4133?96A3?61550B77EB73?` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?F5A69B10?3132?4778?8CD3?3A9622D55F73?` FOREIGN KEY (`RFID_TAG_ID`) REFERENCES `rfid_tag` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rfid_authentication`
--

LOCK TABLES `rfid_authentication` WRITE;
/*!40000 ALTER TABLE `rfid_authentication` DISABLE KEYS */;
INSERT INTO `rfid_authentication` VALUES (1,1,7,1),(2,2,7,1),(3,3,7,0),(4,4,7,1);
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
  `PROFILE_ID` int(11) DEFAULT NULL,
  `NUMBER` varchar(10) NOT NULL,
  `TAG_NAME` text,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NUMBER_UNIQUE` (`NUMBER`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rfid_tag`
--

LOCK TABLES `rfid_tag` WRITE;
/*!40000 ALTER TABLE `rfid_tag` DISABLE KEYS */;
INSERT INTO `rfid_tag` VALUES (1,10,'1285da28d1','Nicolas\' Hair Dryer'),(2,18,'1234abce41','Nicolas\' Laptop'),(3,7,'ab241acd34','Living Room\'s AC'),(4,13,'ababababab','Kitchen Toaster');
/*!40000 ALTER TABLE `rfid_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `rfid_tag_view`
--

DROP TABLE IF EXISTS `rfid_tag_view`;
/*!50001 DROP VIEW IF EXISTS `rfid_tag_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rfid_tag_view` (
  `RFID_ID` tinyint NOT NULL,
  `RFID_NUMBER` tinyint NOT NULL,
  `RFID_NAME` tinyint NOT NULL,
  `PROFILE_NAME` tinyint NOT NULL,
  `USER_ID` tinyint NOT NULL,
  `RFID_PERMISSION` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

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
  `SYSTEM_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`,`ROOM_TYPE_ID`),
  KEY `ROOM_FKIndex1` (`ROOM_TYPE_ID`),
  KEY `SYST_FKIndex2` (`SYSTEM_ID`),
  CONSTRAINT `fk_?57C41637?4A56?4C24?8C6A?7B99B6CD9BB1?` FOREIGN KEY (`ROOM_TYPE_ID`) REFERENCES `room_type` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?81C21334?4A56?4C24?8C6A?DAD687C6CD04?` FOREIGN KEY (`SYSTEM_ID`) REFERENCES `system` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,7,'Kitchen',1),(2,10,'Master Bathroom',1),(3,10,'Kid\'s Bathroom',1),(4,14,'Master Bedroom',1),(5,14,'David\'s Bedroom',1),(6,14,'Fred Bedroom',1),(7,9,'Main Hallway',1),(8,5,'Laundry Room',1),(11,7,'Kitchen',1),(12,10,'Master Bathroom',2),(13,10,'Kid\'s Bathroom',2),(14,14,'Master Bedroom',2),(15,14,'David\'s Bedroom',2),(16,14,'Fred Bedroom',2),(17,9,'Main Hallway',2),(18,5,'Laundry Room',2),(21,7,'Kitchen',3),(22,10,'Master Bathroom',3),(23,10,'Kid\'s Bathroom',3),(24,14,'Master Bedroom',3),(25,14,'David\'s Bedroom',3),(26,14,'Fred Bedroom',3),(27,9,'Main Hallway',3),(28,5,'Laundry Room',3),(29,1,'Foyer',4),(30,2,'Front Hall',4),(31,3,'Living Room',4),(32,4,'Dining Room',4),(33,5,'Laundry Room',4),(34,6,'Sitting Room',4),(35,7,'Kitchen',4),(36,8,'Stairwell',4),(37,9,'Hallway',4),(38,10,'Bathroom',4),(39,11,'Half Bath',4),(40,12,'Ensuite Bathroom',4),(41,13,'Master Bedroom',4),(42,14,'Bedroom',4),(43,15,'Guest Bedroom',4),(44,16,'Balcony',4);
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_type`
--

LOCK TABLES `room_type` WRITE;
/*!40000 ALTER TABLE `room_type` DISABLE KEYS */;
INSERT INTO `room_type` VALUES (1,'Foyer'),(2,'Front hall'),(3,'Living room'),(4,'Dining room'),(5,'Laundry room'),(6,'Sitting room'),(7,'Kitchen'),(8,'Stairwell'),(9,'Hallway'),(10,'Bathroom'),(11,'Half bath'),(12,'Ensuite bathroom'),(13,'Master bedroom'),(14,'Bedroom'),(15,'Guest bedroom'),(16,'Balcony'),(17,'Office'),(18,'Basement');
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
  `RULE_TYPE` int(11) NOT NULL,
  `OPERATOR` varchar(3) NOT NULL,
  `DATE` date DEFAULT NULL,
  `TIME` time DEFAULT NULL,
  `CONSUMPTION` double DEFAULT NULL,
  `APPLIANCE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
INSERT INTO `rule` VALUES (1,1,'=','2013-12-02',NULL,NULL,NULL),(2,1,'=','2014-03-28',NULL,NULL,NULL),(3,2,'>',NULL,'11:00:00',NULL,NULL),(4,2,'<',NULL,'17:00:00',NULL,NULL),(5,4,'=',NULL,NULL,NULL,3),(6,4,'=',NULL,NULL,NULL,4),(7,4,'=',NULL,NULL,NULL,7),(8,4,'=',NULL,NULL,NULL,11),(9,4,'=',NULL,NULL,NULL,17),(10,4,'=',NULL,NULL,NULL,19);
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
  CONSTRAINT `fk_?441E7FCC?889E?45AA?B46E?B768C2F35E91?` FOREIGN KEY (`TIP_ID`) REFERENCES `tip` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?98B92FAF?94B6?412E?840D?CAD887C4CD04?` FOREIGN KEY (`RULE_ID`) REFERENCES `rule` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule_tip_xref`
--

LOCK TABLES `rule_tip_xref` WRITE;
/*!40000 ALTER TABLE `rule_tip_xref` DISABLE KEYS */;
INSERT INTO `rule_tip_xref` VALUES (1,1,1),(2,2,2),(3,3,3),(4,3,4),(5,3,5),(6,4,3),(7,4,4),(8,4,6),(9,5,3),(10,5,4),(11,5,7),(12,6,3),(13,6,4),(14,6,8),(15,7,3),(16,7,4),(17,7,9),(18,8,3),(19,8,4),(20,8,10);
/*!40000 ALTER TABLE `rule_tip_xref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `ID` int(11) NOT NULL,
  `START_EVENT_ID` int(11) NOT NULL,
  `END_EVENT_ID` int(11) NOT NULL,
  `SOCKET_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `RECURRENCE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `START_EVENT_ID_idx` (`START_EVENT_ID`),
  KEY `END_EVENT_ID_idx` (`END_EVENT_ID`),
  KEY `SOCKET_ID_idx` (`SOCKET_ID`),
  KEY `USER_ID_idx` (`USER_ID`),
  KEY `RECURRENCE_ID_idx` (`RECURRENCE_ID`),
  CONSTRAINT `END_EVENT_ID` FOREIGN KEY (`END_EVENT_ID`) REFERENCES `scheduled_event` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RECURRENCE_ID` FOREIGN KEY (`RECURRENCE_ID`) REFERENCES `schedule_recurrence` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SOCKET_ID` FOREIGN KEY (`SOCKET_ID`) REFERENCES `socket` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `START_EVENT_ID` FOREIGN KEY (`START_EVENT_ID`) REFERENCES `scheduled_event` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
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
  CONSTRAINT `fk_?EDE32FA4?0D2A?4AA0?AAD5?F117E91A7CAC?` FOREIGN KEY (`SOCKET_OPERATION_MODE_ID`) REFERENCES `socket_operation_mode` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `schedule_recurrence`
--

DROP TABLE IF EXISTS `schedule_recurrence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_recurrence` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_recurrence`
--

LOCK TABLES `schedule_recurrence` WRITE;
/*!40000 ALTER TABLE `schedule_recurrence` DISABLE KEYS */;
INSERT INTO `schedule_recurrence` VALUES (1,'Once'),(2,'Hourly'),(3,'Daily'),(4,'Weekly'),(5,'Bi-Weekly'),(6,'Monthly'),(7,'Yearly');
/*!40000 ALTER TABLE `schedule_recurrence` ENABLE KEYS */;
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
  CONSTRAINT `fk_?7E3A34D7?58D7?4D66?9717?4B01DDEC431B?` FOREIGN KEY (`SOCKET_OPERATION_MODE_ID`) REFERENCES `socket_operation_mode` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `SCHEDULE_MODE_ID` int(11) NOT NULL,
  `SOCKET_ID` int(11) NOT NULL,
  `USERS_ID` int(11) NOT NULL,
  `EVENT_TIME` datetime DEFAULT NULL,
  `RECURRENCE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `SCHEDULED_EVENT_FKIndex1` (`USERS_ID`),
  KEY `SCHEDULED_EVENT_FKIndex2` (`SOCKET_ID`),
  KEY `SCHEDULED_EVENT_FKIndex3` (`SCHEDULE_MODE_ID`),
  KEY `SCHEDULED_EVENT_FKIndex4` (`RECURRENCE_ID`),
  CONSTRAINT `fk_?0A5185F2?CAED?41C8?9B0A?6E94C01D710B?` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?1D49F5A7?D149?4ACB?9C8D?B8DE2C97CA6A?` FOREIGN KEY (`SCHEDULE_MODE_ID`) REFERENCES `socket_operation_mode` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?A12CB52D?38FA?408C?AFF7?D7F371EDABC7?` FOREIGN KEY (`RECURRENCE_ID`) REFERENCES `schedule_recurrence` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?C343C72D?12FA?564C?AFF7?D7F371EDABC7?` FOREIGN KEY (`SOCKET_ID`) REFERENCES `socket` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheduled_event`
--

LOCK TABLES `scheduled_event` WRITE;
/*!40000 ALTER TABLE `scheduled_event` DISABLE KEYS */;
INSERT INTO `scheduled_event` VALUES (2,2,31,7,'2013-12-03 19:00:00',1),(3,2,27,7,'2013-12-03 20:00:01',4),(4,3,34,7,'2013-12-02 15:25:00',1);
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
  `SOCKET_POSITION` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `OUTLET_ID` (`OUTLET_ID`,`SOCKET_POSITION`),
  KEY `SOCKET_FKIndex1` (`OUTLET_ID`),
  KEY `SOCKET_FKIndex2` (`SOCKET_OPERATION_MODE_ID`),
  KEY `SOCKET_FKIndex3` (`SOCKET_OPERATION_STATUS_ID`),
  CONSTRAINT `fk_?42C4695B?2ECA?4B8F?9A9C?0B6AC6BB5B03?` FOREIGN KEY (`SOCKET_OPERATION_MODE_ID`) REFERENCES `socket_operation_mode` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?E5A5CFB9?41A8?4166?A790?47FA4AEB7303?` FOREIGN KEY (`SOCKET_OPERATION_STATUS_ID`) REFERENCES `socket_operation_status` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?F61548DC?550F?4EC3?AC6C?5D3F97DA104C?` FOREIGN KEY (`OUTLET_ID`) REFERENCES `outlet` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socket`
--

LOCK TABLES `socket` WRITE;
/*!40000 ALTER TABLE `socket` DISABLE KEYS */;
INSERT INTO `socket` VALUES (27,3,3,14,0),(28,3,3,14,1),(29,3,3,15,0),(30,3,3,15,1),(31,3,3,16,0),(32,3,3,16,1),(33,3,3,17,0),(34,3,3,17,1),(35,3,3,18,0),(36,3,3,18,1),(37,3,3,19,0),(38,3,3,19,1);
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
  CONSTRAINT `fk_?23BD712B?7922?4593?BB1D?63D9BB7EE508?` FOREIGN KEY (`SOCKET_ID`) REFERENCES `socket` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?4A324159?B8D3?45F2?8F72?05686A4C6CA3?` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socket_assignment`
--

LOCK TABLES `socket_assignment` WRITE;
/*!40000 ALTER TABLE `socket_assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `socket_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `socket_current_view_by_hour`
--

DROP TABLE IF EXISTS `socket_current_view_by_hour`;
/*!50001 DROP VIEW IF EXISTS `socket_current_view_by_hour`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `socket_current_view_by_hour` (
  `ID` tinyint NOT NULL,
  `TIMESTAMP_HOUR` tinyint NOT NULL,
  `HOUR` tinyint NOT NULL,
  `SOCKET_ID` tinyint NOT NULL,
  `CURRENT_HOUR_KWH` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `socket_operation_mode`
--

DROP TABLE IF EXISTS `socket_operation_mode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socket_operation_mode` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socket_operation_mode`
--

LOCK TABLES `socket_operation_mode` WRITE;
/*!40000 ALTER TABLE `socket_operation_mode` DISABLE KEYS */;
INSERT INTO `socket_operation_mode` VALUES (1,'On'),(2,'Off'),(3,'Default');
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
  `NAME` tinytext,
  `SYSTEM_ACTIVE` tinyint(1) NOT NULL,
  `OUTLET_OPERATION_MODE_ID` int(11) NOT NULL,
  `SPIKE_PROTECTION` tinyint(1) NOT NULL,
  `ENCRYPTION_KEY` varchar(16) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_?E5461ABC?5077?4C52?853B?F22D3C58FE98?` (`OUTLET_OPERATION_MODE_ID`),
  CONSTRAINT `fk_?E5461ABC?5077?4C52?853B?F22D3C58FE98?` FOREIGN KEY (`OUTLET_OPERATION_MODE_ID`) REFERENCES `outlet_operation_mode` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system`
--

LOCK TABLES `system` WRITE;
/*!40000 ALTER TABLE `system` DISABLE KEYS */;
INSERT INTO `system` VALUES (1,'David\'s System',1,1,1,'1234123412341234'),(2,'Charles\' System',1,1,1,'1234123412341234'),(3,'Michael\'s System',1,1,1,'1234123412341234'),(4,'Nicolas\'s System',1,1,1,'b89b66eb2bf74b9c');
/*!40000 ALTER TABLE `system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_tip`
--

DROP TABLE IF EXISTS `system_tip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_tip` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TIP_ID` int(11) NOT NULL,
  `SYSTEM_ID` int(11) NOT NULL,
  `TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `SYSTEM_ID_idx` (`SYSTEM_ID`),
  KEY `TIP_ID_idx` (`TIP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_tip`
--

LOCK TABLES `system_tip` WRITE;
/*!40000 ALTER TABLE `system_tip` DISABLE KEYS */;
INSERT INTO `system_tip` VALUES (1,21,4,'2013-11-30 21:41:21'),(2,10,4,'2013-12-03 01:45:11'),(3,24,4,'2013-12-03 14:31:11'),(4,13,4,'2013-12-03 20:30:00'),(5,20,4,'2013-11-15 10:32:11');
/*!40000 ALTER TABLE `system_tip` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tip`
--

LOCK TABLES `tip` WRITE;
/*!40000 ALTER TABLE `tip` DISABLE KEYS */;
INSERT INTO `tip` VALUES (1,'Turn on and off your Christmas lights with the help of our scheduling feature and save energy at the same time.'),(2,'Use our convenient web interface to participate to the Earth hour by turning off all electricity in your home!'),(3,'Try to use your Home Appliances during off peak periods to reduce your electric bill.'),(4,'Try to use your Clothe Dryer during off peak periods to reduce your electric bill.'),(5,'Try to use your Air Conditioner during off peak periods to reduce your electric bill.'),(6,'Try to use your Portable Heater during off peak periods to reduce your electric bill.'),(7,'Try to use your Dishwasher during off peak periods to reduce your electric bill.'),(8,'Try to use your Clothe Washer during off peak periods to reduce your electric bill.'),(9,'You can shedule your pool filter to run only for some period of time in off-peak hour to save energy being consumed.'),(10,'Use the sheduling tool for devices with high consumption'),(11,'The Child Safety mode will disable each socket unless it sees a plugged device'),(12,'You can view the consumption of each device independantly by navigating to the outlet it is currently plugged'),(13,'The Dashboard is the perfect page to get an overview of your system'),(14,'You can see the total consumption of your system by day or month in the usage page'),(15,'Cerberus encrypts all your data for your security. Keep your key secret.'),(16,'You can go in System Settings to configure your outlet default operation mode.'),(17,'To add a new RFID tag, simply plug it in an outlet and it will appear in your system as UNSET'),(18,'You can restrict the use of outlets only to devices that your system recongnizes'),(19,'Each outlet will give you the status of its connectivity'),(20,'Look at the event logs to make sure that your system is oerating without errors'),(21,'When at work, heat less to conserve energy while you\'re not there'),(22,'Do you have a block heater for your car? You can schedule that too!'),(23,'After midnight? Schedule all the lights off.'),(24,'Have difficulty waking up? You can schedule the lights to turn on in the morning.'),(25,'You can use the CLI interface to reconfigure directly an outlet.');
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
-- Temporary table structure for view `user_system_view`
--

DROP TABLE IF EXISTS `user_system_view`;
/*!50001 DROP VIEW IF EXISTS `user_system_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `user_system_view` (
  `USERS_ID` tinyint NOT NULL,
  `SYSTEM_ID` tinyint NOT NULL,
  `USER_TYPE_ID` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

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
  CONSTRAINT `fk_?15088E1B?AC75?4136?BE48?8B120B01B952?` FOREIGN KEY (`USER_SETTING_ID`) REFERENCES `user_setting` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?46C82E7A?345E?48BB?9ED4?648E3F3405AD?` FOREIGN KEY (`USER_TYPE_ID`) REFERENCES `user_type` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?4D9BD4AC?9A1F?4DB6?9E8A?9CB2C2ACBDF7?` FOREIGN KEY (`PERSONAL_INFORMATION_ID`) REFERENCES `personal_information` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_?F5F29746?0833?41D8?AB8D?D2F76D6888A2?` FOREIGN KEY (`LOGIN_ID`) REFERENCES `login` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,1,1,1,'2013-03-27',1,'2013-03-27',1),(2,1,2,2,2,'2013-03-27',1,'2013-03-27',1),(3,1,2,3,3,'2013-03-27',1,'2013-03-27',1),(4,1,2,4,4,'2013-03-27',1,'2013-03-27',1),(5,1,3,5,5,'2013-03-27',1,'2013-03-27',1),(6,1,3,6,6,'2013-03-27',1,'2013-03-27',1),(7,NULL,2,7,7,'2013-12-02',NULL,'2013-12-02',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `current_day_view`
--

/*!50001 DROP TABLE IF EXISTS `current_day_view`*/;
/*!50001 DROP VIEW IF EXISTS `current_day_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `current_day_view` AS select `current_hour_view`.`ID` AS `ID`,date_format(`current_hour_view`.`TIMESTAMP_HOUR`,'%Y-%m-%d') AS `TIMESTAMP_DAY`,date_format(`current_hour_view`.`TIMESTAMP_HOUR`,'%d') AS `DAY`,`current_hour_view`.`SYSTEM_ID` AS `SYSTEM_ID`,sum(`current_hour_view`.`CURRENT_HOUR_KWH`) AS `CURRENT_DAY_KWH` from `current_hour_view` group by date_format(`current_hour_view`.`TIMESTAMP_HOUR`,'%Y-%m-%d'),`current_hour_view`.`SYSTEM_ID` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `current_hour_view`
--

/*!50001 DROP TABLE IF EXISTS `current_hour_view`*/;
/*!50001 DROP VIEW IF EXISTS `current_hour_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `current_hour_view` AS select `current_view_by_hour`.`ID` AS `ID`,`current_view_by_hour`.`TIMESTAMP_HOUR` AS `TIMESTAMP_HOUR`,`current_view_by_hour`.`HOUR` AS `HOUR`,`current_view_by_hour`.`SYSTEM_ID` AS `SYSTEM_ID`,`current_view_by_hour`.`CURRENT_HOUR_KWH` AS `CURRENT_HOUR_KWH` from `current_view_by_hour` union select `current_hour`.`ID` AS `ID`,date_format(`current_hour`.`TIMESTAMP`,'%Y-%m-%d %H:00:00') AS `TIMESTAMP_HOUR`,date_format(`current_hour`.`TIMESTAMP`,'%H') AS `HOUR`,`current_hour`.`SYSTEM_ID` AS `SYSTEM_ID`,`current_hour`.`CURRENT_HOUR` AS `CURRENT_HOUR_KWH` from `current_hour` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `current_system_view`
--

/*!50001 DROP TABLE IF EXISTS `current_system_view`*/;
/*!50001 DROP VIEW IF EXISTS `current_system_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `current_system_view` AS select `current`.`ID` AS `CURRENT_ID`,`room`.`SYSTEM_ID` AS `SYSTEM_ID` from (((`current` join `socket` on((`socket`.`ID` = `current`.`SOCKET_ID`))) join `outlet` on((`outlet`.`ID` = `socket`.`OUTLET_ID`))) join `room` on((`room`.`ID` = `outlet`.`ROOM_ID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `current_view_by_hour`
--

/*!50001 DROP TABLE IF EXISTS `current_view_by_hour`*/;
/*!50001 DROP VIEW IF EXISTS `current_view_by_hour`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `current_view_by_hour` AS select `current`.`ID` AS `ID`,date_format(`current`.`TIMESTAMP`,'%Y-%m-%d %H:00:00') AS `TIMESTAMP_HOUR`,date_format(`current`.`TIMESTAMP`,'%H') AS `HOUR`,(select `outlet_system_view`.`SYSTEM_ID` from `outlet_system_view` where (`current`.`SOCKET_ID` = `outlet_system_view`.`SOCKET_ID`)) AS `SYSTEM_ID`,((sum(`current`.`CURRENT`) * 30) / 1000) AS `CURRENT_HOUR_KWH` from `current` group by date_format(`current`.`TIMESTAMP`,'%Y-%m-%d %H'),(select `user_system_view`.`SYSTEM_ID` from `user_system_view` where (`current`.`USERS_ID` = `user_system_view`.`USERS_ID`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `outlet_system_view`
--

/*!50001 DROP TABLE IF EXISTS `outlet_system_view`*/;
/*!50001 DROP VIEW IF EXISTS `outlet_system_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `outlet_system_view` AS select `outlet`.`ID` AS `OUTLET_ID`,`room`.`SYSTEM_ID` AS `SYSTEM_ID`,`socket`.`ID` AS `SOCKET_ID` from ((`outlet` join `room` on((`room`.`ID` = `outlet`.`ROOM_ID`))) join `socket` on((`socket`.`OUTLET_ID` = `outlet`.`ID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rfid_tag_view`
--

/*!50001 DROP TABLE IF EXISTS `rfid_tag_view`*/;
/*!50001 DROP VIEW IF EXISTS `rfid_tag_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rfid_tag_view` AS (select `rfid_tag`.`ID` AS `RFID_ID`,`rfid_tag`.`NUMBER` AS `RFID_NUMBER`,`rfid_tag`.`TAG_NAME` AS `RFID_NAME`,`consumption_profile`.`PROFILE_NAME` AS `PROFILE_NAME`,`rfid_authentication`.`USERS_ID` AS `USER_ID`,`rfid_authentication`.`PERMISSION` AS `RFID_PERMISSION` from ((`rfid_tag` join `rfid_authentication` on((`rfid_authentication`.`RFID_TAG_ID` = `rfid_tag`.`ID`))) left join `consumption_profile` on((`consumption_profile`.`ID` = `rfid_tag`.`PROFILE_ID`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `socket_current_view_by_hour`
--

/*!50001 DROP TABLE IF EXISTS `socket_current_view_by_hour`*/;
/*!50001 DROP VIEW IF EXISTS `socket_current_view_by_hour`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `socket_current_view_by_hour` AS select `current`.`ID` AS `ID`,date_format(`current`.`TIMESTAMP`,'%Y-%m-%d %H:00:00') AS `TIMESTAMP_HOUR`,date_format(`current`.`TIMESTAMP`,'%H') AS `HOUR`,`current`.`SOCKET_ID` AS `SOCKET_ID`,((sum(`current`.`CURRENT`) * 30) / 1000) AS `CURRENT_HOUR_KWH` from `current` group by date_format(`current`.`TIMESTAMP`,'%Y-%m-%d %H'),`current`.`SOCKET_ID` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `user_system_view`
--

/*!50001 DROP TABLE IF EXISTS `user_system_view`*/;
/*!50001 DROP VIEW IF EXISTS `user_system_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_system_view` AS (select `users`.`ID` AS `USERS_ID`,`login`.`SYSTEM_ID` AS `SYSTEM_ID`,`users`.`USER_TYPE_ID` AS `USER_TYPE_ID` from (`users` join `login` on((`users`.`LOGIN_ID` = `login`.`ID`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-02 14:05:28
