-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-04-2023 a las 20:31:46
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `interbanking_challenge`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `company`
--

CREATE TABLE `company` (
  `cuit` varchar(13) NOT NULL,
  `business_name` text NOT NULL,
  `accession_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `company`
--

INSERT INTO `company` (`cuit`, `business_name`, `accession_date`) VALUES
('0123456790', 'Kiosco Potter', '2023-04-22'),
('20246464139', 'La Birra Bar', '2023-04-20'),
('30546671166', 'UTN', '2023-04-21'),
('30687307123', 'Cinemark', '2023-04-18'),
('30714247464', 'Pinguino Expediciones', '2023-04-21'),
('30717505383', 'Sur Propiedades SA', '2023-04-21'),
('33682097049', 'Bowen', '2023-03-17'),
('37682099749', 'Sayain Store', '2023-04-21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transfer`
--

CREATE TABLE `transfer` (
  `id` int(11) NOT NULL,
  `cuit` text NOT NULL,
  `amount` double NOT NULL,
  `debit_account` text NOT NULL,
  `credit_account` text NOT NULL,
  `dates` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `transfer`
--

INSERT INTO `transfer` (`id`, `cuit`, `amount`, `debit_account`, `credit_account`, `dates`) VALUES
(1, '20246464139', 1800, '0000000054', '0000000044', '2023-04-21'),
(2, '20246464139', 3500, '0000000054', '0000000044', '2023-04-19'),
(3, '30546671166', 79822, '0000000044', '0000000054', '2023-04-05'),
(4, '30714247464', 570, '0000000023', '0000000054', '2023-04-05'),
(5, '37682099749', 900000, '0000000012', '0000000033', '2023-03-30'),
(6, '30717505383', 147, '0000000090', '0000000035', '2023-02-27'),
(7, '30687307123', 3459, '0000000092', '0000000007', '2023-03-19');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`cuit`);

--
-- Indices de la tabla `transfer`
--
ALTER TABLE `transfer`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `transfer`
--
ALTER TABLE `transfer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
