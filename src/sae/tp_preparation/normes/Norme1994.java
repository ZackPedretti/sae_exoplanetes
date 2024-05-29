package sae.tp_preparation.normes;

import sae.tp_preparation.ColorTool;
import sae.tp_preparation.RgbToLab;

/**
 * Classe représentant la norme de 1994.
 *
 * Question 2.6 :
 * "Étudier l’influence des types de normes utilisées pour la recherche de la couleur voisine
 * la plus proche.
 * Pour cela, ajoutez un attribut NormeCouleurs distanceCouleur dans Palette, afin
 * que getPlusProche utilise la norme sélectionnée."
 */
public class Norme1994 implements NormeCouleur{
    @Override
    public double distanceCouleur(int color1, int color2) {
        int[] rgb1 = ColorTool.getRGBArray(color1);
        int[] cielab1 = RgbToLab.rgb2lab(rgb1[0], rgb1[1], rgb1[2]);

        int[] rgb2 = ColorTool.getRGBArray(color2);
        int[] cielab2 = RgbToLab.rgb2lab(rgb2[0], rgb2[1], rgb2[2]);

        int deltaL = cielab1[0] - cielab2[0];

        double c1 = Math.sqrt(Math.pow(cielab1[1], 2) + Math.pow(cielab1[2], 2));
        double c2 = Math.sqrt(Math.pow(cielab2[1], 2) + Math.pow(cielab2[2], 2));

        double deltaC = c1 - c2;

        double sc = 1 + 0.045 * c1;
        double sh = 1 + 0.015 * c1;

        double deltaH = Math.sqrt(Math.pow(cielab1[1] - cielab2[1], 2) + Math.pow(cielab1[2] - cielab2[2], 2) - deltaC);

        return Math.sqrt(Math.pow(deltaL / 1, 2) + Math.pow(deltaC / sc, 2) + Math.pow(deltaH / sh, 2));
    }
}
