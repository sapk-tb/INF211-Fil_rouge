package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Niveauqualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite;

@Remote
public interface IServiceCandidature {

	public Candidature getCandidature(int id);
	public List<Candidature> listeDesCandidatures();
	public void setCandidature(String nom, String prenom, Date date_naissance, String adresse_postale, String adresse_email, String cv, Niveauqualification niveau, Set<Secteuractivite> secteurs);
}
