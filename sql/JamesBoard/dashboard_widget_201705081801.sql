CREATE TABLE `dashboard_widget` (
  `widget_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) NOT NULL,
  `category_name` varchar(100) DEFAULT NULL,
  `widget_name` varchar(100) DEFAULT NULL,
  `data_json` text,
  PRIMARY KEY (`widget_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


INSERT INTO cboard.dashboard_widget (widget_id,user_id,category_name,widget_name,data_json) VALUES 
(1,'1','Default Category','student_1','{"config":{"chart_type":"line","filters":[],"groups":[],"keys":[{"col":"name","type":"eq","values":[]}],"selects":["id","age","city","birthday"],"valueAxis":"vertical","values":[{"cols":[{"aggregate_type":"sum","col":"score"}],"name":"","series_type":"stackbar","type":"value"}]},"datasetId":1}')
;