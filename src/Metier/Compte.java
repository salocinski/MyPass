package Metier;

public class Compte
{
	//------------------------- ATTRIBUTS -------------------------//
	private int id;
	private String nom;
	private String login;
	private String mdp;
	private Personne user;
	private String adresse;
	//------------------------- ATTRIBUTS -------------------------//
	
	//------------------------- CONSTRUCTEURS -------------------------//
	public Compte()
	{	}
	public Compte(String nom, String login, String mdp)
	{
		this.nom = nom;
		this.login = login;
		this.mdp = mdp;
	}
	
	public Compte (int id, String nom, String login, String mdp)
	{
		this.id = id;
		this.nom = nom;
		this.login = login;
		this.mdp = mdp;
	}
	
	public Compte (int id, String nom, String login, String mdp, String adresse)
	{
		this.id = id;
		this.nom = nom;
		this.login = login;
		this.mdp = mdp;
		this.adresse = adresse;
	}
	
	public Compte (int id, String nom, String login, String mdp, Personne user)
	{
		this.id = id;
		this.nom = nom;
		this.login = login;
		this.mdp = mdp;
		this.user = user;
	}
	//------------------------- CONSTRUCTEURS -------------------------//
	
	//------------------------- ACCESSEURS -------------------------//
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Personne getUser() {
		return user;
	}
	public void setUser(Personne user) {
		this.user = user;
	}	

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	//------------------------- ACCESSEURS -------------------------//
}
