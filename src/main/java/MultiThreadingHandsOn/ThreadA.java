package MultiThreadingHandsOn;

class ThreadA {
    public static void main(String[] args)throws InterruptedException {
        ThreadB b=new ThreadB();
        b.start();
        synchronized(b){
            System.out.println("main Thread calling wait() method");//step-1
            b.wait();
            System.out.println("main Thread got notification call");//step-4
            System.out.println(b.total);
        }

        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        Thread[] t = new Thread[system.activeCount()];
        system.enumerate(t);
        for (Thread t1: t) {
            System.out.println(t1.getName()+"-------"+t1.isDaemon());
        }
    }
}
class ThreadB extends Thread {
    int total=0;
    public void run() {
        synchronized(this) {
            System.out.println("child thread starts calculation");//step-2
            for(int i=0;i<=100;i++) {
                total=total+i;
            }
            System.out.println("child thread giving notification call"); //step-3
            this.notify();
        }
    }
}

