package sae.tp_preparation.normes;

import sae.tp_preparation.ColorTool;

/**
 * Classe représentant la norme Redmean.
 *
 * Question 2.4 :
 * "Programmez cette fa¸con de comparer des couleurs dans une classe dans une classe
 * NormeRedmean implémentant NormeCouleurs et comparez avec l’approche précédente."
 */
public class NormeRedmean implements NormeCouleur{
    @Override
    public double distanceCouleur(int c1, int c2) {
        int[] c1Array = ColorTool.getRGBArray(c1);
        int[] c2Array = ColorTool.getRGBArray(c2);

        double avgRed = (float)(c1Array[0] + c2Array[0]) / 2;

        int diffR = Math.abs(c1Array[0] - c2Array[0]);
        int diffG = Math.abs(c1Array[1] - c2Array[1]);
        int diffB = Math.abs(c1Array[2] - c2Array[2]);

        return Math.sqrt(((2 + (avgRed / 256)) * diffR) + (4 * diffG) + ((2 + (255 - avgRed / 256)) * diffB));
    }
}
