-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 26, 2021 at 03:47 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `koratuwa`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
CREATE TABLE IF NOT EXISTS `bill` (
  `Bill ID` varchar(35) NOT NULL,
  `User Name` varchar(15) DEFAULT NULL,
  `Customer ID` varchar(8) DEFAULT NULL,
  `Date & Time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Total (Rs.)` float NOT NULL,
  `Discount (Rs.)` float NOT NULL,
  `Net Total (Rs.)` float NOT NULL,
  `Cash (Rs.)` float NOT NULL,
  `Balance (Rs.)` float NOT NULL DEFAULT '0',
  `Payment Method` varchar(20) NOT NULL,
  PRIMARY KEY (`Bill ID`)
) ENGINE=MyISAM AUTO_INCREMENT=1422973187 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`Bill ID`, `User Name`, `Customer ID`, `Date & Time`, `Total (Rs.)`, `Discount (Rs.)`, `Net Total (Rs.)`, `Cash (Rs.)`, `Balance (Rs.)`, `Payment Method`) VALUES
('BL20212761434', 'admin', '', '2021-10-03 14:03:11', 1200, 0, 1200, 1200, 0, 'Cash'),
('BL20212761446', 'admin', '', '2021-10-03 14:04:18', 1500, 0, 1500, 1500, 0, 'Cash'),
('BL20212761475', 'admin', '', '2021-10-03 14:07:14', 1200, 0, 1200, 1200, 0, 'Cash'),
('BL2021291123718', 'admin', '', '2021-10-18 12:37:44', 2420, 100, 2320, 250, -2070, 'Cash'),
('BL2021291124015', 'admin', '', '2021-10-18 12:40:30', 2520, 100, 2420, 100, -2320, 'Cash');

-- --------------------------------------------------------

--
-- Table structure for table `billitem`
--

