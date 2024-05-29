package sae.tp_preparation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Classe permettant de copier une couleur en une palette de couleurs.
 *
 * Question 2.2 :
 * "Augmentez le nombre de couleurs parmi lesquelles choisir dans le tableau (par exemple
 * cf image 5). Le choix de la couleur la plus proche nécessite une recherche de minimum.
 * Pour cela, créez une classe sae.tp_preparation.Palette avec un tableau de couleurs en attribut et une
 * méthode getPlusProche qui retourne la couleur du tableau la plus proche de la couleur
 * passée en paramètre."
 */
public class ImagePalette {
    public static void main(String[] args) {
        try {
            copyImage("img/the_mountain.png", "img/the_mountain_palette.png", new Palette(new Color[]{Color.BLUE, Color.black, Color.CYAN, Color.GREEN, Color.WHITE}));
            copyImage("img/the_mountain.png", "img/the_mountain_palette_redmean.png", new PaletteRedmean(new Color[]{Color.BLUE, Color.black, Color.CYAN, Color.GREEN, Color.WHITE}));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Méthode permettant de copier une image en une palette de couleurs.
     * L'image doit être de format PNG.
     * @param inputPath chemin de l'image à copier
     * @param outputPath chemin de l'image collée
     * @param palette palette de couleurs
     * @throws IOException
     */
    public static void copyImage(String inputPath, String outputPath, Palette palette) throws IOException{
        BufferedImage inputImage = ImageIO.read(new File(inputPath));
        BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        for(int i = 0; i < inputImage.getWidth(); i++){
            for(int ii = 0; ii < inputImage.getHeight(); ii++){
                outputImage.setRGB(i, ii, palette.nearestColor(inputImage.getRGB(i, ii)));
            }
        }
        ImageIO.write(outputImage, "PNG", new File(outputPath));
    }
}
