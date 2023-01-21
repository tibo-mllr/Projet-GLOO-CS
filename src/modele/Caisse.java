package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("bb1d5882-9557-4d2c-8711-3ec4df4c932d")
public class Caisse extends Mobile {
    @objid ("c132944f-8871-4d5d-a77a-c6942c71d6da")
    public Caisse() {
        super();
    }
    
    public boolean capablePousser(Mobile objet) {
    	return false;
    }

}
