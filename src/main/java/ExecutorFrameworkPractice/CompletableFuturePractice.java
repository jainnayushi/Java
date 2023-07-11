package ExecutorFrameworkPractice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// runAsync
//public class CompletableFuturePractice {
//    private static int data=5;
//    public static void main(String[] args) throws InterruptedException {
//        System.out.println(" Before "+data);
//        CompletableFuture.runAsync(()->{
//            try{
//                Thread.sleep(5000);
//            } catch(InterruptedException e){e.printStackTrace();}
//            data=10;
//        });
//        System.out.println("Main Thraed ");
//        System.out.println("Data in progress in main "+data);
//        Thread.sleep(2500);
//        System.out.println("Data ready in main "+data);
//
//    }
//}

//supplyAsync
public class CompletableFuturePractice {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> data = CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(5000);
            } catch(InterruptedException e){e.printStackTrace();}
            return "data from CF";
        });
        System.out.println("Main Thraed ");
        System.out.println("Data in progress in main "+data.get());
        Thread.sleep(2500);
        System.out.println("Data ready in main "+data.get());

    }
}
