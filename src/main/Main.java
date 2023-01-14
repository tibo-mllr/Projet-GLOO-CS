package main;

import javax.swing.SwingUtilities;

import controle.Controleur;
import ihm.FenetreSokoban;

/**
 * Fichier principal à executer pour lancer Sokoban
 * 
 * @author Thibault Muller, Raphaël Mahaut
 * @version 1.0
 *
 */


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
