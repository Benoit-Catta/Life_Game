package modele;

import java.util.Iterator;

public class Jeu {
	private int largeur;
	private int longueur;
	private Cellule[][] zone;
	
	public Jeu(int longueur, int largeur) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.zone = new Cellule[longueur][largeur];
		
		for(int i = 0 ; i < longueur ; i++ ) {
			for(int c = 0 ; c < longueur ; c++ ) {
				this.zone[i][c] = new Cellule(i, c);
			}
		}
	}
	
	public boolean getEtatCase(int x,int y) {
		return this.zone[x][y].getEtat();
	}
	
	public void setEtatCase(int x,int y, boolean b) {
		this.zone[x][y].setEtat(b);
	}
	
	public void changeEtatCase(int x,int y) {
		this.zone[x][y].changeEtat();
	}
	
	public void jourSuivant() {
		Cellule[][] zone2 = new Cellule[longueur][largeur];
		for(int i = 0 ; i < longueur ; i++ ) {
			for(int c = 0 ; c < longueur ; c++ ) {
				zone2[i][c] = new Cellule(i, c);
			}
		}
		for(int i = 0 ; i < longueur ; i++ ) {
			for(int c = 0 ; c < longueur ; c++ ) {
				zone2[i][c].setEtat(getNextEtat(i,c));
			}
		}
		this.zone = zone2;
	}
	
	public boolean getNextEtat(int x, int y) {
		if( getNombreVoisin(x,y) == 3 && zone[x][y].getEtat() == false ) {
			return true;
		}
		if( (getNombreVoisin(x,y) == 2 || getNombreVoisin(x,y) == 3 ) && zone[x][y].getEtat() == true ) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public int getNombreVoisin(int x, int y) {
		int res = 0;
		if(x != 0 && x != longueur-1 && y != this.largeur-1 && y != 0) {
			if(zone[x-1][y].getEtat()) {res++;}
			if(zone[x-1][y-1].getEtat()) {res++;}
			if(zone[x-1][y+1].getEtat()) {res++;}
			if(zone[x][y+1].getEtat()) {res++;}
			if(zone[x][y-1].getEtat()) {res++;}
			if(zone[x+1][y+1].getEtat()) {res++;}
			if(zone[x+1][y-1].getEtat()) {res++;}
			if(zone[x+1][y].getEtat()) {res++;}
			return res;
		}
		if(x == 0 && y == 0) {
			if(zone[x+1][y].getEtat()) {res++;}
			if(zone[x][y+1].getEtat()) {res++;}
			if(zone[x+1][y+1].getEtat()) {res++;}
			return res;
		}
		if(x == this.longueur-1 && y == this.largeur-1) {
			if(zone[x-1][y].getEtat()) {res++;}
			if(zone[x][y-1].getEtat()) {res++;}
			if(zone[x-1][y-1].getEtat()) {res++;}
			return res;
		}
		if(x == 0 && y == this.largeur-1) {
			if(zone[x+1][y].getEtat()) {res++;}
			if(zone[x+1][y-1].getEtat()) {res++;}
			if(zone[x][y-1].getEtat()) {res++;}
			return res;
		}
		if(y == 0 && x == this.largeur-1) {
			if(zone[x-1][y].getEtat()) {res++;}
			if(zone[x-1][y+1].getEtat()) {res++;}
			if(zone[x][y+1].getEtat()) {res++;}
			return res;
		}
		
		if(x != 0 && x != longueur-1 && y == 0) {
			if(zone[x-1][y].getEtat()) {res++;}
			if(zone[x+1][y].getEtat()) {res++;}
			if(zone[x][y+1].getEtat()) {res++;}
			if(zone[x-1][y+1].getEtat()) {res++;}
			if(zone[x+1][y+1].getEtat()) {res++;}
			return res;
		}
		if(x != 0 && x != longueur-1 && y == largeur-1) {
			if(zone[x-1][y].getEtat()) {res++;}
			if(zone[x+1][y].getEtat()) {res++;}
			if(zone[x][y-1].getEtat()) {res++;}
			if(zone[x-1][y-1].getEtat()) {res++;}
			if(zone[x+1][y-1].getEtat()) {res++;}
			return res;
		}
		if(y != 0 && y != largeur-1 && x == 0) {
			if(zone[x][y-1].getEtat()) {res++;}
			if(zone[x][y+1].getEtat()) {res++;}
			if(zone[x+1][y+1].getEtat()) {res++;}
			if(zone[x+1][y-1].getEtat()) {res++;}
			if(zone[x+1][y].getEtat()) {res++;}
			return res;
		}
		if(y != 0 && y != largeur-1 && x == longueur-1) {
			if(zone[x][y+1].getEtat()) {res++;}
			if(zone[x][y-1].getEtat()) {res++;}
			if(zone[x-1][y-1].getEtat()) {res++;}
			if(zone[x-1][y+1].getEtat()) {res++;}
			if(zone[x-1][y].getEtat()) {res++;}
			return res;
		}
		return -1;
	}
	
	public int getLongueur() {
		return this.longueur;
	}
	
	public int getLargeur() {
		return this.largeur;
	}
}
