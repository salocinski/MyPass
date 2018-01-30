/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extension;

/**
 *
 * @author utilisateur
 */
public class GestionDate
{
	//------------------------- ATTRIBUTS -------------------------//
	private int jour;
	private int mois;
	private int annee;
	private boolean statut;
	//------------------------- ATTRIBUTS -------------------------//
	
	public GestionDate(int jour, int mois, int annee)
	{
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
		this.statut = testDate(jour, mois, annee);
	}
	
	public int nbrJours(int mois)
	{
		switch (mois)
		{
			case 1: return 31;
			case 3: return 31;
			case 5: return 31;
			case 7: return 31;
			case 8: return 31;
			case 10: return 31;
			case 12: return 31;
			case 4: return 30;
			case 6: return 30;
			case 9: return 30;
			case 11: return 30;
		}
		if (mois==2)
		{
			if (Bissextile(annee)== true)
				return 29; 
		}
		else
			return 28;
		
		return 0; 
	}

	private boolean Bissextile(int annee)
	{
		if ((annee%4)==0)
			return true;
		
		return false;
	}
	
	private boolean testDate(int jour, int mois, int annee)
	{
		if (jour<=nbrJours(mois))
			return true;
		return false; 
	}
	//------------------------- ACCESSEURS -------------------------//
	public boolean isStatut()
	{
		return statut;
	}
	//------------------------- ACCESSEURS -------------------------//
}
