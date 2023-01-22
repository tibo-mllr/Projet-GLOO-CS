package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import controle.Direction;

@objid ("5d9ffd25-495a-4f66-8fe3-f2b3fea01b50")
public abstract class Mobile {
    @objid ("842309ee-a6a1-4ee0-af9b-17e887d7c1cc")
    private Tuille tuille;

    @objid ("6db1cb8a-0f2a-48ad-9949-aaed267f6ac7")
    public void setTuille(Tuille nouvelleTuille) {
        tuille = nouvelleTuille;
    }

    @objid ("400c5d4c-3659-4c81-ba72-f9eff447e123")
    public Mobile() {
    }

    @objid ("12c85eae-bfc3-45d1-bb8e-5e2edf166f55")
    public boolean deplacement(Direction direction) {
        Tuille tuilleVoisine = tuille.tuilleVoisine(direction);
        if (tuilleVoisine == null) {
        	return false;
        }
        if (tuilleVoisine.demandeDeplacement(direction, this)) {
            changementTuille(tuilleVoisine);
            return true;
        }
        else {
            return false;
        }
    }

    @objid ("9e3fdfab-5ec7-40fa-b7d0-ba52deabc422")
    public void changementTuille(Tuille nouvelleTuille) {
        tuille.oubli();
        tuille = nouvelleTuille;
    }

    @objid ("59ded501-42ac-4ace-adf0-dce1b5c374ba")
    public abstract boolean capablePousser(Mobile objet);

}
