-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 14, 2014 at 12:43 PM
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `photos`
--

CREATE TABLE IF NOT EXISTS `photos` (
  `id_photos` int(11) NOT NULL AUTO_INCREMENT,
  `lat` double NOT NULL,
  `lang` double NOT NULL,
  `rating` double NOT NULL DEFAULT '0',
  `num_of_user_rated` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `id_season` int(11) NOT NULL,
  `id_place` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `photo_url` varchar(100) NOT NULL,
  PRIMARY KEY (`id_photos`),
  KEY `season_photos_fk` (`id_season`),
  KEY `place_photos_fk` (`id_place`),
  KEY `user_photos_fk` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `rating_mapping`
--

CREATE TABLE IF NOT EXISTS `rating_mapping` (
  `id_rating` int(11) NOT NULL AUTO_INCREMENT,
  `id_season` int(11) NOT NULL,
  `id_place` int(11) NOT NULL,
  `rating` double NOT NULL DEFAULT '0',
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE IF NOT EXISTS `type` (
  `id_type` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `validity` tinyint(1) NOT NULL DEFAULT '0',
  `sex` varchar(10) NOT NULL,
  `dob` date DEFAULT NULL,
  `id_type` int(11) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `user_unq` (`email`),
  KEY `type_user_fk` (`id_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
  ADD CONSTRAINT `user_photos_fk` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `place_photos_fk` FOREIGN KEY (`id_place`) REFERENCES `place` (`id_place`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `season_photos_fk` FOREIGN KEY (`id_season`) REFERENCES `season` (`id_season`) ON DELETE NO ACTION ON UPDATE NO ACTION;

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
