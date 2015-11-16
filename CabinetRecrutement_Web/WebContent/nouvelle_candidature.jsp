<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.model.Niveauqualification"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.service.IServiceNiveauqualification"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite"%>
<%@page import="eu.telecom_bretagne.cabinet_recrutement.service.IServiceSecteuractivite"%>
<%@page
	import="eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature"%>
<%@page
	import="eu.telecom_bretagne.cabinet_recrutement.service.IServiceCandidature"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page
	import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceEntreprise,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise,
                java.util.List"%>

<%
	// Récupération du service (bean session)
	IServiceCandidature serviceCandidature = (IServiceCandidature) ServicesLocator
			.getInstance().getRemoteInterface("ServiceCandidature");
	// Appel de la fonctionnalité désirée auprès du service
	List<Candidature> candidatures = serviceCandidature
			.listeDesCandidatures();
	
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
%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cabinet de recrutement : ajout d'une nouvelle entreprise</title>
<link rel="stylesheet" href="styles.css" type="text/css" />
</head>

<body>

	<h2>Référencer une nouvelle candidature</h2>

	<form action="template.jsp?action=insertion_nouvelle_candidature"
		method="get">
		<input type="hidden" name="action"
			value="insertion_nouvelle_candidature" />
		<table id="affichage">
			<tr>
				<th style="width: 170px">Nom :</th>
				<td><input type="text" name="nom" size="20" maxlength="50">
				</td>
			</tr>
			<tr>
				<th>Prénom :</th>
				<td><input type="text" name="prenom" size="20" maxlength="50">
				</td>
			</tr>
			<tr>
				<th>Date de naissance<br />(format jj/mm/aaaa) :
				</th>
				<td><input type="text" name="date_naissance" size="10"
					maxlength="10"></td>
			</tr>
			<tr>
				<th>Adresse postale (ville) :</th>
				<td><input type="text" name="adresse_postale" size="20"
					maxlength="30"></td>
			</tr>
			<tr>
				<th>Adresse email :</th>
				<td><input type="text" name="adresse_email" size="30"
					maxlength="100"></td>
			</tr>
			<tr>
				<th>Curriculum vitæ :</th>
				<td><textarea rows="7" cols="70" name="cv"></textarea></td>
			</tr>
			<tr>
				<th>Niveau de qualification :</th>
				<td>
					<table id="tab_interne">
						<tr>
							<td>
							<%
							List<Niveauqualification> listeNQ = serviceNiveauqualification.listeDesNiveauqualification();
							for(int i = 0 ; i<listeNQ.size() ; i++){
								%><input type="radio" name="niveau" value="<%=listeNQ.get(i).getIdNq()%>"><%=listeNQ.get(i).getIntitule()%><br /><%
							}
							%>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>Secteur(s) d'activité :</th>
				<td>
					<table id="tab_interne">
						<tr>
							<td>
								<%
									List<Secteuractivite> listeSA = serviceSecteuractivite.listeDesSecteuractivite();
									for (int i = 0; i < listeSA.size(); i++) {
										%><input type="checkbox" name="secteur" value="<%=listeSA.get(i).getIdSa()%>"><%=listeSA.get(i).getIntitule()%><br /><%
									}
								%>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<p>
			<input type="submit" value="Enregistrer" />
		</p>
	</form>

	<a href="index.jsp">Retour au menu</a>

</body>

</html>
