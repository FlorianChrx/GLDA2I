public class PileHanoi implements Pile {
    Disque[] pile = new Disque[PileHanoi.MAX_ELEMENTS];
    int nbElts = 0;

    @Override
    public boolean vide() {
        return nbElts == 0;
    }

    @Override
    public boolean pleine() {
        return nbElts == MAX_ELEMENTS;
    }

    @Override
    public boolean peutEmpiler(Object x) {
        return !pleine() && x instanceof Disque;
    }

    @Override
    public Object sommet() {
        return pile[nbElts - 1];
    }

    @Override
    public Object depile() {
        return pile[nbElts--];
    }

    @Override
    public void empile(Object x) {
        if (peutEmpiler(x)) {
            pile[++nbElts] = (Disque) x;
        }
    }

    @Override
    public void vider() {
        nbElts = 0;
    }

    @Override
    public int nbElements() {
        return nbElts;
    }

    @Override
    public void deplacerUnElementVers(Pile p) {
        p.empile(depile());
    }
}
