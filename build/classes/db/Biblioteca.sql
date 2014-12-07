-- phpMyAdmin SQL Dump
-- version 3.3.7deb7
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 07-12-2014 a las 12:49:37
-- Versión del servidor: 5.1.73
-- Versión de PHP: 5.3.3-7+squeeze19

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `Biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Administradores`
--

CREATE TABLE IF NOT EXISTS `Administradores` (
  `userName` varchar(40) NOT NULL,
  `passwd` varchar(40) NOT NULL,
  `dni` varchar(12) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `Administradores`
--

INSERT INTO `Administradores` (`userName`, `passwd`, `dni`) VALUES
('jose', 'j', '11111'),
('ventura', 'ventura', '0000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Libros`
--

CREATE TABLE IF NOT EXISTS `Libros` (
  `codigo` varchar(15) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `autor` varchar(100) NOT NULL,
  `cantidad` int(3) NOT NULL,
  `prestados` int(2) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `Libros`
--

INSERT INTO `Libros` (`codigo`, `nombre`, `titulo`, `autor`, `cantidad`, `prestados`) VALUES
('L-001', 'LIBRO DE ALGEBRA', 'ALGEBRA DEL BALDOR', 'BALDOR', 8, 8),
('L-002', 'Algebra', 'TEST', 'TEST', 10, 1),
('L-003', 'LIBRO III', 'LIBRO III', 'TESTING', 15, 0),
('L-005', 'TES', 'TEST', 'TEST', 58, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Prestamos`
--

CREATE TABLE IF NOT EXISTS `Prestamos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `estado` varchar(15) NOT NULL,
  `id_libro` varchar(15) NOT NULL,
  `id_usuario` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_libro` (`id_libro`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Volcar la base de datos para la tabla `Prestamos`
--

INSERT INTO `Prestamos` (`id`, `fecha`, `estado`, `id_libro`, `id_usuario`) VALUES
(7, '2014-12-07', 'pendiente', 'L-001', 'SM001'),
(8, '2014-12-07', 'pendiente', 'L-001', 'SM001'),
(9, '2014-12-07', 'pendiente', 'L-001', 'SM001'),
(10, '2014-12-07', 'pendiente', 'L-001', 'SM001'),
(11, '2014-12-07', 'pendiente', 'L-001', 'SM001'),
(12, '2014-12-07', 'pendiente', 'L-001', 'SM001'),
(13, '2014-12-07', 'pendiente', 'L-001', 'SM001'),
(14, '2014-12-07', 'pendiente', 'L-001', 'SM001'),
(15, '2014-12-07', 'pendiente', 'L-002', 'SM001');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuarios`
--

CREATE TABLE IF NOT EXISTS `Usuarios` (
  `codigo` varchar(15) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `dni` varchar(113) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `Usuarios`
--

INSERT INTO `Usuarios` (`codigo`, `nombre`, `dni`) VALUES
('SM001', 'Jose Ventura', '1111');

--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `Prestamos`
--
ALTER TABLE `Prestamos`
  ADD CONSTRAINT `Prestamos_ibfk_1` FOREIGN KEY (`id_libro`) REFERENCES `Libros` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Prestamos_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `Usuarios` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
