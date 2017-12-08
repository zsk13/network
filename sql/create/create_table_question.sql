DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `qid` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacher_id` bigint(20) DEFAULT NULL,
  `question` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `answer` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;