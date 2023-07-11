package CollectionHandsOn;
import java.util.*;
class MyComparator implements Comparator<Object> {
    public int compare(Object obj1, Object obj2) {
        String s1 = (String)obj1;
        String s2 = obj2.toString();
        return s2.compareTo(s1);
    }
}

public class CollectionsPractice {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Z");
        al.add("A");
        al.add("K");
        al.add("N");
        al.add("C");
        System.out.println("Before Sorting:"+al); //Before Sorting:[Z, A, K, N,C]
//        Collections.sort(al, new MyComparator());
        System.out.println("After Sorting:"+al); //After Sorting: [Z, N, K, C, A]
        System.out.println(Collections.binarySearch(al, "Z")); //-6 ??
        System.out.println(Collections.binarySearch(al, "J")); //-1
    }
}
