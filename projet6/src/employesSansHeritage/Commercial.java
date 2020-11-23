package employesSansHeritage;

public class Commercial {
     private final double temps_travail;
        private final double taux_horaire;
        private final String nom;
        private double heures;

        public Commercial(String nom) {
            temps_travail = 1000;
            taux_horaire = 0.01;
            this.nom = nom;
        }

        public void setTravail(double heures) {
            this.heures = heures;
        }

        public double salaireHebdo() {
            return temps_travail + taux_horaire * heures;
        }

        public String toString() {
            return nom;
        }
}
