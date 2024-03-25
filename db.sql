CREATE TABLE `Bien` (
                        `id` int PRIMARY KEY AUTO_INCREMENT,
                        `date_creation` date,
                        `surface` int,
                        `nbPiece` int,
                        `type_eau_chaude` varchar(255),
                        `chauffage` varchar(255),
                        `type_bien` varchar(255),
                        `id_adresse` int,
                        `classification` varchar(255)
);

CREATE TABLE `Annexe` (
                          `id` int PRIMARY KEY AUTO_INCREMENT,
                          `num_bien` int,
                          `surface` int,
                          `num_annexe` int,
                          `nb_piece` int,
                          `description` varchar(255)
);

CREATE TABLE `Piece` (
                         `id` int PRIMARY KEY AUTO_INCREMENT,
                         `num_bien` int,
                         `id_affectation` int,
                         `description` varchar(255),
                         `surface` int,
                         `nb_murs` int,
                         `nb_portes` int,
                         `nb_fenetre` int,
                         `affectation_piece` varchar(255)
);

CREATE TABLE `Mobilier` (
                            `id` int PRIMARY KEY AUTO_INCREMENT,
                            `id_piece` int,
                            `description` varchar(255),
                            `nature` varchar(255)
);

CREATE TABLE `Adresse` (
                           `id` int PRIMARY KEY AUTO_INCREMENT,
                           `num_rue` int,
                           `nom_rue` varchar(255),
                           `code_postal` varchar(255),
                           `ville` varchar(255),
                           `etage` int,
                           `num_logement` int
);

ALTER TABLE `Annexe` ADD FOREIGN KEY (`num_bien`) REFERENCES `Bien` (`id`);

ALTER TABLE `Piece` ADD FOREIGN KEY (`num_bien`) REFERENCES `Bien` (`id`);

ALTER TABLE `Mobilier` ADD FOREIGN KEY (`id_piece`) REFERENCES `Piece` (`id`);

ALTER TABLE `Bien` ADD FOREIGN KEY (`id_adresse`) REFERENCES `Adresse` (`id`);
