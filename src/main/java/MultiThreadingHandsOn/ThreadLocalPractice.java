package MultiThreadingHandsOn;

import java.beans.IntrospectionException;


public class ThreadLocalPractice implements Runnable {
//    1
//    public static Integer number = 10;
        static ThreadLocal<Integer> number = new ThreadLocal<>();
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadLocalPractice());
        Thread t2 = new Thread(new ThreadLocalPractice());
        Thread t3 = new Thread(new ThreadLocalPractice());
        t1.start();
        t2.start();
        t3.start();
        try{
            t1.join();
            t2.join();
            t3.join();
        }catch(InterruptedException e){ e.printStackTrace();}

    }
    public void run(){
//        2
//        number = (int)(Math.random()*100);
        number.set((int)(Math.random()*100));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        3
//        System.out.println(number);
        System.out.println(number.get());
    }
}
