-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-01-2023 a las 06:13:19
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
-- Base de datos: `prueba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuesta`
--

CREATE TABLE `encuesta` (
  `id_encuesta` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp(),
  `correo_usuario` varchar(255) NOT NULL,
  `id_genero_musical` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `encuesta`
--

INSERT INTO `encuesta` (`id_encuesta`, `fecha`, `correo_usuario`, `id_genero_musical`) VALUES
(1, '2023-01-07 19:49:19', 'pablovelasquezr@gmail.com', 1),
(2, '2023-01-07 22:01:18', 'pablovelasquezr@gmail.com', 3),
(3, '2023-01-07 22:01:34', 'pablovelasquezr@gmail.com', 3),
(4, '2023-01-09 02:23:40', 'hg', 1),
(5, '2023-01-09 03:01:49', 'asd', 1),
(6, '2023-01-09 03:07:07', 'sds', 1),
(8, '2023-01-09 03:10:35', 'as', 1),
(9, '2023-01-09 03:10:44', 'assa', 6),
(10, '2023-01-09 03:10:51', 'asas', 4),
(11, '2023-01-09 03:14:34', 'assasa', 6),
(12, '2023-01-09 03:20:38', 'pablovelasquezr@gmail.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero_musical`
--

CREATE TABLE `genero_musical` (
  `id_genero_musical` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `genero_musical`
--

INSERT INTO `genero_musical` (`id_genero_musical`, `nombre`) VALUES
(1, 'Rock'),
(3, 'Pop'),
(4, 'Clasica'),
(5, 'Jazz'),
(6, 'Metal'),
(7, 'Rap');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `correo_usuario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`correo_usuario`) VALUES
(''),
('a'),
('as'),
('asas'),
('asd'),
('assa'),
('assasa'),
('hg'),
('pablovelasquezr@gmail.com'),
('sds');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `encuesta`
--
ALTER TABLE `encuesta`
  ADD PRIMARY KEY (`id_encuesta`),
  ADD KEY `correo_usuario` (`correo_usuario`),
  ADD KEY `id_genero_musical` (`id_genero_musical`);

--
-- Indices de la tabla `genero_musical`
--
ALTER TABLE `genero_musical`
  ADD PRIMARY KEY (`id_genero_musical`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`correo_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `encuesta`
--
ALTER TABLE `encuesta`
  MODIFY `id_encuesta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `genero_musical`
--
ALTER TABLE `genero_musical`
  MODIFY `id_genero_musical` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `encuesta`
--
ALTER TABLE `encuesta`
  ADD CONSTRAINT `encuesta_ibfk_1` FOREIGN KEY (`correo_usuario`) REFERENCES `usuario` (`correo_usuario`),
  ADD CONSTRAINT `encuesta_ibfk_2` FOREIGN KEY (`id_genero_musical`) REFERENCES `genero_musical` (`id_genero_musical`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
