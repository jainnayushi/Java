package ExecutorFrameworkPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.Date;

class Service implements Runnable{
    int i;
    public Service(int i){this.i = i;}
    public void run(){
        System.out.println(i+" "+Thread.currentThread().getName());
        try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
    }
}
class Service2 implements Callable<String>{
    int i;
    public Service2(int i){this.i = i;}
    public String call() throws InterruptedException, ExecutionException{
        return(i+" "+Thread.currentThread().getName());
    }
}

class Service3 implements Callable<String>{
    int i;
    public Service3(int i){this.i = i;}
    public String call() throws InterruptedException, ExecutionException{
        System.out.println(i+" "+Thread.currentThread().getName());
        return("Returning "+i+" "+Thread.currentThread().getName());
    }
}
//1. With Execute()
//public class ExecutorServicePractice {
//    public static void main(String[] args) throws InterruptedException {
//        ExecutorService es = Executors.newFixedThreadPool(5);
//        System.out.println(new Date());
//        for(int i=1; i<=10; i++){
//            es.execute(new Service(i));
//        }
//        es.shutdown();
////        es.awaitTermination(10, TimeUnit.SECONDS);
//        System.out.println(new Date());
//    }
//}

//2. submit() with Runnable
//public class ExecutorServicePractice {
//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        ExecutorService es = Executors.newFixedThreadPool(5);
//        System.out.println(new Date());
//        List<Future<String>> futureList = new ArrayList<>();
//        for(int i=1; i<=10; i++){
//            futureList.add((Future<String>) es.submit(new Service(i)));
//        }
////        es.shutdown();
//        es.awaitTermination(10, TimeUnit.SECONDS);
//        for(Future<String> fut : futureList)
//            System.out.println(fut.get()); // null
//        System.out.println(new Date());
//    }
//}

//3. submit() with Callable
//public class ExecutorServicePractice {
//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        ExecutorService es = Executors.newFixedThreadPool(5);
//        System.out.println(new Date());
//        List<Future<String>> futureList = new ArrayList<>();
//        for(int i=1; i<=10; i++){
//            futureList.add((Future<String>) es.submit(new Service2(i)));
//        }
//        es.awaitTermination(10, TimeUnit.SECONDS);
//        for(Future<String> fut : futureList)
//            System.out.println(fut.get());
//        System.out.println(new Date());
//    }
//}

//4. invokeany() and callable
//public class ExecutorServicePractice {
//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        ExecutorService es = Executors.newFixedThreadPool(5);
//        System.out.println(new Date());
//        List<Callable<String>> callableList = new ArrayList<>();
//        callableList.add(new Service3(1));
//        callableList.add(new Service3(2));
//        callableList.add(new Service3(4));
//        callableList.add(new Service3(3));
//        String str = es.invokeAny(callableList);
//        es.awaitTermination(10, TimeUnit.SECONDS);
//        System.out.println(str);
//        System.out.println(new Date());
//    }
//}

//5. invokeAll() and callable
public class ExecutorServicePractice {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(5);
        System.out.println(new Date());
        List<Callable<String>> callableList = new ArrayList<>();
        callableList.add(new Service3(1));
        callableList.add(new Service3(2));
        callableList.add(new Service3(4));
        callableList.add(new Service3(3));
        List<Future<String>> futureList =  es.invokeAll(callableList);
        es.awaitTermination(10, TimeUnit.SECONDS);
        for(Future<String> fut : futureList)
            System.out.println(fut.get());
        System.out.println(new Date());
    }
}

//With shutdown
//Wed Apr 26 20:35:30 IST 2023
//Wed Apr 26 20:35:30 IST 2023
//4 pool-1-thread-4
//2 pool-1-thread-2
//3 pool-1-thread-3
//5 pool-1-thread-5
//1 pool-1-thread-1
//6 pool-1-thread-2
//7 pool-1-thread-5
//8 pool-1-thread-4
//9 pool-1-thread-3
//10 pool-1-thread-1

//with awaittermination
//Wed Apr 26 20:34:17 IST 2023
//1 pool-1-thread-1
//3 pool-1-thread-3
//5 pool-1-thread-5
//2 pool-1-thread-2
//4 pool-1-thread-4
//7 pool-1-thread-5
//6 pool-1-thread-3
//8 pool-1-thread-1
//9 pool-1-thread-2
//10 pool-1-thread-4
//Wed Apr 26 20:34:27 IST 2023

//2
//Wed Apr 26 20:44:10 IST 2023
//        3 pool-1-thread-3
//        1 pool-1-thread-1
//        2 pool-1-thread-2
//        5 pool-1-thread-5
//        4 pool-1-thread-4
//        7 pool-1-thread-1
//        6 pool-1-thread-2
//        8 pool-1-thread-3
//        9 pool-1-thread-5
//        10 pool-1-thread-4
//        null
//        null
//        null
//        null
//        null
//        null
//        null
//        null
//        null
//        null
//        Wed Apr 26 20:44:20 IST 2023

//3
//Wed Apr 26 20:58:15 IST 2023
//        1 pool-1-thread-1
//        2 pool-1-thread-2
//        3 pool-1-thread-3
//        4 pool-1-thread-4
//        5 pool-1-thread-5
//        6 pool-1-thread-4
//        7 pool-1-thread-5
//        8 pool-1-thread-4
//        9 pool-1-thread-4
//        10 pool-1-thread-4
//        Wed Apr 26 20:58:25 IST 2023