create table adresse
(
    id          int auto_increment,
    num_rue     int          null,
    nom_rue     varchar(255) null,
    code_postal varchar(255) null,
    ville       varchar(255) null
)
    comment 'Table ''michka.adresse'' doesn''t exist in engine';

create table annexe
(
    id          int auto_increment,
    num_bien    int          null,
    surface     int          null,
    num_annexe  int          null,
    nb_piece    int          null,
    description varchar(255) null
)
    comment 'Table ''michka.annexe'' doesn''t exist in engine';

create table bien
(
    id              int auto_increment,
    date_creation   date         null,
    surface         int          null,
    nbPiece         int          null,
    type_eau_chaude varchar(255) null,
    chauffage       varchar(255) null,
    type_bien       varchar(255) null,
    id_adresse      int          null,
    classification  varchar(255) null,
    etage           int          null,
    num_logement    int          null
)
    comment 'Table ''michka.bien'' doesn''t exist in engine';

create table mobilier
(
    id          int auto_increment,
    id_piece    int          null,
    description varchar(255) null,
    nature      varchar(255) null
)
    comment 'Table ''michka.mobilier'' doesn''t exist in engine';

create table piece
(
    id                int auto_increment,
    num_bien          int          null,
    id_affectation    int          null,
    description       varchar(255) null,
    surface           int          null,
    nb_murs           int          null,
    nb_portes         int          null,
    nb_fenetre        int          null,
    affectation_piece varchar(255) null
)
    comment 'Table ''michka.piece'' doesn''t exist in engine';

