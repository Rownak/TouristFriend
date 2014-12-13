-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 13, 2014 at 04:54 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `touristfriend_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE IF NOT EXISTS `district` (
  `id_district` int(11) NOT NULL AUTO_INCREMENT,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `district_name` varchar(55) NOT NULL,
  PRIMARY KEY (`id_district`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`id_district`, `latitude`, `longitude`, `district_name`) VALUES
(1, 24.8978, 91.8714, 'Sylhet'),
(2, 23.7, 90.375, 'Dhaka');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE IF NOT EXISTS `location` (
  `id_location` int(11) NOT NULL AUTO_INCREMENT,
  `location_name` varchar(55) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `id_district` int(11) NOT NULL,
  PRIMARY KEY (`id_location`),
  KEY `district_location_fk` (`id_district`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`id_location`, `location_name`, `latitude`, `longitude`, `id_district`) VALUES
(1, 'Shahjalal University Of Science & Technology', 24.912, 91.8322, 1),
(2, 'University of Dhaka', 23.7315, 90.3925, 2),
(3, 'Hatirjheel', 23.7495747, 90.3967635, 2),
(4, 'Savar', 23.8583, 90.2667, 2),
(5, 'Jaflong', 25.1633829, 92.0175242, 1),
(6, 'Bisnakandi', 25.17064, 91.885786, 1),
(7, 'Kumargaon', 24.912, 91.8322, 1),
(8, 'Hatirjheel Link Road 1, Dhaka, Bangladesh', 23.7495747, 90.3967635, 2),
(9, 'Hatirjheel Link Road 1', 23.7495747, 90.3967635, 2),
(10, 'Hatirjheel Link Road 1', 23.7495747, 90.3967635, 2),
(11, 'Sylhet - Sunamganj Highway', 24.9089335, 91.8380286, 1);

-- --------------------------------------------------------

--
-- Table structure for table `photos`
--

CREATE TABLE IF NOT EXISTS `photos` (
  `id_photos` int(11) NOT NULL AUTO_INCREMENT,
  `lat` double NOT NULL,
  `lang` double NOT NULL,
  `rating` double NOT NULL DEFAULT '0',
  `num_of_user_rated` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `id_season` int(11) NOT NULL,
  `id_place` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `photo_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_photos`),
  UNIQUE KEY `photo_url` (`photo_url`),
  KEY `season_photos_fk` (`id_season`),
  KEY `place_photos_fk` (`id_place`),
  KEY `user_photos_fk` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=115 ;

--
-- Dumping data for table `photos`
--

INSERT INTO `photos` (`id_photos`, `lat`, `lang`, `rating`, `num_of_user_rated`, `date`, `description`, `id_season`, `id_place`, `id_user`, `photo_url`) VALUES
(1, 24.92326, 91.831683, 6, 7, NULL, 'shohid minar', 1, 1, 1, '/Sylhet/Shahjalal University Of Science & Technology/sust4.jpg'),
(2, 25.18587, 92.015414, 3.923076923076923, 13, NULL, 'zero point', 1, 2, 2, '/Sylhet/Jaflong/jaflong1.jpg'),
(3, 23.912649, 90.254374, 7, 66, NULL, 'Monument', 1, 3, 3, '/Dhaka/Savar/savar1.jpg'),
(4, 25.18587, 92.015414, 4.4, 10, NULL, 'Jaflong', 1, 2, 4, '/Sylhet/Jaflong/jaflong2.jpg'),
(5, 25.18587, 91.67857, 2.0250569476082, 439, NULL, NULL, 1, 2, 1, '/Sylhet/Jaflong/jaflong3.jpg'),
(6, 23.456, 91.67857, 6, 66, NULL, NULL, 1, 2, 1, '/Sylhet/Jaflong/jaflong4.jpg'),
(7, 23.912649, 91.67857, 5, 435, NULL, NULL, 1, 2, 1, '/Sylhet/Jaflong/jaflong5.jpg'),
(8, 23.7495747, 90.3967635, 0, 0, NULL, NULL, 1, 7, 1, 'pictures\\Dhaka\\Hatirjheel Link Road 1\\fahad.jpg'),
(9, 23.7495747, 90.3967635, 0, 0, NULL, NULL, 1, 7, 1, '/Dhaka/Hatirjheel Link Road 1/fahad.jpg'),
(10, 24.9089287, 91.8380018, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG20141212_192638.jpg'),
(11, 24.9089287, 91.8380018, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG20141212_205648.jpg'),
(88, 23.456, 91.67857, 0, 5, NULL, NULL, 1, 8, 1, 'pictures\\Sylhet\\Sylhet - Sunamganj Highway\\new.jpg'),
(89, 24.9089287, 91.8380018, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG20141212_210513.jpg'),
(91, 24.9089287, 91.8380018, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG20141212_210726.jpg'),
(93, 24.9089287, 91.8380018, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG20141212_211524.jpg'),
(95, 24.9089287, 91.8380018, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG20141212_212252.jpg'),
(96, 24.9089273, 91.8379849, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG20141212_213457.jpg'),
(97, 24.9089273, 91.8379849, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG20141212_223111.jpg'),
(99, 24.908929166666667, 91.83800666666666, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG_20141213_014544.jpg'),
(103, 24.9089556, 91.8379829, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG20141213_164850.jpg'),
(104, 24.90892861111111, 91.83800166666666, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG_20141212_204543.jpg'),
(106, 24.9089338, 91.8379838, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG20141213_171518.jpg'),
(108, 24.908955555555554, 91.83798277777777, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG_20141213_164850.jpg'),
(111, 24.908928055555553, 91.83798499999999, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG_20141213_204131.jpg'),
(112, 24.9089282, 91.837985, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG20141213_204417.jpg'),
(113, 24.908928055555553, 91.83798499999999, 0, 0, NULL, NULL, 1, 8, 1, '/Sylhet/Sylhet - Sunamganj Highway/IMG_20141213_204417.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `place`
--

CREATE TABLE IF NOT EXISTS `place` (
  `id_place` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `id_location` int(11) NOT NULL,
  PRIMARY KEY (`id_place`),
  KEY `location_place_fk` (`id_location`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `place`
--

INSERT INTO `place` (`id_place`, `name`, `description`, `latitude`, `longitude`, `id_location`) VALUES
(1, 'Shohid Minar', 'sust', 24.92326, 91.831683, 7),
(2, 'Jaflong - Tamabil Rd', 'jaflong', 25.18587, 92.015414, 5),
(3, 'Radio Colony Road', 'savar', 23.912649, 90.254374, 4),
(4, 'University Ave', NULL, 91.8322, 0, 7),
(5, 'Hatirjheel Link Road 1', NULL, 23.7495747, 90.3967635, 8),
(6, 'Hatirjheel Link Road 1', NULL, 23.7495747, 90.3967635, 10),
(7, 'Hatirjheel Link Road 1', NULL, 23.7495747, 90.3967635, 9),
(8, 'Sylhet - Sunamganj Highway', NULL, 24.9089335, 91.8380286, 11);

-- --------------------------------------------------------

--
-- Table structure for table `rating_mapping`
--

CREATE TABLE IF NOT EXISTS `rating_mapping` (
  `id_rating` int(11) NOT NULL AUTO_INCREMENT,
  `id_season` int(11) NOT NULL,
  `id_place` int(11) NOT NULL,
  `rating` double NOT NULL DEFAULT '0',
  `num_of_user_rated` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_rating`),
  KEY `season_rating_mapping_fk` (`id_season`),
  KEY `place_rating_mapping_fk` (`id_place`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `season`
--

CREATE TABLE IF NOT EXISTS `season` (
  `id_season` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `starting_date` date NOT NULL,
  `ending_date` date NOT NULL,
  PRIMARY KEY (`id_season`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `season`
--

INSERT INTO `season` (`id_season`, `name`, `description`, `starting_date`, `ending_date`) VALUES
(1, 'summer', 'summer', '2015-03-28', '2015-05-28');

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE IF NOT EXISTS `type` (
  `id_type` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_type`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`id_type`, `name`, `description`) VALUES
(1, 'User', 'App user');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `validity` tinyint(1) NOT NULL DEFAULT '0',
  `sex` varchar(10) NOT NULL,
  `dob` date DEFAULT NULL,
  `id_type` int(11) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `user_unq` (`email`),
  KEY `type_user_fk` (`id_type`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `user_id`, `user_name`, `email`, `password`, `validity`, `sex`, `dob`, `id_type`) VALUES
(1, 1123, 'hfjhdhh', 'hhdhudjh', 'hhhh', 1, 'Client', NULL, 1),
(2, 1123, 'yfyff', 'RR t hgh', 'jjjj', 0, 'Client', NULL, 1),
(3, 1123, 'fujbff', 'gydghii', 'hhhhh', 0, 'Client', NULL, 1),
(4, 1123, 'dgff', 'xghgfgj', 'gggg', 1, 'Client', NULL, 1),
(5, 1123, 'rrrr', 'rrrr', 'rrrr', 1, 'Client', NULL, 1),
(6, 1026665, 'fhjhfd', 'chjj@ghhh.ghh', 'jjjjj', 0, 'Male', NULL, 1),
(7, 505645, 'fhjhfd', 'chjj@ghh', '12345', 0, 'Male', NULL, 1),
(9, 814366, 'fihfd', 'rownak.sust@gmail.com', '12345', 1, 'Male', NULL, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `district_location_fk` FOREIGN KEY (`id_district`) REFERENCES `district` (`id_district`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `photos`
--
ALTER TABLE `photos`
  ADD CONSTRAINT `place_photos_fk` FOREIGN KEY (`id_place`) REFERENCES `place` (`id_place`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `season_photos_fk` FOREIGN KEY (`id_season`) REFERENCES `season` (`id_season`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `user_photos_fk` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `place`
--
ALTER TABLE `place`
  ADD CONSTRAINT `location_place_fk` FOREIGN KEY (`id_location`) REFERENCES `location` (`id_location`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rating_mapping`
--
ALTER TABLE `rating_mapping`
  ADD CONSTRAINT `place_rating_mapping_fk` FOREIGN KEY (`id_place`) REFERENCES `place` (`id_place`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `season_rating_mapping_fk` FOREIGN KEY (`id_season`) REFERENCES `season` (`id_season`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `type_user_fk` FOREIGN KEY (`id_type`) REFERENCES `type` (`id_type`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
