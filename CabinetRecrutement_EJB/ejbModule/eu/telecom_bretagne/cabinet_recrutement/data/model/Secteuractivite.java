package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the secteuractivite database table.
 * 
 */
@Entity
@NamedQuery(name="Secteuractivite.findAll", query="SELECT s FROM Secteuractivite s")
public class Secteuractivite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECTEURACTIVITE_IDSA_GENERATOR", sequenceName="SECTEURACTIVITE_ID_SA_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECTEURACTIVITE_IDSA_GENERATOR")
	@Column(name="id_sa")
	private Integer idSa;

	private String intitule;

	//bi-directional many-to-many association to Offreemploi
	@ManyToMany
	@JoinTable(
		name="liaisonoffresecteur"
		, joinColumns={
			@JoinColumn(name="id_sa")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_offre")
			}
		)
	private Set<Offreemploi> offreemplois;

	//bi-directional many-to-many association to Candidature
	@ManyToMany
	@JoinTable(
		name="liaisonsecteurcandidature"
		, joinColumns={
			@JoinColumn(name="id_sa")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_candid")
			}
		)
	private Set<Candidature> candidatures;

	public Secteuractivite() {
	}

	public Integer getIdSa() {
		return this.idSa;
	}

	public void setIdSa(Integer idSa) {
		this.idSa = idSa;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Set<Offreemploi> getOffreemplois() {
		return this.offreemplois;
	}

	public void setOffreemplois(Set<Offreemploi> offreemplois) {
		this.offreemplois = offreemplois;
	}

	public Set<Candidature> getCandidatures() {
		return this.candidatures;
	}

	public void setCandidatures(Set<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

}