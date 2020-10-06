public class PileHanoi implements Pile<Disque> {

    private Disque[] elements;  // les éléments contenus dans la pile
    private int nbElem = 0; // le nombre d’éléments dans la pile
    private String nom;     // nom de la pile : information supplémentaire propre à PileTableau


    public PileHanoi(String nom) {
        this.nom = nom;
        this.elements = new Disque[MAX_ELEMENTS];
    }

    public boolean vide() {
        if (this.nbElements() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pleine() {
        if (this.nbElements() == MAX_ELEMENTS) {
            return true;
        } else {
            return false;
        }
    }

    public boolean peutEmpiler(Disque x) {
        if (this.vide()) {
            return true;
        }
        // On vérifie que le disque que l'on déplace est plus grand que le sommet de la pile ou que la pile est vide
        if (this.sommet().diametre() > x.diametre()) {
            return true;
        } else {
            return false;
        }
    }

    public Disque sommet() {
        if (this.vide()) {
            return null;
        }
        return elements[this.nbElements() - 1];
    }

    public Disque depile() {
        // On vérifie si le tableau est vide pour avoir quelque chsoe a depiler
        if (!vide()) {
            this.nbElem = this.nbElements() - 1;
        }
        return elements[nbElements()];
    }

    public void empile(Disque x) {
        // On vérifie que la pile n'est pas pleine et que peutEmpiler est bon
        if (this.peutEmpiler(x)) {
            // On parcours de la fin au début
            elements[this.nbElements()] = x;
            this.nbElem = this.nbElements() + 1;
        }
    }

    public void vider() {
        this.elements = (Disque[]) new Object[MAX_ELEMENTS];
        this.nbElem = 0;
    }

    public int nbElements() {
        return this.nbElem;
    }

    public String getNom() {
        return this.nom;
    }

    public void deplacerUnElementVers(Pile<Disque> p) {
        if (p instanceof PileHanoi) {
            p = (Pile) p;
        }
        p.empile(this.depile());
    }

    @Override
    public String toString() {
        String phrase = "Nom de la pile :" + this.nom + "\n";

        for (int i = 0; i < this.nbElements(); i++) {

            phrase = phrase + " " + elements[i].toString();
        }
        return phrase;
    }

    public void deplacerDesDisques(int n, Pile dest, Pile interm) {
        if (n == 0)
            return;
        PileHanoi dest2 = null, interm2 = null;
        if (dest instanceof PileHanoi) {
            dest2 = (PileHanoi) dest;
        }
        if (interm instanceof PileHanoi) {
            interm2 = (PileHanoi) interm;
        }
        this.deplacerDesDisques(n - 1, interm, dest);
        this.deplacerUnElementVers(dest);
        interm2.deplacerDesDisques(n - 1, dest, this);
    }

}