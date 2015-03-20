package graphic;

import java.awt.Color;
import java.awt.Graphics;

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
     * Coordonnées nécessaires pour la résolution du problème.
     */
    public int x1, y1, x2, y2;
    
    /**
     * Couleur du rectangle.
     */
    private Color couleur;

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
        x1 = superieurGauche.getX();
        y1 = superieurGauche.getY() + height;
        x2 = superieurGauche.getX() + width;
        y2 = superieurGauche.getY();
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
        return "X1=" + this.x1 + "; Y1=" + this.y1 + "; X2=" + this.x2 + "; Y2=" + this.y2;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    
    

    public void affiche(Graphics g) {
        g.setColor(this.couleur);
        g.drawRect(this.getSuperieurGauche().getX(), this.getSuperieurGauche().getY(), this.getWidth(), this.getHeight());
    }

}
