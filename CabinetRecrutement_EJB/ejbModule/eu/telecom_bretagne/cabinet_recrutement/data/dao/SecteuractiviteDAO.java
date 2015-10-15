package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite;

/**
 * Session Bean implementation class SecteuractiviteDAO
 */
@Stateless
@LocalBean
public class SecteuractiviteDAO {

	/**
	 * Référence vers le gestionnaire de persistance.
	 */
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
    public SecteuractiviteDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public Secteuractivite findById(Integer id) {
		return entityManager.find(Secteuractivite.class, id);
	}
    
    public List<Secteuractivite> findAll() {
		Query query = entityManager
				.createQuery("select sa from Secteuractivite sa order by sa.idSa");
		List l = query.getResultList();

		return (List<Secteuractivite>) l;
	}
	// -----------------------------------------------------------------------------
	public Secteuractivite persist(Secteuractivite sa) {
		entityManager.persist(sa);
		return sa;
	}

	// -----------------------------------------------------------------------------
	public Secteuractivite update(Secteuractivite sa) {
		Secteuractivite secteur = entityManager.merge(sa);
		return secteur;
	}
	// -----------------------------------------------------------------------------
}
