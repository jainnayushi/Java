package Java8HandsOn;

import java.util.Optional;

public class OptionalPractice {
    public static void main(String[] args) {
        String[] s = new String[5];
        s[0] = "ram";
        s[1] = "sam"; // s[2,3,5] = null

// Problem
//        System.out.println(s[2].toUpperCase()); // Null Pointer Exception

// Solution
        Optional<String> o = Optional.ofNullable(s[2]);
        if(o.isPresent()){
            System.out.println(o.get().toUpperCase());
        }else{
            System.out.println("Value not exist");
        }
    }
}
