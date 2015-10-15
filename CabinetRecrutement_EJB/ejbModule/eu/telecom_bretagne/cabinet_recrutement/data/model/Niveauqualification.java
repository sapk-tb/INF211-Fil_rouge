package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the niveauqualification database table.
 * 
 */
@Entity
@NamedQuery(name="Niveauqualification.findAll", query="SELECT n FROM Niveauqualification n")
public class Niveauqualification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NIVEAUQUALIFICATION_IDNQ_GENERATOR", sequenceName="NIVEAUQUALIFICATION_ID_NQ_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NIVEAUQUALIFICATION_IDNQ_GENERATOR")
	@Column(name="id_nq")
	private Integer idNq;

	private String intitule;

	//bi-directional many-to-one association to Candidature
	@OneToMany(mappedBy="niveauqualification")
	private Set<Candidature> candidatures;

	//bi-directional many-to-one association to Offreemploi
	@OneToMany(mappedBy="niveauqualification")
	private Set<Offreemploi> offreemplois;

	public Niveauqualification() {
	}

	public Integer getIdNq() {
		return this.idNq;
	}

	public void setIdNq(Integer idNq) {
		this.idNq = idNq;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Set<Candidature> getCandidatures() {
		return this.candidatures;
	}

	public void setCandidatures(Set<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

	public Candidature addCandidature(Candidature candidature) {
		getCandidatures().add(candidature);
		candidature.setNiveauqualification(this);

		return candidature;
	}

	public Candidature removeCandidature(Candidature candidature) {
		getCandidatures().remove(candidature);
		candidature.setNiveauqualification(null);

		return candidature;
	}

	public Set<Offreemploi> getOffreemplois() {
		return this.offreemplois;
	}

	public void setOffreemplois(Set<Offreemploi> offreemplois) {
		this.offreemplois = offreemplois;
	}

	public Offreemploi addOffreemploi(Offreemploi offreemploi) {
		getOffreemplois().add(offreemploi);
		offreemploi.setNiveauqualification(this);

		return offreemploi;
	}

	public Offreemploi removeOffreemploi(Offreemploi offreemploi) {
		getOffreemplois().remove(offreemploi);
		offreemploi.setNiveauqualification(null);

		return offreemploi;
	}

}