package DAO;

import Connexion.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Metier.Compte;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CompteDAO
{
	//------------------------- ATTRIBUTS -------------------------//
	private Connection laConnexion;
	//------------------------- ATTRIBUTS -------------------------//

	public CompteDAO()
	{
		laConnexion = Connexion.getConnexion();
	}
	
	public Compte chargerCompte(int id) throws SQLException
	{
		boolean encore = false;
		ResultSet ligne;
		Compte user = new Compte();
		Statement transmission;
		String requete;

		transmission = laConnexion.createStatement();
		
		requete = "SELECT * FROM compte WHERE  id_compte = "+id;
		
		ligne = transmission.executeQuery(requete);
		encore = ligne.next();
		
		if(encore)
			user = (new Compte(ligne.getInt("id_compte"), ligne.getString("nom_site"), ligne.getString("login_compte"), ligne.getString("mdp_compte"), ligne.getString("adresse_site")));
		
		ligne.close();
		return user;
	}
	
	public ArrayList <Compte> chargerListeCompte(int id) throws SQLException
	{
		ArrayList <Compte> lesComptes = new ArrayList <> ();
		String requete = "SELECT * FROM compte WHERE id_personne = "+id;
		Statement transmission = laConnexion.createStatement();
		ResultSet resultat;

		resultat = transmission.executeQuery(requete);

		while(resultat.next())
		{
			lesComptes.add(new Compte (resultat.getInt("id_compte"),resultat.getString("nom_site"), resultat.getString("login_compte"), resultat.getString("mdp_compte"), resultat.getString("adresse_site")));
		}
		resultat.close();
		
		return lesComptes;
	}
	
	public void majCompte(Compte c) throws SQLException
	{
		Statement ordre = laConnexion.createStatement();
		
		String requete = "UPDATE compte SET nom_site = '"+c.getNom()+"', login_compte ='"+c.getLogin()+"', mdp_compte = '"+c.getMdp()+"', adresse_site = '"+c.getAdresse()+"' WHERE id_compte = "+c.getId();
		int res = ordre.executeUpdate(requete);
		
		if(res == 1)
			JOptionPane.showMessageDialog(null, "Compte mis à jour.", "Confirmation de mise à jour", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "La mise à jour du compte a échouée.", "Erreur de modification", JOptionPane.ERROR_MESSAGE);
	}
	
	public void supprimerCompte(int id) throws SQLException
	{
		Statement ordre = laConnexion.createStatement();
		
		String requete = "DELETE FROM compte WHERE id_compte = "+id;
		int res = ordre.executeUpdate(requete);
		
		if(res == 1)
			JOptionPane.showMessageDialog(null, "Compte supprimé.", "Confirmation de suppression", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "La suppression du compte a échouée.", "Erreur de suppression", JOptionPane.ERROR_MESSAGE);
	}
	
	public void creerCompte(String site, String login, String mdp, String adresse, int id)
	{
		Statement transmission = null;
		try
		{
			transmission = laConnexion.createStatement();
		}
		catch (SQLException ex)
		{
			Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		String requete = "INSERT INTO compte (nom_site, login_compte, mdp_compte, adresse_site, id_personne) VALUES ('"+site+"', '"+login+"', '"+mdp+"', '"+adresse+"',"+id+")";
		
		int resultat = 0;
		
		try
		{
			resultat = transmission.executeUpdate(requete);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(CompteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		if(resultat == 1)
			JOptionPane.showMessageDialog(null, "Compte crée.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "La création du compte a échouée.", "Erreur de création", JOptionPane.ERROR_MESSAGE);
	}
}