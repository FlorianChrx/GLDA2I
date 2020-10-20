package calculatrice2;

import calculatrice.CalculatriceException;

import java.util.HashMap;
import java.util.Stack;

public class Calculatrice {
    /**
     * Représente la pile de calcul
     */
    private final Stack<Double> resultat;
    /**
     * Permet d'associer à un symbole l'opération liée
     */
    private final HashMap<String, Operation> OPERATIONS;

    /**
     * Constructeur de la calculatrice
     */
    public Calculatrice() {
        resultat = new Stack<>();
        OPERATIONS = new HashMap<>();
        for (Operation o : Operation.values()) {
            OPERATIONS.put(o.toString(), o);
        }
    }

    /**
     * Verifie qu'une chaîne de caractère est un nombre
     * @param str la chaine à vérifier
     * @return si cette chaine est un nombre (vrai) ou non (faux)
     */
    private boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    /**
     * Permet de calculer le résultat d'une expression
     * @param str l'expression sous forme de chaine de caractère
     * @return le resultat du calcul de l'expression
     * @throws CalculatriceException si un erreur s'est produite
     */
    public String calculer(String str) throws CalculatriceException {
        String[] tokens = str.split(" ");
        for (String token : tokens) {
            if (isNumeric(token)) {
                resultat.push(Double.parseDouble(token));
            } else {
                if (!OPERATIONS.containsKey(token)) throw new CalculatriceException();
                Operation o = OPERATIONS.get(token);
                double[] values = new double[o.getOPERANDES()];
                for (int i = o.getOPERANDES() - 1; i >= 0; i--) {
                    values[i] = resultat.pop();
                }
                resultat.push(o.eval(values));
            }
        }
        return resultat.pop() + "";
    }
}
