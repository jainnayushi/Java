package CollectionHandsOn.Set;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.Iterator;

public class CopyOnWriteArraySetPractice {
    public static void main(String[] args){
        ArrayList<String> lst = new ArrayList<>();
        lst.add("A");
        lst.add("B");
        lst.add("C");
        Iterator<String> itr = lst.iterator();
        lst.add("D"); // -> Problem
        while (itr.hasNext()) {
            String s = itr.next();
            System.out.println(s); // ConcurrentModificationException
        }

        CopyOnWriteArraySet<String> cwas = new CopyOnWriteArraySet<String>();
        cwas.add("A");
        cwas.add("B");
        cwas.add("C");
        Iterator<String> itr2 = cwas.iterator();
        cwas.add("D");
        while (itr2.hasNext()) {
            String s = itr2.next();
            System.out.println(s); /// A B C
        }
    }
}
