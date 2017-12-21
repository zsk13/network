DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `qid` bigint(20) NOT NULL AUTO_INCREMENT,
  `qname` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `question` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `answer` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`qid`),
  KEY `q_c_foreign` (`course_id`),
  CONSTRAINT `q_c_foreign` FOREIGN KEY (`course_id`) REFERENCES `course` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;