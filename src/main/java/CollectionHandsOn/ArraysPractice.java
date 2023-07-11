package CollectionHandsOn;
import java.util.*;
class MyyComparator implements Comparator<Object> {
    public int compare(Object obj1, Object obj2) {
        String s1 = obj1.toString();
        String s2 = obj2.toString();
        return s2.compareTo(s1);
    }
}
public class ArraysPractice {
    public static void main(String args[]) {
        int[] a = {10, 5, 20, 11, 6};
        Arrays.sort(a); //Sort By Natural Order // 5 6 10 11 20
        System.out.println(Arrays.binarySearch(a, 6)); //1
        System.out.println(Arrays.binarySearch(a, 14)); //-5 - Insertion Point
        String[] s = {"A", "Z", "B"};
        Arrays.sort(s); // A B Z
        System.out.println(Arrays.binarySearch(s, "N")); //-3 - Insertion Point
        System.out.println(Arrays.binarySearch(s, "Z")); //2
        System.out.println(Arrays.binarySearch(s, "S")); //-3 - Insertion Point
        Arrays.sort(s, new MyComparator()); // Z B A
        System.out.println(Arrays.binarySearch(s, "Z", new MyyComparator())); //0
        System.out.println(Arrays.binarySearch(s, "S", new MyyComparator())); //-2 - Insertion Point
    }
}
