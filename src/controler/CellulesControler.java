package controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modele.Jeu;
import vue.Fenetre;
import vue.JPanelCellule;

public class CellulesControler implements MouseListener{
	
	private Jeu jeu;
	private Fenetre fenetre;
	
	public CellulesControler(Jeu jeu, Fenetre fenetre) {
		this.jeu = jeu;
		this.fenetre = fenetre;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JPanelCellule cellule = (JPanelCellule) e.getSource();
		jeu.changeEtatCase(cellule.getX2(), cellule.getY2());
		cellule.miseAJour(jeu);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
