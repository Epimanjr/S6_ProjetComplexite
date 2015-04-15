/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import java.util.ArrayList;

/**
 *
 * @author Maxime BLAISE, Guillaume DENIS, Antoine NOSAL
 */
public class ListeRectangle extends ArrayList<Rectangle> {

    /**
     * Constructeur vide
     */
    public ListeRectangle() {
        super();
    }

    /**
     * Compare tous les rectangles deux à deux
     * @return Le nombre de paires se coupant
     */
    public int toutesLesPaires() {
        // Initialisation
        int nbPaires = 0;
        // Parcours de tous les rectangles
        for (int i = 0; i < this.size(); i++) {
            for (int j = i + 1; j < this.size(); j++) {
                if (comparer(this.get(i), this.get(j))) {
                    nbPaires++;
                }
            }
        }
 
        return nbPaires;
    }

    /**
     * Alogirthme de balayage
     * 
     * R: rectangle courant (donc Rx2: x2 de R) 
     * RC: rectangles comparés (donc RCx1: x1 de RC)
     * 
     * Rappel du sujet:
     * Soit R le rectangle courant. Balayer la liste L de rectangles dans l’ordre en partant de R et en
     * s’arrêtant au premier segment, D, dont la coordonnée x du coin inférieur gauche est plus 
     * grande que la coordonnée x du coin supérieur droit de R. Parmi les rectangles après R dans la 
     * liste L, ceux qui coupent R en x sont exactement ceux après R et avant D.
     */
    public int balayage() {
        // Initialisation
        int nbPaires = 0;
        int Rx2;
        int RCx1;
        // Parcours
        for (int i = 0; i < this.size(); i++) {
            Rx2 = this.get(i).x2;
            for (int j = i + 1; j < this.size(); j++) {
                RCx1 = this.get(j).x1;
                if (Rx2 > RCx1) {
                    if (comparerYseulement(this.get(i), this.get(j))) {
                        nbPaires++;
                    }
                } else {
                    break;
                }
            }
        }
        // Retour
        return nbPaires;
    }

    /**
     * Compare si deux rectangles se coupent
     * @param r1
     * @param r2
     * @return boolean
     */
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
    
    /**
     * Compare si deux rectangles se coupent en Y seulement
     * @param r1
     * @param r2
     * @return boolean
     */
    public boolean comparerYseulement(Rectangle r1, Rectangle r2) {
        //System.out.println(" *** COMPARAISON DE " + r1 + " ET " + r2 + " ***");
        // Test sur les Y
        boolean bY = ((r1.y1 < r2.y1) && (r1.y1 > r2.y2)) || ((r2.y1 < r1.y1) && (r2.y1 > r1.y2));
        // System.out.println("\tComparaison sur les Y : " + bY);
        return bY;
    }
    
    /**
     * Permet de trier le tableau de rectangles
     * @return le tableau trié
     */
    public ListeRectangle trierTableau() {
        ListeRectangle res = new ListeRectangle();
        //parcours des rectangles
        for (int i = 0; i < this.size(); i++) {
            int val = this.get(i).x1;
            //recherche du rang du rectangle
            int rang = chercherRang(res, val);
            //insertion à la bonne place
            if (rang == -1) {
                res.add(this.get(i));
            } else {
                res.add(rang, this.get(i));
            }
        }
        return res;
    }

    /**
     * Recherche la place du rectangle en fonction du x1 d'un rectangle
     * @param liste
     * @param val 
     * @return l'indice à insérer
     */
    public int chercherRang(ListeRectangle liste, int val) {
    	//parcours de la liste
        for (int i = 0; i < liste.size(); i++) {
        	//si le rectangle d'indice i a un x1 plus grand que val 
            if (liste.get(i).x1 > val) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Tri Fusion d'un tableau de Rectangles
     * trouvé sur http://fr.wikibooks.org/wiki/Impl%C3%A9mentation_d'algorithmes_classiques/Algorithmes_de_tri/Tri_fusion#Java_ou_C.23
     * @param tabRectangle
     * @param debut
     * @param fin
     */
    public static void triFusion(ArrayList<Rectangle> tabRectangle, int debut, int fin){
    	int milieu;
    	
    	if(debut < fin){
    		milieu = (debut+fin)/2;
    		triFusion(tabRectangle, debut, milieu);
    		triFusion(tabRectangle, milieu+1, fin);
    		fusionner(tabRectangle, debut, milieu, fin);
    	}
    }
    
    /**
     * 
     * @param tabRectangle
     * @param debut
     * @param milieu
     * @param fin
     */
    public static void fusionner(ArrayList<Rectangle> tabRectangle, int debut, int milieu, int fin){
    	
    	//nouveau tableau
    	ArrayList<Rectangle> tmp = new ArrayList<Rectangle>(fin+1);
    	
    	int moitie1 = debut; // indice de la première moitié de save
    	int moitie2 = milieu+1; //indice de la deuxième moitié de save
    	int i = debut; //indice dans tabRectangle
    	Rectangle r1;
    	Rectangle r2;
    	
    	//tant qu'on ne sort pas des sous tableaux
    	while(moitie1 <= milieu && moitie2 <= fin){
    		r1 = tabRectangle.get(moitie1);
    		r2 = tabRectangle.get(moitie2);
    		// si le x1 du premier élément du premier tableau est inférieur à celui du 2e tableau
    		if(r1.x1 <= r2.x1){
    			tmp.add(r1);
    			moitie1++;
    		}
    		else {
    			tmp.add(r2);
    			moitie2++;
    		}
    		//i++;
    	}
    	//on fusionne les tableaux
    	if(i <= fin){
    		while(moitie1 <= milieu){
    			tmp.add(tabRectangle.get(moitie1));
    			moitie1++;
    			//i++;
    		}
    		while(moitie2 <= fin){
    			tmp.add(tabRectangle.get(moitie2));
    			moitie2++;
    			//i++;
    		}
    	}
    	tabRectangle = tmp;
    }
}
