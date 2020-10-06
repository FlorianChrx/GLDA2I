package tp5;

import java.util.*;

public class Main {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        tri();
    }

    public static void unMotSurDeux(){
        String str = keyboard.nextLine();
        StringTokenizer st = new StringTokenizer(str);
        int i = 0;
        while (st.hasMoreTokens()) {
            String render = i % 2 == 0 ? st.nextToken(): st.nextToken().toUpperCase();
            System.out.print(render + " ");
            i++;
        }
    }

    public static void tri(){
        String str = keyboard.nextLine();
        StringTokenizer st = new StringTokenizer(str);
        ArrayList<String> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        Collections.sort(list);
        list.forEach(word -> System.out.print(word + " "));
    }



}
