package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import controle.Controleur;
import controle.Direction;

@objid ("e4a4bca7-c6da-482f-b386-834880b5d059")
public class Personnage extends Mobile {
    
    public Personnage(Tuille tuille){
       super(tuille);
    }

    @objid ("eafcb64f-3257-4ce0-83f0-d9d744db45b3")
    public boolean deplacement(Direction direction) {
    	Tuille tuilleVoisine = super.getTuille().tuilleVoisine(direction);
    	if (tuilleVoisine.demandeDeplacement(direction, this)) {
    		super.setTuille(tuilleVoisine);
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}
