package controle;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import modele.Personnage;

@objid ("7c4c74ff-0f6e-4444-8be5-a47a0956bfae")
public class Controleur {
    @objid ("0f46d428-5978-45dd-a09c-55f6c9e94711")
    private Personnage personnage;

    @objid ("804851b6-f891-46ac-8096-6f09045b4e5e")
    public void action(Direction direction) {
    	personnage.deplacement(direction);
    }

}
