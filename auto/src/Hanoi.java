import java.util.Scanner;

/**
 * Programme permettant de manipuler et d'expérimenter le problème
 * des tours de Hanoï
 */
public class Hanoi {
    /**
     * Les trois piles représentant les tours de Hanoi
     */
    private static PileHanoi a, b, c;
    /**
     * Attribut permettant les saisies clavier
     */
    private static final Scanner clavier = new Scanner(System.in);

    /**
     * Initialisation des tours pour n disques
     *
     * @param n
     */
    private static void init(int n) {
        a = new PileHanoi("A");
        b = new PileHanoi("B");
        c = new PileHanoi("C");
        for (int i = n; i > 0; i--)
            a.empile(new DisqueHanoi(i));
    }

    /**
     * Affichage des trois tours
     */
    private static void affiche() {
        System.out.println(a + "\n" + b + "\n" + c);
    }

    /**
     * Pour le mode interactif, le choix de la pile est donné par le joueur
     * en toutes lettres ("A", "B", "C"). -> retourne la pile correspondante
     *
     * @param r
     * @return
     */
    private static PileHanoi analyse(String r) {
        switch (r.toLowerCase()) {
            case "a":
                return a;
            case "b":
                return b;
            case "c":
                return c;
            default:
                return null;
        }
    }

    /**
     * Méthode principale du programme.
     *
     * @param arg
     */
    public static void main(String[] arg) {
        int nbDisques = 3;
        init(nbDisques);
        boolean fini;
        String rep;
        PileHanoi start, end;

        if (arg[0].equals("--auto")) {
            resoudreAuto(a, b, c);
        } else {
            do {
                affiche();
                System.out.print("Déplacer de: ");
                rep = clavier.nextLine();
                fini = rep.equalsIgnoreCase("stop");
                start = analyse(rep);
                if (!fini) {
                    System.out.print("Vers : ");
                    rep = clavier.nextLine();
                    fini = rep.equalsIgnoreCase("stop");
                    end = analyse(rep);
                    if (end.peutEmpiler(start.sommet()))
                        start.deplacerUnElementVers(end);
                    else
                        System.out.println("Impossible !");
                }
            } while (!fini);
        }
        System.out.println("Ok, c'est fini !");
    }

    public static void resoudreAuto(PileHanoi a, PileHanoi b, PileHanoi c) {
        a.deplacerDesDisques(a.nbElements(), b, c);
        System.out.println(a + "\n" + b + "\n" + c);
    }
}
