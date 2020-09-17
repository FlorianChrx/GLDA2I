public class Main {
    public static void main(String[] args) {
        Pile pile = new PileTableau<Integer>("wallah");
        pile.empile(1);
        pile.empile(2);
        pile.empile(3);
        Pile pile1 = new PileTableau<Integer>("pouloulou");
        pile.deplacerUnElementVers(pile1);
        System.out.println(pile.toString());
        System.out.println(pile1.toString());
    }
}