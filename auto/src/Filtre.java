public class Filtre {
    private int nb;
    private Filtre next;

    public Filtre(int i) {
        nb = i;
    }

    public void filtrer(int i) {
        if (i % nb == 0) {
            return;
        } else if (next == null) {
            next = new Filtre(i);
        } else {
            next.filtrer(i);
        }
    }

    @Override
    public String toString() {
        if (next != null) {
            return nb + ", " + next.toString();
        } else {
            return nb + "";
        }
    }
}
