-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 07 Juillet 2021 à 03:48
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `gestion comptes`
--

-- --------------------------------------------------------

--
-- Structure de la table `t_client`
--

CREATE TABLE IF NOT EXISTS `t_client` (
  `numClient` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  `Contact` int(11) NOT NULL,
  `solde` double NOT NULL,
  `numCompte` int(11) NOT NULL,
  PRIMARY KEY (`numClient`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `t_client`
--

INSERT INTO `t_client` (`numClient`, `nom`, `prenom`, `adresse`, `Contact`, `solde`, `numCompte`) VALUES
(1, 'sami', 'raw', 'nabeul', 50664115, 14, 14),
(2, 'nermin', 'baatout', 'ball', 5066411, 70, 15),
(3, 'nermine', 'mmmm', 'sousse', 50664115, 50, 14);

-- --------------------------------------------------------

--
-- Structure de la table `t_operation`
--

CREATE TABLE IF NOT EXISTS `t_operation` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  `montant` double NOT NULL,
  `numClient` int(11) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
