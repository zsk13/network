-- ----------------------------
-- Table structure for course_student
-- ----------------------------
DROP TABLE IF EXISTS `course_student`;
CREATE TABLE `course_student` (
  `cs_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_id` bigint(20) DEFAULT NULL,
  `s_id` bigint(20) DEFAULT NULL,
  `s_time` date DEFAULT NULL,
  PRIMARY KEY (`cs_id`),
  KEY `s_id_foreign` (`s_id`),
  KEY `c_id_foreign` (`c_id`),
  CONSTRAINT `c_id_foreign` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `s_id_foreign` FOREIGN KEY (`s_id`) REFERENCES `users` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;