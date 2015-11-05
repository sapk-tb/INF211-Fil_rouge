package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreemploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Offreemploi;

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

}
