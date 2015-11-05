<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceEntreprise,
                eu.telecom_bretagne.cabinet_recrutement.service.IServiceCandidature,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise,
                eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature"%>

<h2>Connexion au syst�me</h2>

<p style="font-style: italic;">
  Pour une entreprise, l'identifiant est de la forme ENT_ + cl� primaire (ENT_1 par exemple)
  et CAND_ + cl� primaire (CAND_1 par exemple) pour une candidature.
</p>

<%
  String identifiant = request.getParameter("identifiant");
  if(identifiant == null) // Pas de param�tre "identifiant" => affichage du formulaire
  {
  	%>
		<form action="connexion.jsp" method="get">
		  <!-- <input type="hidden" name="action" value="connexion" /> -->
		  <p>
		    Identifiant : <input type="text" name="identifiant"/>
		  </p>
		  <p>
		    <input type="submit" value="Connexion"/>
		  </p>
		</form>
  	<%
  }
  else                    // Param�tre "identifiant" existant => connexion
  {
  	if(identifiant.equals(""))
  	{
      %>
      <p class="erreur">Veuillez renseignez votre num�ro d'identifiant pour pouvoir vous connecter</p>
      <a href="index.jsp">Retour...</a>
      <%
  	}
    else if(identifiant.startsWith("ENT_"))
  	{
  		IServiceEntreprise serviceEntreprise = (IServiceEntreprise) ServicesLocator.getInstance().getRemoteInterface("ServiceEntreprise");
  		int id = Integer.parseInt(identifiant.substring(4)); // On enl�ve le pr�fixe "ENT_";
  		Entreprise entreprise = serviceEntreprise.getEntreprise(id);
  		if(entreprise == null)
  		{
  			%>
  			<p class="erreur">Erreur : il n'y a pas d'entreprise avec cet identifiant : <%=identifiant%></p>
  			<a href="index.jsp">Retour...</a>
  			<%
  		}
  		else
  		{
        session.setAttribute("utilisateur",entreprise);
        response.sendRedirect("index.jsp");
  		}
  	}
  	else if(identifiant.startsWith("CAND_"))
  	{
  		IServiceCandidature serviceCandidature = (IServiceCandidature) ServicesLocator.getInstance().getRemoteInterface("ServiceCandidature");
  		int id = Integer.parseInt(identifiant.substring(5)); // On enl�ve le pr�fixe "CAND_";
  		Candidature candidature = serviceCandidature.getCandidature(id);
      if(candidature == null)
      {
        %>
        <p class="erreur">Erreur : il n'y a pas de candidature avec cet identifiant : <%=identifiant%></p>
        <a href="index.jsp">Retour...</a>
        <%
      }
      else
      {
        session.setAttribute("utilisateur",candidature);
        response.sendRedirect("index.jsp");
      }
  	}
  }
%>
