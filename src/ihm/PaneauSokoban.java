package ihm;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controle.ContenuCase;
import controle.IControleur;

/**
 * Panneau de l'IHM pour le jeu Sokoban
 * 
 * @author Dominique Marcadet, Thibault Muller, Raphaël Mahaut
 * @version 1.1
 *
 */

@SuppressWarnings("serial")
public class PaneauSokoban extends JPanel {

    private static final int TAILLE_IMAGE = FenetreSokoban.TAILLE_IMAGE;

    private static EnumMap<ContenuCase, Image> images;

    private IControleur controleur;

    public PaneauSokoban(IControleur controleur2) {
        this.controleur = controleur2;
        try {
            images = new EnumMap<ContenuCase, Image>(
                    Map.of(
                            ContenuCase.CASE_VIDE, ImageIO.read(new File("img/Vide.jpg")),
                            ContenuCase.MUR, ImageIO.read(new File("img/Mur.jpg")),
                            ContenuCase.CAISSE, ImageIO.read(new File("img/Caisse.jpg")),
                            ContenuCase.CAISSE_RANGEE, ImageIO.read(new File("img/CaisseRangee.jpg")),
                            ContenuCase.RANGEMENT, ImageIO.read(new File("img/Rangement.jpg")),
                            ContenuCase.JOUEUR, ImageIO.read(new File("img/Joueur.jpg"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        // Le côté métier raisonne en [ligne, colonne]
        // Le côté IHM raisonne en [x, y]
        // Donc x <=> colonne et y <=> ligne
        
        int nbLignes = controleur.getNbLignes();
        int nbColonnes = controleur.getNbColonnes();
        
        int decalageLat = (FenetreSokoban.LARGEUR_FENETRE - nbColonnes*TAILLE_IMAGE)/2 - 8; // permet de centrer l'entrepot horizontalement
        int decalageHor = (FenetreSokoban.HAUTEUR_FENETRE - nbLignes*TAILLE_IMAGE)/2 - 8; // permet de centrer l'entrepot verticalement
        
        for (int l = 0; l < nbLignes; ++l) {
            for (int c = 0; c < nbColonnes; ++c) {
                g.drawImage(images.get(controleur.getContenu(l, c)), decalageLat + (c * TAILLE_IMAGE), decalageHor + (l * TAILLE_IMAGE), TAILLE_IMAGE,
                        TAILLE_IMAGE, null);
            }
        }
    }

}
