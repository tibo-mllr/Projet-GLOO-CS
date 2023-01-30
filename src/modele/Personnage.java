package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Représentation du joueur dans le jeu
 * 
 * @author Thibault Muller, Raphaël Mahaut
 * @version 1.0
 *
 */


@objid ("e4a4bca7-c6da-482f-b386-834880b5d059")
public class Personnage extends Mobile {
    @objid ("840f3604-7967-4fc4-a392-fd910e83ad79")
    public Personnage() {
        super();
    }

    @objid ("0ec94641-f2c3-4d06-9b04-5cfbae90c02a")
    public boolean capablePousser(Mobile objet) {
        return (objet instanceof Caisse); // Le personnage est capable de déplacer les caisses en se déplaçant
    }

}
