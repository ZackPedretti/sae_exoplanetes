package sae.tp_preparation.normes;

/**
 *  Interface définissant la manière de calculer la distance entre deux couleurs.
 *
 *  Question 2.3 :
 *  "Écrire l’interface NormeCouleurs"
 */
public interface NormeCouleur {
    /**
     * retourne la distance entre deux couleurs passées en paramètre.
     * @param c1 première couleur
     * @param c2 deuxième couleur
     * @return la distance entre les deux couleurs.
     */
    double distanceCouleur(int c1, int c2);
}
