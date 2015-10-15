package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Niveauqualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite;

/**
 * Session Bean implementation class CandidatureDAO
 */
@Stateless
@LocalBean
public class CandidatureDAO {

	/**
	 * Référence vers le gestionnaire de persistance.
	 */
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
    public CandidatureDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public Candidature findById(Integer id) {
		return entityManager.find(Candidature.class, id);
	}
    
    public List<Candidature> findAll() {
		Query query = entityManager
				.createQuery("select candidature from Candidature candidature order by candidature.idCandid");
		List l = query.getResultList();

		return (List<Candidature>) l;
	}
	// -----------------------------------------------------------------------------
	public Candidature persist(Candidature candidature) {
		entityManager.persist(candidature);
		return candidature;
	}

	// -----------------------------------------------------------------------------
	public Candidature update(Candidature candidature) {
		Candidature c = entityManager.merge(candidature);
		return c;
	}
	// -----------------------------------------------------------------------------
	public void remove(Candidature candidature) {
		if(!entityManager.contains(candidature)) candidature = entityManager.merge(candidature);
		entityManager.remove(candidature);
	}
	// -----------------------------------------------------------------------------

	public List<Candidature> findSpecific(Secteuractivite sa, Niveauqualification nq){
		Query query = entityManager
				.createQuery("select candidature from Candidature candidature join candidature.Niveauqualification niveauQ"
						   + "where niveauQ.idNq = :IdNQ and candidature.Secteuractivite secteur"
						   + " where secteur.idSa = :IdSA order by candidature.idCandid desc");
		query.setParameter("IdSA", sa);
		query.setParameter("IdNQ", nq);
		
		List<Candidature> l = query.getResultList();

		return l;
	}
}
