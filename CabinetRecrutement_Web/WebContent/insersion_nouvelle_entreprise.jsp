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
	IServiceEntreprise serviceEntreprise = (IServiceEntreprise) ServicesLocator.getInstance().getRemoteInterface("ServiceEntreprise");
// Appel de la fonctionnalité désirée auprès du service
	List<Entreprise> entreprises = serviceEntreprise.listeDesEntreprises();

	EntrepriseDAO entrepriseDAO = null;

	try
	{
		entrepriseDAO = (EntrepriseDAO) ServicesLocator.getInstance().getRemoteInterface("EntrepriseDAO");
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

	<h2>Référencer une nouvelle entreprise</h2>
<%

String nom = request.getParameter("nom");
String descriptif = request.getParameter("descriptif");
String adresse_postale = request.getParameter("adresse_postale");

out.println("nom : "+nom);
out.println("descriptif : "+descriptif);
out.println("adresse postale : "+adresse_postale);

serviceEntreprise.setEntreprise(nom, descriptif, adresse_postale);

%>
	<a href="index.jsp">Retour au menu</a>

</body>

</html>
