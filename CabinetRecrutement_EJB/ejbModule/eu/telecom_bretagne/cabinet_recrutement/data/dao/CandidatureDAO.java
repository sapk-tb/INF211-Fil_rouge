package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class CandidatureDAO
 */
@Stateless
@LocalBean
public class CandidatureDAO {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
	
    public CandidatureDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public Candidature findById(Integer id) {
		return entityManager.find(Candidature.class, id);
	}
    
    public List<Candidature> findAll() {
		Query query = entityManager
				.createQuery("select candidature from Candidature candidature order by candidature.idCandid");
		List<Candidature> l = query.getResultList();

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
		entityManager.remove(candidature);
	}
	// -----------------------------------------------------------------------------

	public List<Candidature> findSpecific(SecteurActivite sa, NiveauQualification nq){
		Query query = entityManager
				.createQuery("select candidature from Candidature candidature join candidature.niveauQualification niveauQ"
						   + "where niveauQ.idNq = :IdNQ and candidature.secteurActivite secteur"
						   + " where secteur.idSa = :IdSA order by candidature.idCandid desc");
		query.setParameter("IdSA", sa);
		query.setParameter("IdNQ", nq);
		
		List<Candidature> l = query.getResultList();

		return l;
	}
}
