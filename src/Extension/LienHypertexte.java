/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extension;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.net.URI;
import java.util.Map;
import javax.swing.JLabel;

public class LienHypertexte extends javax.swing.JFrame
{
	//Ouverture du navigateur par defaut du systeme + ouverture page definie
	public void ouvertureLien(String lien)
	{
		try
		{
			URI uri = new URI(lien);
			Desktop dt = Desktop.getDesktop();
			dt.browse(uri);
		}
		catch(Exception ex){}
	}
	
	//Fonction permettant de gerer le soulignement lors du survol d'un Jlabel
	public void souligner(boolean enable, JLabel labelLien)
	{
		Font font = labelLien.getFont();
		Map map = font.getAttributes();
		
		if (enable)
		{
			map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			labelLien.setForeground(new Color(26,13,171));
			labelLien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		else
		{
			map.put(TextAttribute.UNDERLINE, null);
			labelLien.setForeground(new Color(0,0,0));
		}

		labelLien.setFont(font.deriveFont(map));
	}
}
