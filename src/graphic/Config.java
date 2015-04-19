
package graphic;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Maxime BLAISE
 * @author Antoine NOSAL
 * @author Geoffrey GAILLARD
 * @author Guillaume DENIS
 */
public class Config {
    
    public static int width = 600, height = 600;
    public static int marge = 2;
    
    /**
     * Dimention du canvas
     */
    
    public static final int largeurCanvas = 600, hauteurCanvas = 400; 
    
    /**
     * Couleur de la bordure du rectangle.
     */
    public static final Color couleurRectangle = new Color(0, 204, 0);
    
    /**
     * Dimension minimale d'un rectangle.
     */
    public static final int largeurMinimale = 15, hauteurMinimale = 5;
    
    public static final Color[] listeCouleurs = {
        Color.red , Color.GREEN , Color.BLUE
    };
    
    public static final int borne = 100000;
    
}
