package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.CandidatureDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;

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

}
