import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Classe qui copie l'image de base en noir et blanc.
 *
 * Question 1.4 :
 * "En utilisant ces méthodes, écrire une classe qui charge l’image d’origine, créée une
 * nouvelle image, y stocke la conversion de l’image initiale en noir et blanc et sauve cette
 * nouvelle image."
 */
public class ImageBlackAndWhite {
    public static void main(String[] args) {
        try {
            copyImage("img/the_mountain.png", "img/the_mountain_noir_et_blanc.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Méthode permettant de copier une image en noir et blanc.
     * L'image doit être de format PNG.
     * @param inputPath chemin de l'image à copier
     * @param outputPath chemin de l'image collée
     * @throws IOException
     */
    public static void copyImage(String inputPath, String outputPath) throws IOException{
        BufferedImage inputImage = ImageIO.read(new File(inputPath));
        BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        for(int i = 0; i < inputImage.getWidth(); i++){
            for(int ii = 0; ii < inputImage.getHeight(); ii++){
                int avg = Arrays.stream(ColorTool.getRGBArray(inputImage.getRGB(i, ii))).sum() / 3;
                int rgb = (new Color(avg, avg, avg)).getRGB();
                outputImage.setRGB(i, ii, rgb);
            }
        }
        ImageIO.write(outputImage, "PNG", new File(outputPath));
    }
}
