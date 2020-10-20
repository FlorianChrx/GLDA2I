import calculatrice.* ;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

    public static void main(String [] args) throws CalculatriceException {
        if (args.length < 3)
            System.err.println("Au moins deux nombres et une opérande sur la ligne de commande !") ;
        else {
            double x = Double.parseDouble(args[0]);
            double y = Double.parseDouble(args[1]);
            Operation o = Operation.getOperation(args[2]);
            System.out.println(x + " " + o + " " + y + " = "+ o.eval(x,y)) ;
        }
    }
}
