package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreemploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Niveauqualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Offreemploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite;

/**
 * Session Bean implementation class ServiceOffreemploi
 */
@Stateless
@LocalBean
public class ServiceOffreemploi implements IServiceOffreemploi {

	@EJB 
	private OffreemploiDAO offreemploiDAO; 
    /**
     * Default constructor. 
     */
    public ServiceOffreemploi() { 
        // TODO Auto-generated constructor stub
    }

	@Override
	public Offreemploi getOffreemploi(int id) {
		return offreemploiDAO.findById(id);
	}

	@Override
	public List<Offreemploi> listeDesOffreemploi() {
		return offreemploiDAO.findAll();
	}

	@Override
	public List<Offreemploi> listeDesOffresPourUneEntreprise(int id) {
		return offreemploiDAO.findByEntreprise(id);
	}

	@Override
	public void setOffreemploi(String titre, String descriptifmission, String profilrecherche, Niveauqualification niveau, Set<Secteuractivite> secteurs) {
		Offreemploi nouvelleOffreemploi = new Offreemploi();
		nouvelleOffreemploi.setTitre(titre);
		nouvelleOffreemploi.setDescriptifmission(descriptifmission);
		nouvelleOffreemploi.setDatedepot(new Date());
		nouvelleOffreemploi.setNiveauqualification(niveau);
		nouvelleOffreemploi.setSecteuractivites(secteurs);
		offreemploiDAO.persist(nouvelleOffreemploi);
	}

}
