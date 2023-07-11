package CollectionHandsOn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentCollectionsPractice {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> cwal = new CopyOnWriteArrayList<String>();
        cwal.add("A");
        cwal.add("B");
        cwal.add("C");
        Iterator<String> itr2 = cwal.iterator();
        cwal.add("D");
        while (itr2.hasNext()) {
            String s = itr2.next();
//            Every Update Operation will be performed on Separate Copy
//            Hence After getting iterator if we are trying to Perform any Modification to the List
//            it won’t be reflected to the iterator.
            System.out.println(s);
        }
        // A
        // B
        // C
        System.out.println();
        // CopyOnWriteArraySet
        CopyOnWriteArraySet<String> cwas = new CopyOnWriteArraySet<String>();
        cwas.add("A");
        cwas.add("B");
        cwas.add("C");
        Iterator<String> itr3 = cwas.iterator();
        cwas.add("D");
        while (itr3.hasNext()) {
            String s = itr3.next();
            System.out.println(s);
        }
        // A
        // B
        // C
        System.out.println();
        // Different from ConcurrentHashMap
        HashMap<Number, String> m = new HashMap<>();
        m.put(101, "A");
        m.put(102, "B");
        m.put(103, "C");
        Iterator itr4 = m.keySet().iterator();
        m.put(104, "D");
        while (itr4.hasNext()) { // Fail safe Iterator - ConcurrentModificationException
            Integer I1 = (Integer) itr4.next();
            System.out.println(I1+" : "+m.get(I1));
        }
        // 101 : A
        // 102 : B
        // 103 : C
        // 104 : D
    }
}
