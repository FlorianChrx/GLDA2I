import java.util.List;

public class Chaines {
    public static void main(String[] args) {
        List<String> l = List.of("Rabattu","Barrage","Canard","Dromadaire");
        //l.stream().forEach(System.out::println);
        //l.stream().filter(str -> !str.equals("")).forEach(System.out::println);
        //System.out.println(l.stream().filter(str -> str.length() >= 5).findFirst().orElse(""));
        //l.stream().filter(str -> str.length() > 2).map(str -> str.substring(0,1).toUpperCase().concat("...").concat(str.substring(str.length()-1, str.length()))).forEach(System.out::println);
        //l.stream().sorted((first, second) -> first.length() - second.length()).forEach(System.out::println);
        l.stream().sorted().forEach(System.out::println);
    }
}
