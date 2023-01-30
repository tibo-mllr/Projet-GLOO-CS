package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import controle.Direction;

/**
 * Représentation des positions dans l'entrepot par ligne et colonne
 * 
 * @author Thibault Muller, Raphaël Mahaut
 * @version 1.0
 *
 */


@objid ("10307ae9-bc29-4efa-ad40-e8723da241ec")
public class Position {
    @objid ("3ad9ee87-8016-4379-8be5-1bac35bc1a8b")
    private int indexLigne;

    @objid ("8c144e84-370f-4419-894f-d8405254485d")
    private int indexColonne;

    @objid ("4edbd933-54e4-42fd-aab2-6af6cc3c845f")
    public Position positionVoisine(Direction direction) {
        switch (direction) {
            case HAUT:
                return new Position(indexLigne - 1, indexColonne);
            case BAS:
                return new Position(indexLigne + 1, indexColonne);
            case GAUCHE:
                return new Position(indexLigne, indexColonne - 1);
            case DROITE:
                return new Position(indexLigne, indexColonne + 1);
            default:
                return null;
        }
    }

    @objid ("815c5a39-dda8-4b05-b568-790eb0e76acb")
    public Position(int indexLigne, int indexColonne) {
        this.indexLigne = indexLigne;
        this.indexColonne = indexColonne;
    }

    @objid ("21a2e84c-cfb8-4cc1-8d6b-62d573ff0561")
    @Override
    public boolean equals(Object obj) {
        if( obj == this ) return true;
        if( obj == null ) return false;
        if( obj.getClass() != getClass() ) {
             return false;
         }
         Position other = ( Position ) obj;
        return this.indexLigne == other.indexLigne && this.indexColonne == other.indexColonne;
    }

}
