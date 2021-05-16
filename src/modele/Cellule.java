package modele;

public class Cellule {
	private int x;
	private int y;
	private boolean vivant;
	
	public Cellule(int x,int y) {
		this.x = x;
		this.y = y;
		this.vivant = false;
	}
	
	public void changeEtat() {
		if(this.vivant) {
			this.vivant = false;
		} else {
			this.vivant = true;
		}
	}
	
	public boolean getEtat() {
		return this.vivant;
	}
	
	public void setEtat(boolean b) {
		this.vivant = b;
	}
	
	public int getX2() {
		return this.x;
	}
	
	public int getY2() {
		return this.y;
	}
	
}
