/**
 * Classe représentant un nombre rationnel (fraction de 2 entiers)
 */
public class Rationnel {

    /**
     * Représente la partie entière du rationnel
     */
    private int entier;

    /**
     * Numérateur de la partie décimale
     */
    private int numerateur;

    /**
     * Dénominateur de la partie décimale
     */
    private int denominateur;

    /**
     * Constructeur complet d'un rationnel
     *
     * @param n la partie entière du rationnel
     * @param a le numérateur de la partie décimale
     * @param b le dénominateur de la partie décimale
     */
    public Rationnel(int n, int a, int b) {
        entier = n;
        numerateur = a;
        denominateur = b;
        simplification();
    }

    /**
     * Constructeur d'un rationnel < 1 (sans partie entière)
     *
     * @param a le numérateur de la partie décimale
     * @param b le dénominateur de la partie décimale
     */
    public Rationnel(int a, int b) {
        numerateur = a;
        denominateur = b;
    }

    /**
     * Constructeur d'un entier
     *
     * @param n L'entier
     */
    public Rationnel(int n) {
        entier = n;
        denominateur = 1;
    }

    public boolean estNul() {
        return entier + denominateur == 0;
    }

    public Rationnel inverse() {
        Rationnel result = new Rationnel(entier, numerateur, denominateur);
        result.setNumerateur(result.getEntier() * result.getDenominateur() + result.getNumerateur());
        int temp = result.getNumerateur();
        result.setNumerateur(result.getDenominateur());
        result.setDenominateur(temp);
        result.setEntier(0);
        return result;
    }

    private void simplification() {
        entier += numerateur / denominateur;
        numerateur = numerateur % denominateur;
        int pgcd = pgcd(numerateur, denominateur);
        if (pgcd != 1) {
            numerateur = numerateur / pgcd;
            denominateur = denominateur / pgcd;
            if (denominateur == 0) denominateur = 1;
        }
        if (denominateur < 0) {
            entier--;
            denominateur *= -1;
        }
    }

    public int pgcd(int a, int b) {
        int r = 0;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public Rationnel ajouter(Rationnel r) {
        Rationnel result = new Rationnel(entier, numerateur, denominateur);
        result.setEntier(entier + r.getEntier());
        result.setDenominateur(denominateur * r.getDenominateur());
        result.setNumerateur(numerateur * r.getDenominateur() + r.getNumerateur() * denominateur);
        return result;
    }

    public Rationnel multiplier(Rationnel r) {
        Rationnel result = new Rationnel(0);
        result.setNumerateur(((entier * denominateur) + numerateur) * ((r.getEntier() * r.getDenominateur()) + r.getNumerateur()));
        result.setDenominateur(denominateur * r.getDenominateur());
        return result;
    }

    public int comparer(Rationnel other){
        if(entier == other.getEntier()) return entier - other.getEntier();
        int numerateur = numerateur * r.getDenominateur() - r.getNumerateur() * denominateur;
        return 0;
    }

    @Override
    public String toString() {
        simplification();
        String result = "";
        if (estNul()) return "0";
        if (entier != 0) {
            result += entier;
            if (numerateur != 0) result += " + ";
        }
        if (numerateur != 0) result += numerateur + "/" + denominateur;
        return result;
    }

    public int getEntier() {
        return entier;
    }

    public void setEntier(int entier) {
        this.entier = entier;
    }

    public int getNumerateur() {
        return numerateur;
    }

    public void setNumerateur(int numerateur) {
        this.numerateur = numerateur;
    }

    public int getDenominateur() {
        return denominateur;
    }

    public void setDenominateur(int denominateur) {
        this.denominateur = denominateur;
    }
}
