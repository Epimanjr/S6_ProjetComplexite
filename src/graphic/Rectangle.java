package graphic;

/**
 *
 * @author Maxime BLAISE
 * @author Antoine NOSAL
 * @author Geoffrey GAILLARD
 * @author Guillaume DENIS
 */
public class Rectangle {

    /**
     * Point supérieur gauche. (en haut à gauche)
     */
    private Point superieurGauche;

    /**
     * Largeur du rectangle.
     */
    private int width;

    /**
     * Hauteur du rectangle.
     */
    private int height;

    /**
     * Créer un rectangle à partir d'un point et de ses dimensions
     *
     * @param superieurGauche Point supérieur gauche. (en haut à gauche)
     * @param width Largeur du rectangle.
     * @param height Hauteur du rectangle.
     */
    public Rectangle(Point superieurGauche, int width, int height) {
        this.superieurGauche = superieurGauche;
        this.width = width;
        this.height = height;
    }

    /**
     * Créer un Rectangle aléatoire sur le Panel graphique.
     *
     * @return Objet Rectangle
     */
    public static Rectangle getRandomRectangle() {
        // Point supérieur gauche
        Point p1 = Point.getRandomPoint();
        // Largeur du rectangle
        int width = (int) (Math.random() * (Config.width - p1.getX()));
        width = (width < Config.largeurMinimale) ? Config.largeurMinimale : width;
        // Hauteur du rectangle
        int height = (int) (Math.random() * (Config.height - p1.getY()));
        height = (height < Config.hauteurMinimale) ? Config.hauteurMinimale : height;
        // Création !
        return new Rectangle(p1, width, height);
    }

    public Point getSuperieurGauche() {
        return superieurGauche;
    }

    public void setSuperieurGauche(Point superieurGauche) {
        this.superieurGauche = superieurGauche;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "superieurGauche=" + superieurGauche + ", width=" + width + ", height=" + height + '}';
    }

}
