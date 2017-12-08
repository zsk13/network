DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `r_id` bigint(20) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `location_x` float DEFAULT NULL,
  `location_y` float DEFAULT NULL,
  `s_time` datetime DEFAULT NULL,
  `e_time` datetime DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;