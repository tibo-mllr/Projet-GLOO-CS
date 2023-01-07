package modele;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid("26e154aa-b4a1-4890-8686-eb4052e6afdd")
public class Entrepot {
    private int width;
    private int height;

    public Entrepot(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @objid("64fad707-e4ac-48c0-803a-a1b57f236c87")
    private List<Tuille> tuilles = new ArrayList<Tuille>();

    @objid("1132815e-53f9-4a82-8567-322fff810193")
    private List<Position> positions = new ArrayList<Position>();

    @objid("8dc30092-0480-4420-b6c1-ecea3a1d4e43")
    public Tuille getTuileDePosition(Position position) {
        return tuilles.get(position.getX() + position.getY() * width);
    }

    public int getNbColonnes() {
        return width;
    }

    public int getNbLignes() {
        return height;
    }

}
