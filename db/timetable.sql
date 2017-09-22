-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.1.25-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win32
-- HeidiSQL Versione:            9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dump della struttura del database timetable
CREATE DATABASE IF NOT EXISTS `timetable` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `timetable`;

-- Dump della struttura di tabella timetable.class
CREATE TABLE IF NOT EXISTS `class` (
  `schoolID` varchar(7) NOT NULL,
  `classID` varchar(7) NOT NULL,
  `grade` int(1) NOT NULL,
  `section` char(1) NOT NULL,
  `courseID` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`schoolID`,`classID`),
  KEY `FK_class_course` (`schoolID`,`courseID`),
  CONSTRAINT `FK_class_course` FOREIGN KEY (`schoolID`, `courseID`) REFERENCES `course` (`schoolID`, `courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.class: ~14 rows (circa)
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` (`schoolID`, `classID`, `grade`, `section`, `courseID`) VALUES
	('SCH001', 'CLS1A', 1, 'A', 'CRS001'),
	('SCH001', 'CLS1B', 1, 'B', 'CRS007'),
	('SCH001', 'CLS2A', 2, 'A', 'CRS002'),
	('SCH001', 'CLS2B', 2, 'B', 'CRS008'),
	('SCH001', 'CLS3A', 3, 'A', 'CRS004'),
	('SCH001', 'CLS3B', 3, 'B', 'CRS003'),
	('SCH001', 'CLS4A', 4, 'A', 'CRS005'),
	('SCH001', 'CLS4B', 4, 'B', 'CRS009'),
	('SCH001', 'CLS5A', 5, 'A', 'CRS006'),
	('SCH001', 'CLS5B', 5, 'B', 'CRS0010'),
	('SCH002', 'CLS1A', 1, 'A', 'CRS001'),
	('SCH003', 'CLS1A', 1, 'A', 'CRS001'),
	('SCH003', 'CLS1B', 2, 'B', 'CRS001'),
	('SCH003', 'CLS1C', 2, 'C', 'CRS001');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;

-- Dump della struttura di tabella timetable.course
CREATE TABLE IF NOT EXISTS `course` (
  `schoolID` varchar(7) NOT NULL,
  `courseID` varchar(7) NOT NULL,
  `grade` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`schoolID`,`courseID`),
  CONSTRAINT `FK_course_school` FOREIGN KEY (`schoolID`) REFERENCES `school` (`schoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.course: ~13 rows (circa)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`schoolID`, `courseID`, `grade`, `name`) VALUES
	('SCH001', 'CRS001', 1, 'AMMINISTRAZIONE FINANZA E MARKETING'),
	('SCH001', 'CRS0010', 5, 'TURISMO'),
	('SCH001', 'CRS002', 2, 'AMMINISTRAZIONE FINANZA E MARKETING'),
	('SCH001', 'CRS003', 3, 'TURISMO'),
	('SCH001', 'CRS004', 3, 'AMMINISTRAZIONE FINANZA E MARKETING'),
	('SCH001', 'CRS005', 4, 'AMMINISTRAZIONE FINANZA E MARKETING'),
	('SCH001', 'CRS006', 5, 'AMMINISTRAZIONE FINANZA E MARKETING'),
	('SCH001', 'CRS007', 1, 'TURISMO'),
	('SCH001', 'CRS008', 2, 'TURISMO'),
	('SCH001', 'CRS009', 4, 'TURISMO'),
	('SCH002', 'CRS001', 1, 'MATEMATICA APPLICATA'),
	('SCH003', 'CRS001', 1, 'CORSO A'),
	('SCH003', 'CRS002', 1, 'CORSO D');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Dump della struttura di tabella timetable.enabling
CREATE TABLE IF NOT EXISTS `enabling` (
  `schoolID` varchar(7) NOT NULL,
  `subjectID` varchar(7) NOT NULL,
  `teacherID` varchar(7) NOT NULL,
  PRIMARY KEY (`subjectID`,`teacherID`,`schoolID`),
  KEY `FK_enabling_teacher` (`teacherID`),
  KEY `FK_enabling_subject` (`schoolID`,`subjectID`),
  CONSTRAINT `FK_enabling_subject` FOREIGN KEY (`schoolID`, `subjectID`) REFERENCES `subject` (`schoolID`, `subjectID`),
  CONSTRAINT `FK_enabling_teacher` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`teacherID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.enabling: ~42 rows (circa)
/*!40000 ALTER TABLE `enabling` DISABLE KEYS */;
INSERT INTO `enabling` (`schoolID`, `subjectID`, `teacherID`) VALUES
	('SCH001', 'SJB001', 'THC001'),
	('SCH002', 'SJB001', 'THC001'),
	('SCH003', 'SJB001', 'THC001'),
	('SCH001', 'SJB001', 'THC0011'),
	('SCH001', 'SJB001', 'THC0016'),
	('SCH001', 'SJB0010', 'THC0015'),
	('SCH001', 'SJB0010', 'THC008'),
	('SCH001', 'SJB0011', 'THC009'),
	('SCH001', 'SJB0012', 'THC0010'),
	('SCH001', 'SJB0013', 'THC0012'),
	('SCH001', 'SJB0013', 'THC0017'),
	('SCH001', 'SJB0014', 'THC0015'),
	('SCH001', 'SJB0014', 'THC008'),
	('SCH001', 'SJB0015', 'THC001'),
	('SCH001', 'SJB0015', 'THC005'),
	('SCH001', 'SJB0016', 'THC0013'),
	('SCH001', 'SJB0016', 'THC003'),
	('SCH001', 'SJB0017', 'THC001'),
	('SCH001', 'SJB0017', 'THC005'),
	('SCH001', 'SJB0018', 'THC001'),
	('SCH001', 'SJB0018', 'THC0016'),
	('SCH001', 'SJB0019', 'THC0013'),
	('SCH001', 'SJB0019', 'THC003'),
	('SCH001', 'SJB002', 'THC0017'),
	('SCH001', 'SJB002', 'THC002'),
	('SCH003', 'SJB002', 'THC002'),
	('SCH001', 'SJB0020', 'THC0013'),
	('SCH001', 'SJB0020', 'THC003'),
	('SCH001', 'SJB003', 'THC0016'),
	('SCH001', 'SJB003', 'THC003'),
	('SCH003', 'SJB003', 'THC003'),
	('SCH003', 'SJB003', 'THC004'),
	('SCH001', 'SJB004', 'THC0014'),
	('SCH001', 'SJB004', 'THC004'),
	('SCH001', 'SJB005', 'THC0013'),
	('SCH001', 'SJB005', 'THC003'),
	('SCH001', 'SJB006', 'THC0014'),
	('SCH001', 'SJB006', 'THC004'),
	('SCH001', 'SJB007', 'THC005'),
	('SCH001', 'SJB008', 'THC006'),
	('SCH001', 'SJB009', 'THC0018'),
	('SCH001', 'SJB009', 'THC007');
/*!40000 ALTER TABLE `enabling` ENABLE KEYS */;

-- Dump della struttura di tabella timetable.lab
CREATE TABLE IF NOT EXISTS `lab` (
  `schoolID` varchar(7) NOT NULL,
  `labID` varchar(7) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`schoolID`,`labID`),
  CONSTRAINT `FK_Lab_school` FOREIGN KEY (`schoolID`) REFERENCES `school` (`schoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.lab: ~1 rows (circa)
/*!40000 ALTER TABLE `lab` DISABLE KEYS */;
INSERT INTO `lab` (`schoolID`, `labID`, `name`, `type`) VALUES
	('SCH001', 'LAB001', 'Laib5D', 'Laboratorio PC'),
	('SCH001', 'LAB002', 'Palestrina C11', 'Palestra');
/*!40000 ALTER TABLE `lab` ENABLE KEYS */;

-- Dump della struttura di tabella timetable.role
CREATE TABLE IF NOT EXISTS `role` (
  `schoolID` varchar(7) NOT NULL,
  `classID` varchar(7) NOT NULL,
  `subjectID` varchar(7) NOT NULL,
  `TeacherID` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`schoolID`,`classID`,`subjectID`),
  KEY `FK__subject` (`subjectID`),
  KEY `FK__teacher` (`TeacherID`),
  CONSTRAINT `FK__class` FOREIGN KEY (`schoolID`, `classID`) REFERENCES `class` (`schoolID`, `classID`),
  CONSTRAINT `FK__subject` FOREIGN KEY (`subjectID`) REFERENCES `subject` (`subjectID`),
  CONSTRAINT `FK__teacher` FOREIGN KEY (`TeacherID`) REFERENCES `teacher` (`teacherID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.role: ~126 rows (circa)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`schoolID`, `classID`, `subjectID`, `TeacherID`) VALUES
	('SCH001', 'CLS2B', 'SJB001', 'THC001'),
	('SCH001', 'CLS3A', 'SJB001', 'THC001'),
	('SCH001', 'CLS3A', 'SJB0018', 'THC001'),
	('SCH001', 'CLS3B', 'SJB0017', 'THC001'),
	('SCH001', 'CLS4A', 'SJB001', 'THC001'),
	('SCH001', 'CLS4A', 'SJB0018', 'THC001'),
	('SCH001', 'CLS4B', 'SJB0015', 'THC001'),
	('SCH001', 'CLS4B', 'SJB0017', 'THC001'),
	('SCH001', 'CLS5A', 'SJB0018', 'THC001'),
	('SCH001', 'CLS5B', 'SJB001', 'THC001'),
	('SCH001', 'CLS5B', 'SJB0015', 'THC001'),
	('SCH002', 'CLS1A', 'SJB001', 'THC001'),
	('SCH003', 'CLS1A', 'SJB001', 'THC001'),
	('SCH003', 'CLS1B', 'SJB001', 'THC001'),
	('SCH003', 'CLS1C', 'SJB001', 'THC001'),
	('SCH001', 'CLS1A', 'SJB0012', 'THC0010'),
	('SCH001', 'CLS1B', 'SJB0012', 'THC0010'),
	('SCH001', 'CLS2A', 'SJB0012', 'THC0010'),
	('SCH001', 'CLS2B', 'SJB0012', 'THC0010'),
	('SCH001', 'CLS3A', 'SJB0012', 'THC0010'),
	('SCH001', 'CLS3B', 'SJB0012', 'THC0010'),
	('SCH001', 'CLS4A', 'SJB0012', 'THC0010'),
	('SCH001', 'CLS4B', 'SJB0012', 'THC0010'),
	('SCH001', 'CLS5A', 'SJB0012', 'THC0010'),
	('SCH001', 'CLS5B', 'SJB0012', 'THC0010'),
	('SCH001', 'CLS1A', 'SJB001', 'THC0011'),
	('SCH001', 'CLS2A', 'SJB001', 'THC0011'),
	('SCH001', 'CLS3B', 'SJB001', 'THC0011'),
	('SCH001', 'CLS4B', 'SJB001', 'THC0011'),
	('SCH001', 'CLS5A', 'SJB001', 'THC0011'),
	('SCH001', 'CLS3B', 'SJB0013', 'THC0012'),
	('SCH001', 'CLS5B', 'SJB0013', 'THC0012'),
	('SCH001', 'CLS1B', 'SJB005', 'THC0013'),
	('SCH001', 'CLS2B', 'SJB005', 'THC0013'),
	('SCH001', 'CLS4A', 'SJB0020', 'THC0013'),
	('SCH001', 'CLS4B', 'SJB0016', 'THC0013'),
	('SCH001', 'CLS5A', 'SJB0019', 'THC0013'),
	('SCH001', 'CLS5A', 'SJB0020', 'THC0013'),
	('SCH001', 'CLS5B', 'SJB0016', 'THC0013'),
	('SCH001', 'CLS1B', 'SJB004', 'THC0014'),
	('SCH001', 'CLS1B', 'SJB006', 'THC0014'),
	('SCH001', 'CLS2B', 'SJB004', 'THC0014'),
	('SCH001', 'CLS2B', 'SJB006', 'THC0014'),
	('SCH001', 'CLS4B', 'SJB004', 'THC0014'),
	('SCH001', 'CLS5A', 'SJB004', 'THC0014'),
	('SCH001', 'CLS5B', 'SJB004', 'THC0014'),
	('SCH001', 'CLS1B', 'SJB0010', 'THC0015'),
	('SCH001', 'CLS2B', 'SJB0010', 'THC0015'),
	('SCH001', 'CLS4B', 'SJB0014', 'THC0015'),
	('SCH001', 'CLS5B', 'SJB0014', 'THC0015'),
	('SCH001', 'CLS1B', 'SJB001', 'THC0016'),
	('SCH001', 'CLS1B', 'SJB003', 'THC0016'),
	('SCH001', 'CLS2B', 'SJB003', 'THC0016'),
	('SCH001', 'CLS4B', 'SJB003', 'THC0016'),
	('SCH001', 'CLS5B', 'SJB003', 'THC0016'),
	('SCH001', 'CLS2B', 'SJB002', 'THC0017'),
	('SCH001', 'CLS4B', 'SJB0013', 'THC0017'),
	('SCH001', 'CLS4B', 'SJB002', 'THC0017'),
	('SCH001', 'CLS5B', 'SJB002', 'THC0017'),
	('SCH001', 'CLS2B', 'SJB009', 'THC0018'),
	('SCH001', 'CLS4B', 'SJB009', 'THC0018'),
	('SCH001', 'CLS5B', 'SJB009', 'THC0018'),
	('SCH001', 'CLS1A', 'SJB002', 'THC002'),
	('SCH001', 'CLS1B', 'SJB002', 'THC002'),
	('SCH001', 'CLS2A', 'SJB002', 'THC002'),
	('SCH001', 'CLS3A', 'SJB002', 'THC002'),
	('SCH001', 'CLS3B', 'SJB002', 'THC002'),
	('SCH001', 'CLS4A', 'SJB002', 'THC002'),
	('SCH001', 'CLS5A', 'SJB002', 'THC002'),
	('SCH003', 'CLS1A', 'SJB002', 'THC002'),
	('SCH003', 'CLS1B', 'SJB002', 'THC002'),
	('SCH003', 'CLS1C', 'SJB002', 'THC002'),
	('SCH001', 'CLS1A', 'SJB003', 'THC003'),
	('SCH001', 'CLS1A', 'SJB005', 'THC003'),
	('SCH001', 'CLS2A', 'SJB003', 'THC003'),
	('SCH001', 'CLS2A', 'SJB005', 'THC003'),
	('SCH001', 'CLS3A', 'SJB0019', 'THC003'),
	('SCH001', 'CLS3A', 'SJB0020', 'THC003'),
	('SCH001', 'CLS3B', 'SJB0016', 'THC003'),
	('SCH001', 'CLS3B', 'SJB003', 'THC003'),
	('SCH001', 'CLS4A', 'SJB0019', 'THC003'),
	('SCH003', 'CLS1A', 'SJB003', 'THC003'),
	('SCH001', 'CLS1A', 'SJB004', 'THC004'),
	('SCH001', 'CLS1A', 'SJB006', 'THC004'),
	('SCH001', 'CLS2A', 'SJB004', 'THC004'),
	('SCH001', 'CLS2A', 'SJB006', 'THC004'),
	('SCH001', 'CLS3A', 'SJB004', 'THC004'),
	('SCH001', 'CLS3B', 'SJB004', 'THC004'),
	('SCH001', 'CLS4A', 'SJB004', 'THC004'),
	('SCH003', 'CLS1B', 'SJB003', 'THC004'),
	('SCH003', 'CLS1C', 'SJB003', 'THC004'),
	('SCH001', 'CLS1A', 'SJB007', 'THC005'),
	('SCH001', 'CLS1B', 'SJB007', 'THC005'),
	('SCH001', 'CLS2A', 'SJB007', 'THC005'),
	('SCH001', 'CLS2B', 'SJB007', 'THC005'),
	('SCH001', 'CLS3B', 'SJB0015', 'THC005'),
	('SCH001', 'CLS5B', 'SJB0017', 'THC005'),
	('SCH001', 'CLS1A', 'SJB008', 'THC006'),
	('SCH001', 'CLS1B', 'SJB008', 'THC006'),
	('SCH001', 'CLS2A', 'SJB008', 'THC006'),
	('SCH001', 'CLS2B', 'SJB008', 'THC006'),
	('SCH001', 'CLS3A', 'SJB008', 'THC006'),
	('SCH001', 'CLS4A', 'SJB008', 'THC006'),
	('SCH001', 'CLS1A', 'SJB009', 'THC007'),
	('SCH001', 'CLS1B', 'SJB009', 'THC007'),
	('SCH001', 'CLS2A', 'SJB009', 'THC007'),
	('SCH001', 'CLS3A', 'SJB009', 'THC007'),
	('SCH001', 'CLS3B', 'SJB009', 'THC007'),
	('SCH001', 'CLS4A', 'SJB009', 'THC007'),
	('SCH001', 'CLS5A', 'SJB009', 'THC007'),
	('SCH001', 'CLS1A', 'SJB0010', 'THC008'),
	('SCH001', 'CLS2A', 'SJB0010', 'THC008'),
	('SCH001', 'CLS3A', 'SJB0010', 'THC008'),
	('SCH001', 'CLS3B', 'SJB0014', 'THC008'),
	('SCH001', 'CLS4A', 'SJB0010', 'THC008'),
	('SCH001', 'CLS5A', 'SJB0010', 'THC008'),
	('SCH001', 'CLS1A', 'SJB0011', 'THC009'),
	('SCH001', 'CLS1B', 'SJB0011', 'THC009'),
	('SCH001', 'CLS2A', 'SJB0011', 'THC009'),
	('SCH001', 'CLS2B', 'SJB0011', 'THC009'),
	('SCH001', 'CLS3A', 'SJB0011', 'THC009'),
	('SCH001', 'CLS3B', 'SJB0011', 'THC009'),
	('SCH001', 'CLS4A', 'SJB0011', 'THC009'),
	('SCH001', 'CLS4B', 'SJB0011', 'THC009'),
	('SCH001', 'CLS5A', 'SJB0011', 'THC009'),
	('SCH001', 'CLS5B', 'SJB0011', 'THC009');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dump della struttura di tabella timetable.school
CREATE TABLE IF NOT EXISTS `school` (
  `schoolID` varchar(7) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `startLessons` int(11) NOT NULL,
  `endLessons` int(11) NOT NULL,
  `workDays` int(11) NOT NULL,
  PRIMARY KEY (`schoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.school: ~0 rows (circa)
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` (`schoolID`, `name`, `address`, `startLessons`, `endLessons`, `workDays`) VALUES
	('SCH001', 'ITC Paolo Savi', 'VIA DIAZ, 10 - VITERBO', 8, 13, 6),
	('SCH002', 'Liceo P. Ruffini', 'Via Vetulonia, 43 - Viterbo', 8, 13, 5),
	('SCH003', 'CORSO BASE', 'VIA PAOLO', 8, 12, 1);
/*!40000 ALTER TABLE `school` ENABLE KEYS */;

-- Dump della struttura di tabella timetable.study_plan
CREATE TABLE IF NOT EXISTS `study_plan` (
  `subjectID` varchar(7) NOT NULL,
  `courseID` varchar(7) NOT NULL,
  `schoolID` varchar(7) NOT NULL,
  `hoursweek` int(2) DEFAULT NULL,
  `hoursLab` int(2) DEFAULT '0',
  `typeLab` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`subjectID`,`courseID`,`schoolID`),
  KEY `FK_study_plan_course` (`schoolID`,`courseID`),
  CONSTRAINT `FK_study_plan_course` FOREIGN KEY (`schoolID`, `courseID`) REFERENCES `course` (`schoolID`, `courseID`),
  CONSTRAINT `FK_study_plan_subject` FOREIGN KEY (`subjectID`) REFERENCES `subject` (`subjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.study_plan: ~123 rows (circa)
/*!40000 ALTER TABLE `study_plan` DISABLE KEYS */;
INSERT INTO `study_plan` (`subjectID`, `courseID`, `schoolID`, `hoursweek`, `hoursLab`, `typeLab`) VALUES
	('SJB001', 'CRS001', 'SCH001', 4, 0, NULL),
	('SJB001', 'CRS001', 'SCH002', 25, 0, NULL),
	('SJB001', 'CRS001', 'SCH003', 1, 0, NULL),
	('SJB001', 'CRS0010', 'SCH001', 4, 0, NULL),
	('SJB001', 'CRS002', 'SCH001', 4, 0, NULL),
	('SJB001', 'CRS002', 'SCH003', 1, 0, NULL),
	('SJB001', 'CRS003', 'SCH001', 4, 0, NULL),
	('SJB001', 'CRS004', 'SCH001', 4, 0, NULL),
	('SJB001', 'CRS005', 'SCH001', 4, 0, NULL),
	('SJB001', 'CRS006', 'SCH001', 4, 0, NULL),
	('SJB001', 'CRS007', 'SCH001', 4, 0, NULL),
	('SJB001', 'CRS008', 'SCH001', 4, 0, NULL),
	('SJB001', 'CRS009', 'SCH001', 4, 0, NULL),
	('SJB0010', 'CRS001', 'SCH001', 2, 0, NULL),
	('SJB0010', 'CRS002', 'SCH001', 2, 0, NULL),
	('SJB0010', 'CRS004', 'SCH001', 4, 0, NULL),
	('SJB0010', 'CRS005', 'SCH001', 5, 0, NULL),
	('SJB0010', 'CRS006', 'SCH001', 6, 0, NULL),
	('SJB0010', 'CRS007', 'SCH001', 2, 0, NULL),
	('SJB0010', 'CRS008', 'SCH001', 2, 0, NULL),
	('SJB0011', 'CRS001', 'SCH001', 2, 0, NULL),
	('SJB0011', 'CRS0010', 'SCH001', 2, 0, NULL),
	('SJB0011', 'CRS002', 'SCH001', 2, 0, NULL),
	('SJB0011', 'CRS003', 'SCH001', 2, 0, NULL),
	('SJB0011', 'CRS004', 'SCH001', 2, 0, NULL),
	('SJB0011', 'CRS005', 'SCH001', 2, 0, NULL),
	('SJB0011', 'CRS006', 'SCH001', 2, 0, NULL),
	('SJB0011', 'CRS007', 'SCH001', 2, 0, NULL),
	('SJB0011', 'CRS008', 'SCH001', 2, 0, NULL),
	('SJB0011', 'CRS009', 'SCH001', 2, 0, NULL),
	('SJB0012', 'CRS001', 'SCH001', 1, 0, NULL),
	('SJB0012', 'CRS0010', 'SCH001', 1, 0, NULL),
	('SJB0012', 'CRS002', 'SCH001', 1, 0, NULL),
	('SJB0012', 'CRS003', 'SCH001', 1, 0, NULL),
	('SJB0012', 'CRS004', 'SCH001', 1, 0, NULL),
	('SJB0012', 'CRS005', 'SCH001', 1, 0, NULL),
	('SJB0012', 'CRS006', 'SCH001', 1, 0, NULL),
	('SJB0012', 'CRS007', 'SCH001', 1, 0, NULL),
	('SJB0012', 'CRS008', 'SCH001', 1, 0, NULL),
	('SJB0012', 'CRS009', 'SCH001', 1, 0, NULL),
	('SJB0013', 'CRS0010', 'SCH001', 3, 0, NULL),
	('SJB0013', 'CRS003', 'SCH001', 3, 0, NULL),
	('SJB0013', 'CRS009', 'SCH001', 3, 0, NULL),
	('SJB0014', 'CRS0010', 'SCH001', 3, 0, NULL),
	('SJB0014', 'CRS003', 'SCH001', 3, 0, NULL),
	('SJB0014', 'CRS009', 'SCH001', 3, 0, NULL),
	('SJB0015', 'CRS0010', 'SCH001', 2, 0, NULL),
	('SJB0015', 'CRS003', 'SCH001', 1, 0, NULL),
	('SJB0015', 'CRS009', 'SCH001', 2, 0, NULL),
	('SJB0016', 'CRS0010', 'SCH001', 2, 0, NULL),
	('SJB0016', 'CRS003', 'SCH001', 3, 0, NULL),
	('SJB0016', 'CRS009', 'SCH001', 2, 0, NULL),
	('SJB0017', 'CRS0010', 'SCH001', 2, 0, NULL),
	('SJB0017', 'CRS003', 'SCH001', 2, 0, NULL),
	('SJB0017', 'CRS009', 'SCH001', 2, 0, NULL),
	('SJB0018', 'CRS004', 'SCH001', 2, 0, NULL),
	('SJB0018', 'CRS005', 'SCH001', 2, 0, NULL),
	('SJB0018', 'CRS006', 'SCH001', 2, 0, NULL),
	('SJB0019', 'CRS004', 'SCH001', 3, 0, NULL),
	('SJB0019', 'CRS005', 'SCH001', 3, 0, NULL),
	('SJB0019', 'CRS006', 'SCH001', 3, 0, NULL),
	('SJB002', 'CRS001', 'SCH001', 3, 0, NULL),
	('SJB002', 'CRS001', 'SCH003', 1, 0, NULL),
	('SJB002', 'CRS0010', 'SCH001', 3, 0, NULL),
	('SJB002', 'CRS002', 'SCH001', 3, 0, NULL),
	('SJB002', 'CRS002', 'SCH003', 1, 0, NULL),
	('SJB002', 'CRS003', 'SCH001', 3, 0, NULL),
	('SJB002', 'CRS004', 'SCH001', 3, 0, NULL),
	('SJB002', 'CRS005', 'SCH001', 3, 0, NULL),
	('SJB002', 'CRS006', 'SCH001', 3, 0, NULL),
	('SJB002', 'CRS007', 'SCH001', 3, 0, NULL),
	('SJB002', 'CRS008', 'SCH001', 3, 0, NULL),
	('SJB002', 'CRS009', 'SCH001', 3, 0, NULL),
	('SJB0020', 'CRS004', 'SCH001', 3, 0, NULL),
	('SJB0020', 'CRS005', 'SCH001', 2, 0, NULL),
	('SJB0020', 'CRS006', 'SCH001', 3, 0, NULL),
	('SJB003', 'CRS001', 'SCH001', 2, 0, NULL),
	('SJB003', 'CRS001', 'SCH003', 2, 0, NULL),
	('SJB003', 'CRS0010', 'SCH001', 2, 0, NULL),
	('SJB003', 'CRS002', 'SCH001', 2, 0, NULL),
	('SJB003', 'CRS002', 'SCH003', 2, 0, NULL),
	('SJB003', 'CRS003', 'SCH001', 2, 0, NULL),
	('SJB003', 'CRS007', 'SCH001', 2, 0, NULL),
	('SJB003', 'CRS008', 'SCH001', 2, 0, NULL),
	('SJB003', 'CRS009', 'SCH001', 2, 0, NULL),
	('SJB004', 'CRS001', 'SCH001', 4, 0, NULL),
	('SJB004', 'CRS0010', 'SCH001', 3, 0, NULL),
	('SJB004', 'CRS002', 'SCH001', 4, 0, NULL),
	('SJB004', 'CRS003', 'SCH001', 3, 0, NULL),
	('SJB004', 'CRS004', 'SCH001', 3, 0, NULL),
	('SJB004', 'CRS005', 'SCH001', 3, 0, NULL),
	('SJB004', 'CRS006', 'SCH001', 3, 0, NULL),
	('SJB004', 'CRS007', 'SCH001', 4, 0, NULL),
	('SJB004', 'CRS008', 'SCH001', 4, 0, NULL),
	('SJB004', 'CRS009', 'SCH001', 3, 0, NULL),
	('SJB005', 'CRS001', 'SCH001', 2, 0, NULL),
	('SJB005', 'CRS002', 'SCH001', 2, 0, NULL),
	('SJB005', 'CRS007', 'SCH001', 2, 0, NULL),
	('SJB005', 'CRS008', 'SCH001', 2, 0, NULL),
	('SJB006', 'CRS001', 'SCH001', 2, 0, NULL),
	('SJB006', 'CRS002', 'SCH001', 2, 0, NULL),
	('SJB006', 'CRS007', 'SCH001', 2, 0, NULL),
	('SJB006', 'CRS008', 'SCH001', 2, 0, NULL),
	('SJB007', 'CRS001', 'SCH001', 3, 0, NULL),
	('SJB007', 'CRS002', 'SCH001', 3, 0, NULL),
	('SJB007', 'CRS007', 'SCH001', 3, 0, NULL),
	('SJB007', 'CRS008', 'SCH001', 3, 0, NULL),
	('SJB008', 'CRS001', 'SCH001', 2, 0, NULL),
	('SJB008', 'CRS002', 'SCH001', 2, 0, NULL),
	('SJB008', 'CRS004', 'SCH001', 2, 0, NULL),
	('SJB008', 'CRS005', 'SCH001', 2, 0, NULL),
	('SJB008', 'CRS007', 'SCH001', 2, 0, NULL),
	('SJB008', 'CRS008', 'SCH001', 2, 0, NULL),
	('SJB009', 'CRS001', 'SCH001', 3, 0, NULL),
	('SJB009', 'CRS0010', 'SCH001', 3, 0, NULL),
	('SJB009', 'CRS002', 'SCH001', 3, 0, NULL),
	('SJB009', 'CRS003', 'SCH001', 3, 0, NULL),
	('SJB009', 'CRS004', 'SCH001', 3, 0, NULL),
	('SJB009', 'CRS005', 'SCH001', 3, 0, NULL),
	('SJB009', 'CRS006', 'SCH001', 3, 0, NULL),
	('SJB009', 'CRS007', 'SCH001', 3, 0, NULL),
	('SJB009', 'CRS008', 'SCH001', 3, 0, NULL),
	('SJB009', 'CRS009', 'SCH001', 3, 0, NULL);
/*!40000 ALTER TABLE `study_plan` ENABLE KEYS */;

-- Dump della struttura di tabella timetable.subject
CREATE TABLE IF NOT EXISTS `subject` (
  `schoolID` varchar(7) NOT NULL,
  `subjectID` varchar(7) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`subjectID`,`schoolID`),
  KEY `FK_subject_school` (`schoolID`),
  CONSTRAINT `FK_subject_school` FOREIGN KEY (`schoolID`) REFERENCES `school` (`schoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.subject: ~18 rows (circa)
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` (`schoolID`, `subjectID`, `name`) VALUES
	('SCH001', 'SJB001', 'Lingua e letteratura italiana'),
	('SCH002', 'SJB001', 'Storia'),
	('SCH003', 'SJB001', 'MATERIA A'),
	('SCH001', 'SJB0010', 'Economia aziendale'),
	('SCH001', 'SJB0011', 'Scienze motorie e sportive'),
	('SCH001', 'SJB0012', 'Religione cattolica'),
	('SCH001', 'SJB0013', 'Lingua Tedesca'),
	('SCH001', 'SJB0014', 'Discipline turistiche e aziendali'),
	('SCH001', 'SJB0015', 'Geografia turistica'),
	('SCH001', 'SJB0016', 'Diritto e legislazione turistica'),
	('SCH001', 'SJB0017', 'Arte e territorio'),
	('SCH001', 'SJB0018', 'Storia'),
	('SCH001', 'SJB0019', 'Diritto'),
	('SCH001', 'SJB002', 'Lingua inglese'),
	('SCH003', 'SJB002', 'MATERIA B'),
	('SCH001', 'SJB0020', 'Economia politica'),
	('SCH001', 'SJB003', 'Storia, Cittadinanza e Costituzione'),
	('SCH003', 'SJB003', 'MATERIA C'),
	('SCH001', 'SJB004', 'Matematica'),
	('SCH001', 'SJB005', 'Diritto ed Economia'),
	('SCH001', 'SJB006', 'Scienze integrate'),
	('SCH001', 'SJB007', 'Geografia'),
	('SCH001', 'SJB008', 'Informatica'),
	('SCH001', 'SJB009', 'Lingua Francese');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;

-- Dump della struttura di tabella timetable.teacher
CREATE TABLE IF NOT EXISTS `teacher` (
  `teacherID` varchar(7) NOT NULL,
  `schoolID` varchar(7) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `hoursWeek` int(11) NOT NULL,
  `freeDay` int(11) NOT NULL,
  PRIMARY KEY (`teacherID`,`schoolID`),
  KEY `FK_teacher_school` (`schoolID`),
  CONSTRAINT `FK_teacher_school` FOREIGN KEY (`schoolID`) REFERENCES `school` (`schoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.teacher: ~23 rows (circa)
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`teacherID`, `schoolID`, `name`, `surname`, `hoursWeek`, `freeDay`) VALUES
	('THC001', 'SCH001', 'Mario', 'Rossi', 22, 0),
	('THC001', 'SCH002', 'Maria ', 'Luisa', 22, 0),
	('THC001', 'SCH003', 'PROFESSORE ', 'A', 22, 2),
	('THC0010', 'SCH001', 'Marina', 'Chiesa', 22, 0),
	('THC0011', 'SCH001', 'Pino', 'Franco', 22, 5),
	('THC0012', 'SCH001', 'Franca', 'Pane', 22, 4),
	('THC0013', 'SCH001', 'Federica', 'Lana', 22, 3),
	('THC0014', 'SCH001', 'Giorgio', 'Penna', 22, 2),
	('THC0015', 'SCH001', 'Paolo', 'Nera', 22, 1),
	('THC0016', 'SCH001', 'Mario', 'Tavola', 22, 4),
	('THC0017', 'SCH001', 'Giovanni', 'Rana', 22, 0),
	('THC0018', 'SCH001', 'Maria', 'Passato', 22, 1),
	('THC002', 'SCH001', 'Giovanni', 'Verdi', 22, 0),
	('THC002', 'SCH003', 'PROFESSORE', 'B', 22, 1),
	('THC003', 'SCH001', 'Marco', 'Bianchi', 22, 0),
	('THC003', 'SCH003', 'PROFESSORE', 'C', 22, 3),
	('THC004', 'SCH001', 'Luca', 'Gialli', 22, 0),
	('THC004', 'SCH003', 'PROFESSORE', 'D', 22, 2),
	('THC005', 'SCH001', 'Giorgio', 'Neri', 22, 0),
	('THC006', 'SCH001', 'Federico', 'Gatti', 22, 0),
	('THC007', 'SCH001', 'Anna', 'Franchi', 22, 0),
	('THC008', 'SCH001', 'Maria', 'Sassi', 22, 0),
	('THC009', 'SCH001', 'Giulia', 'Gentile', 22, 0);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
