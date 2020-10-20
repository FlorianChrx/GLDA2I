import calculatrice.* ;

public class Calculer {
    public static void main(String [] args) {
        Calculatrice c = new Calculatrice() ;
        for (String arg : args) System.out.println(arg + " = " + c.calculer(arg));
    }
}
