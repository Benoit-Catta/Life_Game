package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import fichier.LireJeuFichier;
import modele.Jeu;
import vue.Fenetre;

public class ImportJeuControler implements ActionListener{

	private Fenetre fenetre;
	
	public ImportJeuControler(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(fenetre.getFichierImport() != null && !fenetre.getFichierImport().equals("")) {
			try {
				LireJeuFichier action = new LireJeuFichier(fenetre.getFichierImport());
				fenetre.setTaille(action.getJeu(),action.getLongueur(), action.getLargeur());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
