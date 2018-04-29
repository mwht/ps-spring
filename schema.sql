-- phpMyAdmin SQL Dump
-- version 4.7.8
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Czas generowania: 29 Kwi 2018, 21:49
-- Wersja serwera: 5.7.17
-- Wersja PHP: 7.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `ps`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'Danie dnia'),
(2, 'Śniadania'),
(3, 'Obiady'),
(4, 'Desery');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dishes`
--

CREATE TABLE `dishes` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `price` double NOT NULL,
  `image_url` text NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `dishes`
--

INSERT INTO `dishes` (`id`, `name`, `price`, `image_url`, `category_id`) VALUES
(1, 'Kotlet schabowy z mizerią', 14, 'img/menu/dailydish.jpg', 1),
(2, 'Jajecznica', 7, 'img/menu/jajecznica.jpg', 2),
(3, 'Omlet', 9, 'img/menu/omlet.jpg', 2),
(4, 'Kanapki z awokado', 4, 'img/menu/kanapki-z-awokado.jpg', 2),
(5, 'Zupa pomidorowa', 5.5, 'img/menu/pomidorowa.jpg', 3),
(6, 'Bigos', 8.5, 'img/menu/bigos.jpg', 3),
(7, 'Sernik na zimno', 5.5, 'img/menu/sernik.jpg', 4),
(8, 'Tiramisu', 6.7, 'img/menu/tiramisu.jpg', 4);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `dishes`
--
ALTER TABLE `dishes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `dishes`
--
ALTER TABLE `dishes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
