-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 08 Mar 2025 pada 05.24
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pustakaloka`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `fullname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`username`, `password`, `fullname`) VALUES
('admin', '202cb962ac59075b964b07152d234b70', 'Admin'),
('dfsd', 'a6b14a3123d327627a887a6a442d427f', 'dsfsd'),
('dfsdf', '7d70663568cac5af684503681e3a4d41', 'fdsfsd'),
('gg', '28b662d883b6d76fd96e4ddc5e9ba780', 'admin'),
('hjghjyt', 'e9654e1cd95ffc4c60a74f9d5984fd9e', 'jhkkjhk'),
('sdfsdf', 'ba7893e62fc5e3cb5324626c2f332847', 'fdsf'),
('tesitn', 'ba248c985ace94863880921d8900c53f', 'testing'),
('user1', '81dc9bdb52d04dc20036dbd8313ed055', 'User 1'),
('user2', '81dc9bdb52d04dc20036dbd8313ed055', 'User 2'),
('user3', '81dc9bdb52d04dc20036dbd8313ed055', 'User 3');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
