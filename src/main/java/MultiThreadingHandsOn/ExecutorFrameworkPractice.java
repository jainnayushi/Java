package MultiThreadingHandsOn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Printer2 implements Runnable{
    static int counter =1;
    int remainder;
    static String lock = "LOCK";
    Printer2(int remainder){
        this.remainder=remainder;
    }
    public void printer(){
        System.out.println(counter + " : " + Thread.currentThread().getName());
        counter++;

    }

    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            synchronized (lock) {
                try {
                    while (counter % 2 != remainder)
                        lock.wait();
                    printer();
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class ExecutorFrameworkPractice {
    public static void main(String[] args) {
        Printer2 evenObject = new Printer2(0);
        Printer2 oddObject = new Printer2(1);
//
//        // Aliasing thread name
//        Thread evenThread = new Thread(evenObject);
//        Thread oddThread = new Thread(oddObject);
//
//        oddThread.start();
//        evenThread.start();

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(evenObject);
        service.submit(oddObject);

        Printer2 evenObject2 = new Printer2(0);
        Printer2 oddObject2 = new Printer2(1);
        ExecutorService service2 = Executors.newFixedThreadPool(2);
        service2.submit(evenObject2);
        service2.submit(oddObject2);

//        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
//
//        //Stats before tasks execution
//        System.out.println("Largest executions: "
//                + executor.getLargestPoolSize());
//        System.out.println("Maximum allowed threads: "
//                + executor.getMaximumPoolSize());
//        System.out.println("Current threads in pool: "
//                + executor.getPoolSize());
//        System.out.println("Currently executing threads: "
//                + executor.getActiveCount());
//        System.out.println("Total number of threads(ever scheduled): "
//                + executor.getTaskCount());
//
//        executor.submit(new Printer2(0));
//        executor.submit(new Printer2(1));
//
//        //Stats after tasks execution
//        System.out.println("Core threads: " + executor.getCorePoolSize());
//        System.out.println("Largest executions: "
//                + executor.getLargestPoolSize());
//        System.out.println("Maximum allowed threads: "
//                + executor.getMaximumPoolSize());
//        System.out.println("Current threads in pool: "
//                + executor.getPoolSize());
//        System.out.println("Currently executing threads: "
//                + executor.getActiveCount());
//        System.out.println("Total number of threads(ever scheduled): "
//                + executor.getTaskCount());
//
//        executor.shutdown();
    }
}
