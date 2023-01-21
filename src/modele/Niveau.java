package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import controle.Controleur;

@objid ("51a617df-0e43-4fe3-9ea6-d17326c0f908")
public class Niveau {
    @objid ("59602800-5249-4064-88f3-e66229866dc9")
    private int niveau;

    @objid ("33d113c2-d4c3-4d82-b7dd-3d909f9e6e76")
    public Niveau(int niveau) {
        this.niveau = niveau;
    }

    @objid ("86cfb652-f257-4ad4-aec4-c778fe945caf")
    public boolean genererNiveau(Controleur controleur) {
        String[] line;
        Entrepot entrepot;
        Tuille tuilleTemporaire;
        Mobile mobileTemporaire;
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
                    	tuilleTemporaire = new Tuille(Fixe.NORMAL, null, entrepot);
                        entrepot.addElement(new Position(Integer.parseInt(line[0]), Integer.parseInt(line[1])), tuilleTemporaire);
                        break;
                    case "M":
                        tuilleTemporaire = new Tuille(Fixe.MUR, null, entrepot);
                        entrepot.addElement(new Position(Integer.parseInt(line[0]), Integer.parseInt(line[1])), tuilleTemporaire);
                        break;
                    case "C":
                    	mobileTemporaire = new Caisse();
                        tuilleTemporaire = new Tuille(Fixe.NORMAL, mobileTemporaire, entrepot);
                        entrepot.addElement(new Position(Integer.parseInt(line[0]), Integer.parseInt(line[1])), tuilleTemporaire);
                        mobileTemporaire.setTuille(tuilleTemporaire);
                        break;
                    case "CR":
                    	mobileTemporaire = new Caisse();
                        tuilleTemporaire = new Tuille(Fixe.DESTINATION, mobileTemporaire, entrepot);
                        entrepot.addElement(new Position(Integer.parseInt(line[0]), Integer.parseInt(line[1])), tuilleTemporaire);
                        mobileTemporaire.setTuille(tuilleTemporaire);
                        
                        objectifs.add(tuilleTemporaire);
                        break;
                    case "R":
                        tuilleTemporaire = new Tuille(Fixe.DESTINATION, null, entrepot);
                        entrepot.addElement(new Position(Integer.parseInt(line[0]), Integer.parseInt(line[1])), tuilleTemporaire);
                        
                        objectifs.add(tuilleTemporaire);
                        break;
                    case "J":
                    	personnage = new Personnage();
                        tuilleTemporaire = new Tuille(Fixe.NORMAL, personnage, entrepot);
                        entrepot.addElement(new Position(Integer.parseInt(line[0]), Integer.parseInt(line[1])), tuilleTemporaire);
                        personnage.setTuille(tuilleTemporaire);
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

    @objid ("24307792-2ad2-4dea-ad30-65b97e4e6645")
    public void niveauSup() {
        this.niveau += 1;
    }

}
