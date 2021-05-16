package vue;

import java.awt.Color;

import javax.swing.JPanel;

import modele.Jeu;

public class JPanelCellule extends JPanel{
	private int x;
	private int y;
	
	public JPanelCellule(int x, int y) {
		this.x = x;
		this.y = y;
		this.setBackground(Color.WHITE);
	}
	
	public void miseAJour(Jeu jeu) {
		if(jeu.getEtatCase(x, y)) {
			this.setBackground(Color.BLACK);
		} else {
			this.setBackground(Color.WHITE);
		}
	}
	
	public int getX2() {
		return this.x;
	}
	
	public int getY2() {
		return this.y;
	}
}
