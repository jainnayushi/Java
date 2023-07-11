package CollectionHandsOn.Map;
import java.util.*;
class Temp {
    public String toString() {
        return "temp";
    }
    public void finalize() {
        System.out.println("finalize() Called");
    }
}
public class WeakHashMapPractice {
    public static void main(String[] args) throws InterruptedException {
            HashMap m = new HashMap();
            Temp t = new Temp();
            m.put(t, "Ayushi");
            System.out.println(m);
            t = null;
            System.gc();
            Thread.sleep(5000);
            System.out.println(m);
//            {temp=Ayushi}
//            {temp=Ayushi}
            System.out.println();

            WeakHashMap wm = new WeakHashMap();
            Temp t1 = new Temp();
            wm.put(t1, "Ayushi");
            System.out.println(wm);
            t1 = null;
            System.gc();
            Thread.sleep(5000);
            System.out.println(wm);
//            {temp=Ayushi}
//            finalize() Called
//            {}
    }
}
