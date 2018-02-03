package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connexion.Connexion;
import java.io.IOException;
import Metier.Personne;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PersonneDAO
{
	private Connection laConnexion;
	
	public PersonneDAO ()
	{
		try
		{
			laConnexion = Connexion.getConnexion();
		}
		catch (IOException ex)
		{
			Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void creerPersonne(String pseudo, String prenom, String nom, String dateNaissance, String mdp)
	{
		//------------------------- FORMATAGE DATE BDD -------------------------//
		String[] dateFormat = dateNaissance.split("/");
		//On enregistre le format de la date de naissance sans prise en compte du caractère "/".
		String dateBdd = dateFormat[0]+dateFormat[1]+dateFormat[2];
		//------------------------- FORMATAGE DATE BDD -------------------------//
		
		Statement transmission = null;
		try {
			transmission = laConnexion.createStatement();
		} catch (SQLException ex) {
			Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		String requete = "INSERT INTO personne (pseudo_personne, prenom_personne, nom_personne, date_naissance_personne, mdp_personne) VALUES ('"+pseudo+"', '"+prenom+"', '"+nom+"', '"+dateBdd+"', '"+mdp+"' )";
		
		int resultat = 0;
		
		try
		{
			resultat = transmission.executeUpdate(requete);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		if(resultat == 1)
		{
			JOptionPane.showMessageDialog(null, "Le nouvel utilisateur a bien été enregistré.", "Confirmation de création", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			System.out.println("Erreur de creation.");
			JOptionPane.showMessageDialog(null, "Ce pseudo a déjà été selectionné. \n Veuillez choisir un nouveau pseudo.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
		}
			
	}
	
	public Personne chargePersonne(int id)
	{
		boolean encore = false;
		ResultSet ligne = null;
		Personne user = new Personne();
		Statement transmission = null;
		String requete = "SELECT * FROM personne WHERE id_personne = "+id;

		//On effectue la transmission des informations
		try
		{
			transmission = laConnexion.createStatement();
		} 
		catch (SQLException e){}
		
		//On effectue la transmission de la requete.
		try
		{
			ligne = transmission.executeQuery(requete);
		}
		catch (SQLException e){}
		//On recupere le resultat de la requete.
		try
		{
			encore = ligne.next();
		}
		catch (SQLException e){}
		//ALTER TABLE personne ADD CONSTRAINT pseudo_personne UNIQUE (pseudo_personne);
		if(encore)
		{
			//On instancie notre objet Personne avec les elements recuperes dans la requete.
			try
			{
				user = ( new Personne(ligne.getInt("id_personne"), ligne.getString("nom_personne")) );
			}
			catch (SQLException e) {}
		}
		//On tente de fermer la connexion
		try
		{
			ligne.close();
		}
		catch (SQLException e){}
		
		return user;
	}
	
	public Personne chargePersonne(String pseudo)
	{
		boolean encore = false;
		ResultSet ligne = null;
		Personne user = null;
		Statement transmission = null;
		
		String requete = "SELECT * FROM personne WHERE pseudo_personne = '"+pseudo+"'";
		//On effectue la transmission des informations
		try
		{
			transmission = laConnexion.createStatement();
		} 
		catch (SQLException e){}
		
		//On effectue la transmission de la requete.
		try
		{
			ligne = transmission.executeQuery(requete);
		}
		catch (SQLException e){}
		//On recupere le resultat de la requete.
		try
		{
			encore = ligne.next();
		}
		catch (SQLException e){}
		
		if(encore)
		{
			//On instancie notre objet Personne avec les elements recuperes dans la requete.
			try
			{
	
				user = new Personne(ligne.getInt("id_personne"), ligne.getString("pseudo_personne"), ligne.getString("prenom_personne"), ligne.getString("nom_personne"), ligne.getString("mdp_personne")) ;
			}
			catch (SQLException e){}
		}
		//On tente de fermer la connexion
		try
		{
			ligne.close();
		}
		catch (SQLException e){}
		
		return user;
	}
	
	public Personne chargePersonne(String pseudo, String mdp)
	{
		boolean encore = false;
		ResultSet ligne = null;
		Personne user = new Personne();
		Statement transmission = null;
		
		String requete = "SELECT * FROM personne WHERE pseudo_personne = '"+pseudo+"' AND mdp_personne = '"+mdp+"'";
		//On effectue la transmission des informations
		try
		{
			transmission = laConnexion.createStatement();
		} 
		catch (SQLException e){}
		
		//On effectue la transmission de la requete.
		try
		{
			ligne = transmission.executeQuery(requete);
		}
		catch (SQLException e){}
		//On recupere le resultat de la requete.
		try
		{
			encore = ligne.next();
		}
		catch (SQLException e){}
		
		if(encore)
		{
			//On instancie notre objet Personne avec les elements recuperes dans la requete.
			try
			{
				user = ( new Personne(ligne.getInt("id_personne"), ligne.getString("pseudo_personne"), ligne.getString("prenom_personne"), ligne.getString("nom_personne"), ligne.getString("mdp_personne")) );
			}
			catch (SQLException e) {}
		}
		//On tente de fermer la connexion
		try
		{
			ligne.close();
		}
		catch (SQLException e){}
		
		return user;
	}
	
	public Personne chargePersonne(String pseudo, String prenom, String nom, String dateNaissance)
	{
		//------------------------- FORMATAGE DATE BDD -------------------------//
		String[] dateFormat = dateNaissance.split("/");
		//On enregistre le format de la date de naissance sans prise en compte du caractère "/".
		String dateBdd = dateFormat[0]+dateFormat[1]+dateFormat[2];
		//------------------------- FORMATAGE DATE BDD -------------------------//
		
		boolean encore = false;
		ResultSet ligne = null;
		Personne user = new Personne();
		Statement transmission = null;
		
		String requete = "SELECT * FROM personne WHERE pseudo_personne = '"+pseudo+"' AND prenom_personne = '"+prenom+"' AND nom_personne = '"+nom+"' AND date_naissance_personne = '"+dateBdd+"'";

		//On effectue la transmission des informations
		try
		{
			transmission = laConnexion.createStatement();
		} 
		catch (SQLException e){}
		
		//On effectue la transmission de la requete.
		try
		{
			ligne = transmission.executeQuery(requete);
		}
		catch (SQLException e){}
		//On recupere le resultat de la requete.
		try
		{
			encore = ligne.next();
		}
		catch (SQLException e){}
		
		if(encore)
		{
			//On instancie notre objet Personne avec les elements recuperes dans la requete.
			try
			{
				user = ( new Personne(ligne.getInt("id_personne"), ligne.getString("pseudo_personne"), ligne.getString("prenom_personne"), ligne.getString("nom_personne"), ligne.getString("mdp_personne")) );
			}
			catch (SQLException e) {}
		}
		//On tente de fermer la connexion
		try
		{
			ligne.close();
		}
		catch (SQLException e){}
		
		return user;
	}
	public ArrayList <Personne> chargerListePersonne() throws SQLException
	{
		ArrayList <Personne> lesPersonnes = new ArrayList <> ();
		ResultSet resultat;
		Statement transmission = laConnexion.createStatement();
		String requete = "SELECT * FROM personne";
		resultat = transmission.executeQuery(requete);
		
		while(resultat.next())
		{
			lesPersonnes.add(new Personne (resultat.getInt("id_personne"), resultat.getString("prenom_personne")));
		}
		resultat.close();
		
		return lesPersonnes;
	}
	
	public void supprimerPersonne(int id) throws SQLException
	{
		Statement ordre = laConnexion.createStatement();
		String requete = "DELETE FROM personne WHERE id_personne = "+id;
		int res = ordre.executeUpdate(requete);

		//------------------------- AFFICHAGE MESSAGE -------------------------//
		if (res == 1)
			JOptionPane.showMessageDialog(null, "L'utilisateur a été supprimé.", "Suppression d'un utilisateur", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "La suppression a echouée.", "Suppression d'un utilisateur", JOptionPane.ERROR_MESSAGE);	
		//------------------------- AFFICHAGE MESSAGE -------------------------//
	}
}