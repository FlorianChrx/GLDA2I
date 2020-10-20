package calculatrice;

import java.util.HashMap;
import java.util.Stack;

public class Calculatrice {
    private Stack<Double> resultat;
    private HashMap<String, Operation> operations;

    public Calculatrice() {
        resultat = new Stack<>();
        operations = new HashMap<>();
        for (Operation o : Operation.values()) {
            operations.put(o.toString(), o);
        }
    }

    private boolean isNumeric(String str) {
        return str.chars().allMatch( Character::isDigit );
    }

    public String calculer(String str) {
        String[] tokens = str.split(" ");
        for (String token : tokens) {
            if (isNumeric(token)) {
                resultat.push(Double.parseDouble(token));
            } else {
                Double b = resultat.pop();
                Double a = resultat.pop();
                resultat.push(operations.get(token).eval(a, b));
            }
        }
        return resultat.pop() + "";
    }
}
