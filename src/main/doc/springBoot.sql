
CREATE TABLE `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `age` INT(11) DEFAULT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `money` FLOAT DEFAULT NULL,
  `theme_remark_color` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8