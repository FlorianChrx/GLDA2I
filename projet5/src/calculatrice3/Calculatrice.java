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
