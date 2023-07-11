package CollectionHandsOn.Map;
// In the Case of ConcurrentHashMap iterator creates a Read Only Copy of Map Object and
// iterates over that Copy if any Changes to the Map after getting iterator
// it won’t be affected/ reflected.
import java.util.concurrent.ConcurrentHashMap;
import java.util.*;
public class ConcurrentHashMapPractice {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Number, String> m = new ConcurrentHashMap<>();
        m.put(101, "A");
        m.put(102, "B");
        Iterator itr = m.keySet().iterator();
        m.put(103, "C");
        System.out.println(m.putIfAbsent(103,"D"));
        while (itr.hasNext()) {
            Integer I1 = (Integer) itr.next();
            System.out.println(I1+" : "+m.get(I1));
            m.put(104, "D");
        }
        System.out.println(m);
//        C
//        101 : A
//        102 : B
//        103 : C
//        104 : D
//        {101=A, 102=B, 103=C, 104=D}
        System.out.println();


        // Problem with HashMap
        HashMap<Number, String> hmap = new HashMap<>();
        hmap.put(101, "A");
        hmap.put(102, "B");
        Iterator itr1 = hmap.keySet().iterator();
//        hmap.put(103, "C"); -> Problem
        while (itr1.hasNext()) {
            Integer I1 = (Integer) itr1.next();
            System.out.println(I1+" : "+hmap.get(I1));
        }
        System.out.println(hmap);
        // 101 : A
        // 102 : B
        // {101=A, 102=B}
        System.out.println();


        // ConcurrentHashMap 3 Methods
        ConcurrentHashMap<Number, String> chmap = new ConcurrentHashMap<>();
        chmap.put(101, "A");
        chmap.put(102, "B");
        chmap.put(103, "D");
        chmap.put(103, "R");
        System.out.println(chmap); //{101=A, 102=B, 103=R}
        chmap.putIfAbsent(103, "S");
        System.out.println(chmap.putIfAbsent(103, "S")); /// R - returns old value & new not updated
        System.out.println(chmap); //{101=A, 102=B, 103=R}

        System.out.println();
        chmap.put(104, "D");
        chmap.remove(101, "R"); //"Entry" Not Matched with Key So Not Removed
        System.out.println(chmap); ///{101=A, 102=B, 103=C, 104=D}
        chmap.remove(101, "A");
        System.out.println(chmap); ///{102=B, 103=C, 104=D} - "Entry" matched so removed

        System.out.println();
        chmap.put(105, "T");
        chmap.replace(105, "R", "Z");
        System.out.println(chmap); //{102=B, 103=R, 104=D, 105=T} // Value Not Matched with Key So Not Replaced
        chmap.replace(105, "T", "Z");
        System.out.println(chmap); //{102=B, 103=R, 104=D, 105=Z} - Value matched so replaced
    }
}
