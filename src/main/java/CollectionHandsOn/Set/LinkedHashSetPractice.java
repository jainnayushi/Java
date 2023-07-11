package CollectionHandsOn.Set;

import java.util.LinkedHashSet;

public class LinkedHashSetPractice {
    public static void main(String[] args){
        LinkedHashSet<String> lhset = new LinkedHashSet<>();
        lhset.add("A");
        // 1. Duplicates NOT allowed
        lhset.add("A"); /// No Error on inserting duplicate
        System.out.println(lhset.add("A")); ///false
        System.out.println(lhset); ///[A]
        // 2. Null insertion allowed
        lhset.add(null);
        lhset.add("B");
        // 2.1. Null insertion allowed any times but later got ignored
        lhset.add(null);
        // 3. """Insertion Order Preserved""" unlike HashSet
        lhset.add("2");
        System.out.println(lhset); ///[A,null, B, 2]
        lhset.remove(2); // No Index Support - NO error but no outcome - Doubt
        lhset.remove("A");
        System.out.println(lhset); ///[null, B, 2]
        // 4. Shift and add
        //lhset.add(2,"M"); // No Index Support - Error
        lhset.add("M");
        System.out.println(lhset); ///[[null,B,2,M]
        // 5. Replace and add
        //lhset.set(2,"Z"); // No Index Support - Error
        //lhset.set("Z"); // Cannot Find Symbol - Error
        // 6. Get size of list
        System.out.println(lhset.size()); ///4
        // 7. Clear List
        lhset.clear();
        System.out.println(lhset); ///[]
    }
}
