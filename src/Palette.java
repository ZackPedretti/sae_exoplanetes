import java.awt.*;

/**
 * Classe modélisant une palette de couleurs.
 *
 * Question 2.2
 * "Augmentez le nombre de couleurs parmi lesquelles choisir dans le tableau (par exemple
 * cf image 5). Le choix de la couleur la plus proche nécessite une recherche de minimum.
 * Pour cela, créez une classe Palette avec un tableau de couleurs en attribut et une
 * méthode getPlusProche qui retourne la couleur du tableau la plus proche de la couleur
 * passée en paramètre."
 */
public class Palette {
    Color[] colors;

    public Palette(Color[] colors){
        this.colors = colors;
    }

    /**
     * Méthode permettant de récupérer quelle couleur de la palette est la plus proche de l'entier RGB
     * @param rgb entier RGB
     * @return entier RGB correspondant à la couleur
     */
    public int nearestColor(int rgb){
        int minDistance = ColorTool.getDistance(rgb, colors[0]);
        Color nearestColor = colors[0];
        for(Color c : colors){
            if (ColorTool.getDistance(rgb, c) < minDistance) nearestColor = c;
        }
        return nearestColor.getRGB();
    }
}
