import java.util.*;

public class NoeudArbre {
    /**
     * Attribut servant à la saisie clavier
     */
    private static final Scanner keyboard = new Scanner(System.in);
    /**
     * Chaine de caractère représentant le contenu du noeud
     */
    private String chaine;
    /**
     * Noeuds fils de l'arbre binaire (ici non / oui)
     */
    private NoeudArbre gauche, droite;

    /**
     * Constructeur permettant de construire un noeud simple sans fils
     *
     * @param chaine le contenu du noeud
     */
    public NoeudArbre(String chaine) {
        this(chaine, null, (NoeudArbre) null);
    }

    /**
     * Constructeur permettant de fabriquer un noeud avec les contenu du noeud père et de ses fils
     *
     * @param chaine le contenu du père
     * @param gauche le contenu du fils de gauche (non)
     * @param droite le contenu du file de droite (oui)
     */
    public NoeudArbre(String chaine, String gauche, String droite) {
        this(chaine, new NoeudArbre(gauche), new NoeudArbre(droite));
    }

    /**
     * Constructeur permettant de construire un noeud en lui donnant ses fils construits
     *
     * @param chaine le contenu du noeud
     * @param droite le fils droit du noeud
     * @param gauche le fils gauche du noeud
     */
    public NoeudArbre(String chaine, NoeudArbre gauche, NoeudArbre droite) {
        this.chaine = chaine;
        this.gauche = gauche;
        this.droite = droite;
    }

    @Override
    public String toString() {
        if (droite == null && gauche == null) return chaine + ",";
        return (chaine + "," + " " + (gauche != null ? gauche.toString() : "") + " " + (droite != null ? droite.toString() : ""));
    }

    /**
     * Permet d'obtenir une chaine de caractère sauvegardable utilisable facilement pour la reconstruction d'un arbre
     * @return
     */
    public String toSaveString() {
        return "\"" + toString() + "\"";
    }

    /**
     * Pose une serie de questions jusqu'à trouver l'animal ou si echec de recherche (non existant)
     */
    public void rechercherAnimal() {
        System.out.println(chaine);
        String response = keyboard.nextLine();
        switch (response) {
            case "oui":
                if (droite == null) return;
                droite.rechercherAnimal();
                break;
            case "non":
                if (gauche == null) {
                    apprendre();
                    return;
                }
                gauche.rechercherAnimal();
                break;
            default:
                System.out.println("Saisie invalide");
                rechercherAnimal();
        }
    }

    /**
     * Transforme une feuille en noeud contenant 2 noouvelles feuilles pour ajouter une question et ses 2 possibilités d'animaux
     */
    private void apprendre() {
        System.out.println("Qu’est-ce que c’est ?");
        String chaine = keyboard.nextLine();
        System.out.println(chaine + " ! Je ne connais pas cet animal. Donnez-moi une question qui permette de les différencier :");
        String question = keyboard.nextLine();
        System.out.println("Quelle doit être la réponse ?");
        switch (keyboard.nextLine()) {
            case "oui":
                droite = new NoeudArbre(chaine);
                gauche = new NoeudArbre(this.chaine);
                break;
            case "non":
                gauche = new NoeudArbre(chaine);
                droite = new NoeudArbre(this.chaine);
                break;
            default:
                System.out.println("Saisie invalide");
        }
        this.chaine = question;
    }

    /**
     * Permet de tracer le cheminement permettant de caractériser un animal
     *
     * @param animal le nom de l'animal à caractériser
     * @return les réponses à donner pour faire deviner cet animal
     */
    String definir(String animal) {
        if (droite == null && gauche == null) return chaine;
        String resG = "";
        String resD = "";
        if (gauche != null) resG = gauche.definir(animal);
        if (droite != null) resD = droite.definir(animal);
        if (resG.contains(animal)) {
            resG = "non -> " + resG;
        } else {
            resG = "";
        }
        if (resD.contains(animal)) {
            resD = "oui -> " + resD;
        } else {
            resD = "";
        }
        return chaine + " => " + resG + resD;
    }

    /**
     * Contruit un arbre à partir de sa représentation textuelle (préfixe)
     * exemple: Est-ce un mammifère ?, poisson, chien
     *
     * @param strings
     * @return
     */
    public static NoeudArbre fromString(Queue<String> strings) {
        if (strings.isEmpty()) return null;
        String element = strings.poll();
        if (!element.contains("?")) {
            return new NoeudArbre(element, (NoeudArbre) null, null);
        }
        NoeudArbre left = fromString(strings);
        NoeudArbre right = fromString(strings);;
        return new NoeudArbre(element, left, right);
    }

    /**
     * Fonction principale permettant soit de lancer le mode de recherche soit de caractériser un animal donné en paramètre
     *
     * @param args Voir sujet pour utilisation des paramètres
     */
    public static void main(String[] args) {
        NoeudArbre n = null;
        switch (args.length) {
            case 2:
                if (args[0].equals("--definir")) {
                    n = new NoeudArbre("Est-ce un mammifère ?");
                    n.droite = new NoeudArbre("Est-ce un canidé ?", "chat", "chien");
                    n.gauche = new NoeudArbre("Est-ce dangereux ?", "poisson", "requin");
                    System.out.println(n.definir(args[1]));
                }
                break;
            case 1:
                Queue<String> queue = new LinkedList<String>(Arrays.asList(args[0].split(",")));
                n = fromString(queue);
            case 3:
                if (n == null) n = new NoeudArbre(args[0], args[1], args[2]);
            default:
                if (n == null) n = new NoeudArbre("Est-ce un mammifère ?", "poisson", "chien");
                do {
                    n.rechercherAnimal();
                    System.out.println("Voulez vous continuer ?");
                } while (!keyboard.nextLine().equals("non"));
                System.out.println(n.toString());
                System.err.println(n.toSaveString());
        }
    }
}
