ALTER TABLE Compte ADD CONSTRAINT FK_Compte_id_personne FOREIGN KEY (id_personne) REFERENCES Personne(id_personne);
