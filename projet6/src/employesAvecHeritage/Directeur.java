package employesAvecHeritage;

public class Directeur extends Commercial {

    private static Directeur instance;

    private Directeur(String nom) {
        super(nom, 3000, 0.4);
    }

    public static Directeur createDirecteur(String nom){
        instance = new Directeur(nom);
        return getDirecteur();
    }

    public static Directeur getDirecteur() {
        return instance;
    }
}
