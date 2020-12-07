package employesAvecHeritage;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un commmercial dans l'entreprise
 */
public class Commercial extends EmployeQuelconque {

    /**
     * Liste de tous les autres commerciaux instanciés pour permettre notamment d'accéder à tout
     * leur chiffre d'affaire
     */
    protected static List<Commercial> commerciaux = new ArrayList<>();

    /**
     * Constructeur public permettant de créer un commercial par son nom
     *
     * @param nom le nom du commercial
     */
    public Commercial(String nom) {
        super(1200, 0.01, nom);
        if (this != Directeur.getDirecteur()) commerciaux.add(this);
    }

    /**
     * Constructeur restreint permettant de crer un commercial spécifique (notamment un directeur)
     *
     * @param nom  le nom du commercial
     * @param base le salaire de base du commercial
     * @param taux le pourcentage percu du chiffer d'affaire généré
     */
    protected Commercial(String nom, double base, double taux) {
        super(base, taux, nom);
        if (this != Directeur.getDirecteur()) commerciaux.add(this);
    }

    /**
     * Permet d'obtenir le chiffre d'affaire total des commerciaux
     *
     * @return le chiffre d'affaire des commerciaux
     */
    protected static double getTotal() {
        return commerciaux.stream().mapToDouble(commercial -> commercial.effectue).sum();
    }

    @Override
    public double salaireHebdo() {
        return base + taux * effectue;
    }
}
