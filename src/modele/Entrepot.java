package modele;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import controle.ContenuCase;

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
				positions.add(new Position(i, j));
				if (i==0 || i == 5) {
					tuilles.add(new Tuille(ContenuCase.MUR, this));
				}
				else if (j ==0 || j == 4) {
					tuilles.add(new Tuille(ContenuCase.MUR, this));
				}
				else if (i==1 && j==1) {
					tuilles.add(new Tuille(ContenuCase.JOUEUR, this));
				}
				else if (i==4 && j==5) {
					tuilles.add(new Tuille(ContenuCase.RANGEMENT, this));
				}
				else if (i==2 && j==2) {
					tuilles.add(new Tuille(ContenuCase.CAISSE, this));
				}
				else {
					tuilles.add(new Tuille(ContenuCase.CASE_VIDE, this));
				}
			}
		}		
    }


    @objid("8dc30092-0480-4420-b6c1-ecea3a1d4e43")
    public Tuille getTuileDePosition(Position position) {
        return tuilles.get(position.getX() + position.getY() * width);
    }

    public Position getPosition(Tuille tuille) {
    	return positions.get(tuilles.indexOf(tuille));
    }
    
    public int getNbColonnes() {
        return width;
    }

    public int getNbLignes() {
        return height;
    }
    
    public ContenuCase getContenu(int i, int j) {
    	if (i==0 || i == 5) {
			return ContenuCase.MUR;
		}
		else if (j ==0 || j == 4) {
			return ContenuCase.MUR;
		}
		else if (i==1 && j==1) {
			return ContenuCase.JOUEUR;
		}
		else if (i==4 && j==5) {
			return ContenuCase.RANGEMENT;
		}
		else if (i==2 && j==2) {
			return ContenuCase.CAISSE;
		}
		else {
			return ContenuCase.CASE_VIDE;
		}
    }

}