DROP TABLE IF EXISTS `billitem`;
CREATE TABLE IF NOT EXISTS `billitem` (
  `Bill ID` varchar(20) NOT NULL,
  `Item ID` varchar(50) NOT NULL,
  `Item Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_sinhala_ci NOT NULL,
  `Buying Price (Rs.)` float NOT NULL,
  `Selling Price (Rs.)` float NOT NULL,
  `Price (Rs.)` float NOT NULL,
  `Quantity` float NOT NULL,
  `Total (Rs.)` float NOT NULL,
  `Discount (Rs.)` float NOT NULL,
  `Net Total (Rs.)` float NOT NULL,
  `Complete` int(11) NOT NULL DEFAULT '0',
  `isFree` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Bill ID`,`Item ID`,`isFree`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `billitem`
--

INSERT INTO `billitem` (`Bill ID`, `Item ID`, `Item Name`, `Buying Price (Rs.)`, `Selling Price (Rs.)`, `Price (Rs.)`, `Quantity`, `Total (Rs.)`, `Discount (Rs.)`, `Net Total (Rs.)`, `Complete`, `isFree`) VALUES
('BL20212761434', '1', 'කැරට්', 100, 120, 120, 10, 1200, 0, 1200, 0, 0),
('BL20212761446', '1', 'කැරට්', 100, 150, 150, 10, 1500, 0, 1500, 0, 0),
('BL20212761475', '1', 'කැරට්', 100, 120, 120, 10, 1200, 0, 1200, 0, 0),
('BL2021291123718', '1', 'Bag', 800, 820, 820, 1, 820, 0, 820, 0, 0),
('BL2021291123718', '2', 'T Shirt', 1500, 1600, 1500, 1, 1600, 100, 1500, 0, 0),
('BL2021291124015', '1', 'Bag', 800, 820, 820, 1, 820, 0, 820, 0, 0),
('BL2021291124015', '2', 'T Shirt', 1500, 1700, 1600, 1, 1700, 100, 1600, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `cashier`
--

DROP TABLE IF EXISTS `cashier`;
CREATE TABLE IF NOT EXISTS `cashier` (
  `Cashier ID` varchar(12) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Contact` varchar(10) NOT NULL,
  PRIMARY KEY (`Cashier ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cashier`
--

INSERT INTO `cashier` (`Cashier ID`, `Name`, `Address`, `Contact`) VALUES
('01', 'Kasun', 'Colombo', '0772209791'),
('02', 'Punsara', 'Ratnapura', '0752359687');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `Customer ID` varchar(12) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Address` varchar(60) NOT NULL,
  `Contact` char(10) NOT NULL,
  PRIMARY KEY (`Customer ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer ID`, `Name`, `Address`, `Contact`) VALUES
('001', 'Kasun Malaka', 'No: 77/01, Polgahawela, Kurunegala', '0775556535'),
('002', 'Buddhika Sampath', 'No: 21, Kompitiya, Godakaela', '0789215632'),
('004', 'Nimal Weerarathna', 'No: 56, Panadura', '0773215623');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `Item ID` varchar(50) NOT NULL,
  `Bar Code` varchar(100) NOT NULL,
  `Item Name` varchar(40) CHARACTER SET utf8 COLLATE utf8_sinhala_ci NOT NULL,
  `Buying Price (Rs.)` float NOT NULL,
  `Selling Price (Rs.)` float NOT NULL,
  `Quantity` float NOT NULL,
  `Supplier ID` varchar(12) NOT NULL,
  `Alert Quantity` varchar(15) NOT NULL DEFAULT '0',
  `Brand` char(15) NOT NULL DEFAULT 'Aanya',
  PRIMARY KEY (`Item ID`),
  UNIQUE KEY `Item Name` (`Item Name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`Item ID`, `Bar Code`, `Item Name`, `Buying Price (Rs.)`, `Selling Price (Rs.)`, `Quantity`, `Supplier ID`, `Alert Quantity`, `Brand`) VALUES
('1', '120', 'Bag', 800, 820, 98, '', '10', 'Aanya'),
('2', '2269', 'T Shirt', 1500, 1700, 49, '', '200', 'Aanya'),
('233', '0', 'Trouser', 3000, 3500, 100, '', '0', 'Aanya');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `Order ID` int(8) NOT NULL AUTO_INCREMENT,
  `Item Name` varchar(40) NOT NULL,
  `Quantity` varchar(14) NOT NULL,
  `Date & Time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Paied Amount` double NOT NULL,
  PRIMARY KEY (`Order ID`)
) ENGINE=MyISAM AUTO_INCREMENT=11155 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`Order ID`, `Item Name`, `Quantity`, `Date & Time`, `Paied Amount`) VALUES
(11154, 'Bag', '1000', '2021-10-18 12:29:09', 0);

-- --------------------------------------------------------

--
-- Table structure for table `return_bill`
--

DROP TABLE IF EXISTS `return_bill`;
CREATE TABLE IF NOT EXISTS `return_bill` (
  `Bill ID` varchar(20) NOT NULL,
  `Item ID` int(5) NOT NULL,
  `Item Name` varchar(60) CHARACTER SET utf8 COLLATE utf8_sinhala_ci NOT NULL,
  `Return Quantity` float NOT NULL,
  `Balance (Rs.)` float NOT NULL,
  `User Name` varchar(8) NOT NULL,
  `Date & Time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `return_bill`
--

INSERT INTO `return_bill` (`Bill ID`, `Item ID`, `Item Name`, `Return Quantity`, `Balance (Rs.)`, `User Name`, `Date & Time`) VALUES
('BL202022163734', 1, 'DVD Player', 1, 2400, 'admin', '2020-08-08 06:39:21'),
('BL20202216410', 2, 'Radio', 2, 7800, 'admin', '2020-08-08 06:42:10'),
('BL202022164546', 2, 'Radio', 2.5, 9600, 'admin', '2020-08-08 06:46:25'),
('BL202022195159', 1, 'DVD Player', 1, 2500, 'admin', '2020-08-08 14:49:57'),
('BL2020222184252', 1, 'DVD Player', 1, 2500, 'admin', '2020-08-09 18:45:20'),
('BL2020222184238', 1, 'DVD Player', 1, 2500, 'admin', '2020-08-09 18:45:38'),
('BL2020222185311', 1, 'DVD Player', 1, 2245, 'admin', '2020-08-09 22:03:06'),
('BL2020222221536', 1, 'DVD Player', 1, 2500, 'admin', '2020-08-09 22:16:33'),
('BL2020222221536', 2, 'Radio', 1, 4000, 'admin', '2020-08-09 22:16:33'),
('BL202027520717', 1, 'DVD Player', 1, 2300, 'admin', '2020-10-01 20:09:15'),
('1', 1, 'DVD Player', 1, 2500, 'admin', '2020-10-20 20:54:11'),
('BL2020307121133', 1, 'DVD Player', 10, 25000, 'admin', '2020-11-02 15:54:25'),
('BL202030893035', 1, 'DVD Player', 1, 2300, 'a', '2020-11-03 09:31:36'),
('BL202030893035', 4, 'Samsung TV', 2, 40000, 'a', '2020-11-03 09:31:36'),
('BL202030891912', 1, 'DVD Player', 1, 2500, 'admin', '2020-11-03 09:32:15'),
('BL202143121241', 1, 'DVD Player', 1, 2500, 'admin', '2021-02-12 20:29:46'),
('BL202143121241', 1, 'DVD Player', 1, 2500, 'admin', '2021-02-12 20:30:56'),
('BL20214320361', 1, 'DVD Player', 1, 2500, 'admin', '2021-02-12 20:38:21'),
('BL202143203511', 1, 'DVD Player', 1, 2500, 'a', '2021-02-12 20:39:26'),
('BL20214320513', 1, 'DVD Player', 1, 2500, 'admin', '2021-02-12 20:56:54'),
('BL20219911224', 1, 'DVD Player', 1, 2500, 'admin', '2021-04-09 11:11:33'),
('BL202199134852', 1, 'DVD Player', 1, 2500, 'admin', '2021-04-09 14:14:51'),
('BL202199141516', 454, 'gfgf', 1, 4545, 'admin', '2021-04-09 14:15:32'),
('BL202199141554', 454, 'gfgf', 1, 4545, 'admin', '2021-04-09 14:16:13'),
('BL202199141627', 1, 'DVD Player', 1, 2500, 'admin', '2021-04-09 14:16:45'),
('BL202126912155', 1, 'කැරට්', 1, 12, 'admin', '2021-09-26 08:04:16'),
('BL202126901452', 1, 'කැරට්', 1, 12, 'admin', '2021-09-26 08:04:32'),
('BL202126823587', 1, 'කැරට්', 1, 12, 'admin', '2021-09-26 08:06:17'),
('BL2021268233715', 1, 'කැරට්', 1, 12, 'admin', '2021-09-26 08:08:40'),
('BL2021268231416', 1, 'කැරට්', 1, 12, 'admin', '2021-09-26 08:10:43'),
('BL2021268225212', 1, 'කැරට්', 1, 12, 'admin', '2021-09-26 08:31:28'),
('BL202126901633', 1, 'කැරට්', 1, 12, 'admin', '2021-10-02 12:30:51'),
('BL20212682204', 1, 'කැරට්', 1, 12, 'admin', '2021-10-02 12:49:10'),
('BL2021268224538', 1, 'කැරට්', 1, 12, 'admin', '2021-10-02 12:50:17'),
('BL2021268214239', 1, 'කැරට්', 1, 12, 'admin', '2021-10-02 14:27:09');

-- --------------------------------------------------------

--
-- Table structure for table `return_bill_temp`
--

DROP TABLE IF EXISTS `return_bill_temp`;
CREATE TABLE IF NOT EXISTS `return_bill_temp` (
  `Bill ID` varchar(15) NOT NULL,
  `Item Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_sinhala_ci NOT NULL,
  `Quantity` float NOT NULL,
  `Price (Rs.)` float NOT NULL,
  `Total (Rs.)` float NOT NULL,
  `User Name` varchar(25) NOT NULL,
  `Date Time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `return_bill_temp`
--

INSERT INTO `return_bill_temp` (`Bill ID`, `Item Name`, `Quantity`, `Price (Rs.)`, `Total (Rs.)`, `User Name`, `Date Time`) VALUES
('BL2021268214239', 'කැරට්', 1, 12, 12, 'admin', '2021-10-02 14:27:09');

-- --------------------------------------------------------

--
-- Table structure for table `return _sup`
--

DROP TABLE IF EXISTS `return _sup`;
CREATE TABLE IF NOT EXISTS `return _sup` (
  `Item ID` int(5) NOT NULL,
  `Item Name` varchar(50) NOT NULL,
  `Cashier ID` varchar(8) NOT NULL,
  `Date & Time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Return Quantity` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `return _sup`
--

INSERT INTO `return _sup` (`Item ID`, `Item Name`, `Cashier ID`, `Date & Time`, `Return Quantity`) VALUES
(2, 'Radio', '', '2020-08-08 17:52:28', 1),
(4, 'Samsung TV', '', '2020-08-08 17:52:42', 1),
(1, 'DVD Player', '', '2020-08-08 17:56:37', 1),
(4, 'Samsung TV', '', '2020-08-08 17:56:42', 1),
(5, 'Mac Book Pro', '', '2020-08-08 17:57:15', 1),
(5, 'Mac Book Pro', '', '2020-08-08 17:57:46', 100),
(3, 'One Plus 7T', '', '2020-08-09 22:02:32', 1);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `Supplier ID` varchar(12) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Address` varchar(60) NOT NULL,
  `Contact` varchar(10) NOT NULL,
  `Discription` varchar(100) NOT NULL,
  PRIMARY KEY (`Supplier ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Supplier ID`, `Name`, `Address`, `Contact`, `Discription`) VALUES
('001', 'Damith', 'Colombo', '0112338794', ''),
('003', 'Atlal pvt', 'Colombo', '0112325252', 'Books, Pens');

-- --------------------------------------------------------

--
-- Table structure for table `user_acct`
--

DROP TABLE IF EXISTS `user_acct`;
CREATE TABLE IF NOT EXISTS `user_acct` (
  `User Name` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `CaID` varchar(15) NOT NULL,
  PRIMARY KEY (`User Name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_acct`
--

INSERT INTO `user_acct` (`User Name`, `Password`, `CaID`) VALUES
('admin', '1234', 'ADMIN'),
('guest', '123', '01');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
