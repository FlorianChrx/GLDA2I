import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();
        Rationnel r = new Rationnel(n, a, b);
        System.out.println(r.toString());
        Rationnel inverse = r.inverse();
        System.out.println(inverse.toString());
        System.out.println(r.multiplier(inverse).toString());
        System.out.println(r.multiplier(inverse).ajouter(new Rationnel(2,1,7)).ajouter(new Rationnel(2,1,7)));
    }
}