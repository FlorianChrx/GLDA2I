package employesAvecHeritage;

/**
 * Représente un employé mieux payé
 */
public class EmployeMieuxPaye extends EmployeAvecHSup {

    /**
     * Constructeur de l'employé mieux payé
     * @param nom le nom de l'employé
     */
    public EmployeMieuxPaye(String nom) {
        super(35, 7.5, nom, 1.4);
    }
}
