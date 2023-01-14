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
    private Tuille tuille;

    public Mobile(Tuille tuille){
        this.tuille = tuille;
    }
    
    public Tuille getTuille() {
    	return tuille;
    }
    
    public void setTuille(Tuille t) {
    	tuille = t;
    }
    
    public abstract boolean deplacement(Direction direction);
}
