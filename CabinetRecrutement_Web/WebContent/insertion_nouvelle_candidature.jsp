<%@page import="java.util.HashSet"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.dao.NiveauqualificationDAO"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.dao.SecteuractiviteDAO"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.model.Niveauqualification"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.service.IServiceNiveauqualification"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.service.IServiceSecteuractivite"%>
<%@page import="java.util.Date"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.Utils"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.dao.CandidatureDAO"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.service.IServiceCandidature"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page
	import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
			eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocatorException,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceEntreprise,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise,
                eu.telecom_bretagne.cabinet_recrutement.data.dao.EntrepriseDAO,
                java.util.List"%>

<%
// Récupération du service (bean session)
IServiceCandidature serviceCandidature = (IServiceCandidature) ServicesLocator.getInstance().getRemoteInterface("ServiceCandidature");
//Appel de la fonctionnalité désirée auprès du service
	List<Candidature> candidatures = serviceCandidature.listeDesCandidatures();
	
	// Récupération du service (bean session)
	IServiceSecteuractivite serviceSecteuractivite = (IServiceSecteuractivite) ServicesLocator
			.getInstance().getRemoteInterface("ServiceSecteuractivite");
	// Appel de la fonctionnalité désirée auprès du service
	List<Secteuractivite> secteursactivite = serviceSecteuractivite
			.listeDesSecteuractivite();
	
	// Récupération du service (bean session)
	IServiceNiveauqualification serviceNiveauqualification = (IServiceNiveauqualification) ServicesLocator
			.getInstance().getRemoteInterface("ServiceNiveauqualification");
	// Appel de la fonctionnalité désirée auprès du service
	List<Niveauqualification> niveauxqualification = serviceNiveauqualification
			.listeDesNiveauqualification();

	CandidatureDAO candidatureDAO = null;
	SecteuractiviteDAO secteuractiviteDAO = null;
	NiveauqualificationDAO niveauqualificationDAO = null;

	try
	{
		candidatureDAO = (CandidatureDAO) ServicesLocator.getInstance().getRemoteInterface("CandidatureDAO");
		secteuractiviteDAO = (SecteuractiviteDAO) ServicesLocator.getInstance().getRemoteInterface("SecteuractiviteDAO");
		niveauqualificationDAO = (NiveauqualificationDAO) ServicesLocator.getInstance().getRemoteInterface("NiveauqualificationDAO");
	}
	catch (ServicesLocatorException e)
	{
		e.printStackTrace();
	}
%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cabinet de recrutement : ajout d'une nouvelle entreprise</title>
<link rel="stylesheet" href="styles.css" type="text/css" />
</head>

<body>

	<h2>Référencer une nouvelle candidature</h2>
<%
String nom = request.getParameter("nom");
String prenom = request.getParameter("prenom");
String date_naissance = request.getParameter("date_naissance");
String adresse_postale = request.getParameter("adresse_postale");
String adresse_email = request.getParameter("adresse_email");
String cv = request.getParameter("cv");
String niveau = request.getParameter("niveau");
String secteurs[];
secteurs = request.getParameterValues("secteur");

Date date_naissance_convertie = Utils.string2Date(date_naissance);
Niveauqualification niveau_converti = niveauqualificationDAO.findById(Integer.parseInt(niveau));
Set<Secteuractivite> secteurs_convertis = new HashSet<Secteuractivite>();
for(int i=0 ; i<secteurs.length ; i++) {
	secteurs_convertis.add(secteuractiviteDAO.findById(Integer.parseInt(secteurs[i])));
}

out.println("nom : "+nom);
%><br><%
out.println("descriptif : "+prenom);
%><br><%
out.println("date de naissance : "+date_naissance);
%><br><%
out.println("adresse postale : "+adresse_postale);
%><br><%
out.println("adresse_email : "+adresse_email);
%><br><%
out.println("cv : "+cv);
%><br><%
out.println("niveau : "+niveau_converti.getIntitule());
%><br><%
for(Secteuractivite sec : secteurs_convertis) {
	out.println("secteur : "+sec.getIntitule());%><br><%
}

%><br><%

serviceCandidature.setCandidature(nom, prenom, date_naissance_convertie, adresse_postale, adresse_email, cv, niveau_converti, secteurs_convertis);

%>
	<a href="index.jsp">Retour au menu</a>

</body>

</html>
