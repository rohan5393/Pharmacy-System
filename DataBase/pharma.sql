-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 24, 2017 at 03:39 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharma`
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
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerID` int(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `priscriptionID` int(10) NOT NULL,
  `phone` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(111, 'smit', 111111, 'usa', 'heart', 'cable'),
(222, 'rohan', 222222, 'us', 'eye', 'cable');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoiceID` int(10) NOT NULL,
  `customerID` int(10) NOT NULL,
  `priscriptionID` int(10) NOT NULL,
  `totalAmount` int(11) NOT NULL,
  `transactionID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `medicineID` int(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `price` int(5) NOT NULL,
  `manufacturer` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`medicineID`, `name`, `price`, `manufacturer`) VALUES
(701, 'alvin', 5, 'kjxhsiy'),
(702, 'MinPain', 8, 'valsar'),
(703, 'iodex', 20, 'zany'),
(789, 'crocin', 15, 'sun-harms'),
(790, 'Dcold', 10, 'chardra');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `patientID` int(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `doctorID` int(10) NOT NULL,
  `age` int(3) NOT NULL,
  `address` varchar(30) NOT NULL,
  `phone` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patientID`, `name`, `doctorID`, `age`, `address`, `phone`) VALUES
(1, 'viral', 111, 23, 'ind', 999999),
(2, 'flesh', 222, 33, 'aus', 888888);

-- --------------------------------------------------------

--
-- Table structure for table `patientDieses`
--

CREATE TABLE `patientDieses` (
  `patientID` int(10) NOT NULL,
  `dieses` varchar(10) NOT NULL,
  `description` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientDieses`
--

INSERT INTO `patientDieses` (`patientID`, `dieses`, `description`) VALUES
(1, 'heart fail', 'magaj nahi doba ma');

-- --------------------------------------------------------

--
-- Table structure for table `patientRestriction`
--

CREATE TABLE `patientRestriction` (
  `patientID` int(10) NOT NULL,
  `medicineID` int(10) NOT NULL,
  `description` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientRestriction`
--

INSERT INTO `patientRestriction` (`patientID`, `medicineID`, `description`) VALUES
(1, 789, 'elergy');

-- --------------------------------------------------------

--
-- Table structure for table `prescription`
--

CREATE TABLE `prescription` (
  `priscriptionID` int(10) NOT NULL,
  `date` int(8) NOT NULL,
  `patientID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `prescriptionOfMedicine`
--

CREATE TABLE `prescriptionOfMedicine` (
  `pomID` int(10) NOT NULL,
  `medicineID` int(10) NOT NULL,
  `dosage` varchar(25) NOT NULL,
  `description` varchar(25) NOT NULL,
  `patientID` int(10) NOT NULL,
  `prescriptionID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prescriptionOfMedicine`
--

INSERT INTO `prescriptionOfMedicine` (`pomID`, `medicineID`, `dosage`, `description`, `patientID`, `prescriptionID`) VALUES
(1, 789, '2per day', 'don\'t take more', 1, 0),
(2, 790, '3per day', '', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `medicineID` int(10) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `quantity` int(5) NOT NULL,
  `price` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`medicineID`, `name`, `quantity`, `price`) VALUES
(701, 'alvin', 15, 5),
(702, 'MinPain', 20, 8),
(705, 'ipill', 5, 12),
(707, 'vicks', 6, 15);

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

-- --------------------------------------------------------

--
-- Stand-in structure for view `vdoctor`
-- (See below for the actual view)
--
CREATE TABLE `vdoctor` (
`dieses` varchar(10)
,`medicineID` int(10)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vpatient`
-- (See below for the actual view)
--
CREATE TABLE `vpatient` (
`name` varchar(25)
,`address` int(3)
,`phone` int(10)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vpharmapatient`
-- (See below for the actual view)
--
CREATE TABLE `vpharmapatient` (
`patientID` int(10)
,`name` varchar(25)
,`doctorID` int(10)
,`dieses` varchar(10)
,`medicineID` int(10)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vstock`
-- (See below for the actual view)
--
CREATE TABLE `vstock` (
`medicineID` int(10)
,`name` varchar(25)
,`quantity` int(5)
,`price` int(5)
);

-- --------------------------------------------------------

--
-- Structure for view `vdoctor`
--
DROP TABLE IF EXISTS `vdoctor`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vdoctor`  AS  select `patientdieses`.`dieses` AS `dieses`,`medicine`.`medicineID` AS `medicineID` from (`patientdieses` join `medicine`) ;

-- --------------------------------------------------------

--
-- Structure for view `vpatient`
--
DROP TABLE IF EXISTS `vpatient`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vpatient`  AS  select `patient`.`name` AS `name`,`patient`.`age` AS `address`,`patient`.`phone` AS `phone` from `patient` ;

-- --------------------------------------------------------

--
-- Structure for view `vpharmapatient`
--
DROP TABLE IF EXISTS `vpharmapatient`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vpharmapatient`  AS  select `patient`.`patientID` AS `patientID`,`patient`.`name` AS `name`,`patient`.`doctorID` AS `doctorID`,`patientdieses`.`dieses` AS `dieses`,`patientrestriction`.`medicineID` AS `medicineID` from ((`patient` join `patientdieses`) join `patientrestriction`) where ((`patient`.`patientID` = `patientdieses`.`patientID`) and (`patient`.`patientID` = `patientrestriction`.`patientID`)) ;

-- --------------------------------------------------------

--
-- Structure for view `vstock`
--
DROP TABLE IF EXISTS `vstock`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vstock`  AS  select `stock`.`medicineID` AS `medicineID`,`medicine`.`name` AS `name`,`stock`.`quantity` AS `quantity`,`medicine`.`price` AS `price` from (`stock` join `medicine` on((`stock`.`medicineID` = `medicine`.`medicineID`))) ;

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
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerID`),
  ADD KEY `priscriptionID` (`priscriptionID`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctorID`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoiceID`),
  ADD KEY `customerID` (`customerID`),
  ADD KEY `priscriptionID` (`priscriptionID`),
  ADD KEY `transactionID` (`transactionID`);

--
-- Indexes for table `medicine`
--
ALTER TABLE `medicine`
  ADD PRIMARY KEY (`medicineID`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patientID`),
  ADD KEY `doctorID` (`doctorID`);

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
-- Indexes for table `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`priscriptionID`),
  ADD KEY `patientID` (`patientID`);

--
-- Indexes for table `prescriptionOfMedicine`
--
ALTER TABLE `prescriptionOfMedicine`
  ADD PRIMARY KEY (`pomID`),
  ADD KEY `medicineID` (`medicineID`),
  ADD KEY `patientID` (`patientID`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`medicineID`);

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

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`priscriptionID`) REFERENCES `prescription` (`priscriptionID`);

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`),
  ADD CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`priscriptionID`) REFERENCES `prescription` (`priscriptionID`),
  ADD CONSTRAINT `invoice_ibfk_3` FOREIGN KEY (`transactionID`) REFERENCES `transaction` (`transactionID`);

--
-- Constraints for table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`doctorID`) REFERENCES `doctor` (`doctorID`);

--
-- Constraints for table `patientDieses`
--
ALTER TABLE `patientDieses`
  ADD CONSTRAINT `patientdieses_ibfk_1` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`);

--
-- Constraints for table `patientRestriction`
--
ALTER TABLE `patientRestriction`
  ADD CONSTRAINT `patientrestriction_ibfk_1` FOREIGN KEY (`medicineID`) REFERENCES `medicine` (`medicineID`),
  ADD CONSTRAINT `patientrestriction_ibfk_2` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`);

--
-- Constraints for table `prescription`
--
ALTER TABLE `prescription`
  ADD CONSTRAINT `prescription_ibfk_2` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`);

--
-- Constraints for table `prescriptionOfMedicine`
--
ALTER TABLE `prescriptionOfMedicine`
  ADD CONSTRAINT `prescriptionofmedicine_ibfk_1` FOREIGN KEY (`medicineID`) REFERENCES `medicine` (`medicineID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
