-- MySQL dump 10.13  Distrib 5.5.25a, for Win64 (x86)
--
-- Host: localhost    Database: foodiesv3
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
  `ID` bigint(20) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'no 393, sri byrsveshwara nilaya','badaveshwara msrga ward- 16','Mandya',1486148355090,1001375200252,'mbmahesha47@gmail.com','CNF','Mahesh',0,'near basavanagudi','M B',1486148355090,1487400036707,'8951626085','571401','Karnataka','cauvery nagar');
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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menus`
--

LOCK TABLES `menus` WRITE;
/*!40000 ALTER TABLE `menus` DISABLE KEYS */;
INSERT INTO `menus` VALUES (47,1,20170312,1489299370637,'breakfast-title-1','breakfast-subtitle-1','breakfast-desc-1',100,'N/A',1489233279672,1489233279677,0),(48,2,20170312,1489299370637,'Lunch-title-1','Lunch-subtitle-1','Lunch-desc-1',22221,'N/A',1489233298262,1489233298266,0),(50,3,20170312,1489299370637,'Dinner-title','Dinner-subtitle','Dinner-desc',12345,'N/A',1489101547286,1489101547286,0),(51,1,20170313,1489385760000,'breakfast-title-2','breakfast-subtitle-2','breakfast-desc-2',1000,'N/A',1489233268892,1489233268901,0),(52,2,20170313,1489385760000,'Lunch-title-2','Lunch-subtitle-2','Lunch-desc-2',2000,'N/A',1489231751331,1489231751363,0),(53,3,20170313,1489385760000,'Dinner-title-2','Dinner-subtitle-2','Dinner-desc-2',3000,'N/A',1489231760245,1489231760245,0),(54,1,20170315,1489516200000,'bf-title-15','bf-subtitle-15','bf-desc-15',1500,'N/A',1489697193904,1489697193904,0),(55,2,20170315,1489516200000,'lc-title-15','lc-subtitle-15','lc-desc-15',150,'N/A',1489697231093,1489697231093,0),(56,3,20170315,1489516200000,'dn-title-15','dn-subtitle-15','dn-desc-15',15,'N/A',1489697465311,1489697465311,0);
/*!40000 ALTER TABLE `menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderitem` (
  `ID` bigint(20) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
INSERT INTO `orderitem` VALUES (1,1486148371877,47,0,1489216373825,112767613459,'25','1','249731902','CNFD','25'),(2,1486148388685,50,0,1489231018581,112767613330,'35','2','130657456','CNFD','70'),(3,1486148400361,47,0,1489215082934,112767566303,'50','3','-364736361','DLRD','150'),(4,1486148895160,50,0,1489215193237,112767561560,'20','3','-446292769','DLRD','60'),(5,1486148895160,47,0,1489215193240,112767561560,'90','3','-446095733','DLRD','270'),(6,1486148895161,48,0,1489215193240,112767561560,'100','3','-401080788','DLRD','300'),(7,1487015049008,47,0,1489216255991,112766075766,'25','1','1792159616','RCVD','25'),(8,1487015049008,48,0,1489216255993,112766075766,'35','2','1792219379','RCVD','70'),(9,1487015049008,50,0,1489216255993,112766075766,'50','3','1792351005','RCVD','150'),(16,1487016409740,48,0,1489215870883,112767566339,'35','1','-287262582','RCVD','35'),(17,1487016409740,50,0,1489215870887,112767566339,'20','2','-287237539','RCVD','40'),(18,1487016409740,47,0,1489215870887,112767566339,'20','3','-287088491','RCVD','60'),(19,1487417062147,48,0,1489215803370,112767566458,'20','5','-221471535','RCVD','100');
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `ID` bigint(20) NOT NULL,
  `CREATED_ON` bigint(20) NOT NULL DEFAULT '0',
  `CUSTOMER_ITEM_ID` bigint(20) NOT NULL,
  `DELIVERY_ON` bigint(20) NOT NULL,
  `IS_DELETED` int(11) NOT NULL DEFAULT '0',
  `MODIFIED_ON` bigint(20) NOT NULL DEFAULT '0',
  `ORDER_ITEM_ID` bigint(20) NOT NULL,
  `ORDER_STATUS` varchar(20) NOT NULL,
  `TOTAL_VALUE` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1486148371875,1001375200252,0,0,1489216373765,112767613459,'CNFD','31'),(2,1486148388664,1001375200252,0,0,1489231018479,112767613330,'CNFD','76'),(3,1486148400328,1001375200252,0,0,1489215082889,112767566303,'CNFD','156'),(4,1486148895120,1001375200252,0,0,1489215193197,112767561560,'INIT','636'),(5,1487015048935,1001375200252,0,0,1489216255945,112766075766,'INIT','2261'),(6,1487016409550,1001375200252,0,0,1489215870833,112767566339,'DLRD','141'),(7,1487417061941,1001375200252,0,0,1489215803292,112767566458,'DLRD','106');
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
  `ROLE_ID` bigint(20) NOT NULL,
  `PRIVILEGE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`PRIVILEGE_ID`),
  KEY `FK_m4sky3qieevica6xjahjnitap` (`PRIVILEGE_ID`),
  CONSTRAINT `FK_4jed2h7jlcbho9rhs8m47exj3` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`),
  CONSTRAINT `FK_m4sky3qieevica6xjahjnitap` FOREIGN KEY (`PRIVILEGE_ID`) REFERENCES `privilege` (`PRIVILEGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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

-- Dump completed on 2017-03-17 10:50:08
