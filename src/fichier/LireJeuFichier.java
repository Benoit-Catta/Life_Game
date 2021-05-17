package fichier;

import java.io.*;


import modele.Jeu;


public class LireJeuFichier {
	private Jeu jeu;
	private int longueur;
	private int largeur;
		
   public LireJeuFichier(String args) throws IOException{
	    BufferedReader lecteurAvecBuffer = null;
	    String ligne;
	    
	    try
	      {
		lecteurAvecBuffer = new BufferedReader(new FileReader(args));
	      }
	    catch(FileNotFoundException exc)
	      {
		System.out.println("Erreur d'ouverture");
	      }
	    int longueur = 0;
	    int largeur = 0;
	    String[] game;
	    
	    	ligne = lecteurAvecBuffer.readLine();
	    	//System.out.println(ligne);
	    	longueur = (int) Integer.parseInt(ligne);
	    	this.longueur = longueur;
	    	//System.out.println(longueur);
	    	
	    	ligne = lecteurAvecBuffer.readLine();
	    	//System.out.println(ligne);
	    	largeur = (int) Integer.parseInt(ligne);
	    	this.largeur = largeur;
	    	
	    	game = new String[longueur];
	    	this.jeu = new Jeu(longueur,largeur);
	    	int c = 0;
	    	while ((ligne = lecteurAvecBuffer.readLine()) != null) {
	    		game[c] = ligne;
	    		c++;
	    	}
	    	for(int i = 0 ; i < longueur ; i++) {
	    		int compteur = 0;
	    		boolean vivant = false;
	    		for (String s: game[i].split("/")) {
	    			if(vivant && s != null) {
	    				for(int u = 0 ; u < (int) Integer.parseInt(s); u++) {
	    					jeu.changeEtatCase(i, compteur+u);
	    				}
	    			}
	    	        vivant = !vivant;
	    			compteur = compteur + (int) Integer.parseInt(s);
	    	      }
	    	}
	    
	      
	    lecteurAvecBuffer.close();
	}
   
   public Jeu getJeu() {
	   return this.jeu;
   }
   
   public int getLongueur() {
	   return this.longueur;
   }
   
   public int getLargeur() {
	   return this.largeur;
   }
}