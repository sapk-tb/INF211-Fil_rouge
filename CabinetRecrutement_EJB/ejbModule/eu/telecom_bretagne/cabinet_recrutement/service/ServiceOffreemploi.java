package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreemploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
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
	public void setOffreemploi(String titre, String descriptifmission, String profilrecherche, Entreprise entreprise, Niveauqualification niveau, Set<Secteuractivite> secteurs) {
		Offreemploi nouvelleOffreemploi = new Offreemploi();
		nouvelleOffreemploi.setTitre(titre);
		nouvelleOffreemploi.setDescriptifmission(descriptifmission);
		nouvelleOffreemploi.setDatedepot(new Date());
		nouvelleOffreemploi.setNiveauqualification(niveau);
		nouvelleOffreemploi.setSecteuractivites(secteurs);
		nouvelleOffreemploi.setEntreprise(entreprise);
		offreemploiDAO.persist(nouvelleOffreemploi);
	}

	@Override
	public List<Offreemploi> listeDesOffresPourUneCandidature(Candidature candidature) {
		Niveauqualification niveau = candidature.getNiveauqualification();
		Set<Secteuractivite> secteurs_candidature = candidature.getSecteuractivites();
		List<Offreemploi> offres = offreemploiDAO.findAll();
		List<Offreemploi> liste_1 = new ArrayList<Offreemploi>();
		List<Offreemploi> liste_2 = new ArrayList<Offreemploi>();
		for(Offreemploi offre : offres) {
			if(niveau.getIdNq().equals(offre.getNiveauqualification().getIdNq())) liste_1.add(offre);
		}
		
		for(Offreemploi offre : liste_1) {
			boolean match = false;
			Set<Secteuractivite> secteurs_offre = offre.getSecteuractivites();
			for(Secteuractivite sec_o : secteurs_offre) {
				for(Secteuractivite sec_c : secteurs_candidature) {
					if(sec_o.getIdSa().equals(sec_c.getIdSa())) match = true;
				}
			}
			if(match) liste_2.add(offre);
		}
		
		return liste_1;
	}

}
