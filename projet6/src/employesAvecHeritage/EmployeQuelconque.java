package employesAvecHeritage;

public abstract class EmployeQuelconque {
    /**
     * La base de calcul du salaire d'un employé. Il peut etre d'origine horaire ou numéraire
     */
    protected final double base;
    /**
     * Le taux lié à la remunération. Il peut être le taux horaire ou le pourcentage de commission
     */
    protected final double taux;
    /**
     * Le nom de l'employé
     */
    protected final String nom;
    /**
     * Le travail effectué. Il peut être numéraire ou horaire.
     */
    protected double effectue;

    /**
     * Contrcuteur d'un employé quelconque
     *
     * @param base la base de calcul de la rémunération
     * @param taux le taux lié à la rémunération
     * @param nom  le nom de l'employé
     */
    protected EmployeQuelconque(double base, double taux, String nom) {
        this.base = base;
        this.taux = taux;
        this.nom = nom;
    }

    /**
     * Permet de modifier la mesure de travail effectué
     *
     * @param effectue
     */
    public void setTravail(double effectue) {
        this.effectue = effectue;
    }

    /**
     * Permet de représenter l'employé sous forme de chaîne de caractères
     *
     * @return
     */
    public String toString() {
        return nom;
    }

    public abstract double salaireHebdo();
}
