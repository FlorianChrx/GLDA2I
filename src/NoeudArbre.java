import java.util.Scanner;

public class NoeudArbre {
    private static Scanner keyboard = new Scanner(System.in);
    private String chaine;
    private NoeudArbre gauche, droite;

    public NoeudArbre(String chaine) {
        this.chaine = chaine;
    }

    public NoeudArbre (String chaine, String gauche, String droite) {
        this.chaine = chaine;
        this.gauche = new NoeudArbre(gauche);
        this.droite = new NoeudArbre(droite);
    }

    @Override
    public String toString() {
        if (droite == null && gauche == null) return chaine;
        return chaine + " " + (gauche != null ? gauche.toString() : "") +  " " + (droite != null ? droite.toString() : "");
    }

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

    public static void main(String[] args) {
        NoeudArbre n;
        System.out.println(args.length);
        if (args.length == 3) {
            n = new NoeudArbre(args[0], args[1], args[2]);
        } else {
            n = new NoeudArbre("Est-ce un mammifère ?");
            n.droite = new NoeudArbre("chien");
            n.gauche = new NoeudArbre("poisson");
        }
        do {
            n.rechercherAnimal();
            System.out.println("Voulez vous continuer ?");
        } while (!keyboard.nextLine().equals("non"));
        System.out.println(n.toString());
    }

}
