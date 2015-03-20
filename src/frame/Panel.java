package frame;

import graphic.ListeRectangle;
import graphic.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ListIterator;
import javax.swing.JPanel;

/**
 *
 * @author Maxime BLAISE
 */
public class Panel extends JPanel {
    
    /**
     * Constructeur vide.
     */
    public Panel() {
        //
    }

    /**
     * Cette méthode permet de redessiner toutes les figures du dessin.
     *
     * @param g Type : Graphics
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /* 
         * 
         * A COMPLETER AVEC ITERATOR !
         */

        ListIterator<Rectangle> it = MainFrame.listeRectangles.listIterator();
        while (it.hasNext()) {
            it.next().affiche(g);
        }

        this.setBackground(Color.white);
    }
}
