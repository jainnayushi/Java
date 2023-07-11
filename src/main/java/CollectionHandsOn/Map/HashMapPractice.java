package CollectionHandsOn.Map;
import java.util.*;
import java.util.Set;

public class HashMapPractice {
    public static void main(String[] args) {
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        m.put("C", 700);
        m.put("B", 800);
        m.put("V", 200);
        m.put("N", 500);
//        1. Print map Insertion Order NOT Preserved
        System.out.println(m); ///{B=800, C=700, V=200, N=500}
//        2. Insert entry with duplicate Key
        System.out.println(m.put("C", 1000)); ///700 - return old value, add new
        System.out.println(m); ///{B=800, C=1000, V=200, N=500}
//        3. Generate set of keys
        Set<String> s = m.keySet();
        System.out.println(s); ///[B, C, V, N]
//        4. Generate values
        Collection<Integer> c = m.values();
        System.out.println(c); ///[800, 1000, 200, 500]
//        5. Generate entries
        Set s1 = m.entrySet(); //??
        System.out.println(s1); ///[B=800, C=1000, V=200, N=500]
//        6. Iterate
        Iterator itr = s1.iterator(); //??
        while(itr.hasNext()) {
            Map.Entry <String, Integer>m1 = (Map.Entry)itr.next();
            System.out.println(m1.getKey()+" : "+m1.getValue()); ///B : 800 C : 1000 V : 200 N : 500
            if(m1.getKey().equals("N")) {
                m1.setValue(10000);
            }
        }
        System.out.println(m); ///{B=800, C=1000, V=200, N=10000}
    }
}
