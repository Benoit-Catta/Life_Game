package fichier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import modele.Jeu;

public class CreatorFichierJeu {
	public CreatorFichierJeu(String[] monJeu, String nomFichier){
	 
		
		File file = new File(nomFichier);
		   // créer le fichier s'il n'existe pas
		   if (!file.exists()) {
		    try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		   }
     // create a new writer
		Writer writer;
		try {
			writer = new PrintWriter(nomFichier);
			try {
				// append a string
				writer.append(monJeu[0]);
				writer.append(monJeu[1]);
				writer.append(monJeu[2]);

	      	 // flush the writer
				writer.flush();

				// flush the stream again
				writer.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}