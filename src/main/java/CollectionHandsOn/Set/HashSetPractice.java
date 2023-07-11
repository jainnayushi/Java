package CollectionHandsOn.Set;

import java.util.HashSet;

public class HashSetPractice {
    public static void main(String[] args){
        HashSet<String> hset = new HashSet<>();
        hset.add("A");
        // 1. Duplicates NOT allowed
        hset.add("A"); /// No Error on inserting duplicate
        System.out.println(hset.add("A")); ///false
        System.out.println(hset); ///[A]
        // 2. Null insertion allowed
        hset.add(null);
        hset.add("B");
        // 2.1. Null insertion allowed any times but later got ignored
        hset.add(null);
        // 3. Insertion Order NOT Preserved
        hset.add("2");
        System.out.println(hset); ///[null, A, B, 2]
        hset.remove(2); // No Index Support - NO error but no outcome - Doubt
        hset.remove("A");
        System.out.println(hset); ///[null, B, 2]
        // 4. Shift and add
        //hset.add(2,"M"); // No Index Support - Error
        hset.add("M");
        System.out.println(hset); ///[[null,B,2,M]
        // 5. Replace and add
        //hset.set(2,"Z"); // No Index Support - Error
        //hset.set("Z"); // Cannot Find Symbol - Error
        // 6. Get size of list
        System.out.println(hset.size()); ///4
        // 7. Clear List
        hset.clear();
        System.out.println(hset); ///[]
    }
}
