package employesSansHeritage;

public class Main {
    public static void main(String[] args) {
        EmployeNormal e = new EmployeNormal("Tom");
        e.setTravail(10);
        System.out.println(e.salaireHebdo());
    }
}
