package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Niveauqualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Offreemploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite;

@Remote
public interface IServiceOffreemploi {

	public Offreemploi getOffreemploi(int id);
	public List<Offreemploi> listeDesOffreemploi();
	public List<Offreemploi> listeDesOffresPourUneEntreprise(int id);
	public List<Offreemploi> listeDesOffresPourUneCandidature(Candidature candidature);
	public void setOffreemploi(String titre, String descriptifmission, String profilrecherche, Entreprise entreprise, Niveauqualification niveau, Set<Secteuractivite> secteurs);
}