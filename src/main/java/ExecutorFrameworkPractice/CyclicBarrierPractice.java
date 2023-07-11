package ExecutorFrameworkPractice;

import java.util.concurrent.*;
class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction() );
        System.out.println("Starting");
        new Thread(new MyThread4(cb, "A")).start();
        new Thread(new MyThread4(cb, "B")).start();
        new Thread(new MyThread4(cb, "C")).start();
    }
}
// A thread of execution that uses a CyclicBarrier.
class MyThread4 implements Runnable {
    CyclicBarrier cbar;
    String name;
    MyThread4(CyclicBarrier c, String n) {
        cbar = c;
        name = n;
    }
    public void run() {
        System.out.println(name);
        try {
            cbar.await();
        } catch (BrokenBarrierException | InterruptedException exc) {
            System.out.println(exc);
        }
    }
}
// An object of this class is called when the
// CyclicBarrier ends.
class BarAction implements Runnable {
    public void run() {
        System.out.println("Barrier Reached!");
    }
}

