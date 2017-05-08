CREATE TABLE `dashboard_dataset` (
  `dataset_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) NOT NULL,
  `category_name` varchar(100) DEFAULT NULL,
  `dataset_name` varchar(100) DEFAULT NULL,
  `data_json` text,
  PRIMARY KEY (`dataset_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO cboard.dashboard_dataset (dataset_id,user_id,category_name,dataset_name,data_json) VALUES 
(1,'1','Default Category','telenav_student','{"datasource":1,"expressions":[],"query":{"sql":"select * from student;"}}')
;