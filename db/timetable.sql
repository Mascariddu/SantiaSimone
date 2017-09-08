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

-- Dump dei dati della tabella timetable.class: ~0 rows (circa)
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` (`schoolID`, `classID`, `grade`, `section`, `courseID`) VALUES
	('SCH001', 'CLS1A', 1, 'A', 'CRS001');
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

-- Dump dei dati della tabella timetable.course: ~0 rows (circa)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`schoolID`, `courseID`, `grade`, `name`) VALUES
	('SCH001', 'CRS001', 1, 'AMMINISTRAZIONE FINANZA E MARKETING');
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

-- Dump dei dati della tabella timetable.enabling: ~0 rows (circa)
/*!40000 ALTER TABLE `enabling` DISABLE KEYS */;
INSERT INTO `enabling` (`schoolID`, `subjectID`, `teacherID`) VALUES
	('SCH001', 'SJB001', 'THC001'),
	('SCH001', 'SJB0010', 'THC008'),
	('SCH001', 'SJB0011', 'THC009'),
	('SCH001', 'SJB0012', 'THC0010'),
	('SCH001', 'SJB002', 'THC002'),
	('SCH001', 'SJB003', 'THC003'),
	('SCH001', 'SJB004', 'THC004'),
	('SCH001', 'SJB005', 'THC003'),
	('SCH001', 'SJB006', 'THC004'),
	('SCH001', 'SJB007', 'THC005'),
	('SCH001', 'SJB008', 'THC006'),
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

-- Dump dei dati della tabella timetable.role: ~0 rows (circa)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`schoolID`, `classID`, `subjectID`, `TeacherID`) VALUES
	('SCH001', 'CLS1A', 'SJB001', 'THC001'),
	('SCH001', 'CLS1A', 'SJB0012', 'THC0010'),
	('SCH001', 'CLS1A', 'SJB002', 'THC002'),
	('SCH001', 'CLS1A', 'SJB003', 'THC003'),
	('SCH001', 'CLS1A', 'SJB005', 'THC003'),
	('SCH001', 'CLS1A', 'SJB004', 'THC004'),
	('SCH001', 'CLS1A', 'SJB006', 'THC004'),
	('SCH001', 'CLS1A', 'SJB007', 'THC005'),
	('SCH001', 'CLS1A', 'SJB008', 'THC006'),
	('SCH001', 'CLS1A', 'SJB009', 'THC007'),
	('SCH001', 'CLS1A', 'SJB0010', 'THC008'),
	('SCH001', 'CLS1A', 'SJB0011', 'THC009');
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
	('SCH002', 'Liceo P. Ruffini', 'Via Vetulonia, 43 - Viterbo', 8, 13, 5);
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

-- Dump dei dati della tabella timetable.study_plan: ~0 rows (circa)
/*!40000 ALTER TABLE `study_plan` DISABLE KEYS */;
INSERT INTO `study_plan` (`subjectID`, `courseID`, `schoolID`, `hoursweek`, `hoursLab`, `typeLab`) VALUES
	('SJB001', 'CRS001', 'SCH001', 4, 0, NULL),
	('SJB0010', 'CRS001', 'SCH001', 2, 0, NULL),
	('SJB0011', 'CRS001', 'SCH001', 2, 0, NULL),
	('SJB0012', 'CRS001', 'SCH001', 1, 0, NULL),
	('SJB002', 'CRS001', 'SCH001', 3, 0, NULL),
	('SJB003', 'CRS001', 'SCH001', 2, 0, NULL),
	('SJB004', 'CRS001', 'SCH001', 4, 0, NULL),
	('SJB005', 'CRS001', 'SCH001', 2, 0, NULL),
	('SJB006', 'CRS001', 'SCH001', 2, 0, NULL),
	('SJB007', 'CRS001', 'SCH001', 3, 0, NULL),
	('SJB008', 'CRS001', 'SCH001', 2, 0, NULL),
	('SJB009', 'CRS001', 'SCH001', 3, 0, NULL);
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

-- Dump dei dati della tabella timetable.subject: ~0 rows (circa)
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` (`schoolID`, `subjectID`, `name`) VALUES
	('SCH001', 'SJB001', 'Lingua e letteratura italiana'),
	('SCH001', 'SJB0010', 'Economia aziendale'),
	('SCH001', 'SJB0011', 'Scienze motorie e sportive'),
	('SCH001', 'SJB0012', 'Religione cattolica'),
	('SCH001', 'SJB002', 'Lingua inglese'),
	('SCH001', 'SJB003', 'Storia, Cittadinanza e Costituzione'),
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

-- Dump dei dati della tabella timetable.teacher: ~0 rows (circa)
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`teacherID`, `schoolID`, `name`, `surname`, `hoursWeek`, `freeDay`) VALUES
	('THC001', 'SCH001', 'Mario', 'Rossi', 18, 0),
	('THC0010', 'SCH001', 'Marina', 'Chiesa', 18, 0),
	('THC002', 'SCH001', 'Giovanni', 'Verdi', 22, 0),
	('THC003', 'SCH001', 'Marco', 'Bianchi', 18, 0),
	('THC004', 'SCH001', 'Luca', 'Gialli', 18, 0),
	('THC005', 'SCH001', 'Giorgio', 'Neri', 18, 0),
	('THC006', 'SCH001', 'Federico', 'Gatti', 18, 0),
	('THC007', 'SCH001', 'Anna', 'Franchi', 18, 0),
	('THC008', 'SCH001', 'Maria', 'Sassi', 18, 0),
	('THC009', 'SCH001', 'Giulia', 'Gentile', 18, 0);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
