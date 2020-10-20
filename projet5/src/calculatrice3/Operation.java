package calculatrice3;

import calculatrice.CalculatriceException;

import java.util.Stack;

/**
 * Classe repésentant un opération de calcul
 */
public enum Operation {
    PLUS("+") {
        @Override
        public double eval(double[] ops) {
            return ops[0] + ops[1];
        }
    }, MOINS("-") {
        @Override
        public double eval(double[] ops) {
            return ops[0] - ops[1];
        }
    }, FOIS("*") {
        @Override
        public double eval(double[] ops) {
            return ops[0] * ops[1];
        }
    }, DIV("/") {
        @Override
        public double eval(double[] ops) {
            return ops[0] / ops[1];
        }
    }, PUISS("^") {
        @Override
        public double eval(double[] ops) {
            return Math.pow(ops[0], ops[1]);
        }
    }, SQRT("V", 1) {
        @Override
        public double eval(double[] ops) {
            return Math.sqrt(ops[0]);
        }
    }, ABS("ABS", 1) {
        @Override
        public double eval(double[] ops) {
            return Math.abs(ops[1]);
        }
    }, NOT("NOT", 1) {
        @Override
        protected double eval(double[] ops) {
            if (ops[0] == 0) return 1;
            return 0;
        }
    }, IF("IF", 3) {
        @Override
        protected double eval(double[] ops) {
            if (ops[0] == 0){
                return ops[1];
            } else {
                return ops[2];
            }
        }
    }, DROP() {
        @Override
        protected double eval(double[] ops) {
            return 0;
        }

        @Override
        protected void execute(Stack<Double> pile) {
            pile.pop();
        }
    }, DUP() {
        @Override
        protected double eval(double[] ops) {
            return 0;
        }

        @Override
        protected void execute(Stack<Double> pile) {
            pile.push(pile.peek());
        }
    }, SWAP() {
        @Override
        protected double eval(double[] ops) {
            return 0;
        }

        @Override
        protected void execute(Stack<Double> pile) {
            double a = pile.pop();
            double b = pile.pop();
            pile.push(a);
            pile.push(b);
        }
    }, COUNT() {
        @Override
        protected double eval(double[] ops) {
            return 0;
        }

        @Override
        protected void execute(Stack<Double> pile) {
            pile.push((double) pile.size());
        }
    };

    private final String OPERATION;
    private final int OPERANDES;

    /**
     * Contructeur d'un opération
     *
     * @param operation   le symbole de l'opération
     * @param nbOperandes le nombre d'opérandes nécessaire à l'opération
     */
    Operation(String operation, int nbOperandes) {
        OPERATION = operation;
        OPERANDES = nbOperandes;
    }

    /**
     * Contructeur d'un opération par défaut (opération classique à 2 opérandes)
     *
     * @param operation le symbole de l'opération
     */
    Operation(String operation) {
        this(operation, 2);
    }

    /**
     * Constructeur d'une opération de manipulation de pile
     */
    Operation() {
        OPERATION = name();
        OPERANDES = 0;
    }

    @Override
    public String toString() {
        return OPERATION;
    }

    /**
     * Permet d'obtenir une opération à partir de son symbole
     *
     * @param symbole le symbole de l'opération recherchée
     * @return l'opération correspondant au symbole donné
     * @throws CalculatriceException si le symbole n'est pas valable
     */
    public static Operation getOperation(String symbole) throws CalculatriceException {
        for (Operation o : Operation.values()) {
            if (o.OPERATION.equals(symbole)) return o;
        }
        throw new CalculatriceException();
    }

    /**
     * Permet d'effectuer une opération sur 2 nombres
     *
     * @param ops les opérandes
     * @return le résultat de l'opération
     */
    protected abstract double eval(double[] ops);

    /**
     * Comportement par défaut d'une opération sur la pile
     * @param pile la pile à manipuler
     */
    protected void execute(Stack<Double> pile){
        double[] values = new double[getOPERANDES()];
        for (int i = getOPERANDES() - 1; i >= 0; i--) {
            values[i] = pile.pop();
        }
        pile.push(eval(values));
    }

    /**
     * Permet d'accéder au nombre d'opérandes nécesaire à l'opération
     * @return le nombre d'opérandes nécesaire à l'opération
     */
    public int getOPERANDES() {
        return OPERANDES;
    }
}
