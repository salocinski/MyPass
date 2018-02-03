package Metier;
/**
 * La classe personne defini l'utilisateur de l'application.
 * Il est reference selon un prenom qui doit etre unique.
 * @author utilisateur
 *
 */
public class Personne
{
	//------------------------- ATTRIBUTS -------------------------//
	private int id;
	private String pseudo;
	private String prenom;
	private String nom;
	private String dateNaissance;
	private String mdp;
	//------------------------- ATTRIBUTS -------------------------//
	
	//------------------------- CONSTRUCTEURS -------------------------//
	public Personne()
	{	}
	
	public Personne(String prenom)
	{
		this.prenom = prenom;
	}
	
	public Personne(int id, String prenom)
	{
		this.id = id;
		this.prenom = prenom;
	}

	public Personne(int id, String pseudo, String prenom, String nom, String mdp) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.mdp = mdp;
	}
	
	public Personne(String pseudo, String prenom, String nom, String dateNaissance, String mdp) {
		this.pseudo = pseudo;
		this.prenom = prenom;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.mdp = mdp;
	}
	//------------------------- CONSTRUCTEURS -------------------------//
	
	//------------------------- ACCESSEURS -------------------------//
	public String getPrenom()
	{
		return prenom;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getMdp() {
		return mdp;
	}
	//------------------------- CONSTRUCTEURS -------------------------//
}
