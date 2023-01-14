package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import controle.ContenuCase;
import controle.Direction;

@objid ("7ac4f54a-f5bd-4501-9651-9ca090bcdcda")
public class Tuille {
    @objid ("e05013da-1500-4137-81b7-c9d188449edd")
    private Fixe fixe;

    @objid ("9104f766-e5ff-4c14-85ff-62787fb6b0ba")
    private Mobile mobile;

    @objid ("abbda477-ea73-4579-a6b4-1829b77f097a")
    private Entrepot entrepot;

    public Tuille(ContenuCase type, Entrepot entrepot){
    	
    	switch(type) {
    	case CASE_VIDE: fixe = Fixe.NORMAL; break;
    	case MUR: fixe = Fixe.MUR; break;
    	case RANGEMENT: fixe = Fixe.DESTINATION; break;
    	case CAISSE: fixe = Fixe.NORMAL; mobile = new Caisse(this); mobile.setTuille(this); break;
    	case CAISSE_RANGEE: fixe = Fixe.DESTINATION; mobile = new Caisse(this); mobile.setTuille(this); break;
    	case JOUEUR: fixe = Fixe.NORMAL; mobile = new Personnage(this); mobile.setTuille(this); break;
    	default: break;
    	}
        
        this.entrepot = entrepot;
    }

    @objid ("b1346dbd-5e6c-4016-ad68-c95b28d8bc10")
    public Tuille tuilleVoisine(Direction direction) {
    	Position position = entrepot.getPosition(this);
    	
    	Position positionVoisine = position.positionVoisine(direction);
    	return entrepot.getTuileDePosition(positionVoisine);
    }
    
    

    @objid ("dcdfe19e-4e20-4f06-bf8f-af83a391996c")
    public boolean demandeDeplacement(Direction direction, Personnage personnage) {
    	if (!(mobile instanceof Caisse) && !(fixe == Fixe.MUR)) {
    		mobile = personnage;
    		return true;
    	}
    	else if (mobile instanceof Caisse) {
    		if (mobile.deplacement(direction)) {
    			mobile = personnage;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	else {
    		return false;
    	}
    	
    }
    
    public boolean demandeDeplacement(Caisse caisse) {
    	if ((mobile == null) && !(fixe == Fixe.MUR)) {
    		mobile = caisse;
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }
    
    public ContenuCase getContenu() {
    	
    	if (fixe == Fixe.MUR) {
			return ContenuCase.MUR;
		}
		else if (mobile instanceof Personnage) {
			return ContenuCase.JOUEUR;
		}
		else if (mobile instanceof Caisse) {
			if (fixe == Fixe.DESTINATION) {
				return ContenuCase.CAISSE_RANGEE;
			}
			return ContenuCase.CAISSE;
		}
		else if (fixe == Fixe.DESTINATION) {
			return ContenuCase.RANGEMENT;
		}
		else {
			return ContenuCase.CASE_VIDE;
		}
    }
    
    
    public void oubli(){
    	mobile = null;
    }
    
    
    public boolean occupee(){
    	return (mobile instanceof Caisse);
    }

}
