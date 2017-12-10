-- ----------------------------
-- Table structure for registration
-- ----------------------------
DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `r_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `l_id` bigint(20) DEFAULT NULL,
  `s_time` datetime DEFAULT NULL,
  `e_time` datetime DEFAULT NULL,
  `class_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;