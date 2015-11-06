<%@page import="eu.telecom_bretagne.cabinet_recrutement.service.IServiceOffreemploi"%>
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

Object utilisateur = session.getAttribute("utilisateur");
  // Récupération du service (bean session)
	IServiceEntreprise serviceEntreprise = (IServiceEntreprise) ServicesLocator.getInstance().getRemoteInterface("ServiceEntreprise");
	IServiceOffreemploi serviceOffreEmploi = (IServiceOffreemploi) ServicesLocator.getInstance().getRemoteInterface("ServiceOffreemploi");
// Appel de la fonctionnalité désirée auprès du service
	List<Entreprise> entreprises = serviceEntreprise.listeDesEntreprises();

	if(session.getAttribute("utilisateur") != null)
	  {
		out.println("AZAAAAAA");
	  }
	  
%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cabinet de recrutement : ajout d'une nouvelle entreprise</title>
<link rel="stylesheet" href="styles.css" type="text/css" />
</head>

<body>

	<h2>Liste des offres d'emploi</h2>
<%
if(utilisateur instanceof Entreprise && request.getParameter("id_entreprise") != null){
	Entreprise e = (Entreprise) utilisateur;
	out.println(serviceOffreEmploi.listeDesOffresPourUneEntreprise(e.getIdEnt()));
} else {
	out.println(serviceOffreEmploi.listeDesOffreemploi());
}





%>
	<a href="index.jsp">Retour au menu</a>

</body>

</html>
