package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class NiveauQualificationDAO
 */
@Stateless
@LocalBean
public class NiveauQualificationDAO {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
	
    public NiveauQualificationDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public NiveauQualification findById(Integer id) {
		return entityManager.find(NiveauQualification.class, id);
	}
    
    public List<NiveauQualification> findAll() {
		Query query = entityManager
				.createQuery("select nq from NiveauQualification nq order by nq.idNq");
		List<NiveauQualification> l = query.getResultList();

		return (List<NiveauQualification>) l;
	}
	// -----------------------------------------------------------------------------
	public NiveauQualification persist(NiveauQualification nq) {
		entityManager.persist(nq);
		return nq;
	}

	// -----------------------------------------------------------------------------
	public NiveauQualification update(NiveauQualification nq) {
		NiveauQualification niv = entityManager.merge(nq);
		return niv;
	}
	// -----------------------------------------------------------------------------
	public void remove(NiveauQualification nq) {
		entityManager.remove(nq);
	}
	// -----------------------------------------------------------------------------
}
