package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Représentation des caisses contenus dans l'entrepot
 * 
 * @author Thibault Muller, Raphaël Mahaut
 * @version 1.0
 *
 */


@objid ("bb1d5882-9557-4d2c-8711-3ec4df4c932d")
public class Caisse extends Mobile {
    @objid ("c132944f-8871-4d5d-a77a-c6942c71d6da")
    public Caisse() {
        super();
    }

    @objid ("95988845-d292-40cc-acb5-7f9b26c90587")
    public boolean capablePousser(Mobile objet) {
        return false; // Une Caisse ne peut pas faire se déplacer un autre objet mobile
    }

}
