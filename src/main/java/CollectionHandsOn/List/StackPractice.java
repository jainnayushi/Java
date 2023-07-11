package CollectionHandsOn.List;

import java.util.Stack;

public class StackPractice {
    public static void main(String[] args) {
        Stack<String> stk = new Stack<>();
        stk.add("A");
        // 1. Duplicates allowed
        stk.add("A");
        // 2. Null insertion allowed
        stk.add(null);
        stk.add("B");
        // 2.1. Null insertion allowed any times
        stk.add(null);
        // 3. Insertion Order Preserved
        System.out.println(stk); ///[A, A, null, B, null]
        stk.remove(2);
        System.out.println(stk); ///[A, A, B, null]
        // 4. Shift and add
        stk.add(2, "M");
        System.out.println(stk); ///[[A, A, M, B, null]
        // 5. Replace and add
        stk.set(2, "Z");
        System.out.println(stk); ///[A, A, Z, B, null, N]
        // 6. Get Index of element
        System.out.println(stk.indexOf("Z")); ///2
        // 7. Get sublist [0,3)
        System.out.println(stk.subList(0, 3)); ///[A,A,Z]
        // 8. Get element from Index
        System.out.println(stk.get(2)); ///Z
        // 9. Get size of list
        System.out.println(stk.size()); ///5
        // 10. Clear List
        stk.clear();
        System.out.println(stk); ///[]
        // 11. Stack Specific Methods
        stk.push("A1");
        stk.push("B1");
        stk.push("C1");
        System.out.println(stk.peek()); ///C1 - View top ele
        System.out.println(stk); ///[[A1,B1,C1]
        System.out.println(stk.pop()); ///C1
        System.out.println(stk); ///[A1,B1]
        stk.push("C1");
        System.out.println(stk); ///[A1,B1,C1]
        System.out.println(stk.search("A1")); ///3 /// offset if found
        System.out.println(stk.search("B1")); ///2
        System.out.println(stk.search("C1")); ///1
        System.out.println(stk.search("Z1")); ///-1 /// -1 if not found

    }
}
