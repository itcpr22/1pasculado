-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.26-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for login
CREATE DATABASE IF NOT EXISTS `login` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `login`;

-- Dumping structure for table login.tbl1
CREATE TABLE IF NOT EXISTS `tbl1` (
  `users` varchar(50) NOT NULL,
  `passs` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table login.tbl1: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl1` DISABLE KEYS */;
INSERT INTO `tbl1` (`users`, `passs`, `firstname`, `lastname`) VALUES
	('Cris', 'John', '', ''),
	('sjhj', 'hello', 'sgdshgdhs', 'hsghdgh'),
	('hdjhjd', 'hello', 'ekherhe', 'jhjhjej'),
	('hdjhjd', 'hello', 'ekherhe', 'jhjhjej'),
	('hdjhjd', 'hello', 'ekherhe', 'jhjhjej'),
	('hdjhjd', 'hello', 'ekherhe', 'jhjhjej'),
	('gshdg', 'hello', 'sjsd', 'sddhg');
/*!40000 ALTER TABLE `tbl1` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
