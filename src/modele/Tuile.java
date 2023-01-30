package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import controle.ContenuCase;
import controle.Direction;

/**
 * Element représentant les cases du jeu
 * 
 * @author Thibault Muller, Raphaël Mahaut
 * @version 1.0
 *
 */


@objid ("7ac4f54a-f5bd-4501-9651-9ca090bcdcda")
public class Tuile {
    @objid ("581815d8-5687-4895-81b1-85be47ebe507")
    private Fixe fixe;

    @objid ("9104f766-e5ff-4c14-85ff-62787fb6b0ba")
    private Mobile mobile;

    @objid ("abbda477-ea73-4579-a6b4-1829b77f097a")
    private Entrepot entrepot;

    @objid ("b1346dbd-5e6c-4016-ad68-c95b28d8bc10")
    public Tuile tuileVoisine(Direction direction) {
        return entrepot.tuileVoisine(this, direction);
    }

    @objid ("dcdfe19e-4e20-4f06-bf8f-af83a391996c")
    public boolean demandeDeplacement(Direction direction, Mobile demandeur) {
        if (fixe == Fixe.MUR){
            return false;
        }
        if (mobile == null) {
            mobile = demandeur;
            return true;
        }
        if (demandeur.capablePousser(mobile)) {
            if (mobile.deplacement(direction)) {
                mobile = demandeur;
                return true;
            }
        }
        return false;
    }

    @objid ("37c0c66e-be7f-48ed-9fa3-b804bfc74de2")
    public Tuile(Fixe fixe, Mobile mobile, Entrepot entrepot) {
        this.fixe = fixe;
        this.mobile = mobile;
        this.entrepot = entrepot;
    }

    @objid ("e9bfa4ae-640e-4d80-842d-87521a10ca82")
    public ContenuCase getContenu() {
        if (fixe == Fixe.MUR) {
            return ContenuCase.MUR;
        }
        else if (mobile instanceof Personnage) {
            return ContenuCase.JOUEUR;
        }
        else if (mobile instanceof Caisse) {
            if (fixe == Fixe.DESTINATION) {
                return ContenuCase.CAISSE_RANGEE;
            }
            return ContenuCase.CAISSE;
        }
        else if (fixe == Fixe.DESTINATION) {
            return ContenuCase.RANGEMENT;
        }
        else {
            return ContenuCase.CASE_VIDE;
        }
    }

    @objid ("80a52d75-3dd9-4ab8-8bff-5680372bcbcb")
    public void oubli() {
        mobile = null; // oubli l'objet mobile quand celui-ci change de case
    }

    @objid ("466e02a1-9f6f-4b2a-a845-193b97d2d95f")
    public boolean occupee() {
        return (mobile instanceof Caisse); // Vérifie si une tuile contient une caisse pour la fin du jeu
    }

}
