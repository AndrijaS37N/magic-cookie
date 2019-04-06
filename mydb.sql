-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 06, 2019 at 04:48 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `bakery`
--

CREATE TABLE `bakery` (
  `bakery_id` int(11) NOT NULL,
  `bakery_description` varchar(45) DEFAULT NULL,
  `bakery_address` varchar(45) NOT NULL,
  `square_meters` double NOT NULL,
  `tables` int(11) DEFAULT NULL,
  `starts_working` varchar(45) NOT NULL,
  `ends_working` varchar(45) NOT NULL,
  `bakery_phone` varchar(45) DEFAULT NULL,
  `bakery_twitter` varchar(45) DEFAULT NULL,
  `bakery_city_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bakery`
--

INSERT INTO `bakery` (`bakery_id`, `bakery_description`, `bakery_address`, `square_meters`, `tables`, `starts_working`, `ends_working`, `bakery_phone`, `bakery_twitter`, `bakery_city_id`) VALUES
(1, 'Ruf ruf ruf ruf ruf.', 'Ruf Ruf 19', 22.5, 14, '9 AM', '8 PM', '+381 00 000 00 00', '@ruf', 1),
(2, 'Bla bla bla.', 'Bla Bla 12', 14, 6, '7 AM', '5 PM', '+39 00 000 00 00', '@bla', 3);

-- --------------------------------------------------------

--
-- Table structure for table `bakery_city`
--

CREATE TABLE `bakery_city` (
  `bakery_city_id` int(11) NOT NULL,
  `city_name` varchar(145) NOT NULL,
  `bakery_country_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bakery_city`
--

INSERT INTO `bakery_city` (`bakery_city_id`, `city_name`, `bakery_country_id`) VALUES
(1, 'Belgrade', 1),
(2, 'Novi Sad', 1),
(3, 'Rome', 2),
(4, 'Berlin', 4);

-- --------------------------------------------------------

--
-- Table structure for table `bakery_country`
--

CREATE TABLE `bakery_country` (
  `bakery_country_id` int(11) NOT NULL,
  `country_name` varchar(245) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bakery_country`
--

INSERT INTO `bakery_country` (`bakery_country_id`, `country_name`) VALUES
(1, 'Serbia'),
(2, 'Italy'),
(3, 'Spain'),
(4, 'Germany');

-- --------------------------------------------------------

--
-- Table structure for table `chocolate`
--

CREATE TABLE `chocolate` (
  `chocolate_id` int(11) NOT NULL,
  `chocolate_name` varchar(145) NOT NULL,
  `chocolate_description` varchar(145) DEFAULT NULL,
  `chocolate_type_id` int(11) NOT NULL,
  `treat_id` int(11) NOT NULL,
  `cost_per_block` double NOT NULL,
  `chocolate_image` varchar(445) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chocolate`
--

INSERT INTO `chocolate` (`chocolate_id`, `chocolate_name`, `chocolate_description`, `chocolate_type_id`, `treat_id`, `cost_per_block`, `chocolate_image`) VALUES
(1, 'Red M\'s', 'With honeyed nuts.', 1, 2, 1.85, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `chocolate_type`
--

CREATE TABLE `chocolate_type` (
  `chocolate_type_id` int(11) NOT NULL,
  `chocolate_type_name` varchar(145) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chocolate_type`
--

INSERT INTO `chocolate_type` (`chocolate_type_id`, `chocolate_type_name`) VALUES
(1, 'Milky');

-- --------------------------------------------------------

--
-- Table structure for table `cookie`
--

CREATE TABLE `cookie` (
  `cookie_id` int(11) NOT NULL,
  `cookie_name` varchar(145) NOT NULL,
  `cookie_description` varchar(145) DEFAULT NULL,
  `cookie_type_id` int(11) NOT NULL,
  `treat_id` int(11) NOT NULL,
  `cost_per_piece` double NOT NULL,
  `cookie_image` varchar(445) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cookie`
--

INSERT INTO `cookie` (`cookie_id`, `cookie_name`, `cookie_description`, `cookie_type_id`, `treat_id`, `cost_per_piece`, `cookie_image`) VALUES
(1, 'Blue K\'s', 'All chips are glazed with caramel. Medium sweet.', 1, 1, 2.25, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `cookie_type`
--

CREATE TABLE `cookie_type` (
  `cookie_type_id` int(11) NOT NULL,
  `cookie_type_name` varchar(245) NOT NULL,
  `cookie_type_description` varchar(245) DEFAULT NULL,
  `number_of_chips` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cookie_type`
--

INSERT INTO `cookie_type` (`cookie_type_id`, `cookie_type_name`, `cookie_type_description`, `number_of_chips`) VALUES
(1, 'Key\'s', 'Chewy cookies.', 15);

-- --------------------------------------------------------

--
-- Table structure for table `responsibility_category`
--

CREATE TABLE `responsibility_category` (
  `responsibility_category_id` int(11) NOT NULL,
  `responsibility_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `responsibility_category`
--

INSERT INTO `responsibility_category` (`responsibility_category_id`, `responsibility_name`) VALUES
(1, 'R1 - Adding treats.'),
(2, 'R2 - Adding employees.');

-- --------------------------------------------------------

--
-- Table structure for table `treat`
--

CREATE TABLE `treat` (
  `treat_id` int(11) NOT NULL,
  `treat_name` varchar(45) NOT NULL,
  `treat_description` varchar(445) DEFAULT NULL,
  `treat_image` varchar(445) DEFAULT NULL,
  `how_was_it_made` varchar(445) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `treat`
--

INSERT INTO `treat` (`treat_id`, `treat_name`, `treat_description`, `treat_image`, `how_was_it_made`) VALUES
(1, 'Cookies', 'Ruf ruf, ruf ruf!', NULL, 'Bla bla bla bla, bla bla bla, bla bla.'),
(2, 'Chocolates', 'Ruf ruf ruf ruf ruf ruf!', NULL, 'Bla bla bla bla, bla bla bla, bla bla. Bla bla bla.'),
(3, 'Waffles', 'Ruf ruf ruf.', NULL, 'Bla bla bla bla, bla.');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `token` varchar(445) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `email`, `password`, `create_time`, `update_time`, `first_name`, `last_name`, `token`) VALUES
(1, 'keyush', 'key@gmail.com', 'key123', '2019-04-05 00:00:00', NULL, 'Keyush', 'The Stunt Dog', NULL),
(2, 'bla_123', 'bla@gmail.com', 'bla123', '2019-04-06 00:00:00', NULL, 'Bla', 'Blanson', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_admin`
--

CREATE TABLE `user_admin` (
  `responsibility_category_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `admin_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_admin`
--

INSERT INTO `user_admin` (`responsibility_category_id`, `user_id`, `admin_number`) VALUES
(1, 1, 1),
(1, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_employee`
--

CREATE TABLE `user_employee` (
  `employee_number` int(11) NOT NULL,
  `employee_description` varchar(445) DEFAULT NULL,
  `bakery_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_employee`
--

INSERT INTO `user_employee` (`employee_number`, `employee_description`, `bakery_id`, `user_id`) VALUES
(1, 'Working in Belgrade, bla bla bla bla bla.', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `waffle`
--

CREATE TABLE `waffle` (
  `waffle_id` int(11) NOT NULL,
  `waffle_name` varchar(145) NOT NULL,
  `waffle_stuffing` tinyint(1) NOT NULL,
  `waffle_description` varchar(245) DEFAULT NULL,
  `waffle_type_id` int(11) NOT NULL,
  `treat_id` int(11) NOT NULL,
  `cost_per_portion` double NOT NULL,
  `waffle_image` varchar(445) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `waffle`
--

INSERT INTO `waffle` (`waffle_id`, `waffle_name`, `waffle_stuffing`, `waffle_description`, `waffle_type_id`, `treat_id`, `cost_per_portion`, `waffle_image`) VALUES
(1, 'Blue SK\'s', 0, 'Crispy regular ones.', 1, 3, 1.95, NULL),
(2, 'Red SK\'s', 1, 'Vanilla and strawberry stuffing.', 1, 3, 2, NULL),
(3, 'Green SK\'s', 0, 'Soft regular ones.', 1, 3, 1.75, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `waffle_type`
--

CREATE TABLE `waffle_type` (
  `waffle_type_id` int(11) NOT NULL,
  `waffle_type_name` varchar(145) NOT NULL,
  `waffle_type_description` varchar(245) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `waffle_type`
--

INSERT INTO `waffle_type` (`waffle_type_id`, `waffle_type_name`, `waffle_type_description`) VALUES
(1, 'Super Key\'s', 'Hard chrispy waffles.'),
(2, 'Great Ol\' Waf Wafs', 'Regular, homemade-like waffles, medium sized.'),
(3, 'Key\'s Favs', 'Thick, fluffy, vanilla flavoured waffles.'),
(4, 'Woo woo\'s', 'Simply the best small waffles out there!');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bakery`
--
ALTER TABLE `bakery`
  ADD PRIMARY KEY (`bakery_id`) USING BTREE,
  ADD KEY `bakery_city_id` (`bakery_city_id`);

--
-- Indexes for table `bakery_city`
--
ALTER TABLE `bakery_city`
  ADD PRIMARY KEY (`bakery_city_id`),
  ADD KEY `bakery_country_id` (`bakery_country_id`);

--
-- Indexes for table `bakery_country`
--
ALTER TABLE `bakery_country`
  ADD PRIMARY KEY (`bakery_country_id`);

--
-- Indexes for table `chocolate`
--
ALTER TABLE `chocolate`
  ADD PRIMARY KEY (`chocolate_id`) USING BTREE,
  ADD KEY `fk_chocolate_chocolate_type1_idx` (`chocolate_type_id`),
  ADD KEY `fk_chocolate_treat1_idx` (`treat_id`);

--
-- Indexes for table `chocolate_type`
--
ALTER TABLE `chocolate_type`
  ADD PRIMARY KEY (`chocolate_type_id`);

--
-- Indexes for table `cookie`
--
ALTER TABLE `cookie`
  ADD PRIMARY KEY (`cookie_id`) USING BTREE,
  ADD KEY `fk_cookie_cookie_type1_idx` (`cookie_type_id`),
  ADD KEY `fk_cookie_treat1_idx` (`treat_id`);

--
-- Indexes for table `cookie_type`
--
ALTER TABLE `cookie_type`
  ADD PRIMARY KEY (`cookie_type_id`);

--
-- Indexes for table `responsibility_category`
--
ALTER TABLE `responsibility_category`
  ADD PRIMARY KEY (`responsibility_category_id`);

--
-- Indexes for table `treat`
--
ALTER TABLE `treat`
  ADD PRIMARY KEY (`treat_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_admin`
--
ALTER TABLE `user_admin`
  ADD PRIMARY KEY (`admin_number`) USING BTREE,
  ADD KEY `fk_user_admin_responsibility_category1_idx` (`responsibility_category_id`),
  ADD KEY `fk_user_admin_user1_idx` (`user_id`);

--
-- Indexes for table `user_employee`
--
ALTER TABLE `user_employee`
  ADD PRIMARY KEY (`employee_number`) USING BTREE,
  ADD KEY `fk_user_employee_bakery1_idx` (`bakery_id`),
  ADD KEY `fk_user_employee_user1_idx` (`user_id`);

--
-- Indexes for table `waffle`
--
ALTER TABLE `waffle`
  ADD PRIMARY KEY (`waffle_id`) USING BTREE,
  ADD KEY `fk_waffle_waffle_type1_idx` (`waffle_type_id`),
  ADD KEY `fk_waffle_treat1_idx` (`treat_id`);

--
-- Indexes for table `waffle_type`
--
ALTER TABLE `waffle_type`
  ADD PRIMARY KEY (`waffle_type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bakery`
--
ALTER TABLE `bakery`
  MODIFY `bakery_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `bakery_city`
--
ALTER TABLE `bakery_city`
  MODIFY `bakery_city_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `bakery_country`
--
ALTER TABLE `bakery_country`
  MODIFY `bakery_country_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `chocolate`
--
ALTER TABLE `chocolate`
  MODIFY `chocolate_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `cookie`
--
ALTER TABLE `cookie`
  MODIFY `cookie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `cookie_type`
--
ALTER TABLE `cookie_type`
  MODIFY `cookie_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `responsibility_category`
--
ALTER TABLE `responsibility_category`
  MODIFY `responsibility_category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `treat`
--
ALTER TABLE `treat`
  MODIFY `treat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user_admin`
--
ALTER TABLE `user_admin`
  MODIFY `admin_number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user_employee`
--
ALTER TABLE `user_employee`
  MODIFY `employee_number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `waffle`
--
ALTER TABLE `waffle`
  MODIFY `waffle_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bakery`
--
ALTER TABLE `bakery`
  ADD CONSTRAINT `bakery_ibfk_1` FOREIGN KEY (`bakery_city_id`) REFERENCES `bakery_city` (`bakery_city_id`);

--
-- Constraints for table `bakery_city`
--
ALTER TABLE `bakery_city`
  ADD CONSTRAINT `bakery_city_ibfk_1` FOREIGN KEY (`bakery_country_id`) REFERENCES `bakery_country` (`bakery_country_id`);

--
-- Constraints for table `chocolate`
--
ALTER TABLE `chocolate`
  ADD CONSTRAINT `fk_chocolate_chocolate_type1` FOREIGN KEY (`chocolate_type_id`) REFERENCES `chocolate_type` (`chocolate_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_chocolate_treat1` FOREIGN KEY (`treat_id`) REFERENCES `treat` (`treat_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `cookie`
--
ALTER TABLE `cookie`
  ADD CONSTRAINT `fk_cookie_cookie_type1` FOREIGN KEY (`cookie_type_id`) REFERENCES `cookie_type` (`cookie_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cookie_treat1` FOREIGN KEY (`treat_id`) REFERENCES `treat` (`treat_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_admin`
--
ALTER TABLE `user_admin`
  ADD CONSTRAINT `fk_user_admin_responsibility_category1` FOREIGN KEY (`responsibility_category_id`) REFERENCES `responsibility_category` (`responsibility_category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_admin_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_employee`
--
ALTER TABLE `user_employee`
  ADD CONSTRAINT `fk_user_employee_bakery1` FOREIGN KEY (`bakery_id`) REFERENCES `bakery` (`bakery_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_employee_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `waffle`
--
ALTER TABLE `waffle`
  ADD CONSTRAINT `fk_waffle_treat1` FOREIGN KEY (`treat_id`) REFERENCES `treat` (`treat_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_waffle_waffle_type1` FOREIGN KEY (`waffle_type_id`) REFERENCES `waffle_type` (`waffle_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
