package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.CandidatureDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Niveauqualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite;

/**
 * Session Bean implementation class ServiceCandidature
 */
@Stateless
@LocalBean
public class ServiceCandidature implements IServiceCandidature {

	@EJB 
	private CandidatureDAO candidatureDAO; 
    /**
     * Default constructor. 
     */
    public ServiceCandidature() { 
        // TODO Auto-generated constructor stub
    }

	@Override
	public Candidature getCandidature(int id) {
		return candidatureDAO.findById(id);
	}

	@Override
	public List<Candidature> listeDesCandidatures() {
		return candidatureDAO.findAll();
	}

	@Override
	public void setCandidature(String nom, String prenom, Date date_naissance, String adresse_postale, String adresse_email, String cv, Niveauqualification niveau, Set<Secteuractivite> secteurs) {
		Candidature nouvelleCandidature = new Candidature();
		nouvelleCandidature.setNom(nom);
		nouvelleCandidature.setPrenom(prenom);
		nouvelleCandidature.setDatenaissance(date_naissance);
		nouvelleCandidature.setDatedepot(new Date());
		nouvelleCandidature.setAdressepostale(adresse_postale);
		nouvelleCandidature.setAdresseemail(adresse_email);
		nouvelleCandidature.setCurriculumvitae(cv);
		nouvelleCandidature.setNiveauqualification(niveau);
		nouvelleCandidature.setSecteuractivites(secteurs);
		candidatureDAO.persist(nouvelleCandidature);
	}

}
