package employesSansHeritage;

public class EmployeNormal {
    private final double temps_travail;
    private final double taux_horaire;
    private final double majoration;
    private final String nom;
    private double heures;

    public EmployeNormal(String nom) {
        temps_travail = 35;
        taux_horaire = 7.5;
        majoration = 1.25;
        this.nom = nom;
    }

    public void setTravail(double heures) {
        this.heures = heures;
    }

    public double salaireHebdo() {
        return heures > temps_travail ?
                temps_travail * taux_horaire + (heures - temps_travail) * taux_horaire * majoration
                : heures * taux_horaire;
    }

    public String toString() {
        return nom;
    }
}