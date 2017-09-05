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
  `courseID` varchar(7),
  PRIMARY KEY (`schoolID`,`classID`),
  KEY `FK_class_course` (`schoolID`,`courseID`),
  CONSTRAINT `FK_class_course` FOREIGN KEY (`schoolID`, `courseID`) REFERENCES `course` (`schoolID`, `courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.class: ~0 rows (circa)
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
/*!40000 ALTER TABLE `class` ENABLE KEYS */;

-- Dump della struttura di tabella timetable.course
CREATE TABLE IF NOT EXISTS `course` (
  `schoolID` varchar(7) NOT NULL,
  `courseID` varchar(7) NOT NULL,
  `name` varchar(50) NOT NULL,
  `hoursWeek` int(3) NOT NULL,
  PRIMARY KEY (`schoolID`,`courseID`),
  CONSTRAINT `FK_course_school` FOREIGN KEY (`schoolID`) REFERENCES `school` (`schoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.course: ~0 rows (circa)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Dump della struttura di tabella timetable.enabling
CREATE TABLE IF NOT EXISTS `enabling` (
  `subjectID` varchar(7) NOT NULL,
  `teacherID` varchar(7) NOT NULL,
  PRIMARY KEY (`subjectID`,`teacherID`),
  KEY `FK_enabling_teacher` (`teacherID`),
  CONSTRAINT `FK_enabling_subject` FOREIGN KEY (`subjectID`) REFERENCES `subject` (`subjectID`),
  CONSTRAINT `FK_enabling_teacher` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`teacherID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.enabling: ~0 rows (circa)
/*!40000 ALTER TABLE `enabling` DISABLE KEYS */;
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

-- Dump dei dati della tabella timetable.lab: ~0 rows (circa)
/*!40000 ALTER TABLE `lab` DISABLE KEYS */;
/*!40000 ALTER TABLE `lab` ENABLE KEYS */;

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
  `grade` int(1) NOT NULL,
  `subjectID` varchar(7) NOT NULL,
  `courseID` varchar(7) NOT NULL,
  `schoolID` varchar(7) NOT NULL,
  PRIMARY KEY (`grade`,`subjectID`,`courseID`,`schoolID`),
  KEY `FK_study_plan_subject` (`subjectID`),
  KEY `FK_study_plan_course` (`schoolID`,`courseID`),
  CONSTRAINT `FK_study_plan_course` FOREIGN KEY (`schoolID`, `courseID`) REFERENCES `course` (`schoolID`, `courseID`),
  CONSTRAINT `FK_study_plan_subject` FOREIGN KEY (`subjectID`) REFERENCES `subject` (`subjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.study_plan: ~0 rows (circa)
/*!40000 ALTER TABLE `study_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `study_plan` ENABLE KEYS */;

-- Dump della struttura di tabella timetable.subject
CREATE TABLE IF NOT EXISTS `subject` (
  `schoolID` varchar(7) NOT NULL,
  `subjectID` varchar(7) NOT NULL,
  `name` varchar(50) NOT NULL,
  `hoursWeek` int(3) NOT NULL DEFAULT '0',
  `hoursLab` int(3) DEFAULT '0',
  `typeLab` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`subjectID`,`schoolID`),
  KEY `FK_subject_school` (`schoolID`),
  CONSTRAINT `FK_subject_school` FOREIGN KEY (`schoolID`) REFERENCES `school` (`schoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.subject: ~2 rows (circa)
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` (`schoolID`, `subjectID`, `name`, `hoursWeek`, `hoursLab`, `typeLab`) VALUES
	('SCH001', 'HSR012', 'Storia', 10, 0, NULL),
	('SCH001', 'ITA013', 'Letteratura e lingua italiana', 10, 3, 'PC');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;

-- Dump della struttura di tabella timetable.teacher
CREATE TABLE IF NOT EXISTS `teacher` (
  `teacherID` varchar(7) NOT NULL,
  `schoolID` varchar(7) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `hoursWeek` int(11) NOT NULL,
  `preferencesDay` int(11) NOT NULL,
  PRIMARY KEY (`teacherID`,`schoolID`),
  KEY `FK_teacher_school` (`schoolID`),
  CONSTRAINT `FK_teacher_school` FOREIGN KEY (`schoolID`) REFERENCES `school` (`schoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella timetable.teacher: ~0 rows (circa)
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
