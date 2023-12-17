-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 17, 2023 at 07:47 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penyewaan_futsal`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_futsal`
--

CREATE TABLE `tb_futsal` (
  `nama` varchar(50) NOT NULL,
  `no lapangan` int NOT NULL,
  `tnggal_sewa` int NOT NULL,
  `ukuran_lapangan` varchar(50) NOT NULL,
  `jenis_lapangan` varchar(50) NOT NULL,
  `harga_sewa` int NOT NULL,
  `waktu_sewa` int NOT NULL,
  `pembayaran` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tb_futsal`
--

INSERT INTO `tb_futsal` (`nama`, `no lapangan`, `tnggal_sewa`, `ukuran_lapangan`, `jenis_lapangan`, `harga_sewa`, `waktu_sewa`, `pembayaran`) VALUES
('Ramdhan', 5, 21, 'sedang', 'sintetsis', 10000, 2, 'cash'),
('edo', 2, 11, 'kecil', 'interlock', 2000, 1, 'cash');

-- --------------------------------------------------------

--
-- Table structure for table `tb_penyewaan`
--

CREATE TABLE `tb_penyewaan` (
  `kode` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `pembayaran` varchar(50) NOT NULL,
  `waktu_mulai` int NOT NULL,
  `waktu_selesai` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tb_penyewaan`
--

INSERT INTO `tb_penyewaan` (`kode`, `nama`, `pembayaran`, `waktu_mulai`, `waktu_selesai`) VALUES
('7', ' hdh', 'ca', 1, 3),
('3333', 'Ramdhan', 'ngutang', 1, 2),
('7272', ' ram', 'cash', 1, 4),
('2218021', ' Ramdhan', 'cash', 1, 3),
('11', ' edo', 'ngelunjak', 2, 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
