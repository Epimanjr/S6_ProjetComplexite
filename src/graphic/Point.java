package graphic;

/**
 *
 * @author Maxime BLAISE
 * @author Antoine NOSAL
 * @author Geoffrey GAILLARD
 * @author Guillaume DENIS
 */
public class Point {

    /**
     * Abscisse du point.
     */
    private int x;

    /**
     * Ordonnée du point.
     */
    private int y;

    /**
     * Créer un point avec abscisse et ordonnée connu.
     *
     * @param x Abscisse du point.
     * @param y Ordonnée du point.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Créer un Point aléatoire sur le Panel graphique.
     *
     * @return Objet Point
     */
    public static Point getRandomPoint() {
        // Génération de l'abscisse
        int randomX = (int) (Math.random() * (Config.width  - Config.largeurMinimale));
        randomX = (randomX < Config.marge) ? Config.marge : randomX;
        // Génération de l'ordonnée
        int randomY = (int) (Math.random() * (Config.height - Config.hauteurMinimale));
        randomY = (randomY < Config.marge) ? Config.marge : randomY;
        // Création du point
        return new Point(randomX, randomY);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

}
