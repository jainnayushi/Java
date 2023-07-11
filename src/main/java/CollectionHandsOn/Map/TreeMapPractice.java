package CollectionHandsOn.Map;
import java.util.*;
class MyComparator implements Comparator {
    public int compare(Object obj1, Object obj2) {
        String s1 = obj1.toString();
        String s2 = obj2.toString();
        return s2.compareTo(s1);
    }
}
public class TreeMapPractice {
    public static void main(String[] args) {
        TreeMap<Number, String> m = new TreeMap<>();
        m.put(100, "ZZZ");
        m.put(103, "YYY");
        m.put(101, "XXX");
        m.put(107, null);
        // Null NOT allowed
//        m.put(null, "XXX"); //RE: Exception in thread "main" java.lang.NullPointerException
        // Insertion Order NOT preserved
        System.out.println(m); //{100=ZZZ, 101=XXX, 103=YYY, 107=null}

        TreeMap<String, Number> tmap = new TreeMap<>(new MyComparator());
        tmap.put("ZZZ", 10);
        tmap.put("AAA", 20);
        tmap.put("ZZZ", 30);
        tmap.put("LLL", 40);
        System.out.println(tmap); ///{ZZZ=30, LLL=40, AAA=20}
    }
}
