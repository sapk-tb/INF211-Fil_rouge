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
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class CandidatureDAO
 */
@Stateless
@LocalBean
public class OffreEmploiDAO {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
	
    public OffreEmploiDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public OffreEmploi findById(Integer id) {
		return entityManager.find(OffreEmploi.class, id);
	}
    
    public List<OffreEmploi> findAll() {
		Query query = entityManager
				.createQuery("select offre from OffreEmploi offre order by offre.idOffre");
		List<OffreEmploi> l = query.getResultList();

		return (List<OffreEmploi>) l;
	}
	// -----------------------------------------------------------------------------
	public OffreEmploi persist(OffreEmploi offre) {
		entityManager.persist(offre);
		return offre;
	}

	// -----------------------------------------------------------------------------
	public OffreEmploi update(OffreEmploi offre) {
		OffreEmploi o = entityManager.merge(offre);
		return o;
	}
	// -----------------------------------------------------------------------------
	public void remove(OffreEmploi offre) {
		entityManager.remove(offre);
	}
	// -----------------------------------------------------------------------------

	public List<OffreEmploi> findByEntreprise(int IdEnt){
		Query query = entityManager
				.createQuery("select offre from OffreEmloi offre where offre.entreprise.idEnt = :IdENT order by offre.idOffre desc");
		query.setParameter("IdENT", IdEnt);
		
		List<OffreEmploi> l = query.getResultList();

		return l;
	}
	
	public List<OffreEmploi> findBySecteurActiviteAndNiveauQualification(int idSecteurActivite, int idNiveauQualification)
	{
	Query query = entityManager.createQuery("select oe from OffreEmploi oe join oe.secteurActivite secteurs " +
	"where secteurs.idSa = :idSA and oe.niveauQualification.idNq = :idNQ " +
	"order by oe.id desc");
	query.setParameter("idSA", idSecteurActivite);
	query.setParameter("idNQ", idNiveauQualification);
	List<OffreEmploi> l = query.getResultList();
	return l;
	}
	
}
