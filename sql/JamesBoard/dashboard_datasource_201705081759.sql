CREATE TABLE `dashboard_datasource` (
  `datasource_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) NOT NULL,
  `source_name` varchar(100) NOT NULL,
  `source_type` varchar(100) NOT NULL,
  `config` text,
  PRIMARY KEY (`datasource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO cboard.dashboard_datasource (datasource_id,user_id,source_name,source_type,config) VALUES 
(1,'1','telenav','jdbc','{"driver":"com.mysql.jdbc.Driver","jdbcurl":"jdbc:mysql://localhost:3306/telenav","password":"","username":"root"}')
;