package main;

import javax.swing.SwingUtilities;

import controle.ContenuCase;
import controle.Controleur;
import ihm.FenetreSokoban;
import modele.Entrepot;
import modele.Personnage;
import modele.Position;
import modele.Tuille;

public class Main implements Runnable{
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main());
	}
	
	
	@Override
	public void run() {
		Entrepot entrepot = new Entrepot(8, 9);
		Position positionPersonnage = new Position(2, 2);
		Tuille tuillePersonnage = new Tuille(ContenuCase.JOUEUR, entrepot);
		entrepot.addElement(positionPersonnage, tuillePersonnage);
		Personnage personnage = new Personnage(tuillePersonnage);
		Controleur controleur = new Controleur(entrepot, personnage);
		
		entrepot.addElement(new Position(2, 3), new Tuille(ContenuCase.CAISSE, entrepot));
		entrepot.addElement(new Position(3, 4), new Tuille(ContenuCase.CAISSE, entrepot));
		entrepot.addElement(new Position(4, 4), new Tuille(ContenuCase.CAISSE, entrepot));
		entrepot.addElement(new Position(6, 4), new Tuille(ContenuCase.CAISSE, entrepot));
		entrepot.addElement(new Position(6, 5), new Tuille(ContenuCase.CAISSE, entrepot));
		entrepot.addElement(new Position(6, 1), new Tuille(ContenuCase.CAISSE, entrepot));
		
		for (int i=1; i<9; i++) {
			entrepot.addElement(new Position(i, 0), new Tuille(ContenuCase.MUR, entrepot));
		}
		for (int i=0; i<6; i++) {
			entrepot.addElement(new Position(i, 6), new Tuille(ContenuCase.MUR, entrepot));
		}
		for (int i=5; i<9; i++) {
			entrepot.addElement(new Position(i, 7), new Tuille(ContenuCase.MUR, entrepot));
		}
		
		for (int j=2; j<6; j++) {
			entrepot.addElement(new Position(0, j), new Tuille(ContenuCase.MUR, entrepot));
		}
		for (int j=1; j<3; j++) {
			entrepot.addElement(new Position(1, j), new Tuille(ContenuCase.MUR, entrepot));
		}
		for (int j=1; j<3; j++) {
			entrepot.addElement(new Position(3, j), new Tuille(ContenuCase.MUR, entrepot));
		}
		for (int j=2; j<4; j++) {
			entrepot.addElement(new Position(4, j), new Tuille(ContenuCase.MUR, entrepot));
		}
		entrepot.addElement(new Position(5, 2), new Tuille(ContenuCase.MUR, entrepot));
		for (int j=1; j<7; j++) {
			entrepot.addElement(new Position(8, j), new Tuille(ContenuCase.MUR, entrepot));
		}
		
		Position positionDest = new Position(2, 1);
		Tuille tuilleDest = new Tuille(ContenuCase.RANGEMENT, entrepot);
		entrepot.addElement(positionDest, tuilleDest);
		controleur.addObjectif(tuilleDest);
		
		positionDest = new Position(3, 5);
		tuilleDest = new Tuille(ContenuCase.RANGEMENT, entrepot);
		entrepot.addElement(positionDest, tuilleDest);
		controleur.addObjectif(tuilleDest);
		
		positionDest = new Position(4, 1);
		tuilleDest = new Tuille(ContenuCase.RANGEMENT, entrepot);
		entrepot.addElement(positionDest, tuilleDest);
		controleur.addObjectif(tuilleDest);
		
		positionDest = new Position(5, 4);
		tuilleDest = new Tuille(ContenuCase.RANGEMENT, entrepot);
		entrepot.addElement(positionDest, tuilleDest);
		controleur.addObjectif(tuilleDest);
		
		positionDest = new Position(6, 6);
		tuilleDest = new Tuille(ContenuCase.RANGEMENT, entrepot);
		entrepot.addElement(positionDest, tuilleDest);
		controleur.addObjectif(tuilleDest);
		
		positionDest = new Position(7, 4);
		tuilleDest = new Tuille(ContenuCase.RANGEMENT, entrepot);
		entrepot.addElement(positionDest, tuilleDest);
		controleur.addObjectif(tuilleDest);
		
		positionDest = new Position(6, 3);
		tuilleDest = new Tuille(ContenuCase.CAISSE_RANGEE, entrepot);
		entrepot.addElement(positionDest, tuilleDest);
		controleur.addObjectif(tuilleDest);
		
		entrepot.addElement(new Position(1, 3), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(1, 4), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(1, 5), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(2, 4), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(2, 5), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(3, 3), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(4, 5), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(5, 1), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(5, 3), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(5, 5), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(6, 2), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(7, 1), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(7, 2), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(7, 3), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(7, 5), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		entrepot.addElement(new Position(7, 6), new Tuille(ContenuCase.CASE_VIDE, entrepot));
		
		new FenetreSokoban(controleur);
	}
	
}
