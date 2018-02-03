CREATE TABLE Personne(
        id_personne             int (11) Auto_increment  NOT NULL ,
        pseudo_personne         Varchar (25) ,
        prenom_personne         Char (25) ,
        nom_personne            Char (25) ,
        date_naissance_personne Char (8) ,
        mdp_personne            Varchar (25) ,
        PRIMARY KEY (id_personne ) ,
        UNIQUE (pseudo_personne )
)ENGINE=InnoDB;