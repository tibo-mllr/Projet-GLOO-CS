package modele;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid("26e154aa-b4a1-4890-8686-eb4052e6afdd")
public class Entrepot {
    private int width;
    private int height;
    
    @objid("64fad707-e4ac-48c0-803a-a1b57f236c87")
    private List<Tuille> tuilles = new ArrayList<Tuille>();

    @objid("1132815e-53f9-4a82-8567-322fff810193")
    private List<Position> positions = new ArrayList<Position>();

    public Entrepot(int width, int height) {
        this.width = width;
        this.height = height;
        

		for (int i=0; i<6; i++) {
			for (int j=0; j<5; j++) {
				if (i==0 || i == 5) {
					Mur mur = new Mur(this.getTuileDePosition(new Position(i, j)));
					tuilles.add(new Tuille(mur, null, new Position(i, j), this));
				}
				else {
					if (j ==0 || j == 4) {
						Mur mur = new Mur(this.getTuileDePosition(new Position(i, j)));
						tuilles.add(new Tuille(mur, null, new Position(i, j), this));
					}
					else {
						if (i==1 && j==1) {
							Personnage personnage = new Personnage(this.getTuileDePosition(new Position(i, j)));
							tuilles.add(new Tuille(null, personnage, new Position(i, j), this));
						}
						if (i==4 && j==5) {
							Destination destination = new Destination(this.getTuileDePosition(new Position(i, j)));
							tuilles.add(new Tuille(destination, null, new Position(i, j), this));
						}
						if (i==2 && j==2) {
							Caisse caisse = new Caisse(this.getTuileDePosition(new Position(i, j)));
							tuilles.add(new Tuille(null, caisse, new Position(i, j), this));
						}
					}
				}
			}
		}
    }


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
