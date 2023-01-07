package ihm;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controle.Controleur;
import controle.Direction;
import controle.IControleur;


/**
 * Fenêtre de l'IHM pour le jeu Sokoban
 * 
 * @author Dominique Marcadet
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class FenetreSokoban extends JFrame implements KeyListener {

            static final int TAILLE_IMAGE = 32;
    
    private static final int LARGEUR_FENETRE = 20 * TAILLE_IMAGE;
	private static final int HAUTERU_FENETRE = 12 * TAILLE_IMAGE;
    private static final int HAUTEUR_TITRE_FENETRE = 20;
    private Controleur controleur;

    public FenetreSokoban( Controleur controleur ) {
        this.controleur = controleur;

        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setPreferredSize( new Dimension( LARGEUR_FENETRE, HAUTERU_FENETRE + HAUTEUR_TITRE_FENETRE ));
        this.setTitle( "Sokoban" );

        this.add( new PaneauSokoban( controleur ));
        this.addKeyListener( this );

        this.pack();
        this.setVisible( true );
    }

    @Override
    public void keyTyped( KeyEvent e ) {
        // nothing
    }

    @Override
    public void keyPressed( KeyEvent e ) {
        Direction direction = switch( e.getKeyCode() ) {
            case KeyEvent.VK_UP    -> Direction.HAUT;
            case KeyEvent.VK_DOWN  -> Direction.BAS;
            case KeyEvent.VK_LEFT  -> Direction.GAUCHE;
            case KeyEvent.VK_RIGHT -> Direction.DROITE;
            default                -> null;
        };
        if( direction == null ) return;
        controleur.action( direction );
        if( controleur.jeuTermine() ) {
            JOptionPane.showMessageDialog( this, "Vous avez gagné !" );
            System.exit( 0 );
        }
        repaint();
    }

    @Override
    public void keyReleased( KeyEvent e ) {
        // nothing
    }

}
