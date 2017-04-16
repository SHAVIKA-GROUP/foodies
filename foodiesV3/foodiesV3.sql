-- MySQL dump 10.13  Distrib 5.5.25a, for Win64 (x86)
--
-- Host: localhost    Database: foodiesV3
-- ------------------------------------------------------
-- Server version	5.5.25a

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADDRESS_1` varchar(70) DEFAULT NULL,
  `ADDRESS_2` varchar(70) DEFAULT NULL,
  `CITY` varchar(30) DEFAULT NULL,
  `CREATED_ON` bigint(20) NOT NULL DEFAULT '0',
  `CUSTOMER_ITEM_ID` bigint(20) NOT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `ERROR_STATUS` varchar(30) DEFAULT NULL,
  `FIRST_NAME` varchar(50) NOT NULL,
  `IS_DELETED` int(11) NOT NULL DEFAULT '0',
  `LAND_MARK` varchar(40) DEFAULT NULL,
  `last_NAME` varchar(30) DEFAULT NULL,
  `LAST_UPDATE` bigint(20) DEFAULT NULL,
  `MODIFIED_ON` bigint(20) NOT NULL DEFAULT '0',
  `PHONE` varchar(15) DEFAULT NULL,
  `PINCODE` varchar(10) DEFAULT NULL,
  `STATE` varchar(30) DEFAULT NULL,
  `STREET` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'#25, 2nd floor 13 B Cross','mts layout','Bangalore',1491937205383,10021668382447,'mbmahesha47@gmail.com','CNF','Mahesha',0,'hoysala circle','M B',1491937205383,1491937248025,'8951626085','560060','Karnataka','Kengeri upanagar');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menus`
--

DROP TABLE IF EXISTS `menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menus` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MENU_TYPE_ID` int(11) NOT NULL,
  `UNIQUE_ID` bigint(20) NOT NULL,
  `DATE` bigint(20) NOT NULL,
  `TITLE` varchar(100) NOT NULL,
  `SUBTITLE` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(500) NOT NULL,
  `PRICE` int(11) NOT NULL,
  `IMAGE` varchar(200) DEFAULT NULL,
  `CREATED_ON` bigint(20) NOT NULL DEFAULT '0',
  `MODIFIED_ON` bigint(20) NOT NULL DEFAULT '0',
  `IS_DELETED` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menus`
--

