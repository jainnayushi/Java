package CollectionHandsOn.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.*;

public class ArrayListPractice {
    public static void main(String[] args) {
        ArrayList<String> lst = new ArrayList<>();
        lst.add("A");
        // 1. Duplicates allowed
        lst.add("A");
        // 2. Null insertion allowed
        lst.add(null);
        lst.add("B");
        // 2.1. Null insertion allowed any times
        lst.add(null);
        // 3. Insertion Order Preserved
        System.out.println(lst); ///[A, A, null, B, null]
        lst.remove(2);
        System.out.println(lst); ///[A, A, B, null]
        // 4. Shift and add
        lst.add(2,"M");
        System.out.println(lst); ///[[A, A, M, B, null]
        // 5. Replace and add
        lst.set(2,"Z");
        System.out.println(lst); ///[A, A, Z, B, null, N]
        // 6. Get Index of element
        System.out.println(lst.indexOf("Z")); ///2
        // 7. Get sublist [0,3)
        System.out.println(lst.subList(0,3)); ///[A,A,Z]
        // 8. Get element from Index
        System.out.println(lst.get(2)); ///Z
        // 9. Get size of list
        System.out.println(lst.size()); ///5
        // 10. Clear List
        lst.clear();
        System.out.println(lst); ///[]

        // ConcurrentModificationException
//        ArrayList<String> l = new ArrayList<>();
//        l.add("A");
//        l.add("B");
//        l.add("C");
//        Iterator<String> itr = l.iterator();
//        l.add("D");
//        while (itr.hasNext()) {
//            String s = itr.next();
//            System.out.println(s); // ConcurrentModificationException - Read and Update can't happen concurrently
//        }

//        int arr[]={33,3,4,5};
//        List lit = Arrays.asList(arr);
//        System.out.println(lit);
//        for(int x: arr){
//            System.out.println(x);
//        }
    }
}
