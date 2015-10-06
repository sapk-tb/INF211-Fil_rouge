package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the offre_emploi database table.
 * 
 */
@Entity
@Table(name="offre_emploi")
@NamedQuery(name="OffreEmploi.findAll", query="SELECT o FROM OffreEmploi o")
public class OffreEmploi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OFFRE_EMPLOI_IDOFFRE_GENERATOR", sequenceName="OFFRE_EMPLOI_ID_OFFRE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OFFRE_EMPLOI_IDOFFRE_GENERATOR")
	@Column(name="id_offre")
	private Integer idOffre;

	@Temporal(TemporalType.DATE)
	private Date datedepot;

	private String descriptifmission;

	private String profilrecherche;

	private String titre;

	//bi-directional many-to-many association to SecteurActivite
	@ManyToMany(mappedBy="offreEmplois")
	private Set<SecteurActivite> secteurActivites;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="id_ent")
	private Entreprise entreprise;

	//bi-directional many-to-one association to NiveauQualification
	@ManyToOne
	@JoinColumn(name="id_nq")
	private NiveauQualification niveauQualification;

	public OffreEmploi() {
	}

	public Integer getIdOffre() {
		return this.idOffre;
	}

	public void setIdOffre(Integer idOffre) {
		this.idOffre = idOffre;
	}

	public Date getDatedepot() {
		return this.datedepot;
	}

	public void setDatedepot(Date datedepot) {
		this.datedepot = datedepot;
	}

	public String getDescriptifmission() {
		return this.descriptifmission;
	}

	public void setDescriptifmission(String descriptifmission) {
		this.descriptifmission = descriptifmission;
	}

	public String getProfilrecherche() {
		return this.profilrecherche;
	}

	public void setProfilrecherche(String profilrecherche) {
		this.profilrecherche = profilrecherche;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Set<SecteurActivite> getSecteurActivites() {
		return this.secteurActivites;
	}

	public void setSecteurActivites(Set<SecteurActivite> secteurActivites) {
		this.secteurActivites = secteurActivites;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public NiveauQualification getNiveauQualification() {
		return this.niveauQualification;
	}

	public void setNiveauQualification(NiveauQualification niveauQualification) {
		this.niveauQualification = niveauQualification;
	}

}