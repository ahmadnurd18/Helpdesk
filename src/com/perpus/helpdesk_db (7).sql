-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 20, 2026 at 02:10 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `helpdesk_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_peminjaman`
--

CREATE TABLE `detail_peminjaman` (
  `Peminjaman_ID_Peminjaman` char(10) NOT NULL,
  `Perangkat_ID_Perangkat` char(10) NOT NULL,
  `Status_Pengembalian` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `detail_peminjaman`
--

INSERT INTO `detail_peminjaman` (`Peminjaman_ID_Peminjaman`, `Perangkat_ID_Perangkat`, `Status_Pengembalian`) VALUES
('PM25110001', 'PRK2511010', NULL),
('PM25110001', 'PRK2511011', NULL),
('PM25110002', 'PKT2511001', NULL),
('PM25110002', 'PRK2511001', NULL),
('PM25110003', 'PRK2511013', NULL),
('PM25110004', 'PRK2511006', NULL),
('PM25110005', 'PRK2511008', NULL),
('PM25110006', 'PRK2511004', NULL),
('PM25120001', 'PRK2511007', NULL),
('PM25120002', 'PRK2511002', NULL),
('PM25120003', 'PRK2511003', NULL),
('PM25120004', 'PRK2511005', NULL),
('PM25120005', 'PRK2511005', NULL),
('PM25120006', 'PRK2511003', NULL),
('PM25120007', 'PRK2511009', NULL),
('PM25120008', 'PRK2511003', NULL),
('PM25120009', 'PRK2511009', NULL),
('PM26010001', 'PKT2511001', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `detail_pengembalian`
--

CREATE TABLE `detail_pengembalian` (
  `Pengembalian_ID_Pengembalian` char(10) NOT NULL,
  `Perangkat_ID_Perangkat` char(10) NOT NULL,
  `Jumlah_Denda` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `detail_pengembalian`
--

INSERT INTO `detail_pengembalian` (`Pengembalian_ID_Pengembalian`, `Perangkat_ID_Perangkat`, `Jumlah_Denda`) VALUES
('PG25120001', 'PRK2511007', 0.00),
('PG25120002', 'PRK2511004', 25000.00),
('PG25120003', 'PRK2511003', 5000.00),
('PG25120004', 'PRK2511005', 0.00),
('PG25120005', 'PRK2511005', 0.00),
('PG25120006', 'PRK2511003', 0.00),
('PG25120007', 'PRK2511009', 15000.00),
('PG26010001', 'PKT2511001', 25000.00);

-- --------------------------------------------------------

--
-- Table structure for table `detail_tiket`
--

CREATE TABLE `detail_tiket` (
  `Status_Tiket` varchar(45) DEFAULT NULL,
  `Tiket_ID_Tiket` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `detail_tiket`
--

INSERT INTO `detail_tiket` (`Status_Tiket`, `Tiket_ID_Tiket`) VALUES
('CLOSED', 'TKT2511001'),
('CLOSED', 'TKT2511002'),
('CLOSED', 'TKT2511003'),
('CLOSED', 'TKT2511005'),
('ON PROGRESS', 'TKT2511006'),
('CLOSED', 'TKT2512001'),
('CLOSED', 'TKT2512002'),
('ON PROGRESS', 'TKT2512003');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `ID_Pegawai` char(10) NOT NULL,
  `Nama_Pegawai` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Telepon` varchar(15) DEFAULT NULL,
  `Jenis_Kelamin` varchar(45) DEFAULT NULL,
  `Tanggal_Bergabung` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`ID_Pegawai`, `Nama_Pegawai`, `Email`, `Telepon`, `Jenis_Kelamin`, `Tanggal_Bergabung`) VALUES
('PGW2511001', 'Ahmad Fauzi', 'ahmad.fauzi@helpdesk.ac.id', '081234567801', 'Laki-Laki', '2023-01-15'),
('PGW2511002', 'Siti Nurhaliza', 'siti.nurhaliza@helpdesk.ac.id', '081234567802', 'Perempuan', '2023-02-20'),
('PGW2511003', 'Budi Santoso', 'budi.santoso@helpdesk.ac.id', '081234567803', 'Laki-Laki', '2023-03-10'),
('PGW2511004', 'Rina Wulandari', 'rina.wulandari@helpdesk.ac.id', '081234567804', 'Perempuan', '2023-04-05'),
('PGW2511005', 'Dedi Kurniawan', 'dedi.kurniawan@helpdesk.ac.id', '081234567805', 'Laki-Laki', '2023-05-12'),
('PGW2511006', 'Larasati Putri', 'larasati.putri@helpdesk.ac.id', '081234567806', 'Perempuan', '2023-06-18'),
('PGW2511007', 'Eko Prasetyo', 'eko.prasetyo@helpdesk.ac.id', '081234567807', 'Laki-Laki', '2023-07-22'),
('PGW2511008', 'Fitri Handayani', 'fitri.handayani@helpdesk.ac.id', '081234567808', 'Perempuan', '2023-08-30'),
('PGW2511009', 'Galih Pratama', 'galih.pratama@helpdesk.ac.id', '081234567809', 'Laki-Laki', '2023-09-14'),
('PGW2511010', 'Hana Melati', 'hana.melati@helpdesk.ac.id', '081234567810', 'Perempuan', '2023-10-01'),
('PGW2511011', 'Indra Wijaya', 'indra.wijaya@helpdesk.ac.id', '081234567811', 'Laki-Laki', '2023-11-05'),
('PGW2511012', 'Joko Susilo', 'joko.susilo@helpdesk.ac.id', '081234567812', 'Laki-Laki', '2024-01-10'),
('PGW2511013', 'Kartika Sari', 'kartika.sari@helpdesk.ac.id', '081234567813', 'Perempuan', '2024-02-15'),
('PGW2511014', 'Lukman Hakim', 'lukman.hakim@helpdesk.ac.id', '081234567814', 'Laki-Laki', '2024-03-20'),
('PGW2511015', 'Maya Dewi', 'maya.dewi@helpdesk.ac.id', '081234567815', 'Perempuan', '2024-04-25'),
('PGW2511016', 'Nanda Pratama', 'nanda.pratama@helpdesk.ac.id', '081234567816', 'Laki-Laki', '2024-05-30'),
('PGW2511017', 'Oka Mahendra', 'oka.mahendra@helpdesk.ac.id', '081234567817', 'Laki-Laki', '2024-06-10'),
('PGW2511018', 'Putri Ayuni', 'putri.ayuni@helpdesk.ac.id', '081234567818', 'Perempuan', '2024-07-15'),
('PGW2511019', 'Qori Aulia', 'qori.aulia@helpdesk.ac.id', '081234567819', 'Perempuan', '2024-08-20'),
('PGW2511020', 'Rizky Ramadhan', 'rizky.ramadhan@helpdesk.ac.id', '081234567820', 'Laki-Laki', '2024-09-25'),
('PGW2511021', 'Udin', 'udin@mail.com', '018301230', 'Laki-Laki', '2025-11-07');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `ID_Peminjaman` char(10) NOT NULL,
  `Tanggal_Peminjaman` date DEFAULT NULL,
  `Tanggal_Pengembalian` date DEFAULT NULL,
  `Status_Peminjaman` varchar(45) DEFAULT NULL,
  `User_ID_User` char(10) NOT NULL,
  `Pegawai_ID_Pegawai` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`ID_Peminjaman`, `Tanggal_Peminjaman`, `Tanggal_Pengembalian`, `Status_Peminjaman`, `User_ID_User`, `Pegawai_ID_Pegawai`) VALUES
('PM25110001', '2025-11-16', '2025-11-23', 'Kembali', 'USR2511001', 'PGW2511005'),
('PM25110002', '2025-11-16', '2025-11-23', 'Kembali', 'USR2511001', 'PGW2511009'),
('PM25110003', '2025-11-18', '2025-11-21', 'Dipinjam', 'USR2511002', 'PGW2511012'),
('PM25110004', '2025-11-29', '2025-12-04', 'Dipinjam', 'USR2511002', 'PGW2511014'),
('PM25110005', '2025-11-29', '2025-12-06', 'Dipinjam', 'USR2511015', 'PGW2511007'),
('PM25110006', '2025-11-01', '2025-11-08', 'Dikembalikan', 'USR2511012', 'PGW2511004'),
('PM25120001', '2025-12-02', '2025-12-09', 'Dikembalikan', 'USR2511014', 'PGW2511010'),
('PM25120002', '2025-12-13', '2025-12-20', 'Dipinjam', 'USR2511002', 'PGW2511001'),
('PM25120003', '2025-12-13', '2025-12-20', 'Dikembalikan', 'USR2511012', 'PGW2511012'),
('PM25120004', '2025-12-14', '2025-12-21', 'Dikembalikan', 'USR2511012', 'PGW2511012'),
('PM25120005', '2025-12-14', '2025-12-21', 'Dikembalikan', 'USR2511012', 'PGW2511012'),
('PM25120006', '2025-12-20', '2025-12-27', 'Dikembalikan', 'USR2511007', 'PGW2511007'),
('PM25120007', '2025-12-20', '2025-12-27', 'Dikembalikan', 'USR2511007', 'PGW2511007'),
('PM25120008', '2025-12-20', '2025-12-27', 'Dipinjam', 'USR2511007', 'PGW2511007'),
('PM25120009', '2025-12-20', '2025-12-27', 'Dipinjam', 'USR2511007', 'PGW2511001'),
('PM26010001', '2026-01-16', '2026-01-23', 'Dikembalikan', 'USR2511006', 'PGW2511006');

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `ID_Pengembalian` char(10) NOT NULL,
  `Tanggal_Pengembalian` date DEFAULT NULL,
  `Denda_Pengembalian` decimal(10,2) DEFAULT NULL,
  `Peminjaman_ID_Peminjaman` char(10) NOT NULL,
  `Pegawai_ID_Pegawai` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`ID_Pengembalian`, `Tanggal_Pengembalian`, `Denda_Pengembalian`, `Peminjaman_ID_Peminjaman`, `Pegawai_ID_Pegawai`) VALUES
('PG25120001', '2025-12-02', 0.00, 'PM25120001', 'PGW2511014'),
('PG25120002', '2025-12-13', 25000.00, 'PM25110006', 'PGW2511012'),
('PG25120003', '2025-12-31', 5000.00, 'PM25120003', 'PGW2511012'),
('PG25120004', '2025-12-25', 0.00, 'PM25120004', 'PGW2511012'),
('PG25120005', '2025-12-20', 0.00, 'PM25120005', 'PGW2511012'),
('PG25120006', '2025-12-20', 0.00, 'PM25120006', 'PGW2511007'),
('PG25120007', '2026-01-23', 15000.00, 'PM25120007', 'PGW2511007'),
('PG26010001', '2026-02-28', 25000.00, 'PM26010001', 'PGW2511006');

-- --------------------------------------------------------

--
-- Table structure for table `perangkat`
--

CREATE TABLE `perangkat` (
  `ID_Perangkat` char(10) NOT NULL,
  `Jenis_Perangkat` varchar(45) DEFAULT NULL,
  `Merek` varchar(45) DEFAULT NULL,
  `No_Serial` varchar(20) DEFAULT NULL,
  `Model_Perangkat` varchar(45) DEFAULT NULL,
  `status` varchar(20) DEFAULT 'Tersedia'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `perangkat`
--

INSERT INTO `perangkat` (`ID_Perangkat`, `Jenis_Perangkat`, `Merek`, `No_Serial`, `Model_Perangkat`, `status`) VALUES
('PKT2511001', 'Tablet-Admin', 'Advan', 'Adv-01341-A56', 'A56', 'Tersedia'),
('PRK2511001', 'Laptop', 'Dell', 'DL123456789', 'Latitude 5420', 'Tersedia'),
('PRK2511002', 'Laptop', 'HP', 'HP987654321', 'EliteBook 840 G8', 'Tersedia'),
('PRK2511003', 'Desktop', 'Lenovo', 'LN112233445', 'ThinkCentre M70', 'Tersedia'),
('PRK2511004', 'Desktop', 'Acer', 'AC556677889', 'Veriton X2660G', 'Tersedia'),
('PRK2511005', 'Laptop', 'Asus', 'AS223344556', 'ZenBook 14', 'Tersedia'),
('PRK2511006', 'All-in-One', 'Dell', 'DL667788990', 'OptiPlex 5400 AIO', 'Tersedia'),
('PRK2511007', 'Laptop', 'Lenovo', 'LN334455667', 'ThinkPad X1 Carbon', 'Tersedia'),
('PRK2511008', 'Desktop', 'HP', 'HP778899001', 'ProDesk 400 G7', 'Tersedia'),
('PRK2511009', 'Laptop', 'Acer', 'AC990011223', 'Aspire 5', 'Tersedia'),
('PRK2511010', 'Server', 'Dell', 'DL445566778', 'PowerEdge R250', 'Tersedia'),
('PRK2511011', 'Laptop', 'MacBook', 'AP112233445', 'MacBook Air M2', 'Tersedia'),
('PRK2511012', 'Desktop', 'Custom', 'CS556677889', 'Ryzen 5 PC', 'Tersedia'),
('PRK2511013', 'Laptop', 'MSI', 'MS990011223', 'Modern 14', 'Tersedia'),
('PRK2511014', 'All-in-One', 'HP', 'HP334455667', 'ProOne 440 G9', 'Tersedia'),
('PRK2511015', 'Laptop', 'Toshiba', 'TS778899001', 'Portege Z30', 'Tersedia'),
('PRK2511016', 'Desktop', 'Asus', 'AS223344556', 'ExpertCenter D5', 'Tersedia'),
('PRK2511017', 'Laptop', 'Lenovo', 'LN667788990', 'IdeaPad 3', 'Tersedia'),
('PRK2511018', 'Server', 'HP', 'HP112233445', 'ProLiant ML30', 'Tersedia'),
('PRK2511019', 'Laptop', 'Acer', 'AC556677889', 'Nitro 5', 'Tersedia'),
('PRK2511020', 'All-in-One', 'Lenovo', 'LN990011223', 'IdeaCentre AIO 3', 'Tersedia'),
('PRK2511102', 'Laptop-Rumah', 'hp', 'A-234242-BS', 'A50151', 'Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `sementara`
--

CREATE TABLE `sementara` (
  `Perangkat_ID_Perangkat` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE `tiket` (
  `ID_Tiket` char(10) NOT NULL,
  `Judul_Tiket` varchar(45) DEFAULT NULL,
  `Deskripsi_Tiket` varchar(500) DEFAULT NULL,
  `Prioritas_Tiket` varchar(45) DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  `User_ID_User` char(10) NOT NULL,
  `Pegawai_ID_Pegawai` char(10) DEFAULT NULL,
  `Status_Tiket` varchar(20) DEFAULT 'OPEN'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `tiket`
--

INSERT INTO `tiket` (`ID_Tiket`, `Judul_Tiket`, `Deskripsi_Tiket`, `Prioritas_Tiket`, `StartDate`, `EndDate`, `User_ID_User`, `Pegawai_ID_Pegawai`, `Status_Tiket`) VALUES
('TKT2511001', 'Laptop Mati', 'Laptop saya mati total adhadhahdoahdoahdioaoidhoadhoadohishdikdhidhkshdaisidhiafhiahdfishfiahfidhsfjdsahfha\nafhdkshfisfhsaifhsaifhigahfiaofhweindkjhadljsoeuoaoashdoasdokasjd\nsdfhoshiodaohugfbdzmxnxzmnbcmzxc,znclwuoeoejpasjdlashcahsoljadlja	', 'Medium', '2025-11-13', '2025-11-28', 'USR2511002', NULL, 'CLOSED'),
('TKT2511002', 'Internet Lemot', 'lagi skroll tiba-tiba jelek adasjdaspojdpasjd		', 'Medium', '2025-11-07', '2025-12-20', 'USR2511002', NULL, 'CLOSED'),
('TKT2511003', 'Keyboard rusak', 'lagi ngetik tasdsadjsajdsaioaisdjoiasjdoasisadnosdoajdxsxmcnzxoc\n', 'Medium', '2025-11-18', '2025-11-20', 'USR2511002', NULL, 'CLOSED'),
('TKT2511005', 'dsadjla', 'adjaskldjaks	', 'Medium', '2025-11-06', '2025-11-26', 'USR2511002', NULL, 'CLOSED'),
('TKT2511006', 'adjasodjasoj', 'asdmasndkmasnd	', 'Very High', '2025-11-01', '2025-12-20', 'USR2511006', NULL, 'ON PROGRESS'),
('TKT2512001', 'Laptop Mati', 'Laptop saya mati tiba-tiba, pada saat mengetik, mohon perbaiki karena saya sedang deadline', 'Very High', '2025-12-14', '2025-12-16', 'USR2511012', NULL, 'CLOSED'),
('TKT2512002', 'Belum ada judul', 'adadhsoadoaodoadh	\n\nNote; Baik akan kami perbaiki', 'Medium', '2025-12-20', '2025-12-29', 'USR2511007', 'PGW2511003', 'CLOSED'),
('TKT2512003', 'doasjdsoaj', 'adsasdoajdojas	', 'High', '2025-12-04', '2025-12-25', 'USR2511007', 'PGW2511003', 'ON PROGRESS');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID_User` char(10) NOT NULL,
  `Nama_Full` varchar(45) DEFAULT NULL,
  `Nama_User` varchar(45) DEFAULT NULL,
  `Password` varchar(100) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Role` varchar(45) DEFAULT NULL,
  `Pegawai_ID_Pegawai` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID_User`, `Nama_Full`, `Nama_User`, `Password`, `Email`, `Role`, `Pegawai_ID_Pegawai`) VALUES
('USR2511001', 'Admin', 'Admin', 'admin123', 'admin@mail.com', 'admin', NULL),
('USR2511002', 'user', 'user', 'user123', 'user@mail.com', 'user', NULL),
('USR2511003', 'Budi Santoso', 'budis', 'admin123', 'budi.santoso@helpdesk.ac.id', 'admin', 'PGW2511003'),
('USR2511004', 'Rina Wulandari', 'rinaw', 'admin123', 'rina.wulandari@helpdesk.ac.id', 'admin', 'PGW2511004'),
('USR2511005', 'Dedi Kurniawan', 'dedik', 'admin123', 'dedi.kurniawan@helpdesk.ac.id', 'admin', 'PGW2511005'),
('USR2511006', 'Larasati Putri', 'larasp', 'user123', 'larasati.putri@helpdesk.ac.id', 'user', 'PGW2511006'),
('USR2511007', 'Eko Prasetyo', 'ekop', 'user123', 'eko.prasetyo@helpdesk.ac.id', 'user', 'PGW2511007'),
('USR2511008', 'Fitri Handayani', 'fitrih', 'user123', 'fitri.handayani@helpdesk.ac.id', 'user', 'PGW2511008'),
('USR2511009', 'Galih Pratama', 'galihp', 'user123', 'galih.pratama@helpdesk.ac.id', 'user', 'PGW2511009'),
('USR2511010', 'Hana Melati', 'hanam', 'user123', 'hana.melati@helpdesk.ac.id', 'user', 'PGW2511010'),
('USR2511011', 'Indra Wijaya', 'indraw', 'user123', 'indra.wijaya@helpdesk.ac.id', 'user', 'PGW2511011'),
('USR2511012', 'Joko Susilo', 'jokos', 'user123', 'joko.susilo@helpdesk.ac.id', 'user', 'PGW2511012'),
('USR2511013', 'Kartika Sari', 'kartikas', 'user123', 'kartika.sari@helpdesk.ac.id', 'user', 'PGW2511013'),
('USR2511014', 'Lukman Hakim', 'lukmanh', 'user123', 'lukman.hakim@helpdesk.ac.id', 'user', 'PGW2511014'),
('USR2511015', 'Maya Dewi', 'mayad', 'user123', 'maya.dewi@helpdesk.ac.id', 'user', 'PGW2511015'),
('USR2511016', 'Nanda Pratama', 'nandap', 'admin123', 'nanda.pratama@helpdesk.ac.id', 'admin', 'PGW2511016'),
('USR2511017', 'Oka Mahendra', 'okam', 'admin123', 'oka.mahendra@helpdesk.ac.id', 'admin', 'PGW2511017'),
('USR2511018', 'Putri Ayuni', 'putria', 'admin123', 'putri.ayuni@helpdesk.ac.id', 'admin', 'PGW2511018'),
('USR2511019', 'Qori Aulia', 'qoria', 'admin123', 'qori.aulia@helpdesk.ac.id', 'admin', 'PGW2511019'),
('USR2511020', 'Rizky Ramadhan', 'rizkyr', 'admin123', 'rizky.ramadhan@helpdesk.ac.id', 'admin', 'PGW2511020');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
  ADD PRIMARY KEY (`Peminjaman_ID_Peminjaman`,`Perangkat_ID_Perangkat`),
  ADD KEY `fk_Detail_Peminjaman_Perangkat1` (`Perangkat_ID_Perangkat`);

--
-- Indexes for table `detail_pengembalian`
--
ALTER TABLE `detail_pengembalian`
  ADD PRIMARY KEY (`Pengembalian_ID_Pengembalian`,`Perangkat_ID_Perangkat`),
  ADD KEY `fk_Detail_Pengembalian_Perangkat1` (`Perangkat_ID_Perangkat`);

--
-- Indexes for table `detail_tiket`
--
ALTER TABLE `detail_tiket`
  ADD PRIMARY KEY (`Tiket_ID_Tiket`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`ID_Pegawai`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`ID_Peminjaman`),
  ADD KEY `fk_Peminjaman_User1_idx` (`User_ID_User`),
  ADD KEY `fk_Peminjaman_Pegawai1_idx` (`Pegawai_ID_Pegawai`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`ID_Pengembalian`),
  ADD KEY `fk_Pengembalian_Peminjaman1_idx` (`Peminjaman_ID_Peminjaman`),
  ADD KEY `fk_Pengembalian_Pegawai1_idx` (`Pegawai_ID_Pegawai`);

--
-- Indexes for table `perangkat`
--
ALTER TABLE `perangkat`
  ADD PRIMARY KEY (`ID_Perangkat`);

--
-- Indexes for table `sementara`
--
ALTER TABLE `sementara`
  ADD KEY `fk_Sementara_Perangkat1_idx` (`Perangkat_ID_Perangkat`);

--
-- Indexes for table `tiket`
--
ALTER TABLE `tiket`
  ADD PRIMARY KEY (`ID_Tiket`),
  ADD KEY `fk_Tiket_User_idx` (`User_ID_User`),
  ADD KEY `fk_Tiket_Pegawai1_idx` (`Pegawai_ID_Pegawai`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID_User`),
  ADD KEY `FK_User_Pegawai` (`Pegawai_ID_Pegawai`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
  ADD CONSTRAINT `fk_Detail_Peminjaman_Peminjaman1` FOREIGN KEY (`Peminjaman_ID_Peminjaman`) REFERENCES `peminjaman` (`ID_Peminjaman`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Detail_Peminjaman_Perangkat1` FOREIGN KEY (`Perangkat_ID_Perangkat`) REFERENCES `perangkat` (`ID_Perangkat`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `detail_pengembalian`
--
ALTER TABLE `detail_pengembalian`
  ADD CONSTRAINT `fk_Detail_Pengembalian_Pengembalian1` FOREIGN KEY (`Pengembalian_ID_Pengembalian`) REFERENCES `pengembalian` (`ID_Pengembalian`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Detail_Pengembalian_Perangkat1` FOREIGN KEY (`Perangkat_ID_Perangkat`) REFERENCES `perangkat` (`ID_Perangkat`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `detail_tiket`
--
ALTER TABLE `detail_tiket`
  ADD CONSTRAINT `fk_Detail_Tiket_Tiket1` FOREIGN KEY (`Tiket_ID_Tiket`) REFERENCES `tiket` (`ID_Tiket`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `fk_Peminjaman_Pegawai1` FOREIGN KEY (`Pegawai_ID_Pegawai`) REFERENCES `pegawai` (`ID_Pegawai`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Peminjaman_User1` FOREIGN KEY (`User_ID_User`) REFERENCES `user` (`ID_User`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD CONSTRAINT `fk_Pengembalian_Pegawai1` FOREIGN KEY (`Pegawai_ID_Pegawai`) REFERENCES `pegawai` (`ID_Pegawai`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Pengembalian_Peminjaman1` FOREIGN KEY (`Peminjaman_ID_Peminjaman`) REFERENCES `peminjaman` (`ID_Peminjaman`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sementara`
--
ALTER TABLE `sementara`
  ADD CONSTRAINT `fk_Sementara_Perangkat1` FOREIGN KEY (`Perangkat_ID_Perangkat`) REFERENCES `perangkat` (`ID_Perangkat`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tiket`
--
ALTER TABLE `tiket`
  ADD CONSTRAINT `fk_Tiket_Pegawai1` FOREIGN KEY (`Pegawai_ID_Pegawai`) REFERENCES `pegawai` (`ID_Pegawai`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Tiket_User` FOREIGN KEY (`User_ID_User`) REFERENCES `user` (`ID_User`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_User_Pegawai` FOREIGN KEY (`Pegawai_ID_Pegawai`) REFERENCES `pegawai` (`ID_Pegawai`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
