CREATE TABLE `student` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `age` int(4) NOT NULL,
  `score` int(4) NOT NULL,
  `city` varchar(20) NOT NULL,
  `birthday` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


INSERT INTO telenav.student (id,name,age,score,city,birthday) VALUES 
(1,'james',18,88,'shanghai','1988-08-18 00:00:00.000')
,(2,'apache',20,98,'beijing','1970-01-01 00:00:00.000')
,(3,'Cassandra',36,72,'chengdu','1994-03-05 00:00:00.000')
,(4,'Drill',29,19,'chongqing','2002-10-05 00:00:00.000')
;