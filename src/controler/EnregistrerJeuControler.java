package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fichier.CreatorFichierJeu;
import modele.Jeu;
import vue.Fenetre;

public class EnregistrerJeuControler implements ActionListener{
	
	private Jeu jeu;
	private Fenetre fenetre;
	
	public EnregistrerJeuControler(Jeu jeu, Fenetre fenetre) {
		this.jeu = jeu;
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] maString = new String[3];
		maString = jeu.toStringJeu();
		System.out.print(maString[0]);
		System.out.print(maString[1]);
		System.out.print(maString[2]);
		System.out.println(fenetre.getFichierEnregistrer());
		if(fenetre.getFichierEnregistrer() != null && !fenetre.getFichierEnregistrer().equals("")) {
			//System.out.println("clic");
			CreatorFichierJeu crea = new CreatorFichierJeu(maString,fenetre.getFichierEnregistrer());
			//System.out.println("clic2");
		}
		/*if(fenetre.getFichierEnregistrer() != null && !fenetre.getFichierEnregistrer().equals("")) {
			System.out.println("clic2");
			CreatorFichierJeu action = new CreatorFichierJeu(this.jeu,fenetre.getFichierEnregistrer());
			System.out.println("clic3");
		}*/
	}

}
