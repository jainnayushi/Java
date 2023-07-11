package CollectionHandsOn.ComparableComparator;

import java.util.Comparator;
import java.util.TreeSet;
class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        String s1 = o1.toString();
        String s2 = (String)o2;
//        return -s1.compareTo(s2);
        return s2.compareTo(s1);

    }
}
class MyComparator1 implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int i1 = o1.toString().length();
        int i2 = o2.toString().length();
        if(i1>i2){ //i1 then i2
            return-1;
        } else if (i1<i2) { //i2 then i1
            return 1;
        }else{ // asc if equal
            return o1.toString().compareTo(o2.toString());
        }
    }
}
class MyComparator3 implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int i1 = (Integer)o1;
        int i2 = (Integer)o2;
        if(i1%10 > i2%10){
            return -1;
        }else{
            return 1;
        }
    }
}
public class File1 {
    public static void main(String[] args) {
        TreeSet<String> tset1 = new TreeSet<>(); // Default Comparable + Default asc sorted order
        tset1.add("Bb");
        tset1.add("C");
        tset1.add("Ba");
        tset1.add("A");
        tset1.add("D");
        System.out.println(tset1); ///[A, Ba, Bb, C, D]
        TreeSet<String> tset2 = new TreeSet<>(new MyComparator()); //// Our Comparator + Our descending Order
        tset2.add("Bb");
        tset2.add("C");
        tset2.add("A");
        tset2.add("Ba");
        tset2.add("D");
        System.out.println(tset2); ///[D, C, Bb, Ba, A]
        TreeSet<StringBuffer> tset3 = new TreeSet<>(new MyComparator1());
        tset3.add(new StringBuffer("Bb"));
        tset3.add(new StringBuffer("A"));
        tset3.add(new StringBuffer("C"));
        tset3.add(new StringBuffer("Ba"));
        tset3.add(new StringBuffer("D"));
        System.out.println(tset3); ///[Ba, Bb, A, C, D]

        TreeSet<Integer> lst = new TreeSet<>(new MyComparator3());
        lst.add(100);
        lst.add(11);
        lst.add(52);
        lst.add(73);
        System.out.println(lst); ///[73, 52, 11, 100]

    }
}
