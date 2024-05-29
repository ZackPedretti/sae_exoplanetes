package sae.tp_preparation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Classe permettant de copier une image en ne gardant que sa composante rouge, ou ses composantes vertes et bleues.
 *
 * Question 1.5 :
 * "En utilisant ces méthodes, écrire une classe qui charge l’image d’origine, crée une nouvelle image, y stocke la composante Rouge de l’image initiale et sauve cette nouvelle
 * image (cf Figure 3-(c))."
 *
 * Question 1.6 :
 * "Modifier le paramètre utilisé pour stocker les composants Vert + Bleu de l’image originale (cf Figure 3-(d))"
 */
public class ImageComponentFilter {
    public static void main(String[] args) {
        try {
            copyImageR("img/the_mountain.png", "img/the_mountain_rouge.png");
            copyImageGB("img/the_mountain.png", "img/the_mountain_bleu_vert.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Méthode permettant de copier une image en rouge.
     * L'image doit être de format PNG.
     * @param inputPath chemin de l'image à copier
     * @param outputPath chemin de l'image collée
     * @throws IOException
     */
    public static void copyImageR(String inputPath, String outputPath) throws IOException{
        BufferedImage inputImage = ImageIO.read(new File(inputPath));
        BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        for(int i = 0; i < inputImage.getWidth(); i++){
            for(int ii = 0; ii < inputImage.getHeight(); ii++){
                outputImage.setRGB(i, ii, ColorTool.getComponent(inputImage.getRGB(i, ii), true, false, false));
            }
        }
        ImageIO.write(outputImage, "PNG", new File(outputPath));
    }

    /**
     * Méthode permettant de copier une image en rouge.
     * L'image doit être de format PNG.
     * @param inputPath chemin de l'image à copier
     * @param outputPath chemin de l'image collée
     * @throws IOException
     */
    public static void copyImageGB(String inputPath, String outputPath) throws IOException{
        BufferedImage inputImage = ImageIO.read(new File(inputPath));
        BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        for(int i = 0; i < inputImage.getWidth(); i++){
            for(int ii = 0; ii < inputImage.getHeight(); ii++){
                outputImage.setRGB(i, ii, ColorTool.getComponent(inputImage.getRGB(i, ii), false, true, true));
            }
        }
        ImageIO.write(outputImage, "PNG", new File(outputPath));
    }

}
