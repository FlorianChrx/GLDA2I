package employesAvecHeritage;

/**
 * Représente un employe avec salaire basé sur le nombre d'heures effectuées
 */
public class EmployeAvecHSup extends EmployeQuelconque {
    /**
     * Le taux de majoration des heures supplémentaires
     */
    private final double majoration;

    /**
     * Permet de construire un employé avec toutes ses caractéristiques
     * @param base représente ici le nombre d'heures de base hebdomadaire
     * @param taux représente ici le taux horaire de rémunération
     * @param nom représente le nom de l'employé
     * @param majoration représente le taux de majoration des heures supplémentaires
     */
    protected EmployeAvecHSup(double base, double taux, String nom, double majoration) {
        super(base, taux, nom);
        this.majoration = majoration;
    }

    /**
     * Permet le calcul de la rémunération hebdomadaire
     * @return le salaire obtenu pour la semaine
     */
    public double salaireHebdo() {
        return effectue > base ?
                base * taux + (effectue - base) * taux * majoration
                : effectue * taux;
    }
}
