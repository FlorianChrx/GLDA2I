import java.util.Arrays;

public class PileTableauComp implements Pile<Comparable> {

    /**
     * les éléments contenus dans la pile
     */
    private Comparable[] elements;
    /**
     * le nombre d’éléments dans la pile
     */
    private int nbElem = 0;
    /**
     * nom de la pile : information supplémentaire propre à PileTableau
     */
    private String nom;

    public PileTableauComp(String nom) {
        this.nom = nom;
        elements = (Comparable[]) new Object[MAX_ELEMENTS];
    }

    @Override
    public boolean vide() {
        return nbElem == 0;
    }

    @Override
    public boolean pleine() {
        return nbElem == elements.length;
    }

    @Override
    public boolean peutEmpiler(Comparable x) {
        return !pleine();
    }

    @Override
    public Comparable sommet() {
        return elements[nbElem - 1];
    }

    @Override
    public Comparable depile() {
        if (vide()) return null;
        nbElem--;
        return elements[nbElem];
    }

    @Override
    public void empile(Comparable x) {
        if (!pleine()) elements[nbElem++] = x;
    }

    @Override
    public void vider() {
        nbElem = 0;
    }

    @Override
    public int nbElements() {
        return nbElem;
    }

    @Override
    public void deplacerUnElementVers(Pile<Comparable> p) {
        System.out.println(toString() + " -> " + p.toString());
        p.empile(this.depile());
    }

    @Override
    public String toString() {
        String res = "PileTableau{" + "elements=[";
        for (int i = nbElem-1; i >= 0; i--) res += elements[i] + (i - 1 >= 0 ? ", " : "");
        res += "], nbElem=" + nbElem + ", nom='" + nom + '\'' + '}';
        return res;
    }

    public Comparable[] getElements() {
        return elements;
    }

    public int getNbElem() {
        return nbElem;
    }

    public String getNom() {
        return nom;
    }

    public void trier() {
        int n = getElements().length - 1;
        for (int i = n; i >= 1; i--)
            for (int j = 2; j <= i; j++)
                if (getElements()[j - 1].compareTo(getElements()[j]) > 0) {
                    Comparable temp = getElements()[j - 1];
                    getElements()[j - 1] = getElements()[j];
                    getElements()[j] = temp;
                }
    }
}

