package Connexion;

import Extension.FileHelper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author Stryjewski Nicolas (stryjewski.n@gmail.com) Classe Connexion
 *         permettant de gerer, creer et cloturer la connexion a la BDD par le
 *         biais de la bibliotheque JDBC.
 *
 */

public class Connexion
{
	//------------------------- ATTRIBUTS -------------------------//
	
		//------------------------- ADRESSE DE LA BDD -------------------------//
	private static final String URL = "jdbc:mysql://localhost:3306/mypass";
		//------------------------- ADRESSE DE LA BDD -------------------------//
		
		//------------------------- SCRIPT SQL -------------------------//
	private static final String SCRIPT_BDD = "src/SQL/creationBdd.sql";
	private static final String SCRIPT_TABLE = "src/SQL/creationTable.sql";
	private static final String SCRIPT_TABLE2 = "src/SQL/creationTable2.sql";
	private static final String SCRIPT_TABLE3 = "src/SQL/scriptAlterTable.sql";
		//------------------------- SCRIPT SQL -------------------------//
	
		//------------------------- LOGIN DE LA BDD -------------------------//
	private static final String LOGIN = "root";
	private static final String MDP = "";
		//------------------------- ADRESSE DE LA BDD -------------------------//
	
		//------------------------- DRIVER DE LA BDD -------------------------//
	private static final String DRIVER = "com.mysql.jdbc.Driver";
		//------------------------- DRIVER DE LA BDD -------------------------//
	
		//------------------------- OUVERTURE DE CONNEXION -------------------------//
	private static Connection LA_CONNEXION = null;
		//------------------------- OUVERTURE DE CONNEXION -------------------------//
	
	//------------------------- ATTRIBUTS -------------------------//
	
	public Connexion()
	{
		//------------------------- CHARGEMENT DU DRIVER -------------------------//
		try
		{
			System.out.println("Chargement du driver...");
			Class.forName(DRIVER);
			System.out.println("Driver OK...");
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println("Problème de driver");
		}
		//------------------------- CHARGEMENT DU DRIVER -------------------------//
		
		//------------------------- CONNEXION A LA BDD -------------------------//
		try
		{
			System.out.println("Connexion a la BDD...");
			LA_CONNEXION = DriverManager.getConnection(URL, LOGIN, MDP);
			System.out.println("Connexion OK...");
		}
		catch (SQLException ex)
		{
			System.out.println("Problème d'informations liées à la BDD");
			JOptionPane.showMessageDialog(null, "La base de données n'existe pas. \n Cliquez sur 'OK' pour auto-générer la BDD.", "Création de la BDD", JOptionPane.INFORMATION_MESSAGE);
		}
		//------------------------- CONNEXION A LA BDD -------------------------//
	}

	public static Connection getConnexion()
	{
		if (LA_CONNEXION == null)
		{
			//------------------------- CHARGEMENT DU DRIVER -------------------------//
			try
			{
				System.out.println("Chargement du driver...");
				Class.forName(DRIVER).newInstance();
				System.out.println("Driver OK...");
			}
			catch (ClassNotFoundException ex)
			{
				System.out.println("Problème de driver");
			}
			catch (InstantiationException | IllegalAccessException ex)
			{
				Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
			}
			//------------------------- CHARGEMENT DU DRIVER -------------------------//
			
			//------------------------- CONNEXION A LA BDD -------------------------//
			try
			{
				System.out.println("Connexion a la BDD...");
				LA_CONNEXION = DriverManager.getConnection(URL, LOGIN, MDP);
				System.out.println("Connexion OK...");
			}
			catch (SQLException ex)
			{
				System.out.println("Problème d'informations liées à la BDD");
				JOptionPane.showMessageDialog(null, "La base de données n'existe pas. \n Cliquez sur 'OK' pour auto-générer la BDD.", "Création de la BDD", JOptionPane.INFORMATION_MESSAGE);
				String bddTemp = "jdbc:mysql://localhost:3306/mysql";
				try
				{
					//------------------------- CREATION AUTO BDD -------------------------//
						//Si la BDD de l'application n'existe pas, on se connecte sur la BDD par défaut de 'MYSQL'
					LA_CONNEXION = DriverManager.getConnection(bddTemp, LOGIN, MDP);
					Connexion.creerBdd(FileHelper.readFile(SCRIPT_BDD));
						//La connexion nous permet d'injecter une nouvelle BDD dans 'MYSQL'
					LA_CONNEXION = null;
						//On annule la connexion à la BDD par défaut pour ouvrir la connexion à la BDD de l'application.
					LA_CONNEXION = DriverManager.getConnection(URL, LOGIN, MDP);
						//On injecte les SCRIPTS SQL d'auto-génération de structure de table
					Connexion.creerBdd(FileHelper.readFile(SCRIPT_TABLE));
					Connexion.creerBdd(FileHelper.readFile(SCRIPT_TABLE2));
					Connexion.creerBdd(FileHelper.readFile(SCRIPT_TABLE3));
					//------------------------- CREATION AUTO BDD -------------------------//
				}
				catch (SQLException ex1)
				{
					Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex1);
				}
			}
			//------------------------- CONNEXION A LA BDD -------------------------//
		}
		return LA_CONNEXION;
	}

	public static void deconnexion() throws SQLException
	{
		//------------------------- FERMETURE CONNEXION -------------------------//
		LA_CONNEXION.close();
		LA_CONNEXION = null;
		//------------------------- FERMETURE CONNEXION -------------------------//
	}
	
	public static void creerBdd(String scriptSql)
	{
		Statement transmission = null;

		try 
		{
			transmission = LA_CONNEXION.createStatement();
		}
		catch (SQLException ex)
		{
			Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
		}

		int resultat = 0;

		try
		{
			resultat = transmission.executeUpdate(scriptSql);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println("valeur resultat : "+resultat);
		if(resultat == 1)
			JOptionPane.showMessageDialog(null, "La base données a bien été créée.", "Confirmation de création", JOptionPane.INFORMATION_MESSAGE);
		else
			System.out.println("Erreur de creation.");
	}
	
	public void verifService()
	{
		String portStandard = "3306";
		String portDefaut = "8080";
		
		Runtime runtime = Runtime.getRuntime();
		
		//utilisation de netstat natif sur linux et windows
		//service MySQL est démarré (ce que l'on peut vérifier avec "service mysqld status"
		
		//ouverture de netstat par la commande
		String commandeOuvertureNetStat = "netstat -petulan";
		try
		{
			runtime.exec(commandeOuvertureNetStat);
			System.out.println("L'outil de ligne de commande est ouvert.");
			//On doit rechercher le portStandard par le nom de processus "mysqld"
		}
		catch (IOException ex)
		{
			Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		String testServiceSql = "C:\\mysql\\bin\\mysql test";
		
		//on envoi la commande pour lancer le service si eteint.
	}
}