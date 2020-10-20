package calculatrice3;

import calculatrice.CalculatriceException;

import java.util.HashMap;
import java.util.Stack;

public class Calculatrice {
    private final Stack<Double> resultat;
    private final HashMap<String, Operation> OPERATIONS;

    public Calculatrice() {
        resultat = new Stack<>();
        OPERATIONS = new HashMap<>();
        for (Operation o : Operation.values()) {
            OPERATIONS.put(o.toString(), o);
        }
    }

    private boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public String calculer(String str) throws CalculatriceException {
        String[] tokens = str.split(" ");
        for (String token : tokens) {
            if (isNumeric(token)) {
                resultat.push(Double.parseDouble(token));
            } else {
                if(!OPERATIONS.containsKey(token)) throw new CalculatriceException();
                OPERATIONS.get(token).execute(resultat);
            }
        }
        return resultat.pop() + "";
    }
}
