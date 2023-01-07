package modele;

import java.util.ArrayList;
import java.util.List;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import controle.Direction;

@objid ("10307ae9-bc29-4efa-ad40-e8723da241ec")
public class Position {
    @objid ("3ad9ee87-8016-4379-8be5-1bac35bc1a8b")
    private int indexLigne;

    @objid ("8c144e84-370f-4419-894f-d8405254485d")
    private int indexColonne;

    @objid ("16e74a7c-691a-43d1-9339-3bd2ec99e8d9")
    private Tuille tuille;

    @objid ("06c993ae-ffe7-4a35-a4d3-455a64dd8822")
    private Entrepot entrepot;

    @objid ("4edbd933-54e4-42fd-aab2-6af6cc3c845f")
    public Position positionVoisine(Direction direction) {
    	Position positionVoisine;
    	switch(direction) {
    	case HAUT:
    		positionVoisine = new Position(indexLigne-1, indexColonne);
		case BAS:
			positionVoisine = new Position(indexLigne+1, indexColonne);
    	case GAUCHE:
    		positionVoisine = new Position(indexLigne, indexColonne-1);
    	case DROITE:
    		positionVoisine = new Position(indexLigne, indexColonne+1);
    	default:
    		positionVoisine = null;
    	}
    	return positionVoisine;
   }
    }
    
    public int getX() {
    	return indexColonne;
    }
    
    public int getY() {
    	return indexLigne;
    }

}
