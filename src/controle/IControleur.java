package controle;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Interface du controleur permettant l'inversion des dépendances
 * 
 * @author Dominique Marcadet, Thibault Muller, Raphaël Mahaut
 * @version 1.0
 *
 */

@objid ("f04ba7b3-4d1d-42d6-8c84-bf0e4163c85b")
public interface IControleur {
    @objid ("4d31bcfa-f260-4f3b-b02f-bac372dd1c75")
    void action(Direction direction);

    @objid ("c48c0069-8ac6-4080-b533-318acfacdfb4")
    boolean jeuTermine();

    @objid ("5f1a7231-60bf-4747-ae36-293555b46ba6")
    int getNbLignes();

    @objid ("d2989755-1274-469e-9454-3debdb37e296")
    int getNbColonnes();

    @objid ("cc650304-f2eb-4fa4-b7fb-3296f0d8eb2d")
    ContenuCase getContenu(int ligne, int colonne);

    @objid ("69cdbc1d-715d-418e-bd66-bcd8dcc50434")
    boolean generer();

}
