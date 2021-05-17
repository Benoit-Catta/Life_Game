package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controler.BoutonController;
import controler.CellulesControler;
import controler.EnregistrerJeuControler;
import controler.ImportJeuControler;
import modele.Jeu;

public class Fenetre extends JFrame{
	
	private Jeu jeu;
	private JPanelCellule[][] mesCellules;
	private JTextField newJeuFichierText;
	private JButton testImportJeuButton;
	private JTextField enregistrerFichierJeuText;
	private JButton enregistrerFichierJeuButton;
	
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
		
		principal.add(map,BorderLayout.CENTER);
		
		BoutonController action2 = new BoutonController(this.jeu, this);
		
		JButton monBoutton = new JButton("next day");
		monBoutton.addActionListener(action2);
		
		principal.add(monBoutton,BorderLayout.SOUTH);

		JPanel est = new JPanel(new GridLayout(4,1));
		
		newJeuFichierText = new JTextField();
		testImportJeuButton = new JButton("Importer jeu");
		enregistrerFichierJeuText = new JTextField();
		enregistrerFichierJeuButton = new JButton("enregistrer jeu");
		
		est.add(newJeuFichierText);
		
		ImportJeuControler action3 = new ImportJeuControler(this);
		testImportJeuButton.addActionListener(action3);
		
		est.add(testImportJeuButton);
		
		est.add(enregistrerFichierJeuText);
		
		EnregistrerJeuControler action4 = new EnregistrerJeuControler(this.jeu,this);
		enregistrerFichierJeuButton.addActionListener(action4);
		
		est.add(enregistrerFichierJeuButton); 
		
		principal.add(est,BorderLayout.EAST);
		
		this.add(principal);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000,1000);
        this.setVisible(true);
		
	}
	
	public Fenetre(Jeu jeu,int x,int y) {
		this.jeu = jeu;
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
		
		principal.add(map,BorderLayout.CENTER);
		
		BoutonController action2 = new BoutonController(this.jeu, this);
		
		JButton monBoutton = new JButton("next day");
		monBoutton.addActionListener(action2);
		
		principal.add(monBoutton,BorderLayout.SOUTH);

		JPanel est = new JPanel(new GridLayout(4,1));
		
		newJeuFichierText = new JTextField();
		testImportJeuButton = new JButton("Importer jeu");
		enregistrerFichierJeuText = new JTextField();
		enregistrerFichierJeuButton = new JButton("enregistrer jeu");
		
		est.add(newJeuFichierText);
		
		ImportJeuControler action3 = new ImportJeuControler(this);
		testImportJeuButton.addActionListener(action3);
		
		est.add(testImportJeuButton);
		
		est.add(enregistrerFichierJeuText);
		
		EnregistrerJeuControler action4 = new EnregistrerJeuControler(this.jeu,this);
		enregistrerFichierJeuButton.addActionListener(action4);
		
		est.add(enregistrerFichierJeuButton); 
		
		principal.add(est,BorderLayout.EAST);
		
		this.add(principal);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000,1000);
        this.setVisible(true);
        this.miseAJour();
		
	}
	
	public void miseAJour() {
		for( int i = 0 ; i < jeu.getLongueur() ; i++ ) {
			for( int c = 0 ; c < jeu.getLargeur() ; c++ ) {
				mesCellules[i][c].miseAJour(jeu);
			}
		}
	}
	
	public void setTaille(Jeu jeu,int lo, int la) {
		this.dispose();
		Fenetre f = new Fenetre(jeu,lo,la);
	}
	
	public void reset() {
		this.dispose();
		Fenetre f = new Fenetre(50,50);
	}
	
	public String getFichierImport() {
		return this.newJeuFichierText.getText();
	}
	
	public String getFichierEnregistrer() {
		return this.enregistrerFichierJeuText.getText();
	}
}
