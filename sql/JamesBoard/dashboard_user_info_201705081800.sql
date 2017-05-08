CREATE TABLE `dashboard_user_info` (
  `user_city_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;