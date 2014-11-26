-- phpMyAdmin SQL Dump
-- version 3.3.7deb7
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 22-11-2014 a las 19:04:54
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
('lopez', 'lopez', ''),
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
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `Libros`
--

INSERT INTO `Libros` (`codigo`, `nombre`, `titulo`, `autor`, `cantidad`) VALUES
('L-0002', 'TES', 'TEST', 'TEST', 10),
('L-001', 'LIBRO DE ALGEBRA', 'ALGEBRA DEL BALDOR', 'BALDOR', 10);

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
('SM001', 'Jose Ventura', '0000');
