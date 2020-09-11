/**
* Classe représentant une date
*/
public class Date
{
    // les attributs des instances
    private int jour, mois, annee ;
    // les attributs de la classe
    public static String[][] NOM_DES_MOIS =
    {{ "français", "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet",
      "Aout", "Septembre", "Octobre", "Novembre", "Decembre" }, { "anglais", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }, { "espanol", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }};
    public static String langue;
    private static int idxMonth;

    public Date(int jour, int mois, int annee)
    {
        this.jour = jour ;
        this.mois = mois ;
        this.annee = annee ;
    }

    public static void setLangue(String langue) {
        for(int i = 0; i < NOM_DES_MOIS.length; i++){
            if(NOM_DES_MOIS[i][0].equals(langue)){
                idxMonth = i;
            }
        }
    }

    public String toString()
    {
        return jour + " " + NOM_DES_MOIS[idxMonth][mois] + " " + annee ;
    }
}