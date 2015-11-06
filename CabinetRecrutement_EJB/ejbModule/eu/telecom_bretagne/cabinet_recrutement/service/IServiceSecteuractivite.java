package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite;

@Remote
public interface IServiceSecteuractivite {

	public Secteuractivite getSecteuractivite(int id);
	public List<Secteuractivite> listeDesSecteuractivite();
}