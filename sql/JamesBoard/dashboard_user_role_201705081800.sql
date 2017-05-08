CREATE TABLE `dashboard_user_role` (
  `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) DEFAULT NULL,
  `role_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
