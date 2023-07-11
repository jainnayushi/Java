package MultiThreadingHandsOn;

class MyThread1 extends Thread{
    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println("lazy thread");
            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class DaemonThreadPractice {
    public static void main(String[] args)
    {
        MyThread1 t=new MyThread1();
//        t.setDaemon(true); //-->1
        t.start();
        System.out.println("end of main Thread");
    }
}

//Uncomment
//  end of main Thread
//  lazy thread
//Comment
//  end of main Thread
//  lazy thread
//  lazy thread
//  lazy thread
