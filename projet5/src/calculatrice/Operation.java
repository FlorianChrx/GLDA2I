package calculatrice;

/**
 * Classe repésentant un opération de calcul
 */
public enum Operation {
    PLUS("+"){
        @Override
        public double eval(double x, double y) {
            return x+y;
        }
    }, MOINS("-") {
        @Override
        public double eval(double x, double y) {
            return x-y;
        }
    }, FOIS("*") {
        @Override
        public double eval(double x, double y) {
            return x*y;
        }
    }, DIV("/") {
        @Override
        public double eval(double x, double y) {
            return x/y;
        }
    } , PUISS("^") {
        @Override
        public double eval(double x, double y) {
            return Math.pow(x, y);
        }
    };

    /**
     * Représentation textuelle de l'opération
     */
    private final String OPERATION;

    /**
     * Contructeur d'un opération
     * @param operation le symbole de l'opération
     */
    Operation(String operation) {
        OPERATION = operation;
    }

    @Override
    public String toString() {
        return OPERATION;
    }

    /**
     * Permet d'obtenir une opération à partir de son symbole
     * @param symbole le symbole de l'opération recherchée
     * @return l'opération correspondant au symbole donné
     * @throws CalculatriceException si le symbole n'est pas valable
     */
    public static Operation getOperation(String symbole) throws CalculatriceException {
        for (Operation o: Operation.values()){
            if (o.OPERATION.equals(symbole)) return o;
        }
        throw new CalculatriceException();
    }

    /**
     * Permet d'effectuer une opération sur 2 nombres
     * @param x le nombre à gauche de l'opération
     * @param y le nombre à droite de l'opération
     * @return le résultat de l'opération
     */
    public abstract double eval(double x, double y);
}
