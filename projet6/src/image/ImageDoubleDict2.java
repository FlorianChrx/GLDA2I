package image;

import dictionnaire.ArrayListDict;
import dictionnaire.Dictionnaire;

/**
 * La classe <code>ImageDoubleDict2</code> représente une image en niveaux
 * de gris au moyen d'un dictionnaire dont les clefs sont les abscisses des
 * points de l'image, et les valeurs sont elles-mêmes des dictionnaires
 * associant à chaque ordonnée le niveau de gris associé.
 * La différence principale avec <code>ImageDict</code> est le temps d'accès
 * aux données, de l'ordre de <code>largeur + hauteur</code> dans le pire cas,
 * contre <code>largeur * hauteur</code> pour le pire cas dans <code>ImageDict</code>.
 * <B> On remarquera que le code de toutes les méthodes de <code>ImageDict</code>
 * et <code>ImageDoubleDict2</code> est identique, à l'exception de <code>pointEn</code>
 * et <code>definirPoint</code>.</B>
 * Cette classe utilise <code>ArrayListDict</code> pour gérer les dictionnaires.
 *
 * @see image.NiveauGris
 * @see image.Point
 * @see dictionnaire.TabDict
 */
public class ImageDoubleDict2 extends ImageDictQuelconque {

        public ImageDoubleDict2(int w, int h) {
                super(w, h);
        }

        protected void initialiserPoints() {
        points = new ArrayListDict<Integer, Dictionnaire<Integer, NiveauGris>>();
    }

    public NiveauGris pointEn(int x, int y) {
        if (points.contientClef(x)) {
            Dictionnaire<Integer, NiveauGris> d = (Dictionnaire<Integer, NiveauGris>) points.valeurPour(x);
            if (d.contientClef(y))
                return d.valeurPour(y);
        }
        return NiveauGris.BLANC;
    }

    public void definirPoint(int x, int y, NiveauGris gris) {
        if (this.correct(x, y)) {
            if (gris.equals(NiveauGris.BLANC)) {
                Dictionnaire<Integer, NiveauGris> d;
                if (points.contientClef(x)) {
                    d = (Dictionnaire<Integer, NiveauGris>) points.valeurPour(x);
                    d.enleverPour(y);
                    if (d.estVide())
                        points.enleverPour(x);
                }
            } else {
                Dictionnaire<Integer, NiveauGris> d;
                if (points.contientClef(x))
                    d = (Dictionnaire<Integer, NiveauGris>) points.valeurPour(x);
                else {
                    d = new ArrayListDict<>();
                    points.ajouter(x, d);
                }
                d.ajouter(y, gris);
            }
        }
    }
}