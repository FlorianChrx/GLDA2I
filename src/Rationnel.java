/**
 * Classe représentant un nombre rationnel (fraction de 2 entiers)
 */
public class Rationnel implements Comparable<Rationnel> {

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

    /**
     * Permet de tester si le rationnel est nul (=0)
     * @return un booleen représentant si le rationnel est nul
     */
    public boolean estNul() {
        return entier + denominateur == 0;
    }

    /**
     * Permet de construire un Raationnel qui est l'inverse de l'instance courante
     * @return Le rationnel inverse créé
     */
    public Rationnel inverse() {
        Rationnel result = new Rationnel(entier, numerateur, denominateur);
        result.setNumerateur(result.getEntier() * result.getDenominateur() + result.getNumerateur());
        int temp = result.getNumerateur();
        result.setNumerateur(result.getDenominateur());
        result.setDenominateur(temp);
        result.setEntier(0);
        return result;
    }

    /**
     * Permet de simplifier le rationner en mettant la partie décimale en une fraction irréductible positive
     */
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

    /**
     * Permet de calculer le pgcd de deux nombres
     * @param a un entier quelconque
     * @param b un entier quelconque
     * @return le pgcd de a et de b
     */
    public int pgcd(int a, int b) {
        int r = 0;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    /**
     * Permet d'ajouter deux rationnels
     * @param r l'autre rationnel à ajouter
     * @return Le rationnel obtenu
     */
    public Rationnel ajouter(Rationnel r) {
        Rationnel result = new Rationnel(entier, numerateur, denominateur);
        result.setEntier(entier + r.getEntier());
        result.setDenominateur(denominateur * r.getDenominateur());
        result.setNumerateur(numerateur * r.getDenominateur() + r.getNumerateur() * denominateur);
        return result;
    }

    /**
     * Permet de multiplier deux rationnels
     * @param r l'autre rationnel par lequel on multiplie
     * @return Le rationnel obtenu
     */
    public Rationnel multiplier(Rationnel r) {
        Rationnel result = new Rationnel(0);
        result.setNumerateur(((entier * denominateur) + numerateur) * ((r.getEntier() * r.getDenominateur()) + r.getNumerateur()));
        result.setDenominateur(denominateur * r.getDenominateur());
        return result;
    }

    /**
     * Permet de comparer 2 rationnels
     * @param other la rationnel avec lequel on compare
     * @return un nb positif si instance courante supérieure, négatif si inférieure et 0 si égale
     */
    public int comparer(Rationnel other){
        if(entier != other.getEntier()) return entier - other.getEntier();
        int a = numerateur * other.getDenominateur() - other.getNumerateur() * denominateur;
        return a;
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

    @Override
    public int compareTo(Rationnel rationnel) {
        return comparer(rationnel);
    }
}
