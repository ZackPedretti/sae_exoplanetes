package sae.tp_preparation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Classe servant à copier une image pixel par pixel.
 *
 * Question 1.2 :
 * "En utilisant ces méthodes, écrire une classe qui charge une image, la copie pixel par
 * pixel dans une nouvelle image et sauve le résultat."
 */
public class ImageCopyPixels {
    public static void main(String[] args) {
        try {
            copyImage("img/the_mountain.png", "img/the_mountain_copie_pixels.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Méthode permettant de copier une image pixel par pixel.
     * L'image doit être de format PNG.
     * @param inputPath chemin de l'image à copier
     * @param outputPath chemin de l'image collée
     * @throws IOException
     */
    public static void copyImage(String inputPath, String outputPath) throws IOException {
        BufferedImage inputImage = ImageIO.read(new File(inputPath));
        BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        for(int i = 0; i < inputImage.getWidth(); i++){
            for(int ii = 0; ii < inputImage.getHeight(); ii++){
                outputImage.setRGB(i, ii, inputImage.getRGB(i, ii));
            }
        }
        ImageIO.write(outputImage, "PNG", new File(outputPath));
    }
}
