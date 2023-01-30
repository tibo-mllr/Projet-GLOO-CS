package controle;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import modele.Entrepot;
import modele.Niveau;
import modele.Personnage;
import modele.Tuile;

/**
 * Controleur pour le jeu Sokoban
 * 
 * @author Thibault Muller, Raphaël Mahaut
 * @version 1.0
 *
 */


@objid ("7c4c74ff-0f6e-4444-8be5-a47a0956bfae")
public class Controleur implements IControleur {
    @objid ("104b3a29-b258-4094-896f-a9752ca6e02c")
    private Niveau niveau;

    @objid ("35a6f807-5cd7-429a-9125-a345cac453a7")
    private Entrepot entrepot;

    @objid ("e1f8c039-9d97-4dfd-a5d2-188c55f15ac0")
    private List<Tuile> objectifs;

    @objid ("0f46d428-5978-45dd-a09c-55f6c9e94711")
    private Personnage personnage;

    @objid ("804851b6-f891-46ac-8096-6f09045b4e5e")
    public void action(Direction direction) {
        personnage.deplacement(direction);
    }

    @objid ("d15243e3-5d4f-480e-8c9c-61dfe1a9e661")
    public Controleur() {
        this.niveau = new Niveau(1);
        niveau.genererNiveau(this);
    }

    @objid ("1182a2c5-0119-4cfe-91dc-854a14255647")
    public void setAttributes(Entrepot entrepot, Personnage personnage, List<Tuile> objectifs) {
        this.entrepot = entrepot;
        this.personnage = personnage;
        this.objectifs = objectifs;
    }

    @objid ("2fbd4a32-95d8-4d1f-bb4c-efa325cb2af3")
    public boolean jeuTermine() {
        for (Tuile destination: objectifs) {
            if (!destination.occupee()){
                return false;
            }
        }
        niveau.niveauSup();
        return true;
    }

    @objid ("98ff0bba-65d2-44a3-b158-cd62c2370b32")
    public boolean generer() {
        return niveau.genererNiveau(this);
    }

    @objid ("c645c52c-a613-4d7f-ae41-bf8137508d85")
    public int getNbLignes() {
        return entrepot.getNbLignes();
    }

    @objid ("02c2c861-c82c-4112-8f96-d21f9c173e7a")
    public int getNbColonnes() {
        return entrepot.getNbColonnes();
    }

    @objid ("4ac7b73b-a5ba-4f93-8aea-8e085660c785")
    public ContenuCase getContenu(int l, int c) {
        return entrepot.getContenu(l, c);
    }

}
