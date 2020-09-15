/**
* Classe principale
*/
public class Main {

    /**
    * Méthode principale
    */
    public static void main(String [] arg){
        if(arg.length > 0) Date.setLangue(arg[0]);
        Clavier clavier = new Clavier();
        Date date = new Date(clavier.readInt(), clavier.readInt(), clavier.readInt());
        System.out.println(date.toString());
        /*
        ObjetNumerote a = new ObjetNumerote();
        ObjetNumerote b = new ObjetNumerote();
        System.out.println(a.getNum());
        System.out.println(b.getNum());
        */
        /*
        int i ;
        System.out.println("Il y a "+InstanceMemo.nombreInstances()+
                           " instances de la classe InstanceMemo") ;
        for (i=1; i<=4; i++) new InstanceMemo() ;
        System.out.println("Il y a "+InstanceMemo.nombreInstances()+
                           " instances de la classe InstanceMemo : ") ;
        InstanceMemo.afficherInstances() ;
        for (i=1; i<=10; i++) new InstanceMemo() ;
        System.out.println("Il y a "+InstanceMemo.nombreInstances()+
                           " instances de la classe InstanceMemo : ") ;
        InstanceMemo.afficherInstances() ;
        */
    }
}