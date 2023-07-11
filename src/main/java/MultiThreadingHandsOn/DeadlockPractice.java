package MultiThreadingHandsOn;

public class DeadlockPractice {
    public static void main(String[] args) {
        final String lock1="A";
        final String lock2="B";
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println("Inside Thread1");
                    synchronized (lock2){
                        System.out.println("Lock1 executed properly");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (lock2){
                    System.out.println("Inside Thread2");
                    synchronized (lock1){
                        System.out.println("Lock2 executed properly");
                    }
                }
            }
        });
        t1.start();
        t2.start();
        System.out.println("End");
    }

}
