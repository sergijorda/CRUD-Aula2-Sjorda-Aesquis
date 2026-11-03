CREATE DATABASE IF NOT EXISTS DAM2;
USE DAM2;

DROP TABLE IF EXISTS Professors;

CREATE TABLE Professors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    cognoms VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS ModulsProfessionals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    id_professor INT,
    FOREIGN KEY (id_professor) REFERENCES Professors(id) ON DELETE SET NULL
);

INSERT INTO ModulsProfessionals (nom, id_professor) VALUES ('Accés a Dades', 1);
INSERT INTO ModulsProfessionals (nom, id_professor) VALUES ('Desenvolupament d Interfícies', 1);
INSERT INTO ModulsProfessionals (nom, id_professor) VALUES ('Programació Multimèdia', 2);
