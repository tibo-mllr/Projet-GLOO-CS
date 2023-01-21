package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("e4a4bca7-c6da-482f-b386-834880b5d059")
public class Personnage extends Mobile {
    
    @objid ("840f3604-7967-4fc4-a392-fd910e83ad79")
    public Personnage() {
    	super();
    }       
    
    
    public boolean capablePousser(Mobile objet) {
    	return (objet instanceof Caisse);
    }

}
