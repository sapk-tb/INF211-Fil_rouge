package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.SecteuractiviteDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite;

/**
 * Session Bean implementation class ServiceSecteuractivite
 */
@Stateless
@LocalBean
public class ServiceSecteuractivite implements IServiceSecteuractivite {

	@EJB 
	private SecteuractiviteDAO secteuractiviteDAO; 
    /**
     * Default constructor. 
     */
    public ServiceSecteuractivite() { 
        // TODO Auto-generated constructor stub
    }

	@Override
	public Secteuractivite getSecteuractivite(int id) {
		return secteuractiviteDAO.findById(id);
	}

	@Override
	public List<Secteuractivite> listeDesSecteuractivite() {
		return secteuractiviteDAO.findAll();
	}

}
