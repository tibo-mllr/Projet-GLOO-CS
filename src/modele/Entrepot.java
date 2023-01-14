package modele;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid("26e154aa-b4a1-4890-8686-eb4052e6afdd")
public class Entrepot {
    private int nbColonnes;
    private int nbLignes;
    
    @objid("64fad707-e4ac-48c0-803a-a1b57f236c87")
    private List<Tuille> tuilles = new ArrayList<Tuille>();

    @objid("1132815e-53f9-4a82-8567-322fff810193")
    private List<Position> positions = new ArrayList<Position>();

    public Entrepot(int nbLignes, int nbColonnes) {
        this.nbColonnes = nbColonnes;
        this.nbLignes = nbLignes;		
    }
    
    public void addElement(Position position, Tuille tuille) {
    	positions.add(position);
    	tuilles.add(tuille);
    }


    @objid("8dc30092-0480-4420-b6c1-ecea3a1d4e43")
    public Tuille getTuileDePosition(Position position) {
    	int index = positions.indexOf(position);
    	if (index == -1) {
    		return null;
    	}
        return tuilles.get(index);
    }

    public Position getPosition(Tuille tuille) {
    	return positions.get(tuilles.indexOf(tuille));
    }
    
    public int getNbColonnes() {
        return nbColonnes;
    }

    public int getNbLignes() {
        return nbLignes;
    }

}