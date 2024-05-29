package sae.tp_preparation;

import sae.tp_preparation.normes.NormeCouleur;
import sae.tp_preparation.normes.NormeRedmean;

import java.awt.*;

/**
 * Palette utilisant la distance Redmean afin de générer une image.
 */
public class PaletteNorme extends Palette{

    NormeCouleur norme;
    public PaletteNorme(Color[] colors, NormeCouleur norme) {
        super(colors);
        this.norme = norme;
    }

    public int nearestColor(int rgb){
        double minDistance = ColorTool.getDistance(rgb, colors[0]);
        Color nearestColor = colors[0];
        for(Color c : colors){
            if (norme.distanceCouleur(rgb, c.getRGB()) < minDistance) {
                nearestColor = c;
                minDistance = norme.distanceCouleur(rgb, c.getRGB());
            }
        }
        return nearestColor.getRGB();
    }
}
