package ihm;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controle.Controleur;
import controle.Direction;

/**
 * Fenêtre de l'IHM pour le jeu Sokoban
 * 
 * @author Dominique Marcadet, Thibault Muller, Raphaël Mahaut
 * @version 2.0
 *
 */

@SuppressWarnings("serial")
public class FenetreSokoban extends JFrame implements KeyListener {

    static final int TAILLE_IMAGE = 32;

    static final int LARGEUR_FENETRE = 22 * TAILLE_IMAGE;
    static final int HAUTEUR_FENETRE = 15 * TAILLE_IMAGE;
    private static final int HAUTEUR_TITRE_FENETRE = 20;
    private Controleur controleur;

    public FenetreSokoban(Controleur controleur) {
        this.controleur = controleur;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(LARGEUR_FENETRE, HAUTEUR_FENETRE + HAUTEUR_TITRE_FENETRE));
        this.setTitle("Sokoban");

        this.add(new PaneauSokoban(controleur));
        this.addKeyListener(this);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Direction direction = switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> Direction.HAUT;
            case KeyEvent.VK_DOWN -> Direction.BAS;
            case KeyEvent.VK_LEFT -> Direction.GAUCHE;
            case KeyEvent.VK_RIGHT -> Direction.DROITE;
            default -> null;
        };
        if (direction == null)
            return;
        controleur.action(direction);
        repaint();
        
        if (controleur.jeuTermine()) {
            if (!controleur.recommencer()){
            	JOptionPane.showMessageDialog(this, "Vous avez terminé tous les niveaux!");
            	System.exit(0);
            }
        	int option = JOptionPane.showConfirmDialog(this, "Bravo, vous avez réussi! Passez au niveau suivant", "Niveau suivant", JOptionPane.YES_NO_OPTION);
            if (option == 1) {
            	System.exit(0);
            }             
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
        case KeyEvent.VK_R: controleur.recommencer(); repaint(); break;
        }
    }

}
