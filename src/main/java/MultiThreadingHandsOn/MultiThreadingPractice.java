package MultiThreadingHandsOn;

public class MultiThreadingPractice {
    static class Kitchen implements Runnable{
        @Override
        public void run() {
            System.out.println("Order Taken : " +Thread.currentThread().getName());
            prepareFood();
        }
        public synchronized static void prepareFood() {
            System.out.println("Preparation Started : " +Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Preparation Done : " +Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Kitchen k1 = new Kitchen();
        Thread t1 = new Thread(k1);
        t1.start();

        Kitchen k2 = new Kitchen();
        Thread t2 = new Thread(k2);
        t2.start();

        Kitchen k3 = new Kitchen();
        Thread t3 = new Thread(k3);
        t3.start();

    }
}
// All threads concurrently using run()
//Order Taken : Thread-0
//Order Taken : Thread-2
//Preparation Started : Thread-0
//Preparation Started : Thread-2
//Order Taken : Thread-1
//Preparation Started : Thread-1
//Preparation Done : Thread-0
//Preparation Done : Thread-2
//Preparation Done : Thread-1

// Using synchronized in prepareFood() : One thread at a time enter here
//Order Taken : Thread-2
//Order Taken : Thread-0
//Order Taken : Thread-1
//Preparation Started : Thread-2
//Preparation Done : Thread-2
//Preparation Started : Thread-1
//Preparation Done : Thread-1
//Preparation Started : Thread-0
//Preparation Done : Thread-0