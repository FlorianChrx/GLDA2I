package image;

/**
 * La classe <code>ImageTab</code> représente une image en niveaux
 * de gris au moyen d'un tableau à deux dimensions de <code>NiveauGris</code>.
 * Le tableau de départ doit donc être initialisé lors de l'instanciation
 * en plaçant partout des points blancs.
 *
 * @see image.NiveauGris
 */
public class ImageTab extends ImageQuelconque {
    private NiveauGris[][] points;

    public ImageTab(int w, int h) {
        largeur = w;
        hauteur = h;
        this.initialiserPoints();
    }

    private void initialiserPoints() {
        points = new NiveauGris[largeur][hauteur];
        for (int y = 0; y < hauteur; y++)
            for (int x = 0; x < largeur; x++)
                this.definirPoint(x, y, NiveauGris.BLANC);
        // this.definirPoint(x, y, new NiveauGris(NiveauGris.BLANC));
    }

    public NiveauGris pointEn(int x, int y) {
        if (this.correct(x, y))
            return points[x][y];
        return NiveauGris.BLANC;
    }

    public void definirPoint(int x, int y, NiveauGris gris) {
        if (this.correct(x, y))
            points[x][y] = gris;
    }
}