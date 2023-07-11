package Java8HandsOn;

class A{
    public void func(){
        System.out.println("In A");
    }
}
class B{
    public void func(){
        System.out.println("In B");
    }
}
//class C extends A,B{
//    public void func(){
//        System.out.println("In A");
//    }
//}
interface I1{
//    void a();
    default void func(){
        System.out.println("In I1");
    }
}
interface I2{
    //    void a();
    default void func(){
        System.out.println("In I2");
    }
}
class I implements I1 {
    public void func(){
        System.out.println("In I");
    }
}
public class DefaultStaticPractice {
    public static void main(String[] args) {
        System.out.println("hi");
        I1 x = new I();
        x.func();
//        I2 y = new I();
//        y.func();
        I z = new I();
        z.func();
    }
}