LOCK TABLES `menus` WRITE;
/*!40000 ALTER TABLE `menus` DISABLE KEYS */;
INSERT INTO `menus` VALUES (69,1,20170412,1491937281602,'Traditional Wednesday with Foodbox','Breakfast combination','A super combination of GHEE Khara bath and banana salad',50,'20170412_bfst.jpg',1491937396755,1491937396755,0),(70,2,20170412,1491937281602,'Lunch Box','2 phulkas with special Pinapple gravy','+Foodbox famous puliyogare +cure rice',70,'20170412_luch.jpg',1491937435305,1491937435305,0),(71,3,20170412,1491937281602,'Tonight dinner','2 phulkas with tomato-onion curry','+Veg Biriyani with raita',60,'20170412_dinr.jpg',1491937491145,1491937491145,0),(72,1,20170413,1492021800000,'Tremendous Thusday with foodbox','Breakfast combination','3 Idlies +vada with bidadi style chutney',40,'20170413_bfst.jpg',1491937586272,1491937586272,0);
/*!40000 ALTER TABLE `menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderitem` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_ON` bigint(20) NOT NULL DEFAULT '0',
  `FOOD_ID` bigint(20) NOT NULL,
  `IS_DELETED` int(11) NOT NULL DEFAULT '0',
  `MODIFIED_ON` bigint(20) NOT NULL DEFAULT '0',
  `ORDER_ITEM_ID` bigint(20) NOT NULL,
  `PRICE` varchar(20) NOT NULL,
  `QUANTITY` varchar(20) NOT NULL,
  `SRC_ELEMENT_ID` varchar(20) NOT NULL,
  `STATUS` varchar(20) NOT NULL,
  `VALUE` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
INSERT INTO `orderitem` VALUES (1,1491937724056,69,0,1491940714786,114112795250,'50','1','1774179432','DLRD','50'),(2,1491937724056,70,0,1491940714798,114112795250,'70','1','1774268867','DLRD','70'),(3,1491938789105,72,0,1491940714798,114112795250,'40','3','1774286072','DLRD','120'),(4,1491938889051,71,0,1491940714798,114112795250,'60','2','1774315832','DLRD','120'),(5,1491938926770,71,0,1491940714704,114112842215,'60','1','-2067654983','DLRD','60'),(6,1491940483329,70,0,1491940537460,114112842184,'70','1','-2107366355','CNFD','70'),(7,1491940653845,72,0,1491940665069,114112794351,'40','5','958817990','INIT','200');
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_ON` bigint(20) NOT NULL DEFAULT '0',
  `CUSTOMER_ITEM_ID` bigint(20) NOT NULL,
  `DELIVERY_ON` bigint(20) NOT NULL,
  `IS_DELETED` int(11) NOT NULL DEFAULT '0',
  `MODIFIED_ON` bigint(20) NOT NULL DEFAULT '0',
  `ORDER_ITEM_ID` bigint(20) NOT NULL,
  `ORDER_STATUS` varchar(20) NOT NULL,
  `TOTAL_VALUE` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1491937724055,10021668382447,90,0,1491940714746,114112795250,'DLRD','120'),(4,1491938926723,10021668382447,30,0,1491940714622,114112842215,'DLRD','60'),(5,1491940483268,10021668382447,180,0,1491940537391,114112842184,'CNFD','70'),(6,1491940653771,10021668382447,300,0,1491940664948,114112794351,'INIT','200');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `PRIVILEGE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_ON` datetime DEFAULT NULL,
  `IS_DELETED` tinyint(1) NOT NULL DEFAULT '0',
  `MODIFIED_ON` datetime DEFAULT NULL,
  `NAME` varchar(80) NOT NULL,
  PRIMARY KEY (`PRIVILEGE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES (1,'2016-01-26 23:16:43',0,'2016-01-26 23:16:43','Dashboard'),(2,'2016-01-26 23:16:43',0,'2016-01-26 23:16:43','EmployeeList'),(3,'2016-01-26 23:16:43',0,'2016-01-26 23:16:43','Managment');
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `props`
--

DROP TABLE IF EXISTS `props`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `props` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PROPS_KEY` varchar(30) NOT NULL,
  `PROPS_VALUE` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `props`
--

LOCK TABLES `props` WRITE;
/*!40000 ALTER TABLE `props` DISABLE KEYS */;
INSERT INTO `props` VALUES (1,'MENU_BLOCK','1');
/*!40000 ALTER TABLE `props` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_ON` datetime DEFAULT NULL,
  `IS_DELETED` tinyint(1) NOT NULL DEFAULT '0',
  `MODIFIED_ON` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(80) DEFAULT NULL,
  `IS_SYSTEM_ROLE` tinyint(1) NOT NULL DEFAULT '1',
  `ROLE` varchar(50) NOT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'2016-01-26 23:16:43',0,'2016-01-26 23:16:43','He can assess any thing.',1,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_privilege`
--

DROP TABLE IF EXISTS `role_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_privilege` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PRIVILEGE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`PRIVILEGE_ID`),
  KEY `FK_m4sky3qieevica6xjahjnitap` (`PRIVILEGE_ID`),
  CONSTRAINT `FK_4jed2h7jlcbho9rhs8m47exj3` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`),
  CONSTRAINT `FK_m4sky3qieevica6xjahjnitap` FOREIGN KEY (`PRIVILEGE_ID`) REFERENCES `privilege` (`PRIVILEGE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_privilege`
--

LOCK TABLES `role_privilege` WRITE;
/*!40000 ALTER TABLE `role_privilege` DISABLE KEYS */;
INSERT INTO `role_privilege` VALUES (1,1),(1,2),(1,3);
/*!40000 ALTER TABLE `role_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_login`
--

DROP TABLE IF EXISTS `user_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_login` (
  `USER_LOGIN_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_ON` datetime DEFAULT NULL,
  `IS_DELETED` tinyint(1) NOT NULL DEFAULT '0',
  `MODIFIED_ON` datetime DEFAULT NULL,
  `EMAIL` varchar(80) NOT NULL,
  `LOGIN_ATTEMPTS` int(11) NOT NULL,
  `PASSWORD` varchar(80) NOT NULL,
  `STATUS` tinyint(1) NOT NULL DEFAULT '1',
  `USER_INDENTIFICATION_NO` varchar(60) DEFAULT NULL,
  `USERNAME` varchar(55) NOT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  `roles` tinyblob,
  PRIMARY KEY (`USER_LOGIN_ID`),
  KEY `FK_gpx1dx7c93117pfg2bufkfwvu` (`ROLE_ID`),
  CONSTRAINT `FK_gpx1dx7c93117pfg2bufkfwvu` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_login`
--

LOCK TABLES `user_login` WRITE;
/*!40000 ALTER TABLE `user_login` DISABLE KEYS */;
INSERT INTO `user_login` VALUES (1,'2016-01-26 23:16:43',0,'2017-03-04 00:19:54','mbmahesha47@gmail.com',0,'admin',1,NULL,'maheshamb',1,'1');
/*!40000 ALTER TABLE `user_login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-16 10:49:50
