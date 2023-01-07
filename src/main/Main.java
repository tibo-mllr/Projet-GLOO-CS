package main;

import javax.swing.SwingUtilities;

import controle.Controleur;
import controle.ControleurBouchon;
import ihm.FenetreSokoban;
import modele.Entrepot;
import modele.Personnage;

public class Main implements Runnable{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main());
	}

	public void run() {
		Entrepot entrepot = new Entrepot(5, 6);
		Personnage personnage = new Personnage()
		Controleur controleur = new Controleur(personnage, entrepot);
		new FenetreSokoban(controleur);
	}
}
