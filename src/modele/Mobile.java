package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("5d9ffd25-495a-4f66-8fe3-f2b3fea01b50")
public class Mobile {
    @objid ("842309ee-a6a1-4ee0-af9b-17e887d7c1cc")
    private Tuille tuille;
    
    public Tuille getTuille() {
    	return tuille;
    }
    
    public void setTuille(Tuille t) {
    	tuille = t;
    }
}
