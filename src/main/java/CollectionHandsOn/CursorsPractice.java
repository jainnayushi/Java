package CollectionHandsOn;
import java.util.*;
public class CursorsPractice {
    public static void main(String args[]) {
        ArrayList<String> alst = new ArrayList<>();
        alst.add("Ayushi");
        alst.add("Jain");
        alst.add("Ashi");
        alst.add("Jain");
        System.out.println(alst);

        // loop 1
        for (String a1 : alst) {
            System.out.print(a1 + "-");
        }
        System.out.println();

        // loop 2
        alst.forEach(a2 -> System.out.print(a2 + "--"));
        System.out.println();

        // loop 3
        Iterator<String> itr = alst.iterator();
        while (itr.hasNext()) {
            String a3 = itr.next();
            System.out.print(a3 + "---");
        }
        System.out.println();

        // loop 4
        ListIterator<String> litr = alst.listIterator();
        while (litr.hasNext()) {
            String a3 = litr.next();
            System.out.print(a3 + "---");
        }
        while (litr.hasPrevious()) {
            String a4 = litr.previous();
            System.out.print(a4 + "--");
        }
        System.out.println();

        // Vector vct = new Vector();
        Vector<String> vct = new Vector<>();
        vct.add("Ayushi");
        vct.add("Jain");
        vct.add("Ashi");
        vct.add("Jain");
        // loop 5
        Enumeration<String> en = vct.elements();
        while (en.hasMoreElements()) {
            Object a4 = en.nextElement();
            System.out.print(a4 + "----");
        }
    }
}
