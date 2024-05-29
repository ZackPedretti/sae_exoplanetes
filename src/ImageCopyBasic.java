import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Classe servant à copier une image.
 *
 * Question 1.1 :
 * "En utilisant ces méthodes, écrire une classe qui effectue une copie d’une image sur votre
 * disque"
 */
public class ImageCopyBasic {
    public static void main(String[] args) {
        try {
            copyImage("img/the_mountain.png", "img/the_mountain_copie_basique.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Méthode permettant de copier une image.
     * L'image doit être de format PNG.
     * @param inputPath chemin de l'image à copier
     * @param outputPath chemin de l'image collée
     * @throws IOException
     */
    public static void copyImage(String inputPath, String outputPath) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(inputPath));
        ImageIO.write(bufferedImage, "PNG", new File(outputPath));
    }
}
