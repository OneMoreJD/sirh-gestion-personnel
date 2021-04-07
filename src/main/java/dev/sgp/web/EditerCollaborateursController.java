package dev.sgp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditerCollaborateursController
 */
public class EditerCollaborateursController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditerCollaborateursController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String matricule = request.getParameter("matricule");

		if (matricule == null) {
			response.sendError(400, "Un matricule est attendu");						
		}
		
		response.getWriter().write("<h1>Edition de collaborateur</h1>"
				+ "<br>"
				+ "<p>Matricule : " + matricule + "</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String matricule = request.getParameter("matricule");
		String titre = request.getParameter("titre");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		
		boolean paramAreOk = true;
		boolean matriculeIsOk = true;
		boolean titreIsOk = true;
		boolean prenomIsOk = true;
		boolean nomIsOk = true;
		int nbErrors = 0;
		
		if (matricule == null) {
			paramAreOk = false;
			matriculeIsOk = false;
			nbErrors++;
		}
		if (titre == null) {
			paramAreOk = false;
			titreIsOk = false;
			nbErrors++;
		}
		if (nom == null) {
			paramAreOk = false;
			nomIsOk = false;
			nbErrors++;
		}
		if (prenom == null) {
			paramAreOk = false;
			prenomIsOk = false;
			nbErrors++;
		}

		int count = nbErrors;
		
		if (!paramAreOk) {
			String message = nbErrors == 1 ? "Le paramètre suivant est incorrect : " : "Les paramètres suivants sont incorrects : ";
			if (!matriculeIsOk) {
				message = --count > 0 ? message + "matricule, " : message + "matricule";
			}
			if (!titreIsOk) {
				message = --count > 0 ? message + "titre, " : message + "titre";
			}
			if (!prenomIsOk) {
				message = --count > 0 ? message + "prenom, " : message + "prenom";
			}
			if (!nomIsOk) {
				message = --count > 0 ? message + "nom, " : message + "nom";
			}
			response.sendError(400, message);
		}
		
		response.setContentType("text/html");
		response.setStatus(201);
		response.getWriter().write("<h1>Edition de collaborateur</h1>"
				+ "<br>"
				+ "<p>matricule = " + matricule
				+ ", titre = " + titre
				+ ", nom = " + nom
				+ ", prenom = " + prenom
				+ "</p>");
	}

}
