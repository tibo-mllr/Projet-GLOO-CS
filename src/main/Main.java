package main;

import javax.swing.SwingUtilities;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import controle.Controleur;
import ihm.FenetreSokoban;

/**
 * Fichier principal à exécuter pour lancer Sokoban
 * 
 * @author Thibault Muller, Raphaël Mahaut
 * @version 1.0
 *
 */


@objid ("e6392bf7-859c-453f-8733-635ee536e4b3")
public class Main implements Runnable {
    @objid ("1a018d78-c11c-4d9d-b816-a9122aff0ae0")
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Main());
    }

    @objid ("1000f5f1-5de7-4eaf-bce3-bd5c09372bca")
    @Override
    public void run() {
        Controleur controleur = new Controleur();    
        new FenetreSokoban(controleur);
    }

}
