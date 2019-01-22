-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 24, 2017 at 03:41 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `bankAcount`
--

CREATE TABLE `bankAcount` (
  `accountNo` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `type` varchar(25) NOT NULL,
  `balance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bankAcount`
--

INSERT INTO `bankAcount` (`accountNo`, `name`, `type`, `balance`) VALUES
(901, 'Sharon', 'xyz', 500),
(902, 'Henson', 'qaz', 200);

-- --------------------------------------------------------

--
-- Table structure for table `bankUser`
--

CREATE TABLE `bankUser` (
  `accountNo` int(10) NOT NULL,
  `userID` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transactionID` int(10) NOT NULL,
  `depositeAccountNo` int(10) NOT NULL,
  `withdrawAccountNo` int(10) NOT NULL,
  `amount` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bankAcount`
--
ALTER TABLE `bankAcount`
  ADD PRIMARY KEY (`accountNo`);

--
-- Indexes for table `bankUser`
--
ALTER TABLE `bankUser`
  ADD PRIMARY KEY (`accountNo`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transactionID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bankUser`
--
ALTER TABLE `bankUser`
  ADD CONSTRAINT `bankuser_ibfk_1` FOREIGN KEY (`accountNo`) REFERENCES `bankAcount` (`accountNo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
