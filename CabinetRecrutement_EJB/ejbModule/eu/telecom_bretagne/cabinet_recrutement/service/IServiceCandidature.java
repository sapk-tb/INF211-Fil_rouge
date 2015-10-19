package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;

@Remote
public interface IServiceCandidature {

	public Candidature getCandidature(int id);
	public List<Candidature> listeDesCandidatures();
}
