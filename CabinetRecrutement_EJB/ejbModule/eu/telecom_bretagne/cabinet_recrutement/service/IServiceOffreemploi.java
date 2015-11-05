package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Offreemploi;

@Remote
public interface IServiceOffreemploi {

	public Offreemploi getOffreemploi(int id);
	public List<Offreemploi> listeDesOffreemploi();
	public List<Offreemploi> listeDesOffresPourUneEntreprise(int id);
}