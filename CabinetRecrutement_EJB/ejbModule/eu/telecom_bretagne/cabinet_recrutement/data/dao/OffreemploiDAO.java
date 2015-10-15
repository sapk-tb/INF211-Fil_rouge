package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Niveauqualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Offreemploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite;

/**
 * Session Bean implementation class CandidatureDAO
 */
@Stateless
@LocalBean
public class OffreemploiDAO {

	/**
	 * Référence vers le gestionnaire de persistance.
	 */
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
    public OffreemploiDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public Offreemploi findById(Integer id) {
		return entityManager.find(Offreemploi.class, id);
	}
    
    public List<Offreemploi> findAll() {
		Query query = entityManager
				.createQuery("select offre from Offreemploi offre order by offre.idOffre");
		List l = query.getResultList();

		return (List<Offreemploi>) l;
	}
	// -----------------------------------------------------------------------------
	public Offreemploi persist(Offreemploi offre) {
		entityManager.persist(offre);
		return offre;
	}

	// -----------------------------------------------------------------------------
	public Offreemploi update(Offreemploi offre) {
		Offreemploi o = entityManager.merge(offre);
		return o;
	}
	// -----------------------------------------------------------------------------
	public void remove(Offreemploi offre) {
		if(!entityManager.contains(offre)) offre = entityManager.merge(offre);
		entityManager.remove(offre);
	}
	// -----------------------------------------------------------------------------

	public List<Offreemploi> findByEntreprise(int IdEnt){
		Query query = entityManager
				.createQuery("select offre from OffreEmloi offre where offre.entreprise.idEnt = :IdENT order by offre.idOffre desc");
		query.setParameter("IdENT", IdEnt);
		
		List<Offreemploi> l = query.getResultList();

		return l;
	}
	
	public List<Offreemploi> findBySecteuractiviteAndNiveauqualification(int idSecteuractivite, int idNiveauqualification)
	{
	Query query = entityManager.createQuery("select oe from Offreemploi oe join oe.Secteuractivite secteurs " +
	"where secteurs.idSa = :idSA and oe.Niveauqualification.idNq = :idNQ " +
	"order by oe.id desc");
	query.setParameter("idSA", idSecteuractivite);
	query.setParameter("idNQ", idNiveauqualification);
	List<Offreemploi> l = query.getResultList();
	return l;
	}
	
}
