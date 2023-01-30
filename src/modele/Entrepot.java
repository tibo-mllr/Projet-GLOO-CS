package modele;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import controle.ContenuCase;
import controle.Direction;

/**
 * Entrepot contenant les cases du jeu et leurs positions
 * 
 * @author Thibault Muller, Raphaël Mahaut
 * @version 1.0
 *
 */


@objid ("26e154aa-b4a1-4890-8686-eb4052e6afdd")
public class Entrepot {
    @objid ("e2e9c129-b35c-41e4-ae95-9633894c734a")
    private int nbColonnes = 0;

    @objid ("1f300d5e-ce38-494e-b0f5-68a17f37b6f1")
    private int nbLignes = 0;

    @objid ("64fad707-e4ac-48c0-803a-a1b57f236c87")
    private List<Tuile> tuiles = new ArrayList<Tuile>();

    @objid ("1132815e-53f9-4a82-8567-322fff810193")
    private List<Position> positions = new ArrayList<Position>();

    @objid ("8dc30092-0480-4420-b6c1-ecea3a1d4e43")
    public Tuile gettuile(Position position) {
        int index = positions.indexOf(position);
        if (index == -1) {
            return null;
        }
        return tuiles.get(index);
    }

    @objid ("3cdd3fc6-976b-4555-88d2-7e083d7758d1")
    public void addElement(int indexLigne, int indexColonne, Tuile tuile) {
        positions.add(new Position(indexLigne, indexColonne));
        tuiles.add(tuile);
        if (indexLigne >= nbLignes) {
            nbLignes = indexLigne + 1;
        }
        if (indexColonne >= nbColonnes) {
            nbColonnes = indexColonne + 1;
        }
    }

    @objid ("ed62054f-4e1c-4e65-af96-0a28af8b4283")
    public Position getPosition(Tuile tuile) {
        return positions.get(tuiles.indexOf(tuile));
    }

    @objid ("31a8e51c-68b2-42bd-9aa3-7337cbfa7bd8")
    public int getNbColonnes() {
        return nbColonnes;
    }

    @objid ("28d65bad-07c6-4c11-a7f2-fccd70222b3c")
    public int getNbLignes() {
        return nbLignes;
    }

    @objid ("074c68c3-8fe4-4434-a886-0fbf292a6412")
    public ContenuCase getContenu(int l, int c) {
        int index = positions.indexOf(new Position(l, c));
        if (index == -1) {
            return null;
        }
        return tuiles.get(index).getContenu();
    }

    @objid ("cc666222-6b8f-43d8-85de-86ff926cf61b")
    public Tuile tuileVoisine(Tuile tuile, Direction direction) {
        Position positionVoisine = positions.get(tuiles.indexOf(tuile)).positionVoisine(direction);
        return gettuile(positionVoisine);
    }

}
