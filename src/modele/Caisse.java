package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("bb1d5882-9557-4d2c-8711-3ec4df4c932d")
public class Caisse extends Mobile {

    public Caisse(Tuille tuille){
        super(tuille);
     }

    public boolean deplacement(Direction direction) {
		Tuille tuilleVoisine = super.getTuille().tuilleVoisine(direction);
    	if (tuilleVoisine.demandeDeplacement(this)){
    		super.setTuille(tuilleVoisine);
    		return true;
    	}
    	else {
    		return false;
    	}
	}

}
