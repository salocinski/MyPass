/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extension;

import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author utilisateur
 */
public class IconesPerso
{
	//------------------------- ATTRIBUTS -------------------------//
	private final String iconeAdresseQuitter = "../icones/iconeQuitter.png";
	private final String iconeAdresseRetour = "../icones/iconeRetour.png";
	private final String iconeAdresseAjouter = "../icones/iconeAjouter.png";
	private final String iconeAdresseSupprimer = "../icones/iconeSupprimer.png";
	private final String iconeAdresseModifier = "../icones/iconeModifier.png";
	private final String iconeAdresseValider = "../icones/iconeValider.png";
	//------------------------- ATTRIBUTS -------------------------//
	
	//On transmets le bouton ou on doit insérer l'icone et l'adresse ou se situe le fichier image de l'icone.
	public void iconeBouton(JButton bouton, String adresse)
	{
		try
		{
			Image img = ImageIO.read(getClass().getResource(adresse));
			bouton.setIcon(new ImageIcon(img));
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	//On transmets le bouton ou on doit insérer l'icone et l'adresse ou se situe le fichier image de l'icone.
	public void iconeLabel(JLabel label, String adresse)
	{
		try
		{
			Image img = ImageIO.read(getClass().getResource(adresse));
			label.setIcon(new ImageIcon(img));
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
}
