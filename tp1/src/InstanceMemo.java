import java.util.LinkedList;

class InstanceMemo {
    private static LinkedList<InstanceMemo> list = new LinkedList<InstanceMemo>();
    private ObjetNumerote obj;

    public ObjetNumerote getObj(){
        return obj;
    }

    public InstanceMemo() {
        obj = new ObjetNumerote();
        list.add(this);
        if(list.size() > 10) list.pop();
    }

    public static int nombreInstances(){
        try {
            return list.getLast().obj.incrementor-1;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void afficherInstances(){
        for(InstanceMemo instance : list){
            System.out.println("Je suis l’instance numéro " + instance.obj.getNum());
        }  
    }

}