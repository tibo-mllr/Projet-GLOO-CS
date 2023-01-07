package controle;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import modele.Entrepot;
import modele.Personnage;
import modele.Position;
import modele.Tuille;

@objid ("7c4c74ff-0f6e-4444-8be5-a47a0956bfae")
public class Controleur {
    private Entrepot entrepot;
    
    public Controleur(Entrepot entrepot) {
    	this.entrepot = entrepot;
    }

    @objid ("804851b6-f891-46ac-8096-6f09045b4e5e")
    public void action(Direction direction) {
    	personnage.deplacement(direction);
    }
    
	public boolean jeuTermine() {
		// TODO
		return false;
	}

	public int getNbLignes() {
		return entrepot.getNbLignes();
	}

	public int getNbColonnes() {
		return entrepot.getNbColonnes();
	}

	public ContenuCase getContenu(int l, int c) {
		//TODO
		Tuille tuille = entrepot.getTuileDePosition(new Position(l, c));
		switch(tuille) {
		case Mur:
			return ContenuCase.MUR;
		}
	}

}
