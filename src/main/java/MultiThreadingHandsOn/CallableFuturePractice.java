package MultiThreadingHandsOn;

import java.util.concurrent.*;

public class CallableFuturePractice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String result;
        Callable<String> task = () ->{
                Thread.sleep(5000);
                return "Inside Callable";
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(task);
        System.out.println("Done? "+ future.isDone());
        System.out.println("Before getting future");
        result = future.get();
        System.out.println("After getting future");
        System.out.println("Done? "+ future.isDone());
        System.out.println(result);
        System.out.println("Future 2 Running .....");
        Future<String> future2 = executor.submit(task);
        System.out.println(future2.get());
        executor.shutdown();
    }



}
