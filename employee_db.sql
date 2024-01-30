-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               10.4.25-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6532
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for employee_db
CREATE DATABASE IF NOT EXISTS `employee_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `employee_db`;

-- Dumping structure for table employee_db.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

-- Dumping structure for table employee_db.mst_employee
CREATE TABLE IF NOT EXISTS `mst_employee` (
  `id` bigint(20) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `jenis_kelamin` varchar(20) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `negara` varchar(20) DEFAULT NULL,
  `nik` varchar(20) NOT NULL,
  `tanggal` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pqgumjyh9yc1vkhpdiaqcpuul` (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
