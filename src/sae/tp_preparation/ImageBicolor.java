package sae.tp_preparation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Classe permettant de copier une image en sa version bicolore.
 *
 * Question 2.1 :
 * "Programmez ce type de transformation dans une classe et regarder l’image obtenue (cf
 * image 4)."
 */
public class ImageBicolor {
    public static void main(String[] args) {
        try {
            copyImagePalette("img/the_mountain.png", "img/the_mountain_bicolor.png", new Color[] {Color.GREEN, Color.YELLOW});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Méthode permettant de copier une image en une palette de couleurs.
     * L'image doit être de format PNG.
     * @param inputPath chemin de l'image à copier
     * @param outputPath chemin de l'image collée
     * @throws IOException
     */
    public static void copyImagePalette(String inputPath, String outputPath, Color[] colors) throws IOException {
        BufferedImage inputImage = ImageIO.read(new File(inputPath));
        BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        for(int i = 0; i < inputImage.getWidth(); i++){
            for(int ii = 0; ii < inputImage.getHeight(); ii++){
                int minDistance = ColorTool.getDistance(inputImage.getRGB(i, ii), colors[0]);
                Color nearestColor = colors[0];
                for(Color c : colors){
                    if (ColorTool.getDistance(inputImage.getRGB(i, ii), c) < minDistance) nearestColor = c;
                }
                outputImage.setRGB(i, ii, nearestColor.getRGB());
            }
        }
        ImageIO.write(outputImage, "PNG", new File(outputPath));
    }
}
