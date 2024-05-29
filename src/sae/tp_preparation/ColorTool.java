package sae.tp_preparation;

import java.awt.*;

/**
 * Classe contenant des méthodes statiques utiles pour le TP :
 *     - Méthode permettant de recevoir un tableau RGB à partir d'un entier
 *     - Méthodes permettant de ne garder que certaines composantes
 *
 * Question 1.3 :
 * Écrire une méthode prenant en paramètre un entier ´ rgb et retournant les couleurs sous
 * la forme d’un tableau de trois entiers R, G, B.
 * Pour cela, vous pouvez créer une classe OutilCouleur avec une méthode statique :
 * static int[] getTabColor(int c).
 */
public class ColorTool {
    /**
     * Permet d'avoir un tableau RGB correspondant à l'entier RGB que l'on reçoit.
     * @param rgb entier RGB
     * @return tableau int[]{rouge, vert, bleu}
     */
    public static int[] getRGBArray(int rgb){
        int blue = rgb & 0xff;
        int green = (rgb & 0xff00) >> 8;
        int red = (rgb & 0xff0000) >> 16;

        return new int[]{red, green, blue};
    }

    /**
     * Méthode permettant de récupérer la composante souhaitée d'un entier RGB.
     * @param rgb entier RGB
     * @param r composante rouge
     * @param g composante verte
     * @param b composante bleue
     * @return l'entier RGB correspondant
     */
    public static int getComponent(int rgb, boolean r, boolean g, boolean b){
        String hex = (r ? "ff" : "00") + (g ? "ff" : "00") + (b ? "ff" : "00");
        return rgb & Integer.parseInt(hex, 16);
    }

    /**
     * Méthode permettant de récupérer la distance entre deux couleurs.
     * @param rgb entier RGB
     * @param color deuxième couleur
     * @return l'entier correspondant à la distance
     */
    public static int getDistance(int rgb, Color color){
        int[] rgbArray = getRGBArray(rgb);
        return (int)Math.pow((Math.pow(rgbArray[0] - color.getRed(), 2) + Math.pow(rgbArray[1] - color.getGreen(), 2) + Math.pow(rgbArray[2] - color.getBlue(), 2)), 2);
    }
}
