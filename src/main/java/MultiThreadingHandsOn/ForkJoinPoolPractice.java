package MultiThreadingHandsOn;

import java.util.ArrayList;
import java.util.List;

public class ForkJoinPoolPractice {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<10; i++)
            list.add(i);
        long initialTime = System.currentTimeMillis();
        list.stream().forEach(a->{ // 1086
//        list.parallelStream().forEach(a->{ // 214
            try{
                Thread.sleep(100);
                System.out.println(Thread.currentThread());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        long finalTime = System.currentTimeMillis();
        System.out.println(finalTime-initialTime);

    }
}

//with stream
//Thread[main,5,main]
//Thread[main,5,main]
//Thread[main,5,main]
//Thread[main,5,main]
//Thread[main,5,main]
//Thread[main,5,main]
//Thread[main,5,main]
//Thread[main,5,main]
//Thread[main,5,main]
//Thread[main,5,main]
//1086
//with parallelStream
//Thread[ForkJoinPool.commonPool-worker-5,5,main]
//Thread[ForkJoinPool.commonPool-worker-1,5,main]
//Thread[ForkJoinPool.commonPool-worker-4,5,main]
//Thread[ForkJoinPool.commonPool-worker-3,5,main]
//Thread[ForkJoinPool.commonPool-worker-2,5,main]
//Thread[ForkJoinPool.commonPool-worker-6,5,main]
//Thread[ForkJoinPool.commonPool-worker-7,5,main]
//Thread[main,5,main]
//Thread[ForkJoinPool.commonPool-worker-5,5,main]
//Thread[ForkJoinPool.commonPool-worker-1,5,main]
//214