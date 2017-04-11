package test;

import java.io.BufferedReader;
//Packages à importer afin d'utiliser les objets
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class OuvrirTexte {

	public String ouverture (String nom) throws FileNotFoundException{
		try{
			InputStream flux=new FileInputStream(nom); 
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;
			String fichier = " ";
			while ((ligne=buff.readLine())!=null){
				fichier+=ligne;
				fichier+="\n";
				System.out.println(ligne);
			}
			buff.close(); 
			return fichier;
			
			}		
			catch (Exception e){
			System.out.println(e.toString());
			return " ";
			}
		
	      
	}
	   
}