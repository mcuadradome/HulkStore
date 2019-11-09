-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2019 a las 00:48:55
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hulkstore`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingresoproductos`
--

CREATE TABLE `ingresoproductos` (
  `cod_ingreso` int(11) NOT NULL,
  `proveedor` varchar(40) NOT NULL,
  `usuario_fk` varchar(25) NOT NULL,
  `producto_fk` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ingresoproductos`
--

INSERT INTO `ingresoproductos` (`cod_ingreso`, `proveedor`, `usuario_fk`, `producto_fk`, `cantidad`, `fecha`) VALUES
(1, 'vasos JJ', '1233491816', 1, 30, '2019-11-08 01:03:04');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `codProducto` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` text,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`codProducto`, `nombre`, `descripcion`, `precio`) VALUES
(1, 'Vaso pequeño', NULL, 2500),
(2, 'camisa superman XL', NULL, 10000),
(3, 'vaso 10 OZ batman', NULL, 2000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidaproductos`
--

CREATE TABLE `salidaproductos` (
  `codVenta` int(11) NOT NULL,
  `cliente` varchar(25) NOT NULL,
  `usuario_fk` varchar(25) NOT NULL,
  `productoFK` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `salidaproductos`
--

INSERT INTO `salidaproductos` (`codVenta`, `cliente`, `usuario_fk`, `productoFK`, `cantidad`, `fecha`) VALUES
(1, 'marios vasquez', '1233491816', 1, 10, '2019-11-08 04:04:06');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `identificacion` varchar(25) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `user` varchar(15) NOT NULL,
  `pass` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`identificacion`, `nombre`, `apellido`, `user`, `pass`) VALUES
('1233491816', 'Miguel', 'Cuadrado', 'mcuadrado', 'mcuadrado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ingresoproductos`
--
ALTER TABLE `ingresoproductos`
  ADD PRIMARY KEY (`cod_ingreso`),
  ADD KEY `producto_fk` (`producto_fk`),
  ADD KEY `usuario_fk` (`usuario_fk`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`codProducto`);

--
-- Indices de la tabla `salidaproductos`
--
ALTER TABLE `salidaproductos`
  ADD PRIMARY KEY (`codVenta`),
  ADD KEY `productoFK` (`productoFK`),
  ADD KEY `usuario_fk` (`usuario_fk`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`identificacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ingresoproductos`
--
ALTER TABLE `ingresoproductos`
  MODIFY `cod_ingreso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `codProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `salidaproductos`
--
ALTER TABLE `salidaproductos`
  MODIFY `codVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ingresoproductos`
--
ALTER TABLE `ingresoproductos`
  ADD CONSTRAINT `ingresoproductos_ibfk_1` FOREIGN KEY (`producto_fk`) REFERENCES `producto` (`codProducto`),
  ADD CONSTRAINT `ingresoproductos_ibfk_3` FOREIGN KEY (`usuario_fk`) REFERENCES `usuario` (`identificacion`);

--
-- Filtros para la tabla `salidaproductos`
--
ALTER TABLE `salidaproductos`
  ADD CONSTRAINT `salidaproductos_ibfk_1` FOREIGN KEY (`productoFK`) REFERENCES `producto` (`codProducto`),
  ADD CONSTRAINT `salidaproductos_ibfk_3` FOREIGN KEY (`usuario_fk`) REFERENCES `usuario` (`identificacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
