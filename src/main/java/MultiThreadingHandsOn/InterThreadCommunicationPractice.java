package MultiThreadingHandsOn;

import java.util.LinkedList;
import java.util.*;

public class InterThreadCommunicationPractice {
    public static void main(String[] args) {
        String key = "LOCK";
        Queue<Integer> queue = new LinkedList<>(); // Plate
        int plateSize = 5;

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while(true){
                    synchronized (key){
                        try{
                            while(queue.size()==plateSize)
                                key.wait();
                            queue.offer(count++);
                            key.notifyAll();
                            Thread.sleep(1000);
                            System.out.println("Produced : "+queue.size());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (key){
                        try{
                            while(queue.size()==0)
                                key.wait();
                            queue.poll();
                            key.notifyAll();
                            System.out.println("Consumed : "+queue.size());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        });
        producer.start();
        consumer.start();
    }

}
