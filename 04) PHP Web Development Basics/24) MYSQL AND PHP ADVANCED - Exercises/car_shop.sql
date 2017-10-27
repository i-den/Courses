-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: Car_Shop
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB

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
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cars` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `make` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (5,'Audi','A4',2004),(7,'BMW','116',2010),(8,'Ford','Focus',2004),(9,'Ford','Focus',2004),(10,'Audi','A4',2004),(11,'BMW','116',2010),(12,'BMW','116',2010),(30,'Audi','A4',2004),(31,'Audi','A4',2004),(32,'Audi','A4',2004),(33,'Audi','A4',2004),(34,'Audi','A4',2004),(35,'Audi','A4',2004),(36,'Audi','A4',2004),(37,'Audi','A4',2004),(38,'Audi','A4',2004),(39,'Audi','A4',2004),(40,'Audi','A4',2004),(41,'Audi','A4',2004),(42,'Audi','A4',2004),(43,'Audi','A4',2004),(44,'Audi','A4',2004),(47,'Audi','A4',2004),(48,'Audi','A4',2004),(49,'Audi','A4',2004),(50,'Audi','A4',2004),(51,'Audi','A4',2004),(52,'Audi','A4',2004),(53,'Audi','A4',2004),(54,'Audi','A4',2004),(55,'Audi','A4',2004),(56,'Audi','A4',2004),(57,'Audi','A4',2004),(58,'Audi','A4',2004),(59,'Audi','A4',2004),(60,'Audi','A4',2004),(61,'Audi','A4',2004),(62,'Audi','A4',2004);
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `family_name` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (4,'Ivan','Ivanov'),(6,'Ilia','Petrov'),(7,'Stoyan','Lazarov'),(8,'Stoyan','Petrov');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales` (
  `sale_id` int(11) NOT NULL AUTO_INCREMENT,
  `car_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `date_sold` datetime DEFAULT CURRENT_TIMESTAMP,
  `amount` varchar(255) NOT NULL,
  PRIMARY KEY (`sale_id`),
  KEY `sales_cars_car_id_fk` (`car_id`),
  KEY `sales_customers_customer_id_fk` (`customer_id`),
  CONSTRAINT `sales_cars_car_id_fk` FOREIGN KEY (`car_id`) REFERENCES `cars` (`car_id`),
  CONSTRAINT `sales_customers_customer_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (3,5,4,'2017-10-26 22:41:32','BGN 7000'),(5,7,6,'2017-10-26 23:21:18','BGN 24000'),(6,8,7,'2017-10-26 23:22:45','BGN 3800'),(7,9,8,'2017-10-26 23:23:47','BGN 3800'),(8,10,4,'2017-10-27 12:36:17','BGN 7000'),(9,10,4,'2017-10-27 13:02:23','3500'),(10,11,6,'2017-10-27 15:01:24','BGN 24000'),(11,12,6,'2017-10-27 15:16:29','BGN 24000'),(19,10,4,'2017-10-27 16:13:17','500'),(20,10,4,'2017-10-27 16:13:28','500'),(31,30,4,'2017-10-27 16:24:02','BGN 7000'),(32,31,4,'2017-10-27 16:24:03','BGN 7000'),(33,32,4,'2017-10-27 16:24:04','BGN 7000'),(34,33,4,'2017-10-27 16:24:05','BGN 7000'),(35,34,4,'2017-10-27 16:24:06','BGN 7000'),(36,35,4,'2017-10-27 16:24:27','BGN 7000'),(37,36,4,'2017-10-27 16:24:28','BGN 7000'),(38,37,4,'2017-10-27 16:24:29','BGN 7000'),(39,38,4,'2017-10-27 16:24:44','BGN 7000'),(40,39,4,'2017-10-27 16:24:45','BGN 7000'),(41,40,4,'2017-10-27 16:24:46','BGN 7000'),(42,41,4,'2017-10-27 16:24:47','BGN 7000'),(43,42,4,'2017-10-27 16:25:03','BGN 7000'),(44,43,4,'2017-10-27 16:25:04','BGN 7000'),(45,44,4,'2017-10-27 16:25:05','BGN 7000'),(48,47,4,'2017-10-27 16:27:00','BGN 7000'),(49,48,4,'2017-10-27 16:27:00','BGN 7000'),(50,49,4,'2017-10-27 16:27:01','BGN 7000'),(51,50,4,'2017-10-27 16:28:36','BGN 7000'),(52,51,4,'2017-10-27 16:28:37','BGN 7000'),(53,52,4,'2017-10-27 16:28:38','BGN 7000'),(54,53,4,'2017-10-27 16:40:57','BGN 7000'),(55,54,4,'2017-10-27 16:41:14','BGN 7000'),(56,55,4,'2017-10-27 16:41:15','BGN 7000'),(57,56,4,'2017-10-27 16:41:18','BGN 7000'),(58,57,4,'2017-10-27 16:41:19','BGN 7000'),(59,58,4,'2017-10-27 16:41:20','BGN 7000'),(60,59,4,'2017-10-27 16:42:35','BGN 7000'),(61,60,4,'2017-10-27 16:42:36','BGN 7000'),(62,61,4,'2017-10-27 16:42:38','BGN 7000'),(63,62,4,'2017-10-27 16:42:44','BGN 7000');
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER TOTAL_SALES_BEFORE_INSERT
BEFORE INSERT ON sales
FOR EACH ROW
  BEGIN
    SET @sum = @sum + NEW.`amount`;
  END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary table structure for view `sales_view`
--

DROP TABLE IF EXISTS `sales_view`;
/*!50001 DROP VIEW IF EXISTS `sales_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `sales_view` (
  `make` tinyint NOT NULL,
  `model` tinyint NOT NULL,
  `date_sold` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `amount` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'Car_Shop'
--
/*!50003 DROP PROCEDURE IF EXISTS `FIND_CUSTOMER_BY_NAMES` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `FIND_CUSTOMER_BY_NAMES`(IN FIRST_NAME VARCHAR(255), IN FAMILY_NAME VARCHAR(255))
BEGIN
    SELECT `customer_id`
    FROM `customers` AS `c`
    WHERE `c`.`first_name` = FIRST_NAME AND `c`.`family_name` = FAMILY_NAME;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GET_DATE_LAST_SALE` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_DATE_LAST_SALE`(IN SALE_ID INT)
BEGIN
    SELECT `date_sold`  FROM `sales` AS `d` WHERE `d`.`sale_id` = SALE_ID;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GET_SALES` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_SALES`()
BEGIN
    SELECT *
    FROM sales_view;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GET_SALES_AMOUNT` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_SALES_AMOUNT`()
BEGIN
    SELECT SUM(SUBSTRING_INDEX(`amount`, ' ', -1)) AS `sales_amount`
    FROM sales
      JOIN cars USING (car_id);
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GET_SALES_BETWEEN_TWO_DATES` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_SALES_BETWEEN_TWO_DATES`(
  IN START_DATE VARCHAR(255),
  IN END_DATE   VARCHAR(255)
)
BEGIN
    SELECT *
    FROM sales_view
    WHERE `date_sold` >= START_DATE
          AND `date_sold` <= END_DATE;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `sales_view`
--

/*!50001 DROP TABLE IF EXISTS `sales_view`*/;
/*!50001 DROP VIEW IF EXISTS `sales_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `sales_view` AS select `cars`.`make` AS `make`,`cars`.`model` AS `model`,`sales`.`date_sold` AS `date_sold`,concat(`customers`.`first_name`,' ',`customers`.`family_name`) AS `name`,`sales`.`amount` AS `amount` from ((`sales` join `customers` on((`sales`.`customer_id` = `customers`.`customer_id`))) join `cars` on((`sales`.`car_id` = `cars`.`car_id`))) */;
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

-- Dump completed on 2017-10-27 17:23:57
