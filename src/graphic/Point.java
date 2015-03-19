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
        int randomX = (int) (Math.random() * (Config.width  - Config.largeurMinimale));
        int randomY = (int) (Math.random() * (Config.height - Config.hauteurMinimale));
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
