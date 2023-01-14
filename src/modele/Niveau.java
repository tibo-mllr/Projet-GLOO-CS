package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controle.ContenuCase;
import controle.Controleur;

public class Niveau {
	private int niveau; 
	
	public Niveau(int niveau) {
		this.niveau = niveau;
	}
	
	public boolean genererNiveau(Controleur controleur) {
		String[] line;
		Entrepot entrepot;
		Tuille tuilleReference;
		Personnage personnage = null;
		List<Tuille> objectifs = new ArrayList<Tuille>();
		
		try{
			File file = new File("niveaux/niveau" + niveau + ".csv");
			try (Scanner scan = new java.util.Scanner(file)) {
				line = scan.nextLine().split(",");
				entrepot = new Entrepot(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
				
				while(scan.hasNextLine()){
					line = scan.nextLine().split(",");
					
					switch (line[2]) {
					case "V":
						entrepot.addElement(new Position(Integer.parseInt(line[0]), Integer.parseInt(line[1])), new Tuille(ContenuCase.CASE_VIDE, entrepot));
						break;
					case "M":
						entrepot.addElement(new Position(Integer.parseInt(line[0]), Integer.parseInt(line[1])), new Tuille(ContenuCase.MUR, entrepot));
						break;
					case "C":
						entrepot.addElement(new Position(Integer.parseInt(line[0]), Integer.parseInt(line[1])), new Tuille(ContenuCase.CAISSE, entrepot));
						break;
					case "CR":
						tuilleReference = new Tuille(ContenuCase.CAISSE_RANGEE, entrepot);
						objectifs.add(tuilleReference);
						entrepot.addElement(new Position(Integer.parseInt(line[0]), Integer.parseInt(line[1])), tuilleReference);
						break;
					case "R":
						tuilleReference = new Tuille(ContenuCase.RANGEMENT, entrepot);
						objectifs.add(tuilleReference);
						entrepot.addElement(new Position(Integer.parseInt(line[0]), Integer.parseInt(line[1])), tuilleReference);
						break;
					case "J":
						tuilleReference = new Tuille(ContenuCase.JOUEUR, entrepot);
						personnage = new Personnage(tuilleReference);
						entrepot.addElement(new Position(Integer.parseInt(line[0]), Integer.parseInt(line[1])), tuilleReference);
						break;
					default:
						break;				
					}
				
				}
				
				controleur.setAttributes(entrepot, personnage, objectifs);
				
				return true;
				
				
			} catch (NumberFormatException e) {
				System.out.println("le format du fichier n'est pas compatible");
				e.printStackTrace();
				return false;
			}	
		}
		catch(FileNotFoundException e){
			return false;
		}

	}
	
	
	public void niveauSup() {
		this.niveau += 1;
	}
	
}
