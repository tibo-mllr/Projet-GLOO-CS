package controle;


import java.util.List;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import modele.Entrepot;
import modele.Niveau;
import modele.Personnage;
import modele.Position;
import modele.Tuille;

@objid ("7c4c74ff-0f6e-4444-8be5-a47a0956bfae")
public class Controleur {
	private Niveau niveau;
    private Entrepot entrepot;
	private Personnage personnage;
	private List<Tuille> objectifs;
    
    public Controleur() {
    	this.niveau = new Niveau(1);
    	niveau.genererNiveau(this);
    }
     
    public void setAttributes(Entrepot entrepot, Personnage personnage, List<Tuille> objectifs) {
    	this.entrepot = entrepot;
    	this.personnage = personnage;
    	this.objectifs = objectifs;
    }
    
    @objid ("804851b6-f891-46ac-8096-6f09045b4e5e")
    public void action(Direction direction) {
    	personnage.deplacement(direction);
    }
    
	public boolean jeuTermine() {
		for (Tuille destination: objectifs) {
			if (!destination.occupee()){
				return false;
			}
		}
		niveau.niveauSup();
		return true;
	}
	
	public boolean recommencer() {
		return niveau.genererNiveau(this);
	}

	public int getNbLignes() {
		return entrepot.getNbLignes();
	}

	public int getNbColonnes() {
		return entrepot.getNbColonnes();
	}

	public ContenuCase getContenu(int l, int c) {
		Tuille tuille = entrepot.getTuileDePosition(new Position(l, c));
		if (tuille == null) {
			return null;
		}
		return tuille.getContenu();
	}
	
	

}
