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
-- Database: `HealthCare`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `doctorID` int(10) NOT NULL,
  `dname` varchar(25) NOT NULL,
  `phone` int(10) NOT NULL,
  `add` varchar(50) NOT NULL,
  `speciality` varchar(10) NOT NULL,
  `hospital` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`doctorID`, `dname`, `phone`, `add`, `speciality`, `hospital`) VALUES
(301, 'Mike', 300001, 'Wv', 'Heart', 'Corbell'),
(302, 'Selina', 300002, 'VM', 'Eyes', 'Corbell'),
(303, 'Cristina', 300003, 'NM', 'Kidney', 'Corbell'),
(304, 'Herris', 207986, 'CN', 'Brain', 'Corbell');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `patientID` int(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `doctorID` int(10) NOT NULL,
  `age` int(3) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phoneNO` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patientID`, `name`, `doctorID`, `age`, `address`, `phoneNO`) VALUES
(1, 'Anamika', 301, 24, 'Valsad', 100000),
(2, 'Jack', 302, 30, 'Surat', 20000),
(3, 'Sharon', 304, 26, 'IN', 2902390),
(4, 'Gracy', 304, 38, 'GA', 39774);

-- --------------------------------------------------------

--
-- Table structure for table `patientDieses`
--

CREATE TABLE `patientDieses` (
  `patientID` int(10) NOT NULL,
  `dieses` varchar(25) NOT NULL,
  `description` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientDieses`
--

INSERT INTO `patientDieses` (`patientID`, `dieses`, `description`) VALUES
(1, 'Heart Attack', 'Serios'),
(2, 'Eye Infection', 'Blue Eyes'),
(3, 'Broken Leg', 'Leg Fracture'),
(4, 'Skin Rashes', 'Rashes');

-- --------------------------------------------------------

--
-- Table structure for table `patientRestriction`
--

CREATE TABLE `patientRestriction` (
  `patientID` int(10) NOT NULL,
  `medicineID` int(10) NOT NULL,
  `description` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientRestriction`
--

INSERT INTO `patientRestriction` (`patientID`, `medicineID`, `description`) VALUES
(1, 701, 'High Sugar'),
(2, 702, 'Not Require'),
(3, 703, 'Ellergy'),
(4, 790, 'Infection');

-- --------------------------------------------------------

--
-- Stand-in structure for view `pharmapatient`
-- (See below for the actual view)
--
CREATE TABLE `pharmapatient` (
`patientID` int(10)
,`pName` varchar(25)
,`dname` varchar(25)
,`dieses` varchar(25)
,`medicineID` int(10)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vpatientdoctor`
-- (See below for the actual view)
--
CREATE TABLE `vpatientdoctor` (
`patientID` int(10)
,`pName` varchar(25)
,`dname` varchar(25)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vpatpr`
-- (See below for the actual view)
--
CREATE TABLE `vpatpr` (
`patientID` int(10)
,`dieses` varchar(25)
,`medicineID` int(10)
);

-- --------------------------------------------------------

--
-- Structure for view `pharmapatient`
--
DROP TABLE IF EXISTS `pharmapatient`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `healthcare`.`pharmapatient`  AS  select `vpatientdoctor`.`patientID` AS `patientID`,`vpatientdoctor`.`pName` AS `pName`,`vpatientdoctor`.`dname` AS `dname`,`vpatpr`.`dieses` AS `dieses`,`vpatpr`.`medicineID` AS `medicineID` from (`healthcare`.`vpatientdoctor` join `healthcare`.`vpatpr`) where (`vpatpr`.`patientID` = `vpatientdoctor`.`patientID`) ;

-- --------------------------------------------------------

--
-- Structure for view `vpatientdoctor`
--
DROP TABLE IF EXISTS `vpatientdoctor`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `healthcare`.`vpatientdoctor`  AS  select `healthcare`.`patient`.`patientID` AS `patientID`,`healthcare`.`patient`.`name` AS `pName`,`healthcare`.`doctor`.`dname` AS `dname` from (`healthcare`.`patient` join `healthcare`.`doctor` on((`healthcare`.`patient`.`doctorID` = `healthcare`.`doctor`.`doctorID`))) ;

-- --------------------------------------------------------

--
-- Structure for view `vpatpr`
--
DROP TABLE IF EXISTS `vpatpr`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `healthcare`.`vpatpr`  AS  select `healthcare`.`patientdieses`.`patientID` AS `patientID`,`healthcare`.`patientdieses`.`dieses` AS `dieses`,`healthcare`.`patientrestriction`.`medicineID` AS `medicineID` from (`healthcare`.`patientdieses` join `healthcare`.`patientrestriction`) where (`healthcare`.`patientdieses`.`patientID` = `healthcare`.`patientrestriction`.`patientID`) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctorID`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patientID`);

--
-- Indexes for table `patientDieses`
--
ALTER TABLE `patientDieses`
  ADD PRIMARY KEY (`patientID`);

--
-- Indexes for table `patientRestriction`
--
ALTER TABLE `patientRestriction`
  ADD PRIMARY KEY (`patientID`),
  ADD KEY `medicineID` (`medicineID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `patientDieses`
--
ALTER TABLE `patientDieses`
  ADD CONSTRAINT `patientdieses_ibfk_1` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`);

--
-- Constraints for table `patientRestriction`
--
ALTER TABLE `patientRestriction`
  ADD CONSTRAINT `patientrestriction_ibfk_1` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`),
  ADD CONSTRAINT `patientrestriction_ibfk_2` FOREIGN KEY (`medicineID`) REFERENCES `pharma`.`medicine` (`medicineID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
