package image;

import dictionnaire.ArrayListDict;

/**
 * La classe <code>ImageDict2</code> représente une image en niveaux
 * de gris au moyen d'un dictionnaire dont les clefs sont des coordonnées
 * (classe <code>Point</code>) et les valeurs les niveaux de gris associés.
 * Lors de l'instanciation, il suffit de créer un dictionnaire vide puisqu'on
 * ne stocke que les niveau de gris autres que blanc. L'absence de la clef
 * (x, y) dans le dictionnaire signifie que le point (x, y) est blanc.
 * Cette classe utilise <code>ArrayListDict</code>.
 *
 * @see image.NiveauGris
 * @see image.Point
 * @see dictionnaire.TabDict
 */
public class ImageDict2 extends ImageDictQuelconque {

    public ImageDict2(int w, int h) {
        super(w, h);
    }

    protected void initialiserPoints() {
        points = new ArrayListDict<Point, NiveauGris>();
    }

    public NiveauGris pointEn(int x, int y) {
        if (points.contientClef(new Point(x, y)))
            return (NiveauGris) points.valeurPour(new Point(x, y));
        return NiveauGris.BLANC;
    }

    public void definirPoint(int x, int y, NiveauGris gris) {
        if (this.correct(x, y)) {
            if (gris.equals(NiveauGris.BLANC))
                points.enleverPour(new Point(x, y));
            else
                points.ajouter(new Point(x, y), gris);
        }
    }
}
