package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Niveauqualification;

@Remote
public interface IServiceNiveauqualification {

	public Niveauqualification getNiveauqualification(int id);
	public List<Niveauqualification> listeDesNiveauqualification();
}