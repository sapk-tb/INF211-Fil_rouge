<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceCandidature,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature,
                java.util.List"%>

<%
  // Récupération du service (bean session)
	IServiceCandidature serviceCandidature = (IServiceCandidature) ServicesLocator.getInstance().getRemoteInterface("ServiceCandidature");
// Appel de la fonctionnalité désirée auprès du service
	List<Candidature> candidatures = serviceCandidature.listeDesCandidatures();
%>

<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Cabinet de recrutement : liste des candidatures référencées</title>
    <link rel="stylesheet" href="styles.css" type="text/css" />
  </head>

  <body>
  
		<h2>Liste des candidatures référencées :</h2>

		<table id="affichage">
		  <tr>
		    <th>Identifiant</th>
		    <th>Nom</th>
		    <th>Adresse postale (ville)</th>
		  </tr>
		  <%
		  for(Candidature candidature : candidatures)
		  {
		    %>
		    <tr>
		     <td>ENT_<%=candidature.getIdCandid()%></td>
		     <td><a href="template.jsp?action=infos_candidature&id=<%=candidature.getIdCandid()%>"><%=candidature.getNom()%></a></td>
		     <td><%=candidature.getAdressepostale()%></td>
		    </tr>
		    <%
		  }
		  %>
		</table>

    <a href="index.jsp">Retour au menu</a>

  </body>
  
</html>
