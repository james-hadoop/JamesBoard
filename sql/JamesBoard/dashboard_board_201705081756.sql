CREATE TABLE `dashboard_board` (
  `board_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `board_name` varchar(100) NOT NULL,
  `layout_json` text,
  PRIMARY KEY (`board_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO cboard.dashboard_board (board_id,user_id,category_id,board_name,layout_json) VALUES 
(1,'1',1,'student_1','{"rows":[{"type":"widget","widgets":[{"name":"dashboard_student_1","widgetId":1,"width":12}]}]}')
;