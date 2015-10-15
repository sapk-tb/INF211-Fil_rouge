drop table if exists "entreprise" CASCADE;
drop table if exists "niveauqualification" CASCADE;
drop table if exists "secteuractivite" CASCADE;
drop table if exists "offreemploi" CASCADE;
drop table if exists "candidature" CASCADE;
drop table if exists "liaisonoffresecteur" CASCADE;
drop table if exists "liaisonsecteurcandidature" CASCADE;

CREATE TABLE entreprise (
	id_ent SERIAL NOT NULL PRIMARY KEY,
	nom VARCHAR(45) NOT NULL,
	descriptif VARCHAR(100),
	adressePostale VARCHAR(100)
);

CREATE TABLE niveauqualification (
id_NQ SERIAL NOT NULL PRIMARY KEY,
intitule VARCHAR(45) NOT NULL
);

CREATE TABLE secteuractivite (
id_SA SERIAL NOT NULL PRIMARY KEY,
intitule VARCHAR(45) NOT NULL
);

CREATE TABLE offreemploi (
	id_offre SERIAL NOT NULL PRIMARY KEY,	
	titre VARCHAR(45) NOT NULL,
	descriptifMission VARCHAR(1500),
	profilRecherche VARCHAR(45),
	dateDepot DATE,
	id_ent INTEGER NOT NULL,
    FOREIGN KEY (id_ent) REFERENCES entreprise(id_ent),
	id_NQ INTEGER NOT NULL,
    FOREIGN KEY (id_NQ) REFERENCES niveauqualification(id_NQ)
);

CREATE TABLE liaisonoffresecteur (
	id_offre INTEGER NOT NULL,
    FOREIGN KEY (id_offre) REFERENCES offreemploi(id_offre),
	id_SA INTEGER NOT NULL,
    FOREIGN KEY (id_SA) REFERENCES secteuractivite(id_SA),
    PRIMARY KEY (id_offre,id_SA)
);

CREATE TABLE candidature (
    id_candid SERIAL NOT NULL PRIMARY KEY,
    nom VARCHAR(45) NOT NULL,
    prenom VARCHAR(45) NOT NULL,
    dateNaissance DATE,
    adressePostale VARCHAR(100),
    adresseEmail VARCHAR(45),
    dateDepot DATE,
    curriculumVitae TEXT,
    id_NQ INTEGER NOT NULL,
    FOREIGN KEY (id_NQ) REFERENCES niveauqualification(id_NQ)
);

CREATE TABLE liaisonsecteurcandidature (
	id_SA INTEGER NOT NULL,
    FOREIGN KEY (id_SA) REFERENCES secteuractivite(id_SA),
	id_candid INTEGER NOT NULL,
    FOREIGN KEY (id_candid) REFERENCES candidature(id_candid),
	PRIMARY KEY (id_SA,id_candid)
);

INSERT INTO entreprise VALUES (nextval('entreprise_id_ent_seq'),'Télécom Bretagne','Télécom Bretagne est une grande école pionnière en formation, en recherche et en entrepreneuriat.','Plouzané');
INSERT INTO entreprise VALUES (nextval('entreprise_id_ent_seq'),'ENIB','Une école d''ingénieur juste à côté...','Plouzané');
INSERT INTO entreprise VALUES (nextval('entreprise_id_ent_seq'),'ENSSAT',null,'Lannion');
INSERT INTO niveauqualification VALUES (nextval('niveauqualification_id_NQ_seq'),'BAC');
INSERT INTO niveauqualification VALUES (nextval('niveauqualification_id_NQ_seq'),'BAC+2');
INSERT INTO niveauqualification VALUES (nextval('niveauqualification_id_NQ_seq'),'BAC+5');
INSERT INTO secteuractivite VALUES (nextval('secteuractivite_id_SA_seq'),'Informatique');
INSERT INTO secteuractivite VALUES (nextval('secteuractivite_id_SA_seq'),'Social');
INSERT INTO secteuractivite VALUES (nextval('secteuractivite_id_SA_seq'),'Finance');
