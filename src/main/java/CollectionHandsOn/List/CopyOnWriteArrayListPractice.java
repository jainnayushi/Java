package CollectionHandsOn.List;
// It is a Thread Safe Version of ArrayList as the Name indicates CopyOnWriteArrayList
// Creates a Cloned Copy of Underlying ArrayList for Every Update Operation at Certain
// Point Both will Synchronized Automatically Which is taken Care by JVM Internally.
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArrayListPractice {
    public static void main(String[] args){
        ArrayList<String> lst = new ArrayList<>();
        lst.add("A");
        lst.add("B");
        lst.add("C");
        Iterator<String> itr = lst.iterator();
//        lst.add("D"); // -> Problem
        while (itr.hasNext()) {
            String s = itr.next();
            System.out.println(s); // ConcurrentModificationException
        }
        System.out.println();
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

    }
}
