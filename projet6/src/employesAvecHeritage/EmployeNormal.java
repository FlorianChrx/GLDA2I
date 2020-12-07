package employesAvecHeritage;

/**
 * Représente un employé normal
 */
public class EmployeNormal extends EmployeAvecHSup {

    /**
     * Constructeur d'un employé normal
     *
     * @param nom le nom de l'employé
     */
    public EmployeNormal(String nom) {
        super(35, 7.5, nom, 1.25);
    }
}
