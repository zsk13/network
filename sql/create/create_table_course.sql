DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `c_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `c_password` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `c_state` int(11) DEFAULT NULL,
  `t_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `course_id_foreign` (`t_id`),
  CONSTRAINT `course_id_foreign` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
