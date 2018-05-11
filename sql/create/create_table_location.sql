-- ----------------------------
-- Table structure for location
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `l_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `location_name` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `min_lcation_x` double DEFAULT NULL,
  `min_lcation_y` double DEFAULT NULL,
  `max_lcation_x` double DEFAULT NULL,
  `max_location_y` double DEFAULT NULL,
  PRIMARY KEY (`l_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;