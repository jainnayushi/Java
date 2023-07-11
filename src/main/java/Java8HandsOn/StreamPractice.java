package Java8HandsOn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        Integer l3;
        List<Integer> lst = Arrays.asList(1,2,3,4,5);
        System.out.println(lst.stream().toArray());
        for(Integer i : lst){
            System.out.println(i);
        }
//        l= (List<Integer>) lst.stream();
//        System.out.println(l);
        System.out.println();
        lst.stream().forEach(System.out::println);
        System.out.println();
        l = lst.stream().map(e -> e*2).collect(Collectors.toList());
        l.forEach(System.out::println);
        System.out.println();
        l = lst.stream().filter(e -> e%2==0).collect(Collectors.toList());
        l.forEach(System.out::println);

        // pipeline
        l2 = lst.stream().filter(i->i%2!=0)
                .map(i->i*3)
                .collect(Collectors.toList());
        System.out.println();
        l2.forEach(System.out::println);

        l3 = lst.stream().filter(i->i%2!=0)
                .map(i->i*3)
                .reduce(100, (a,b)->(a+b));
        System.out.println();
        System.out.println(l3);

        // used once
        List<Integer> l4 = Arrays.asList(1,2,3,4);

        Stream<Integer> s = l4.stream().filter(i->i>1);
        int sum = s.reduce(0,Integer::sum);
        int x = s.findAny().get(); // IllegalStateException
        System.out.println();
        System.out.println(x);
        System.out.println(sum);



    }
}
