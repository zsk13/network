DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `t_password` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `t_number` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `t_mail` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `t_phone` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;