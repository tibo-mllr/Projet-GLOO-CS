package main;

import javax.swing.SwingUtilities;

import controle.Controleur;
import ihm.FenetreSokoban;
import modele.Caisse;
import modele.Destination;
import modele.Entrepot;
import modele.Mur;
import modele.Personnage;
import modele.Position;

public class Main implements Runnable{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main());
	}

	public void run() {
		Entrepot entrepot = new Entrepot(5, 6);
		Controleur controleur = new Controleur(entrepot);
		new FenetreSokoban(controleur);
	}
}
