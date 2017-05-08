CREATE TABLE `dashboard_role_res` (
  `role_res_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(100) DEFAULT NULL,
  `res_type` varchar(100) DEFAULT NULL,
  `res_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`role_res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;