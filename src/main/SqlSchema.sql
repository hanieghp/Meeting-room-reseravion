CREATE DATABASE  IF NOT EXISTS `room_reserve`;

USE room_reserve;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT  ,
  `password` varchar(20) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `roll` varchar(10) DEFAULT 'USER',
  PRIMARY KEY(`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `rooms`;

CREATE TABLE `rooms` (
  `room_id` int NOT NULL AUTO_INCREMENT ,
  `room_capacity` varchar(15) NOT NULL,
  `Check_In_Date` date NOT NULL,
  `Check_Out_Date` date NOT NULL,
  `isEmpty` tinyint(1) DEFAULT 1,
  PRIMARY KEY(`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation`(
  `reservation_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `room_id` int DEFAULT NULL,
  `reservation_date` date NOT NULL,
  `status`varchar(20) DEFAULT 'PENDING', -- this can be 'PENDING', 'ACCEPTED', 'DECLINED'
  PRIMARY KEY(`reservation_id`),
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (room_id) REFERENCES rooms(room_id)
)
