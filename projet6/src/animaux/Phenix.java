package animaux;

public class Phenix extends Animal {
    private static Phenix le_seul_phenix;

    private Phenix(String nom) {
        super(nom);
    }

    public Phenix() {
        super("Le Phenix");
    }

    public static Phenix uniqueInstance() {
        if (le_seul_phenix == null)
            le_seul_phenix = new Phenix();
        return le_seul_phenix;
    }

    public String toString() {
        return super.toString() + " Je suis le SEUL phenix.";
    }
}