
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
    
    public static int width = 800, height = 800;
    public static int marge = 2;
    
    /**
     * Couleur de la bordure du rectangle.
     */
    public static Color couleurRectangle = new Color(0, 204, 0);
    
    /**
     * Dimension minimale d'un rectangle.
     */
    public static int largeurMinimale = 15, hauteurMinimale = 5;
    
    public static Color[] listeCouleurs = {
        Color.red , Color.GREEN , Color.BLUE
    };
    
    public static int borne = 100000;
    
}
