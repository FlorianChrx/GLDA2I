import java.util.LinkedList;
import java.util.List;

/**
 * Classe permettant d'effectuer le crible de'Eratostene
 */
public class Crible {
    /**
     * Renvoie la liste des nombre premiers compris entre 2 et n
     * @param n la borne maximale des nombres à tester
     * @return
     */
    public static List<Integer> getPremiers(int n){
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 2; i <= n; i++){
            boolean found = false;
            for(int j: list){
                if (i % j == 0){
                    found = true;
                    break;
                }
            }
            if(!found) {
                list.add(i);
            }
        }
        return list;
    }
}
