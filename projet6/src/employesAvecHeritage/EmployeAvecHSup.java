package employesAvecHeritage;

public class EmployeAvecHSup extends EmployeQuelconque {
    private final double majoration;

    protected EmployeAvecHSup(double base, double taux, String nom, double majoration) {
        super(base, taux, nom);
        this.majoration = majoration;
    }

    public double salaireHebdo() {
        return effectue > base ?
                base * taux + (effectue - base) * taux * majoration
                : effectue * taux;
    }
}
