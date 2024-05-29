package sae.tp_preparation;

import sae.tp_preparation.normes.NormeRedmean;

import java.awt.*;

/**
 * Palette utilisant la distance Redmean afin de générer une image.
 */
public class PaletteRedmean extends Palette{
    public PaletteRedmean(Color[] colors) {
        super(colors);
    }

    public int nearestColor(int rgb){
        double minDistance = ColorTool.getDistance(rgb, colors[0]);
        Color nearestColor = colors[0];
        NormeRedmean redmean = new NormeRedmean();
        for(Color c : colors){
            if (redmean.distanceCouleur(rgb, c.getRGB()) < minDistance) {
                nearestColor = c;
                minDistance = redmean.distanceCouleur(rgb, c.getRGB());
            }
        }
        return nearestColor.getRGB();
    }
}
