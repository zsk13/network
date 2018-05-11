-- ----------------------------
-- Table structure for registration
-- ----------------------------
DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `r_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `l_id` bigint(20) DEFAULT NULL,
  `s_time` datetime DEFAULT NULL,
  `e_time` datetime DEFAULT NULL,
  `c_id` bigint(20) DEFAULT NULL,
  `c_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`r_id`),
  KEY `c_r_foreign` (`c_id`),
  CONSTRAINT `c_r_foreign` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;