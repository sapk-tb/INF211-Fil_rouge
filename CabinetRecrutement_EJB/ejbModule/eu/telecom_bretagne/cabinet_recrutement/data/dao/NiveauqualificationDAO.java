package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Niveauqualification;

/**
 * Session Bean implementation class NiveauqualificationDAO
 */
@Stateless
@LocalBean
public class NiveauqualificationDAO {

	/**
	 * Référence vers le gestionnaire de persistance.
	 */
	@PersistenceContext
	EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public NiveauqualificationDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public Niveauqualification findById(Integer id) {
		return entityManager.find(Niveauqualification.class, id);
	}
    
    public List<Niveauqualification> findAll() {
		Query query = entityManager
				.createQuery("select nq from Niveauqualification nq order by nq.idNq");
		List l = query.getResultList();

		return (List<Niveauqualification>) l;
	}
	// -----------------------------------------------------------------------------
	public Niveauqualification persist(Niveauqualification nq) {
		entityManager.persist(nq);
		return nq;
	}

	// -----------------------------------------------------------------------------
	public Niveauqualification update(Niveauqualification nq) {
		Niveauqualification niv = entityManager.merge(nq);
		return niv;
	}
	// -----------------------------------------------------------------------------
}
