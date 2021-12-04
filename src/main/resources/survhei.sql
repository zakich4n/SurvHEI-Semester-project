-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : ven. 03 déc. 2021 à 09:41
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `dbsurvhei`
--

-- --------------------------------------------------------

--
-- Structure de la table `formulaire`
--

DROP TABLE IF EXISTS `formulaire`;
CREATE TABLE IF NOT EXISTS `formulaire` (
                                            `id_formulaire` int(11) NOT NULL AUTO_INCREMENT,
                                            `nom_formulaire` varchar(80) NOT NULL,
                                            `nombre_de_question` int(11) NOT NULL,
                                            `temps_moyen` int(11) NOT NULL,
                                            `actif` tinyint(1) NOT NULL,
                                            `anonyme` tinyint(1) NOT NULL,
                                            `id_user_createur` int(11) NOT NULL,
                                            PRIMARY KEY (`id_formulaire`),
                                            KEY `id_user_createur` (`id_user_createur`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `formulaire`
--

INSERT INTO `formulaire` (`id_formulaire`, `nom_formulaire`, `nombre_de_question`, `temps_moyen`, `actif`, `anonyme`, `id_user_createur`) VALUES
                                                                                                                                              (1, 'Test', 3, 3, 1, 1, 1),
                                                                                                                                              (3, 'Test2', 2, 2, 1, 1, 1),
                                                                                                                                              (7, 'J\'espere que ca va marcher', 3, 7, 1, 0, 7),
                                                                                                                                              (8, 'tre', 3, 3, 1, 0, 7),
                                                                                                                                              (9, 'tre11', 3, 3, 1, 0, 7),
                                                                                                                                              (10, 'tre111111', 3, 3, 1, 0, 7),
                                                                                                                                              (12, 'Rhoooo', 3, 3, 1, 1, 7),
                                                                                                                                              (13, '1554test', 3, 2, 1, 0, 7),
                                                                                                                                              (14, 'zaki', 3, 6, 1, 1, 7),
                                                                                                                                              (15, 'hich', 3, 3, 1, 1, 7);

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
                                          `id_question` int(11) NOT NULL AUTO_INCREMENT,
                                          `obligatoire` tinyint(1) NOT NULL,
                                          `id_formulaire_correspondant` int(11) NOT NULL,
                                          `question` varchar(80) NOT NULL,
                                          `ordre_question` tinyint(4) NOT NULL,
                                          PRIMARY KEY (`id_question`),
                                          KEY `id_formulaire_correspondant` (`id_formulaire_correspondant`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `question`
--

INSERT INTO `question` (`id_question`, `obligatoire`, `id_formulaire_correspondant`, `question`, `ordre_question`) VALUES
                                                                                                                       (15, 1, 1, 'Etienne est plus beau que dieu ?', 1),
                                                                                                                       (16, 0, 1, 'Certainement plus sexy que Appolon ?', 2),
                                                                                                                       (17, 1, 1, 'Etienne >>>>> Tout ? (oui)', 3),
                                                                                                                       (18, 1, 1, 'je ne sais pas ', 1),
                                                                                                                       (19, 1, 1, 'test', 2),
                                                                                                                       (20, 0, 1, 'yuzedy', 3),
                                                                                                                       (21, 1, 1, 'je ne sais pas ', 1),
                                                                                                                       (22, 1, 1, 'test', 2),
                                                                                                                       (23, 0, 1, 'yuzedy', 3),
                                                                                                                       (27, 1, 13, 'test', 1),
                                                                                                                       (28, 0, 13, 'z', 2),
                                                                                                                       (29, 0, 13, 'z', 3),
                                                                                                                       (30, 1, 14, 'couue', 1),
                                                                                                                       (31, 0, 14, 'zdzxe', 2),
                                                                                                                       (32, 1, 14, 'xeerx', 3),
                                                                                                                       (33, 1, 15, 'coucou', 1),
                                                                                                                       (34, 0, 15, 'culcul', 2),
                                                                                                                       (35, 1, 15, 'pipi', 3);

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

DROP TABLE IF EXISTS `reponse`;
CREATE TABLE IF NOT EXISTS `reponse` (
                                         `id_question` int(11) NOT NULL,
                                         `id_user` int(11) NOT NULL,
                                         `reponse_oui_non` tinyint(1) NOT NULL,
                                         PRIMARY KEY (`id_question`,`id_user`),
                                         KEY `id_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `survhei_user`
--

DROP TABLE IF EXISTS `survhei_user`;
CREATE TABLE IF NOT EXISTS `survhei_user` (
                                              `IDUser` int(11) NOT NULL AUTO_INCREMENT,
                                              `User` varchar(80) NOT NULL,
                                              `Password` text NOT NULL,
                                              `DateCreation` date NOT NULL DEFAULT curdate(),
                                              `Email` varchar(80) NOT NULL,
                                              `Nom` varchar(80) NOT NULL,
                                              `Prenom` varchar(80) NOT NULL,
                                              `DateNaissance` datetime NOT NULL,
                                              `Sexe` varchar(80) NOT NULL,
                                              `IsAdmin` tinyint(1) DEFAULT NULL,
                                              PRIMARY KEY (`IDUser`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `survhei_user`
--

INSERT INTO `survhei_user` (`IDUser`, `User`, `Password`, `DateCreation`, `Email`, `Nom`, `Prenom`, `DateNaissance`, `Sexe`, `IsAdmin`) VALUES
                                                                                                                                            (1, 'JT', '$argon2i$v=19$m=65536,t=5,p=1$1DJrdZSunEqkB02a55n4jECr3kQPfVATQRvCj793Q6i2ttaesFTQrsGafYL5nNDTKsnhtQ2QyWpX0grg9bbUSwEHO6j5PFPalDEJCdr8vN7l/8QBIJKDuqsG+68qgcast2dDrfT+6iGaSNfbhXfcNLwMnajLpvBSrZg/0LGwRI8$/rfPBOYIJBfNRy/4Ir64PthiHFPXmw85PGtTSv1IpIuKc30BAYxKP/CxHgrN2pHdYt2OloCLXPaEI+lQ5tP2GQhUHmUh6dne/WLKMnA93unymauotO4fRs+DvOMCjhH7vUqKqxly7p4QMRz6k3ZNQkRq2yJQ3PjhQwl6vbyLlPE', '2021-11-23', 'jtblanqui@hotmail.fr', 'Blanqui', 'Julien-TiÃªn', '2000-01-08 00:00:00', 'm', 1),
                                                                                                                                            (5, 'user', '$argon2i$v=19$m=65536,t=5,p=1$rIJ8SimMXNLHfgRRgdfdcnXXbTt800WgkhvDVYTJLMr0TOrwIFSdOhzBFLOxkAiwH/dxH0f9JKKQRtb0Ioib1CTEG3VvDPpUhXy0lV62fZ+M6tcSetSH22QD6oVua3LI9lD2sIMvoonQ7w0koqvScqFlpPk/5hu4XeZmBGl0jX4$N40UQITIpvcQ1aqNhtxIZ8UkvMAl2xuIByJ9UeDwU7vjF6rOl/8FKZ4iE9c5Bns7uxTJeaIee6rSxyzttzsHht0XR4jJ+CoP3La2yKsRkS75dJYM2ddiejwUTLPThkUV7QmrESJ5HHhiB6DPTZGG9nC9rDbnZVopdRnxCxAyO28', '2021-11-23', 'user@hotmail.fr', 'user', 'user', '2000-01-01 00:00:00', 'm', NULL),
                                                                                                                                            (7, 'admin', '$argon2i$v=19$m=65536,t=5,p=1$bWJVTu+DBEqnvB30/Xvhw7VB0fHMkdA5GsmPRGtxnSWbpBvfJrH7OmIBdea5JtZrZ/qOTkV5pxd/7hOhkB46hKePNGXsbXvI+CsL5pQNs+gmDTAxls2zLdpYa7CYxj0ljqfBFL7TW8UHrXLwMhJP5Xspt7uxDqtJ4aldrNgCOE4$FChvTq//gkdbHcBBdOLQx11yqu8RLc86wL+sFFPxjM2TQ1BMwJXMB21Ol4xl0QlelupUmumFL5f+Kg5ifxfxpo9nLLfRqHEMUQB6j1W/4kWyxGEK3SC7D/Ite3ZlRsLnrrzRp7NGQhDiTXpSXIoF6xlOrGe2G7ABKAMejt8hu8Y', '2021-11-23', 'admin@hotmail.fr', 'admin', 'admin', '2000-01-01 00:00:00', 'm', 1);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `formulaire`
--
ALTER TABLE `formulaire`
    ADD CONSTRAINT `formulaire_ibfk_1` FOREIGN KEY (`id_user_createur`) REFERENCES `survhei_user` (`IDUser`);

--
-- Contraintes pour la table `question`
--
ALTER TABLE `question`
    ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`id_formulaire_correspondant`) REFERENCES `formulaire` (`id_formulaire`);

--
-- Contraintes pour la table `reponse`
--
ALTER TABLE `reponse`
    ADD CONSTRAINT `reponse_ibfk_1` FOREIGN KEY (`id_question`) REFERENCES `question` (`id_question`),
    ADD CONSTRAINT `reponse_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `survhei_user` (`IDUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
