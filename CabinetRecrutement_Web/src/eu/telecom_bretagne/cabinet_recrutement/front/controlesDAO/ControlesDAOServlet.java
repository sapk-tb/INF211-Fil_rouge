package eu.telecom_bretagne.cabinet_recrutement.front.controlesDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.*;
import eu.telecom_bretagne.cabinet_recrutement.data.model.*;
import eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator;
import eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocatorException;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/ControlesDAO")
public class ControlesDAOServlet extends HttpServlet
{
	//-----------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
	//-----------------------------------------------------------------------------
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlesDAOServlet()
	{
		super();
	}
	//-----------------------------------------------------------------------------
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Flot de sortie pour écriture des résultats.
    PrintWriter out = response.getWriter();
    
    // Récupération de la réféence vers le(s) DAO(s)
		EntrepriseDAO entrepriseDAO = null;
		CandidatureDAO candidatureDAO = null;
		OffreemploiDAO offreemploiDAO = null;
		NiveauqualificationDAO niveauqualificationDAO = null;
		SecteuractiviteDAO secteuractiviteDAO = null;
    try
    {
	    entrepriseDAO = (EntrepriseDAO) ServicesLocator.getInstance().getRemoteInterface("EntrepriseDAO");
	    candidatureDAO = (CandidatureDAO) ServicesLocator.getInstance().getRemoteInterface("CandidatureDAO");
	    offreemploiDAO = (OffreemploiDAO) ServicesLocator.getInstance().getRemoteInterface("OffreemploiDAO");
	    niveauqualificationDAO = (NiveauqualificationDAO) ServicesLocator.getInstance().getRemoteInterface("NiveauqualificationDAO");
	    secteuractiviteDAO = (SecteuractiviteDAO) ServicesLocator.getInstance().getRemoteInterface("SecteuractiviteDAO");
    }
    catch (ServicesLocatorException e)
    {
    	e.printStackTrace();
    }
    
    //EntrepriseDAO\\
		out.println("Contrôles de fonctionnement du DAO EntrepriseDAO");
		out.println();
		// Contrôle(s) de fonctionnalités.
		out.println("Liste des entreprises :");
		List<Entreprise> entreprises = entrepriseDAO.findAll();
		for(Entreprise entreprise : entreprises)
		{
			out.println(entreprise.getNom());
		}
		out.println();
		out.println("Obtention de l'entreprise n° 1 :");
		Entreprise e = entrepriseDAO.findById(1);
		out.println(e.getIdEnt());
		out.println(e.getNom());
		out.println(e.getDescriptif());
		out.println(e.getAdressepostale());
		out.println();
		out.println("Obtention de l'entreprise n° 2 :");
		e = entrepriseDAO.findById(2);
		out.println(e.getIdEnt());
		out.println(e.getNom());
		out.println(e.getDescriptif());
		out.println(e.getAdressepostale());
		out.println();
		
		List<Niveauqualification> nqs = niveauqualificationDAO.findAll();
		for(Niveauqualification nq : nqs)
		{
			out.println(nq.getIntitule());
		}
		
		List<Secteuractivite> secs = secteuractiviteDAO.findAll();
		for(Secteuractivite sec : secs)
		{
			out.println(sec.getIntitule());
		}
	
	//CandidatureDAO\\
		out.println("Contrôles de fonctionnement du DAO CandidatureDAO");
		out.println();
		// Contrôle(s) de fonctionnalités.
		out.println("Création d'une candidature :");
		Candidature nouvelleCandidature = new Candidature();
		nouvelleCandidature.setNom("LAVOCAT");
		nouvelleCandidature.setPrenom("Maxime");
		nouvelleCandidature.setDatenaissance(new Date());
		nouvelleCandidature.setAdressepostale("Hirel");
		nouvelleCandidature.setAdresseemail("mlavocat@gmail.com");
		nouvelleCandidature.setCurriculumvitae("mon sdfsdf cv");
		nouvelleCandidature.setDatedepot(new Date());
		Niveauqualification nq = niveauqualificationDAO.findById(1);
		nouvelleCandidature.setNiveauqualification(nq);
		
		// On récupère le secteur d'activité que l'on souhaite ajouter à la candidature grâce à son ID
		Secteuractivite s = secteuractiviteDAO.findById(3);
		// On créer une liste vide de secteurs qu'on affecte à la candidature
		nouvelleCandidature.setSecteuractivites(new HashSet<Secteuractivite>());
		// On ajoute le secteur d'activité récupéré à cette liste
		nouvelleCandidature.getSecteuractivites().add(s);
		// On ajoute la candidature à la liste des candidatures du secteur d'activité
		s.getCandidatures().add(nouvelleCandidature);
		
//		candidatureDAO.persist(nouvelleCandidature);
//		secteuractiviteDAO.update(s);
		
		
//		candidatureDAO.remove(candidatureDAO.findById(18));
		
//		Candidature candModif = candidatureDAO.findById(10);
//		candModif.setCurriculumvitae("bla bla bla");
//		candidatureDAO.update(candModif);
		
		
		List<Candidature> candidatures = candidatureDAO.findAll();
		for(Candidature candidature : candidatures)
		{
			out.println(candidature.getNom());
		}
	}
	//-----------------------------------------------------------------------------
}
