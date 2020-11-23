package employesAvecHeritage;

/**
 * Représente un directeur dans l'entreprise
 */
public class Directeur extends Commercial {

    /**
     * Instance unique du directeur
     */
    private static Directeur instance;

    /**
     * Contructeur du directeur
     * @param nom le nom du directeur
     */
    private Directeur(String nom) {
        super(nom, 3000, 0.4);
    }

    /**
     * Permet de créer le directeur
     * @param nom le nom du directeur à créer
     * @return le directeur créé
     */
    public static Directeur createDirecteur(String nom){
        instance = new Directeur(nom);
        return getDirecteur();
    }

    /**
     * Permet d'obtenir l'instance du directeur
     * @return le directeur
     */
    public static Directeur getDirecteur() {
        return instance;
    }
}
