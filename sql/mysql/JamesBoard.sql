-- MySQL dump 10.13  Distrib 5.7.9, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: cboard
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Table structure for table `dashboard_board`
--
use cboard;
DROP TABLE IF EXISTS `dashboard_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dashboard_board` (
  `board_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `board_name` varchar(100) NOT NULL,
  `layout_json` text,
  PRIMARY KEY (`board_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboard_board`
--

LOCK TABLES `dashboard_board` WRITE;
/*!40000 ALTER TABLE `dashboard_board` DISABLE KEYS */;
INSERT INTO `dashboard_board` VALUES (1,'1',1,'student','{\"rows\":[{\"type\":\"widget\",\"widgets\":[{\"name\":\"student\",\"widgetId\":2,\"width\":12}]}]}');
/*!40000 ALTER TABLE `dashboard_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dashboard_category`
--

DROP TABLE IF EXISTS `dashboard_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dashboard_category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboard_category`
--

LOCK TABLES `dashboard_category` WRITE;
/*!40000 ALTER TABLE `dashboard_category` DISABLE KEYS */;
INSERT INTO `dashboard_category` VALUES (2,'bi','1');
/*!40000 ALTER TABLE `dashboard_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dashboard_city`
--

DROP TABLE IF EXISTS `dashboard_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dashboard_city` (
  `city_id` int(11) NOT NULL,
  `city_name` varchar(100) NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboard_city`
--

LOCK TABLES `dashboard_city` WRITE;
/*!40000 ALTER TABLE `dashboard_city` DISABLE KEYS */;
/*!40000 ALTER TABLE `dashboard_city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dashboard_dataset`
--

DROP TABLE IF EXISTS `dashboard_dataset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dashboard_dataset` (
  `dataset_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) NOT NULL,
  `category_name` varchar(100) DEFAULT NULL,
  `dataset_name` varchar(100) DEFAULT NULL,
  `data_json` text,
  PRIMARY KEY (`dataset_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboard_dataset`
--

LOCK TABLES `dashboard_dataset` WRITE;
/*!40000 ALTER TABLE `dashboard_dataset` DISABLE KEYS */;
INSERT INTO `dashboard_dataset` VALUES (2,'1','Default Category','student','{\"datasource\":1,\"expressions\":[],\"query\":{\"sql\":\"select * from student;\"}}');
/*!40000 ALTER TABLE `dashboard_dataset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dashboard_datasource`
--

DROP TABLE IF EXISTS `dashboard_datasource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dashboard_datasource` (
  `datasource_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) NOT NULL,
  `source_name` varchar(100) NOT NULL,
  `source_type` varchar(100) NOT NULL,
  `config` text,
  PRIMARY KEY (`datasource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboard_datasource`
--

LOCK TABLES `dashboard_datasource` WRITE;
/*!40000 ALTER TABLE `dashboard_datasource` DISABLE KEYS */;
INSERT INTO `dashboard_datasource` VALUES (1,'1','bi','jdbc','{\"driver\":\"com.mysql.jdbc.Driver\",\"jdbcurl\":\"jdbc:mysql://localhost:3306/bi\",\"password\":\"123456\",\"username\":\"pig\"}');
/*!40000 ALTER TABLE `dashboard_datasource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dashboard_role`
--

DROP TABLE IF EXISTS `dashboard_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dashboard_role` (
  `role_id` varchar(100) NOT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboard_role`
--

LOCK TABLES `dashboard_role` WRITE;
/*!40000 ALTER TABLE `dashboard_role` DISABLE KEYS */;
INSERT INTO `dashboard_role` VALUES ('9ed2deb2-cac7-4e78-80bb-051e1bf2c08f','admin','1');
/*!40000 ALTER TABLE `dashboard_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dashboard_role_res`
--

DROP TABLE IF EXISTS `dashboard_role_res`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dashboard_role_res` (
  `role_res_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(100) DEFAULT NULL,
  `res_type` varchar(100) DEFAULT NULL,
  `res_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`role_res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboard_role_res`
--

LOCK TABLES `dashboard_role_res` WRITE;
/*!40000 ALTER TABLE `dashboard_role_res` DISABLE KEYS */;
INSERT INTO `dashboard_role_res` VALUES (1,'9ed2deb2-cac7-4e78-80bb-051e1bf2c08f','menu',1),(2,'9ed2deb2-cac7-4e78-80bb-051e1bf2c08f','menu',7),(3,'9ed2deb2-cac7-4e78-80bb-051e1bf2c08f','board',1),(4,'9ed2deb2-cac7-4e78-80bb-051e1bf2c08f','menu',2),(5,'9ed2deb2-cac7-4e78-80bb-051e1bf2c08f','menu',3),(6,'9ed2deb2-cac7-4e78-80bb-051e1bf2c08f','menu',4),(7,'9ed2deb2-cac7-4e78-80bb-051e1bf2c08f','menu',5),(8,'9ed2deb2-cac7-4e78-80bb-051e1bf2c08f','menu',6),(9,'9ed2deb2-cac7-4e78-80bb-051e1bf2c08f','menu',9),(10,'9ed2deb2-cac7-4e78-80bb-051e1bf2c08f','menu',8),(11,'9ed2deb2-cac7-4e78-80bb-051e1bf2c08f','datasource',1),(12,'9ed2deb2-cac7-4e78-80bb-051e1bf2c08f','dataset',2),(13,'9ed2deb2-cac7-4e78-80bb-051e1bf2c08f','widget',2);
/*!40000 ALTER TABLE `dashboard_role_res` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dashboard_user`
--

DROP TABLE IF EXISTS `dashboard_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dashboard_user` (
  `user_id` varchar(50) NOT NULL,
  `login_name` varchar(100) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `user_password` varchar(100) DEFAULT NULL,
  `user_status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboard_user`
--

LOCK TABLES `dashboard_user` WRITE;
/*!40000 ALTER TABLE `dashboard_user` DISABLE KEYS */;
INSERT INTO `dashboard_user` VALUES ('1','admin','Administrator','ff9830c42660c1dd1942844f8069b74a',NULL);
/*!40000 ALTER TABLE `dashboard_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dashboard_user_info`
--

DROP TABLE IF EXISTS `dashboard_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dashboard_user_info` (
  `user_city_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboard_user_info`
--

LOCK TABLES `dashboard_user_info` WRITE;
/*!40000 ALTER TABLE `dashboard_user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `dashboard_user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dashboard_user_role`
--

DROP TABLE IF EXISTS `dashboard_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dashboard_user_role` (
  `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) DEFAULT NULL,
  `role_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboard_user_role`
--

LOCK TABLES `dashboard_user_role` WRITE;
/*!40000 ALTER TABLE `dashboard_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `dashboard_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dashboard_widget`
--

DROP TABLE IF EXISTS `dashboard_widget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dashboard_widget` (
  `widget_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) NOT NULL,
  `category_name` varchar(100) DEFAULT NULL,
  `widget_name` varchar(100) DEFAULT NULL,
  `data_json` text,
  PRIMARY KEY (`widget_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboard_widget`
--

LOCK TABLES `dashboard_widget` WRITE;
/*!40000 ALTER TABLE `dashboard_widget` DISABLE KEYS */;
INSERT INTO `dashboard_widget` VALUES (2,'1','Default Category','student','{\"config\":{\"chart_type\":\"line\",\"filters\":[],\"groups\":[],\"keys\":[{\"col\":\"name\",\"type\":\"eq\",\"values\":[]}],\"selects\":[\"id\",\"city\",\"birthday\",\"age\"],\"valueAxis\":\"vertical\",\"values\":[{\"cols\":[{\"aggregate_type\":\"sum\",\"col\":\"score\"}],\"name\":\"\",\"series_type\":\"stackbar\",\"type\":\"value\"}]},\"datasetId\":2}');
/*!40000 ALTER TABLE `dashboard_widget` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


use bi;
-- Dump completed on 2017-05-08 22:41:47
-- MySQL dump 10.13  Distrib 5.7.9, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: bi
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `age` int(4) NOT NULL,
  `score` int(4) NOT NULL,
  `city` varchar(20) NOT NULL,
  `birthday` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'james',18,88,'shanghai','1988-08-18 00:00:00'),(2,'apache',20,98,'beijing','1970-01-01 00:00:00'),(3,'Cassandra',36,72,'chengdu','1994-03-05 00:00:00'),(4,'Drill',29,19,'chongqing','2002-10-05 00:00:00');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-08 22:41:48
