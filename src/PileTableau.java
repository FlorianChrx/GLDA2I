import java.util.Arrays;

public class PileTableau<E> implements Pile<E> {

    /**
     * les éléments contenus dans la pile
     */
    private E[] elements;
    /**
     * le nombre d’éléments dans la pile
     */
    private int nbElem = 0;
    /**
     * nom de la pile : information supplémentaire propre à PileTableau
     */
    private String nom;

    public PileTableau(String nom) {
        this.nom = nom;
        elements = (E[]) new Object[MAX_ELEMENTS];
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
    public boolean peutEmpiler(E x) {
        return !pleine();
    }

    @Override
    public E sommet() {
        return elements[nbElem - 1];
    }

    @Override
    public E depile() {
        if (vide()) return null;
        nbElem--;
        return elements[nbElem];
    }

    @Override
    public void empile(E x) {
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
    public void deplacerUnElementVers(Pile<E> p) {
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

    public E[] getElements() {
        return elements;
    }

    public int getNbElem() {
        return nbElem;
    }

    public String getNom() {
        return nom;
    }
}
