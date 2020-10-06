/**
 * Programme permettant de manipuler et d'expérimenter le problème
 * des tours de Hanoï
 */
public class Hanoi {
    // Les trois piles représentant les tours de Hanoï
    private static PileHanoi a, b, c;

    // Initialisation des tours pour n disques, placés au début en A
    private static void init(int n) {
        a = new PileHanoi("A");
        b = new PileHanoi("B");
        c = new PileHanoi("C");
        for (int i = n; i > 0; i--)
            a.empile(new DisqueHanoi(i));
    }

    // Affichage des trois tours
    private static void affiche() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    // Pour le mode interactif, le choix de la pile est donné par le joueur
    // en toutes lettres ("A", "B", "C"). -> retourne la pile correspondante
    private static PileHanoi analyse(String r) {
        if (r.equalsIgnoreCase("A"))
            return a;
        if (r.equalsIgnoreCase("B"))
            return b;
        return c;
    }

    // Méthode principale du programme.
    public static void main(String[] arg) {
        // le nombre de disques (on peut aussi le demander au joueur)
        int nbDisques = 3;

        // initialisation des piles
        init(nbDisques);

        boolean fini = false;
        String rep;
        PileHanoi depart, arrivee;

        System.out.println(arg[0].getClass());

        if (arg[0].equals("--auto")) {
            resoudreAuto(a, b, c);
        } else {
            do {
                affiche();
                System.out.print("Déplacer de : ");
                rep = Clavier.readString();
                if (rep.equalsIgnoreCase("stop"))
                    fini = true;
                depart = analyse(rep);
                if (!fini) {
                    System.out.print("Vers : ");
                    rep = Clavier.readString();
                    if (rep.equalsIgnoreCase("STOP"))
                        fini = true;
                    arrivee = analyse(rep);
                    if (arrivee.peutEmpiler(depart.sommet()))
                        depart.deplacerUnElementVers(arrivee);
                    else
                        System.out.println("Impossible !");
                }
            } while (!fini);
        }


        System.out.println("OK, c'est fini !");
    }

    public static void resoudreAuto(PileHanoi a, PileHanoi b, PileHanoi c) {
        a.deplacerDesDisques(a.nbElements(), b, c);
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
    }
}
