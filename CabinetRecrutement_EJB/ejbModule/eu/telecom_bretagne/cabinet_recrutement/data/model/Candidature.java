package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the candidature database table.
 * 
 */
@Entity
@NamedQuery(name="Candidature.findAll", query="SELECT c FROM Candidature c")
public class Candidature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CANDIDATURE_IDCANDID_GENERATOR", sequenceName="CANDIDATURE_ID_CANDID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CANDIDATURE_IDCANDID_GENERATOR")
	@Column(name="id_candid")
	private Integer idCandid;

	private String adresseemail;

	private String adressepostale;

	private String curriculumvitae;

	@Temporal(TemporalType.DATE)
	private Date datedepot;

	@Temporal(TemporalType.DATE)
	private Date datenaissance;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Niveauqualification
	@ManyToOne
	@JoinColumn(name="id_nq")
	private Niveauqualification niveauqualification;

	//bi-directional many-to-many association to Secteuractivite
	@ManyToMany(mappedBy="candidatures")
	private Set<Secteuractivite> secteuractivites;

	public Candidature() {
	}

	public Integer getIdCandid() {
		return this.idCandid;
	}

	public void setIdCandid(Integer idCandid) {
		this.idCandid = idCandid;
	}

	public String getAdresseemail() {
		return this.adresseemail;
	}

	public void setAdresseemail(String adresseemail) {
		this.adresseemail = adresseemail;
	}

	public String getAdressepostale() {
		return this.adressepostale;
	}

	public void setAdressepostale(String adressepostale) {
		this.adressepostale = adressepostale;
	}

	public String getCurriculumvitae() {
		return this.curriculumvitae;
	}

	public void setCurriculumvitae(String curriculumvitae) {
		this.curriculumvitae = curriculumvitae;
	}

	public Date getDatedepot() {
		return this.datedepot;
	}

	public void setDatedepot(Date datedepot) {
		this.datedepot = datedepot;
	}

	public Date getDatenaissance() {
		return this.datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Niveauqualification getNiveauqualification() {
		return this.niveauqualification;
	}

	public void setNiveauqualification(Niveauqualification niveauqualification) {
		this.niveauqualification = niveauqualification;
	}

	public Set<Secteuractivite> getSecteuractivites() {
		return this.secteuractivites;
	}

	public void setSecteuractivites(Set<Secteuractivite> secteuractivites) {
		this.secteuractivites = secteuractivites;
	}

}