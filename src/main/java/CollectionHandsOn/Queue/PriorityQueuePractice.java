package CollectionHandsOn.Queue;
import java.util.*;
class MyComparator implements Comparator<Object> {
    public int compare(Object obj1, Object obj2) {
        String s1 = (String)obj1;
        String s2 = obj2.toString();
        return s2.compareTo(s1);
    }
}
public class PriorityQueuePractice {
    public static void main(String[] args) {
        PriorityQueue<String> q=new PriorityQueue<String>();
        q.add("A");
        q.offer("Z");
        q.offer("L");
        q.offer("B");
        System.out.println(q); //[A, B, L, Z]

        PriorityQueue<String> que =new PriorityQueue<String>(15, new MyComparator());
        que.add("A");
        que.offer("Z");
        que.offer("L");
        que.offer("B");
        System.out.println(que); ///[Z, B, L, A]
        System.out.println(que.peek()); ///X1
        System.out.println(que); ///[Z, B, L, A]
        System.out.println(que.poll()); ///Z
    }
}
