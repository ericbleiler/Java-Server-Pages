
DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;

CREATE TABLE `jspexam` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `answer1` varchar(128) NOT NULL,
  `answer2` varchar(45) NOT NULL,
  `answer3`  varchar(128) NOT NULL,
  `answer4`  varchar(128) NOT NULL,
  `selected` varchar(128) NOT NULL,
  `correct` varchar(128) NOT NULL,
  PRIMARY KEY (`question_id`),
  UNIQUE KEY `question_id_UNIQUE` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1











   








   