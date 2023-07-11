package CollectionHandsOn.Set;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetPractice {
    public static void main(String[] args) {
    TreeSet<String> tset = new TreeSet<>();
    SortedSet<String> stset = new TreeSet<>();
    tset.add("A");
    // 1. Duplicates NOT allowed
    tset.add("A"); /// No Error on inserting duplicate
    System.out.println(tset.add("A")); ///false
    System.out.println(tset); ///[A]
    // 2. Null insertion NOT allowed
//    tset.add(null); // Null Pointer Exception
    tset.add("B");
    // 3. Insertion Order NOT Preserved
    tset.add("2");
    System.out.println(tset); ///[2,A, B]
//    tset.remove(2); // Class Cast Exception - Doubt
    tset.remove("A");
    System.out.println(tset); ///[2,B]
    // 4. Shift and add
//    tset.add(2,"M"); // No Index Support - Error
    tset.add("M");
    System.out.println(tset); ///[2,B,M]
    // 5. Replace and add
    //tset.set(2,"Z"); // No Index Support - Error
    //tset.set("Z"); // Cannot Find Symbol - Error
    // 6. Get size of list
    System.out.println(tset.size()); ///3
    // 7. Clear List
        tset.clear();
    System.out.println(tset); ///[]
    // 8. SortedSet Methods
        tset.add("A1");
        tset.add("B1");
        tset.add("C1");
        SortedSet<String> sset = new TreeSet<>();
        sset.add("A1");
        sset.add("B1");
        sset.add("C1");
        NavigableSet<String> nset = new TreeSet<>();
        nset.add("A1");
        nset.add("B1");
        nset.add("C1");
        TreeSet<String> t = new TreeSet<>();
        System.out.println(sset.first()); /// A1
        System.out.println(nset.first()); // A1
        System.out.println(tset.first()); /// A1
        System.out.println("------");
        System.out.println(tset.last()); ///C1
        System.out.println(tset.headSet("B1")); ///[A1] // <B1
        System.out.println(tset.tailSet("B1")); ///[B1,C1] //>=B1
        System.out.println(tset.subSet("A1","B1")); //[A1] //[A1,B1)
        System.out.println("------");
        // 9. NavigableSet Methods
//        System.out.println(sset.ceiling("B1")); /// Parent SortedSet is unaware of NavigableSet and its methods
        System.out.println(nset.ceiling("B1")); // B1 //>=
        System.out.println(tset.higher("B1")); /// C1 //>
        System.out.println(tset.floor("B1")); /// B1 //<=
        System.out.println(tset.lower("B1")); /// A1 //<

        System.out.println(tset.lower("D1")); /// C1 //<
        System.out.println(tset.higher("D1")); /// null //> since greter than  it are not present

        System.out.println(tset);
        System.out.println(tset.pollFirst()); /// A1
        System.out.println(tset.pollLast()); /// C1
    }
}
