CREATE TABLE Compte(
        id_compte    int (11) Auto_increment  NOT NULL ,
        login_compte Varchar (25) ,
        mdp_compte   Varchar (25) ,
        nom_site     Varchar (25) ,
        adresse_site Varchar (255) ,
        id_personne  Int ,
        PRIMARY KEY (id_compte )
)ENGINE=InnoDB;