package CollectionHandsOn.List;

import java.util.Vector;
public class VectorPractice {
    public static void main(String[] args) {
        Vector<String> vect = new Vector<>();
        vect.add("A");
        // 1. Duplicates allowed
        vect.add("A");
        // 2. Null insertion allowed
        vect.add(null);
        vect.add("B");
        // 2.1. Null insertion allowed any times
        vect.add(null);
        // 3. Insertion Order Preserved
        System.out.println(vect); ///[A, A, null, B, null]
        vect.remove(2);
        System.out.println(vect); ///[A, A, B, null]
        // 4. Shift and add
        vect.add(2, "M");
        System.out.println(vect); ///[[A, A, M, B, null]
        // 5. Replace and add
        vect.set(2, "Z");
        System.out.println(vect); ///[A, A, Z, B, null, N]
        // 6. Get Index of element
        System.out.println(vect.indexOf("Z")); ///2
        // 7. Get sublist [0,3)
        System.out.println(vect.subList(0, 3)); ///[A,A,Z]
        // 8. Get element from Index
        System.out.println(vect.get(2)); ///Z
        // 9. Get size of list
        System.out.println(vect.size()); ///5
        // 10. Clear List
        vect.clear();
        System.out.println(vect); ///[]
        // 11. Vector Specific Methods
        vect.addElement("A1");
        vect.addElement("B1");
        System.out.println(vect); ///[A1,B1]
        vect.removeElement("A1");
        System.out.println(vect);///[B1]
        vect.removeAllElements();
        System.out.println(vect); ///[]
        vect.addElement("A2");
        System.out.println(vect.capacity()); ///10
        vect.addElement("B2");
        System.out.println(vect.firstElement()); ///A2
        System.out.println(vect.lastElement()); ///B2
        //System.out.println(vect.elementAt(2)); /// Exception
        System.out.println(vect.elementAt(1)); ///B2
        vect.addElement("A2");
        vect.addElement("A2");
        vect.addElement("A2");
        vect.addElement("A2");
        vect.addElement("A2");
        vect.addElement("A2");
        vect.addElement("A2");
        vect.addElement("A2");
        vect.addElement("A2");
        vect.addElement("A2");
        vect.addElement("A2");
        vect.addElement("A2");
        vect.addElement("A2");
        System.out.println(vect.capacity()); ///20 initialCapacity*2
        // 12. Make vector with some capacity
        Vector<String> v = new Vector<>(2);
        v.addElement("A3");
        v.addElement("B3");
        System.out.println(v); ///[A3,B3]
        System.out.println(v.capacity()); ///2
        v.addElement("C3");
        System.out.println(v); ///A3,B3,C3]
        System.out.println(v.capacity()); ///4 initialCapacity*2
    }
}
