/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extension;

import java.io.InputStreamReader;
import java.io.FileInputStream;
 
public class FileHelper
{
	private static final int BUFFER_SIZE = 2048;
 
	public static String readFile(String path)
	{
		StringBuilder fileContent = new StringBuilder();
		try
		{
			InputStreamReader fichier = new InputStreamReader(new FileInputStream(path), "utf8");		
			int nbCharRead = BUFFER_SIZE;
			
			while ( BUFFER_SIZE == nbCharRead)
			{
				char[] buffer = new char[BUFFER_SIZE];
				nbCharRead = fichier.read(buffer);
				
				if(nbCharRead>0)
					fileContent.append(buffer, 0, nbCharRead);
			}
			fichier.close();
		}
		catch (Exception e)
		{
			e.printStackTrace(System.err);
		}
		
		return fileContent.toString();
	}
}
