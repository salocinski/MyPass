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
	//On transmets le bouton ou on doit insérer l'icone et l'adresse ou se situe le fichier image de l'icone.
	public void iconeBouton(JButton bouton, String adresse)
	{
		try
		{
			Image img = ImageIO.read(getClass().getResourceAsStream(adresse));
			bouton.setIcon(new ImageIcon(img));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
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
