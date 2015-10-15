package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the offreemploi database table.
 * 
 */
@Entity
@NamedQuery(name="Offreemploi.findAll", query="SELECT o FROM Offreemploi o")
public class Offreemploi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OFFREEMPLOI_IDOFFRE_GENERATOR", sequenceName="OFFREEMPLOI_ID_OFFRE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OFFREEMPLOI_IDOFFRE_GENERATOR")
	@Column(name="id_offre")
	private Integer idOffre;

	@Temporal(TemporalType.DATE)
	private Date datedepot;

	private String descriptifmission;

	private String profilrecherche;

	private String titre;

	//bi-directional many-to-many association to Secteuractivite
	@ManyToMany(mappedBy="offreemplois")
	private Set<Secteuractivite> secteuractivites;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="id_ent")
	private Entreprise entreprise;

	//bi-directional many-to-one association to Niveauqualification
	@ManyToOne
	@JoinColumn(name="id_nq")
	private Niveauqualification niveauqualification;

	public Offreemploi() {
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

	public Set<Secteuractivite> getSecteuractivites() {
		return this.secteuractivites;
	}

	public void setSecteuractivites(Set<Secteuractivite> secteuractivites) {
		this.secteuractivites = secteuractivites;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Niveauqualification getNiveauqualification() {
		return this.niveauqualification;
	}

	public void setNiveauqualification(Niveauqualification niveauqualification) {
		this.niveauqualification = niveauqualification;
	}

}