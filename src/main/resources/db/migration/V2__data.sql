-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 18 oct. 2021 à 12:14
-- Version du serveur : 10.4.20-MariaDB
-- Version de PHP : 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


--
-- Déchargement des données de la table `customer_order`
--

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


