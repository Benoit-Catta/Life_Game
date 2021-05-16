package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controler.BoutonController;
import controler.CellulesControler;
import modele.Jeu;

public class Fenetre extends JFrame{
	
	private Jeu jeu;
	private JPanelCellule[][] mesCellules;
	
	public Fenetre(int x,int y) {
		this.jeu = new Jeu(x,y);
		this.mesCellules = new JPanelCellule[x][y];
		JPanel principal = new JPanel(new BorderLayout());
		
		JPanel map = new JPanel(new GridLayout(x,y));
		
		CellulesControler action = new CellulesControler(this.jeu,this);
		
		for( int i = 0 ; i < x ; i++ ) {
			for( int c = 0 ; c < y ; c++ ) {
				JPanelCellule uneCellules = new JPanelCellule(i,c); 
				uneCellules.addMouseListener(action);
				mesCellules[i][c] = uneCellules;
				map.add(uneCellules);
			}
		}
		
		BoutonController action2 = new BoutonController(this.jeu, this);
		
		JButton monBoutton = new JButton("next day");
		monBoutton.addActionListener(action2);
		
		principal.add(monBoutton,BorderLayout.SOUTH);

		
		principal.add(map,BorderLayout.CENTER);
		this.add(principal);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000,1000);
        this.setVisible(true);
		
	}
	
	public void miseAJour() {
		for( int i = 0 ; i < jeu.getLongueur() ; i++ ) {
			for( int c = 0 ; c < jeu.getLargeur() ; c++ ) {
				mesCellules[i][c].miseAJour(jeu);
			}
		}
	}
}
