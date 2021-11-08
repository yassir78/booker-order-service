-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 18 oct. 2021 à 10:49
-- Version du serveur : 10.4.20-MariaDB
-- Version de PHP : 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `booker-order`
--

-- --------------------------------------------------------

--
-- Structure de la table `customer_order`
--

CREATE TABLE `customer_order` (
  `id` bigint(20) NOT NULL,
  `buyer_ref` varchar(255) DEFAULT NULL,
  `order_amount` decimal(19,2) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `ref` varchar(255) DEFAULT NULL,
  `seller_ref` varchar(255) DEFAULT NULL,
  `ship_to_address` varchar(255) DEFAULT NULL,
  `ship_to_date` date DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;


-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `order_item`
--

CREATE TABLE `order_item` (
  `id` bigint(20) NOT NULL,
  `product_ref` bigint(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total` decimal(19,2) DEFAULT NULL,
  `related_customer_order_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `order_status`
--

CREATE TABLE `order_status` (
  `id` bigint(20) NOT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `customer_order`
--
ALTER TABLE `customer_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKotljpo0rbqv8lu1hhymcfy0go` (`status_id`);



--
-- Index pour la table `order_item`
--
ALTER TABLE `order_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh2k69tdfjro8iccvs4nwardlw` (`related_customer_order_id`);

--
-- Index pour la table `order_status`
--
ALTER TABLE `order_status`
  ADD PRIMARY KEY (`id`);
COMMIT;
INSERT INTO `customer_order` (`id`, `buyer_ref`, `order_amount`, `order_date`, `ref`, `seller_ref`, `ship_to_address`, `ship_to_date`, `status_id`) VALUES
(2, 'buyerRef1', '1990.00', '2022-09-22', 'ref1', 'sellerRef1', 'ship to address 1', '2022-10-22', 1),
(5, 'buyerRef2', '1990.00', '2022-09-23', 'ref2', 'sellerRef2', 'ship to address 2', '2022-10-24', 4);
--
-- Déchargement des données de la table `order_item`
--

INSERT INTO `order_item` (`id`, `product_ref`, `quantity`, `total`, `related_customer_order_id`) VALUES
(3, 1, 5, '44.00', 2),
(6, 2, 5, '54.00', 5);

-- --------------------------------------------------------


--
-- Déchargement des données de la table `order_status`
--

INSERT INTO `order_status` (`id`, `status`) VALUES
(1, 'new'),
(4, 'packed');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
