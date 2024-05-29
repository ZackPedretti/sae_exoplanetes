package sae.tp_preparation.normes;

import sae.tp_preparation.ColorTool;
import sae.tp_preparation.RgbToLab;

/**
 * Classe représentant la norme CIELAB.
 *
 * Question 2.5 :
 * "Ajoutez une norme implémentant cette métrique. Des classes Java pour la conversion
 * RGB ↔ L*a*b* vous sont fournis."
 */
public class NormeCielab implements NormeCouleur{
    @Override
    public double distanceCouleur(int c1, int c2) {
        int[] rgb1 = ColorTool.getRGBArray(c1);
        int[] cielab1 = RgbToLab.rgb2lab(rgb1[0], rgb1[1], rgb1[2]);

        int[] rgb2 = ColorTool.getRGBArray(c2);
        int[] cielab2 = RgbToLab.rgb2lab(rgb2[0], rgb2[1], rgb2[2]);

        return Math.sqrt(Math.pow(cielab2[0] - cielab1[0], 2) + Math.pow(cielab2[1] - cielab1[1], 2) + Math.pow(cielab2[2] - cielab1[2], 2));
    }
}
