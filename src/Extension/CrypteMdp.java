/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extension;

//CrypteMdp est construite sur le principe du chiffre de Cesar.
//Afin d'éviter les erreurs de chiffrage / déchiffrage.
//Le chiffre de César est défini en attribut de classe.
public class CrypteMdp
{
	//------------------------- ATTRIBUTS -------------------------//
	private static final int TAILLE_ALPHABET = 256;
    private String texte;
	private int decalage = 4;
	//------------------------- ATTRIBUTS -------------------------//
	
	
    public CrypteMdp(String texte)
	{
        this.texte = texte;
    }
    //Fonction pour crypter le "texte". Doit être stocké dans une variable String
	//On utilise cette fonction pour chiffre un mdp
	//L'overRide de cette fonction permet de gérer le déchiffrage du cryptage.
	public String chiffrer()
	{
        StringBuilder sb = new StringBuilder(texte.length());

        for (char c : texte.toCharArray())
		{
			int valeurAscii = (int) c;
			
            if (valeurAscii >= 0 && valeurAscii <= 255)
                sb.append(decaleVar(c, decalage, '!'));
			else
                sb.append(c);
        }

        return sb.toString();
    }
	
	//Fonction OverRidée pour gérer le déchiffrage des données.
	public String chiffrer(int decalage)
	{
        StringBuilder sb = new StringBuilder(texte.length());

        for (char c : texte.toCharArray())
		{
			int valeurAscii = (int) c;

            if (valeurAscii >= 0 && valeurAscii <= 255)
                sb.append(decaleVar(c, decalage, '!'));
			else
                sb.append(c);
        }

        return sb.toString();
    }
    
	public String dechiffrer()
	{
        return chiffrer(-decalage);
    }
 
    private char decaleVar(char caractere, int decalage, char caractereBase)
	{
        int base = (int) caractereBase;
		
        if (decalage < 0)
            base += TAILLE_ALPHABET - 1;
		
        return (char) ((((int) caractere) - base + decalage) % TAILLE_ALPHABET + base);
    }
}