package employesAvecHeritage;

import java.util.ArrayList;
import java.util.List;

public class Commercial extends EmployeQuelconque {

    protected static List<Commercial> commerciaux = new ArrayList<>();

    public Commercial(String nom) {
        super(1200, 0.01, nom);
        if(this != Directeur.getDirecteur()) commerciaux.add(this);
    }

    protected Commercial(String nom, double base, double taux){
        super(base, taux, nom);
        if(this != Directeur.getDirecteur()) commerciaux.add(this);
    }

    @Override
    public double salaireHebdo() {
        return base + taux * effectue;
    }

    protected static double getTotal(){
        return commerciaux.stream().mapToDouble(commercial -> commercial.effectue).sum();
    }
}
