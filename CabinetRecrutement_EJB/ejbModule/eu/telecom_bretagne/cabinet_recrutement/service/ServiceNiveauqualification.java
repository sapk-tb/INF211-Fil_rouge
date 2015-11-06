package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.NiveauqualificationDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Niveauqualification;

/**
 * Session Bean implementation class ServiceNiveauqualification
 */
@Stateless
@LocalBean
public class ServiceNiveauqualification implements IServiceNiveauqualification {

	@EJB 
	private NiveauqualificationDAO niveauqualificationDAO; 
    /**
     * Default constructor. 
     */
    public ServiceNiveauqualification() { 
        // TODO Auto-generated constructor stub
    }

	@Override
	public Niveauqualification getNiveauqualification(int id) {
		return niveauqualificationDAO.findById(id);
	}

	@Override
	public List<Niveauqualification> listeDesNiveauqualification() {
		return niveauqualificationDAO.findAll();
	}

}
