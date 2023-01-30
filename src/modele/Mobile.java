package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import controle.Direction;

/**
 * Elements du jeu Sokoban pouvant se déplacer
 * 
 * @author Thibault Muller, Raphaël Mahaut
 * @version 1.0
 *
 */


@objid ("5d9ffd25-495a-4f66-8fe3-f2b3fea01b50")
public abstract class Mobile {
    @objid ("842309ee-a6a1-4ee0-af9b-17e887d7c1cc")
    private Tuile tuile;

    @objid ("6db1cb8a-0f2a-48ad-9949-aaed267f6ac7")
    public void settuile(Tuile nouvelletuile) {
        tuile = nouvelletuile;
    }

    @objid ("400c5d4c-3659-4c81-ba72-f9eff447e123")
    public Mobile() {
    }

    @objid ("12c85eae-bfc3-45d1-bb8e-5e2edf166f55")
    public boolean deplacement(Direction direction) {
        Tuile tuileVoisine = tuile.tuileVoisine(direction);
        if (tuileVoisine == null) {
            return false;
        }
        if (tuileVoisine.demandeDeplacement(direction, this)) {
            changementtuile(tuileVoisine);
            return true;
        }
        else {
            return false;
        }
    }

    @objid ("9e3fdfab-5ec7-40fa-b7d0-ba52deabc422")
    public void changementtuile(Tuile nouvelletuile) {
        tuile.oubli(); // dit à la tuile qui contient l'objet qu'il se déplace
        tuile = nouvelletuile; // change la tuile dans laquelle est l'objet
    }

    @objid ("59ded501-42ac-4ace-adf0-dce1b5c374ba")
    public abstract boolean capablePousser(Mobile objet);

}
