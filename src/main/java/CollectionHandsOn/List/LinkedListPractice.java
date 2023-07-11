package CollectionHandsOn.List;

import java.util.LinkedList;

public class LinkedListPractice {
    public static void main(String[] args) {
        LinkedList<String> llst = new LinkedList<>();
        llst.add("A");
        // 1. Duplicates allowed
        llst.add("A");
        // 2. Null insertion allowed
        llst.add(null);
        llst.add("B");
        // 2.1. Null insertion allowed any times
        llst.add(null);
        // 3. Insertion Order Preserved
        System.out.println(llst); ///[A, A, null, B, null]
        llst.remove(2);
        System.out.println(llst); ///[A, A, B, null]
        // 4. Shift and add
        llst.add(2,"M");
        System.out.println(llst); ///[[A, A, M, B, null]
        // 5. Replace and add
        llst.set(2,"Z");
        System.out.println(llst); ///[A, A, Z, B, null, N]
        // 6. Get Index of element
        System.out.println(llst.indexOf("Z")); ///2
        // 7. Get sublist [0,3)
        System.out.println(llst.subList(0,3)); ///[A,A,Z]
        // 8. Get element from Index
        System.out.println(llst.get(2)); ///Z
        // 9. Get size of list
        System.out.println(llst.size()); ///5
        // 10. Clear List
        llst.clear();
        System.out.println(llst); ///[]
        // 11. LinkedList Special Methods
        llst.addFirst("A1");
        llst.addLast("Z1");
        System.out.println(llst); ///[A1, Z1]
        System.out.println(llst.getFirst());///A1
        System.out.println(llst.getLast()); ///Z1
        llst.removeFirst();
        System.out.println(llst); ///[Z1]
        llst.removeLast();
        System.out.println(llst); ///[]
        // 12. Queue Interface specific methods
        llst.offer("A1");
        llst.offerFirst("X1");
        llst.offerLast("Z1");
        System.out.println(llst); ///[X1, A1, Z1]
        System.out.println(llst.peek()); ///X1
        System.out.println(llst.pop()); ///X1
        System.out.println(llst); ///[A1,Z1]
        System.out.println(llst.poll()); ///A1
    }
}
