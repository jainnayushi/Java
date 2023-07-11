package MultiThreadingHandsOn;

class Printer1 implements Runnable{
    static int counter =1;
    int remainder;
    static String lock = "LOCK";
    Printer1(int remainder){
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
public class EvenOddMultiThreadingPractice {
    public static void main(String[] args) {
        Printer1 evenObject = new Printer1(0);
        Printer1 oddObject = new Printer1(1);

        // Aliasing thread name
        Thread evenThread = new Thread(evenObject,"Even Thread");
        Thread oddThread = new Thread(oddObject, "Odd Thread");

        oddThread.start();
        evenThread.start();
    }
}
