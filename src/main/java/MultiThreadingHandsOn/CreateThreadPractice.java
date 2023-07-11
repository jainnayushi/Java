package MultiThreadingHandsOn;

class MyThread extends Thread{
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

public class CreateThreadPractice {
    public static void main(String[] args) {
        MyThread t1=new MyThread();//Instantiation of a Thread
        t1.start();//starting of a Thread and creation of a new thread
        MyThread t2=new MyThread();
        t2.start();
        for(int i=0; i<5; i++) {
            System.out.println("main thread" + Thread.currentThread().getName());
        }
    }
}
//1. Only 1 thread
//main thread
//main thread
//main thread
//main thread
//main thread
//Child Thread
//Child Thread
//Child Thread
//Child Thread
//Child Thread
//Child Thread
//Child Thread
//Child Thread
//Child Thread
//Child Thread

// 2. 2 threads
//main threadmain
//main threadmain
//main threadmain
//main threadmain
//main threadmain
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
