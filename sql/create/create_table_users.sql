-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `u_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_open_id` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `type` enum('teacher','student') DEFAULT NULL,
  `sno` varchar(15) DEFAULT NULL,
  `className` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;