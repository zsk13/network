-- ----------------------------
-- Table structure for rollcall
-- ----------------------------
DROP TABLE IF EXISTS `rollcall`;
CREATE TABLE `rollcall` (
  `rc_id` bigint(20) NOT NULL,
  `u_id` bigint(20) NOT NULL,
  `r_id` bigint(20) NOT NULL,
  `location_x` float DEFAULT NULL,
  `location_y` float DEFAULT NULL,
  `location_name` varchar(0) COLLATE utf8_bin DEFAULT NULL,
  `r_time` datetime DEFAULT NULL,
  PRIMARY KEY (`rc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;