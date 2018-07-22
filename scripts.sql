GRANT ALL PRIVILEGES ON *.* TO 'banksMetaData'@'localhost' IDENTIFIED BY 'password';

CREATE DATABASE  IF NOT EXISTS `user_db`;
USE `user_db`;

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_sign_up`;
CREATE TABLE `user_sign_up` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
   `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
 `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
   `emailId` varchar(255) DEFAULT NULL,
 `phoneNo` bigint(20) DEFAULT NULL,
 `enabled` boolean default 1 NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `bank_user_role`;
CREATE TABLE `bank_user_role` (
  `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6z` FOREIGN KEY (`user_id`) REFERENCES `user_sign_up` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3z` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `user_banks`;
CREATE TABLE `user_banks` (
  `bank_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `bank_metadata`;
CREATE TABLE `bank_metadata` (
  `seq_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `message` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


INSERT INTO `user_role` VALUES (0,'ROLE_USER'),(1,'ROLE_ADMIN');


INSERT INTO `user_banks` VALUES (1,'Wells Fargo'),(2,'HSBC'),(3,'JP Morgan Chase');
INSERT INTO `bank_metadata` VALUES (1,'click on bank will redirect to respective bank home page'),(2,'click on login button.'),(3,'If already having login credentials, enter the user credentials and login');
---------------------


CREATE DATABASE  IF NOT EXISTS `bank_db`;
USE `bank_db`;

DROP TABLE IF EXISTS `bank_role`;
CREATE TABLE `bank_role` (
  `role_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `bank_user_sign_up`;
CREATE TABLE `bank_user_sign_up` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `enabled` boolean default 1 NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
 `email_id` varchar(255) DEFAULT NULL,
 `phone_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `bank2_user_role`;
CREATE TABLE `bank2_user_role` (
  `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `FKa68196081fvovjhkek5m97n3z` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6l` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6l` FOREIGN KEY (`user_id`) REFERENCES `bank_user_sign_up` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3z` FOREIGN KEY (`role_id`) REFERENCES `bank_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `account_tran_details`;
CREATE TABLE `account_tran_details` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  `bank_id` bigint(20) NOT NULL,
  `account_balance` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


INSERT INTO `bank_role` VALUES (0,'ROLE_USER'),(1,'ROLE_ADMIN');

INSERT INTO `bank_user_sign_up` VALUES (1,1,'preetham','raj','$2a$10$RcuWdUBxolsbclrp.CxOq.e1J85Bk7JnIVnKzODWlNgo3jaqW0QVm','User','pr@gmail.com',8123679655),(2,1,'prem','ravi','$2a$12$hZR7pcSf0JU/OTXR3TOyuu8r6C6n.JZE8Ei47E4LZs1t0Aq1AO6oC','Admin','prem@gmail.com',8123679655);

INSERT INTO `bank2_user_role` VALUES (1,0,1),(2,1,2);

INSERT INTO `account_tran_details` VALUES (501234100,113312350,'Savings',1,1,17000.00),(501234101,113312350,'Savings',1,1,50000.00),(501234102,113312351,'Savings',1,1,15000.00),(501234103,113312351,'Savings',1,1,21000.00);

INSERT INTO `account_tran_details` VALUES (501234104,113342350,'Savings',2,2,17000.00),(501234105,113342350,'Savings',2,2,50000.00),(501234106,113342351,'Savings',2,2,15000.00),(501234107,113342351,'Savings',2,2,21000.00);
