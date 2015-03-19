/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import java.util.ArrayList;

/**
 *
 * @author Maxime
 */
public class ListeRectangle extends ArrayList<Rectangle>{

    /**
     * Constructeur vide
     */
    public ListeRectangle() {
        super();
    }
    
    public int toutesLesPaires() {
        // Initialisation
        int nbPaires = 0;
        // Parcours
        for(int i=0;i<this.size();i++) {
            for(int j=i+1;j<this.size();j++) {
                if(comparer(this.get(i), this.get(j))) {
                    nbPaires++;
                }
            }
        }
        // Retour
        return nbPaires;
    }
    
    public boolean comparer(Rectangle r1, Rectangle r2) {
        //System.out.println(" *** COMPARAISON DE " + r1 + " ET " + r2 + " ***");
        // Test sur les X
        boolean bX = ((r1.x1 > r2.x1) && (r1.x1 < r2.x2)) || ((r2.x1 > r1.x1) && (r2.x1 < r1.x2));
        //System.out.println("\tComparaison sur les X : " + bX);
        // Test sur les Y
        boolean bY = ((r1.y1 < r2.y1) && (r1.y1 > r2.y2)) || ((r2.y1 < r1.y1) && (r2.y1 > r1.y2));
       // System.out.println("\tComparaison sur les Y : " + bY);
        return bX && bY;
    }
    
    public ListeRectangle trierTableau() {
        ListeRectangle res = new ListeRectangle();
        for(int i=0;i<this.size();i++) {
            int val = this.get(i).x1;
            int rang = chercherRang(res, val);
            if(rang == -1) {
                res.add(this.get(i));
            } else {
                res.add(rang, this.get(i));
            }
        }
        return res;
    }
    
    public int chercherRang(ListeRectangle liste, int val) {
        for(int i=0;i<liste.size();i++) {
            if(liste.get(i).x1 > val) {
                return i;
            }
        }
        return -1;
    }
}
