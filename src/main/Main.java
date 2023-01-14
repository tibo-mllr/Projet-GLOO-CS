package main;

import javax.swing.SwingUtilities;

import controle.Controleur;
import ihm.FenetreSokoban;


public class Main implements Runnable{
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main());
	}
	
	
	@Override
	public void run() {
		Controleur controleur = new Controleur();	
		new FenetreSokoban(controleur);
	}
	
}
