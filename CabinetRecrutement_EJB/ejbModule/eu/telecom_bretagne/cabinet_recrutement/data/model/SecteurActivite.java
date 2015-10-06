package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the secteur_activite database table.
 * 
 */
@Entity
@Table(name="secteur_activite")
@NamedQuery(name="SecteurActivite.findAll", query="SELECT s FROM SecteurActivite s")
public class SecteurActivite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECTEUR_ACTIVITE_IDSA_GENERATOR", sequenceName="SECTEUR_ACTIVITE_ID_SA_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECTEUR_ACTIVITE_IDSA_GENERATOR")
	@Column(name="id_sa")
	private Integer idSa;

	private String intitule;

	//bi-directional many-to-many association to OffreEmploi
	@ManyToMany
	@JoinTable(
		name="liaison_offre_secteur"
		, joinColumns={
			@JoinColumn(name="id_sa")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_offre")
			}
		)
	private Set<OffreEmploi> offreEmplois;

	//bi-directional many-to-many association to Candidature
	@ManyToMany
	@JoinTable(
		name="liaison_secteur_candidature"
		, joinColumns={
			@JoinColumn(name="id_sa")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_candid")
			}
		)
	private Set<Candidature> candidatures;

	public SecteurActivite() {
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

	public Set<OffreEmploi> getOffreEmplois() {
		return this.offreEmplois;
	}

	public void setOffreEmplois(Set<OffreEmploi> offreEmplois) {
		this.offreEmplois = offreEmplois;
	}

	public Set<Candidature> getCandidatures() {
		return this.candidatures;
	}

	public void setCandidatures(Set<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

}