package MultiThreadingHandsOn;

public class SynchronizedBlockPractice {
    static class Kitchen implements Runnable{
        static final String lock = "LOCK";
        @Override
        public void run() {
            System.out.println("Order Taken : " +Thread.currentThread().getName());
            prepareFood();
        }
        public static void prepareFood() {
            synchronized(lock) {
                System.out.println("Preparation Started : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Preparation Done : " + Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        MultiThreadingPractice.Kitchen k1 = new MultiThreadingPractice.Kitchen();
        Thread t1 = new Thread(k1);
        t1.start();

        MultiThreadingPractice.Kitchen k2 = new MultiThreadingPractice.Kitchen();
        Thread t2 = new Thread(k2);
        t2.start();

        MultiThreadingPractice.Kitchen k3 = new MultiThreadingPractice.Kitchen();
        Thread t3 = new Thread(k3);
        t3.start();
    }
}
//Order Taken : Thread-2
//Preparation Started : Thread-2
//Order Taken : Thread-0
//Order Taken : Thread-1
//Preparation Done : Thread-2
//Preparation Started : Thread-1
//Preparation Done : Thread-1
//Preparation Started : Thread-0
//Preparation Done : Thread-0
