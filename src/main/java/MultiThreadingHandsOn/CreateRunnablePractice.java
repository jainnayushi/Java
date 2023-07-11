package MultiThreadingHandsOn;

class MyRunnable implements Runnable{
    public void run(){
        for(int i=0; i<10; i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Child Thread" + Thread.currentThread().getName());
        }
    }
}

public class CreateRunnablePractice {
    public static void main(String[] args) {
        MyRunnable r=new MyRunnable();//r is a Target Runnable
        Thread t1=new Thread(r);//Instantiation of a Thread
        t1.start();//starting of a Thread and creation of a new thread
        Thread t2=new Thread(r);
        t2.start();

        for(int i=0;i<10;i++) {
            System.out.println("main thread");
        }
    }
}
// 1. Only one thread
//main thread
//main thread
//main thread
//main thread
//main thread
//main thread
//main thread
//main thread
//main thread
//main thread
//Child ThreadThread-0
//Child ThreadThread-0
//Child ThreadThread-0
//Child ThreadThread-0
//Child ThreadThread-0
//Child ThreadThread-0
//Child ThreadThread-0
//Child ThreadThread-0
//Child ThreadThread-0
//Child ThreadThread-0

//2. 2 threads
//main thread
//main thread
//main thread
//main thread
//main thread
//main thread
//main thread
//main thread
//main thread
//main thread
//Child ThreadThread-0
//Child ThreadThread-1
//Child ThreadThread-0
//Child ThreadThread-1
//Child ThreadThread-0
//Child ThreadThread-1
//Child ThreadThread-0
//Child ThreadThread-1
//Child ThreadThread-0
//Child ThreadThread-1
//Child ThreadThread-0
//Child ThreadThread-1
//Child ThreadThread-0
//Child ThreadThread-1
//Child ThreadThread-0
//Child ThreadThread-1
//Child ThreadThread-0
//Child ThreadThread-1
//Child ThreadThread-0
//Child ThreadThread-1