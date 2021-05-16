package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Jeu;
import vue.Fenetre;

public class BoutonController implements ActionListener{

	private Jeu jeu;
	private Fenetre fenetre;
	
	public BoutonController(Jeu jeu, Fenetre fenetre) {
		this.jeu = jeu;
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		jeu.jourSuivant();
		fenetre.miseAJour();
	}

}
