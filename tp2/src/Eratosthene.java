public class Eratosthene {
    /**
     * Principe : on crée un générateur de nombres de 2 à N,
     * puis on le fait travailler.
     */
    public static void main (String [] argv) {
        Generateur g = new Generateur(10000) ;
        g.travailler() ;
        System.out.println(g.toString()) ;
    }
}