package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class SecteurActiviteDAO
 */
@Stateless
@LocalBean
public class SecteurActiviteDAO {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
	
    public SecteurActiviteDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public SecteurActivite findById(Integer id) {
		return entityManager.find(SecteurActivite.class, id);
	}
    
    public List<SecteurActivite> findAll() {
		Query query = entityManager
				.createQuery("select sa from SecteurActivite sa order by sa.idSA");
		List<SecteurActivite> l = query.getResultList();

		return (List<SecteurActivite>) l;
	}
	// -----------------------------------------------------------------------------
	public SecteurActivite persist(SecteurActivite sa) {
		entityManager.persist(sa);
		return sa;
	}

	// -----------------------------------------------------------------------------
	public SecteurActivite update(SecteurActivite sa) {
		SecteurActivite secteur = entityManager.merge(sa);
		return secteur;
	}
	// -----------------------------------------------------------------------------
	public void remove(SecteurActivite sa) {
		entityManager.remove(sa);
	}
	// -----------------------------------------------------------------------------
}
