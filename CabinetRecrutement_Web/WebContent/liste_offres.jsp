<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.Utils"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.model.Offreemploi"%>
<%@page
	import="eu.telecom_bretagne.cabinet_recrutement.service.IServiceOffreemploi"%>
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
	List<Offreemploi> offres = serviceOffreEmploi.listeDesOffreemploi();
%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cabinet de recrutement : ajout d'une nouvelle entreprise</title>
<link rel="stylesheet" href="styles.css" type="text/css" />
</head>

<body>
  <%
  if(request.getParameter("id_entreprise")!=null) {
		List<Offreemploi> offresParEnt = serviceOffreEmploi.listeDesOffresPourUneEntreprise(Integer.parseInt(request.getParameter("id_entreprise")));
	  %>
		<h2>Liste de mes offres d'emploi référencées :</h2>

		<table id="affichage">
			<tr>
				<th>Numéro</th>
				<th>Titre</th>

				<th>Entreprise</th>
				<th>Niveau de qualification</th>
				<th>Date de dépôt</th>

			</tr>
			<%
		  for(Offreemploi offre : offresParEnt)
		  {
		    %>
			<tr>
				<td><%=offre.getIdOffre()%></td>
				<td><a href="template.jsp?action=infos_offre&id=<%offre.getIdOffre();%>"><%=offre.getTitre()%></a></td>

				<td><%=offre.getEntreprise().getNom()%></td>
				<td><%=offre.getNiveauqualification().getIntitule()%></td>
				<td><%=Utils.date2String(offre.getDatedepot())%></td>
			</tr>
			<%
		  }
		  %>
		</table>
	<%
	}
  
  else if(request.getParameter("id_candidature")!=null) {
		  Candidature c = (Candidature) utilisateur;
		  List<Offreemploi> offresParCand = serviceOffreEmploi.listeDesOffresPourUneCandidature(c);
		  %>
			<h2>Liste des offres d'emploi qui peuvent m'intéresser :</h2>

			<table id="affichage">
				<tr>
					<th>Numéro</th>
					<th>Titre</th>

					<th>Entreprise</th>
					<th>Niveau de qualification</th>
					<th>Date de dépôt</th>

				</tr>
				<%
			  for(Offreemploi offre : offresParCand)
			  {
			    %>
				<tr>
					<td><%=offre.getIdOffre()%></td>
					<td><a href="template.jsp?action=infos_offre&id=<%offre.getIdOffre();%>"><%=offre.getTitre()%></a></td>

					<td><%=offre.getEntreprise().getNom()%></td>
					<td><%=offre.getNiveauqualification().getIntitule()%></td>
					<td><%=Utils.date2String(offre.getDatedepot())%></td>
				</tr>
				<%
			  }
			  %>
			</table>
		<%
		}
  else {
  %>
		<h2>Liste des offres d'emploi référencées :</h2>

		<table id="affichage">
			<tr>
				<th>Numéro</th>
				<th>Titre</th>

				<th>Entreprise</th>
				<th>Niveau de qualification</th>
				<th>Date de dépôt</th>

			</tr>
			<%
		  for(Offreemploi offre : offres)
		  {
		    %>
			<tr>
				<td><%=offre.getIdOffre()%></td>
				<td><a href="template.jsp?action=infos_offre&id=<%offre.getIdOffre();%>"><%=offre.getTitre()%></a></td>

				<td><%=offre.getEntreprise().getNom()%></td>
				<td><%=offre.getNiveauqualification().getIntitule()%></td>
				<td><%=Utils.date2String(offre.getDatedepot())%></td>
			</tr>
			<%
		  }
		  %>
		</table>
  <%
  	}
  %>
	<a href="index.jsp">Retour au menu</a>

</body>

</html>
