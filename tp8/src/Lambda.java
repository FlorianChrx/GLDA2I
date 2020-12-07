import java.util.Arrays;

public class Lambda {
    // Déclaration de la méthode calcul

    public static void main(String[] args) {
        System.out.println("Il y a " + calcul(args, x -> x.equals("coucou")) + " fois la chaîne \"coucou\" en argument");
        System.out.println("Il y a " + calcul(args, x -> x.equals("-")) + " fois la chaîne \"-\" en argument");
    }

    private static int calcul(String[] args, Compare c) {
        return (int) Arrays.stream(args).filter(x  -> c.compare(x)).count();
    }
}