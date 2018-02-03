package Connexion;

import Extension.FileHelper;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
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
	private static final String SCRIPT_BDD = "/script/creationBdd.sql";
	private static final String SCRIPT_TABLE = "/script/creationTable.sql";
	private static final String SCRIPT_TABLE2 = "/script/creationTable2.sql";
	private static final String SCRIPT_TABLE3 = "/script/scriptAlterTable.sql";
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
		}
		//------------------------- CONNEXION A LA BDD -------------------------//
	}

	public static Connection getConnexion() throws IOException
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
				
				try
				{
					//------------------------- CREATION AUTO BDD -------------------------//
					
						//------------------------- CONNEXION / DECONNEXION BDD PAR DEFAUT -------------------------//
					String bddTemp = "jdbc:mysql://localhost:3306/mysql";
					LA_CONNEXION = DriverManager.getConnection(bddTemp, LOGIN, MDP);
					
					File scriptBdd = new File(SCRIPT_BDD);
					String scriptSQL = FileHelper.lire(scriptBdd.getClass().getResource(SCRIPT_BDD), Charset.defaultCharset());
					Connexion.creerBdd(scriptSQL);
					LA_CONNEXION = null;
						//------------------------- CONNEXION / DECONNEXION BDD PAR DEFAUT -------------------------//
						
						//------------------------- CONNEXION BDD APPLICATION -------------------------//
					LA_CONNEXION = DriverManager.getConnection(URL, LOGIN, MDP);
						//------------------------- CONNEXION BDD APPLICATION -------------------------//
						
						//------------------------- INJECTION SCRIPT SQL -------------------------//
					File scriptTable1 = new File(SCRIPT_TABLE);
					String scriptSQL2 = FileHelper.lire(scriptBdd.getClass().getResource(SCRIPT_TABLE), Charset.defaultCharset());
					Connexion.creerBdd(scriptSQL2);
					
					File scriptTable2 = new File(SCRIPT_TABLE2);
					String scriptSQL3 = FileHelper.lire(scriptBdd.getClass().getResource(SCRIPT_TABLE2), Charset.defaultCharset());
					Connexion.creerBdd(scriptSQL3);
					
					File scriptAlterTable = new File(SCRIPT_TABLE3);
					String scriptSQL4 = FileHelper.lire(scriptBdd.getClass().getResource(SCRIPT_TABLE3), Charset.defaultCharset());
					Connexion.creerBdd(scriptSQL4);
						//------------------------- INJECTION SCRIPT SQL -------------------------//
						
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

	public void deconnexion() throws SQLException
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
}