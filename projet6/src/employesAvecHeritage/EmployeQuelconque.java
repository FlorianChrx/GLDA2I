package employesAvecHeritage;

public abstract class EmployeQuelconque {
    protected final double base;
    protected final double taux;
    protected double effectue ;
    protected final String nom ;

    protected EmployeQuelconque(double base, double taux, String nom) {
        this.base = base;
        this.taux = taux;
        this.nom = nom;
    }

    public void setTravail(double effectue) {
        this.effectue = effectue;
    }

    public String toString() {
        return nom;
    }

    public abstract double salaireHebdo();
}
