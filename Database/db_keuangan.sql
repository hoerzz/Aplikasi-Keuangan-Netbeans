-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 26, 2021 at 02:25 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_keuangan`
--

-- --------------------------------------------------------

--
-- Table structure for table `datagajikaryawan`
--

CREATE TABLE `datagajikaryawan` (
  `id` int(11) NOT NULL,
  `nama_karyawan` varchar(255) NOT NULL,
  `devisi` varchar(255) NOT NULL,
  `jml_gaji` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `datagajikaryawan`
--

INSERT INTO `datagajikaryawan` (`id`, `nama_karyawan`, `devisi`, `jml_gaji`) VALUES
(1, 'aditya', 'staff', '3000000'),
(2, 'chaerudin', 'manajer', '4000000');

-- --------------------------------------------------------

--
-- Table structure for table `data_karyawan`
--

CREATE TABLE `data_karyawan` (
  `id` int(11) NOT NULL,
  `nmkaryawan` varchar(2555) NOT NULL,
  `umur` int(11) NOT NULL,
  `ttl` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `notelp` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_karyawan`
--

INSERT INTO `data_karyawan` (`id`, `nmkaryawan`, `umur`, `ttl`, `alamat`, `notelp`) VALUES
(3, 'aditya', 20, '2000-07-06', 'ciracas', 8888),
(4, 'chaerudin', 21, '2000-06-01', 'bekasi', 2123),
(5, 'haryo', 20, '2000-06-01', 'citayam', 88888);

-- --------------------------------------------------------

--
-- Table structure for table `gajikaryawan`
--

CREATE TABLE `gajikaryawan` (
  `id` int(11) NOT NULL,
  `nama_karyawan` varchar(255) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` varchar(200) NOT NULL,
  `jumlah` decimal(15,0) NOT NULL,
  `jenisgaji` varchar(255) NOT NULL,
  `hitung` decimal(10,0) NOT NULL,
  `datelog` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gajikaryawan`
--

INSERT INTO `gajikaryawan` (`id`, `nama_karyawan`, `tanggal`, `keterangan`, `jumlah`, `jenisgaji`, `hitung`, `datelog`) VALUES
(5, 'aditya', '2021-06-13', 'lembur', '300000', 'Gaji Tambahan', '300000', '2021-06-13 08:27:47'),
(6, 'chaerudin', '2021-06-13', 'lembur', '30000', 'Gaji Tambahan', '30000', '2021-06-13 08:28:28'),
(7, 'aditya', '2021-06-14', 'cuti', '100000', 'Gaji Potongan', '-100000', '2021-06-13 08:29:10'),
(8, 'chaerudin', '2021-06-14', 'cuti', '100000', 'Gaji Potongan', '-100000', '2021-06-13 08:29:43');

-- --------------------------------------------------------

--
-- Table structure for table `jabatan_karyawan`
--

CREATE TABLE `jabatan_karyawan` (
  `id` int(15) NOT NULL,
  `nmkaryawan` varchar(255) NOT NULL,
  `katjabatan` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `ketkontrak` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jabatan_karyawan`
--

INSERT INTO `jabatan_karyawan` (`id`, `nmkaryawan`, `katjabatan`, `status`, `ketkontrak`) VALUES
(2, 'aditya', 'junior', 'aktif', '2 Tahun'),
(3, 'chaerudin', 'senior', 'aktif', '4Tahun'),
(4, 'haryo', 'senior ', 'aktif', '3 tahun');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `keterangan` varchar(200) NOT NULL,
  `jumlah` decimal(15,0) NOT NULL,
  `jenistransaksi` varchar(12) NOT NULL DEFAULT 'Pemasukkan',
  `hitung` decimal(10,0) NOT NULL,
  `datelog` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id`, `tanggal`, `keterangan`, `jumlah`, `jenistransaksi`, `hitung`, `datelog`) VALUES
(1, '2021-06-13', 'pemasukan toko', '32000000', 'Pemasukkan', '32000000', '2021-06-13 07:34:14'),
(2, '2021-06-13', 'jumlah pengeluaran', '25000000', 'Pengeluaran', '-25000000', '2021-06-13 07:34:48');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `status` varchar(10) DEFAULT NULL,
  `lastlogin` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `status`, `lastlogin`) VALUES
('admin', '21232f297a57a5a743894a0e4a801fc3', '', '2021-06-01 01:53:44'),
('albert', '827ccb0eea8a706c4c34a16891f84e7b', 'aktif', '2021-06-13 07:33:34');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `datagajikaryawan`
--
ALTER TABLE `datagajikaryawan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `data_karyawan`
--
ALTER TABLE `data_karyawan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gajikaryawan`
--
ALTER TABLE `gajikaryawan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jabatan_karyawan`
--
ALTER TABLE `jabatan_karyawan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `datagajikaryawan`
--
ALTER TABLE `datagajikaryawan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `data_karyawan`
--
ALTER TABLE `data_karyawan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `gajikaryawan`
--
ALTER TABLE `gajikaryawan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `jabatan_karyawan`
--
ALTER TABLE `jabatan_karyawan`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
