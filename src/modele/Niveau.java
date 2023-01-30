package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import controle.Controleur;

/**
 * Classe permettant de gérer les niveaux et de générer l'entrepot et l'ensemble des objets qui y sont contenus
 * 
 * @author Thibault Muller, Raphaël Mahaut
 * @version 1.0
 *
 */


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
        Entrepot entrepot= new Entrepot();
        Tuile tuileTemporaire;
        Mobile mobileTemporaire;
        Personnage personnage = null;
        List<Tuile> objectifs = new ArrayList<Tuile>();
        int nbCaisses = 0;
        int nbDestinations = 0;
        
        try{
            File file = new File("niveaux/niveau_" + niveau + ".csv"); // lecture du fichier contenant la description du niveau.
            
            try (Scanner scan = new java.util.Scanner(file)) {
                int i = 0;
                
                while(scan.hasNextLine()){
                    line = scan.nextLine().split(",");
                    
                    for (int j = 0; j < line.length; j++) {
                        switch (line[j]) {
                            case "V":
                                tuileTemporaire = new Tuile(Fixe.NORMAL, null, entrepot);
                                entrepot.addElement(i, j, tuileTemporaire);
                                break;
                            case "M":
                                tuileTemporaire = new Tuile(Fixe.MUR, null, entrepot);
                                entrepot.addElement(i, j, tuileTemporaire);
                                break;
                            case "C":
                                mobileTemporaire = new Caisse();
                                tuileTemporaire = new Tuile(Fixe.NORMAL, mobileTemporaire, entrepot);
                                mobileTemporaire.settuile(tuileTemporaire);
                                entrepot.addElement(i, j, tuileTemporaire);
                                nbCaisses++;
                                break;
                            case "R":
                                mobileTemporaire = new Caisse();
                                tuileTemporaire = new Tuile(Fixe.DESTINATION, mobileTemporaire, entrepot);
                                mobileTemporaire.settuile(tuileTemporaire);
                                objectifs.add(tuileTemporaire);
                                entrepot.addElement(i, j, tuileTemporaire);
                                nbCaisses++;
                                nbDestinations++;
                                break;
                            case "D":
                                tuileTemporaire = new Tuile(Fixe.DESTINATION, null, entrepot);
                                objectifs.add(tuileTemporaire);
                                entrepot.addElement(i, j, tuileTemporaire);
                                nbDestinations++;
                                break;
                            case "J":
                                if (personnage != null) {
                                    System.out.println("le fichier " + "niveau_" + niveau + ".csv" + " ne correspond pas à un niveau car il y a plusieurs personnages");
                                    niveau++;
                                    return genererNiveau(controleur);
                                }
                                personnage = new Personnage();
                                tuileTemporaire = new Tuile(Fixe.NORMAL, personnage, entrepot);
                                personnage.settuile(tuileTemporaire);
                                entrepot.addElement(i, j, tuileTemporaire);
                                break;
                            default:
                                break;                
                        }
                            
                    }
                    i++;
                }
                if (nbCaisses != nbDestinations) {
                    System.out.println("le fichier " + "niveau_" + niveau + ".csv" + " ne correspond pas à un niveau car il n'y a pas autant de caisses que de destinations");
                    niveau++;
                    return genererNiveau(controleur);
                }
                
                if (personnage == null) {
                    System.out.println("le fichier " + "niveau_" + niveau + ".csv" + " ne correspond pas à un niveau car n'a pas de personnage");
                    niveau++;
                    return genererNiveau(controleur);
                }
                controleur.setAttributes(entrepot, personnage, objectifs);
                
                return true;
                
                
            } catch (NumberFormatException e) {
                System.out.println("le format du fichier " + "niveaux/niveau_" + niveau + ".csv" + " n'est pas compatible");
                e.printStackTrace();
                niveau++;
                return genererNiveau(controleur);
            }    
        }
        catch(FileNotFoundException e){
            return false;
        }
    }

    @objid ("24307792-2ad2-4dea-ad30-65b97e4e6645")
    public void niveauSup() { 
        this.niveau++;
    }

}
