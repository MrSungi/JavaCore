CREATE TABLE `groups` (
 `group_id` int(11) NOT NULL AUTO_INCREMENT,
 `code` varchar(10) NOT NULL,
 `form` enum('INDIRECT','PROLONGED','','') NOT NULL,
 `year` int(11) NOT NULL,
 `program_id` int(11) NOT NULL,
 PRIMARY KEY (`group_id`),
 KEY `program_id` (`program_id`),
 CONSTRAINT `groups_ibfk_1` FOREIGN KEY (`program_id`) REFERENCES `studyprogram` (`program_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4

CREATE TABLE `student` (
 `student_id` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(11) NOT NULL,
 `surname` varchar(11) NOT NULL,
 `group_id` int(11) DEFAULT NULL,
 PRIMARY KEY (`student_id`),
 KEY `group_id` (`group_id`),
 CONSTRAINT `student_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4

CREATE TABLE `studyprogram` (
 `program_id` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(40) NOT NULL,
 `department` varchar(30) NOT NULL,
 PRIMARY KEY (`program_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4