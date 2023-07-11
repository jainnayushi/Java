package OopsHandsOn;

interface I1{
    void func1();
    default void func2(){
        System.out.println("Default Method");
    }
    static void func3(){
        System.out.println("Static Method");
    }
}
class C1 implements I1{

    @Override
    public void func1() {
        System.out.println("Abstract Method");
    }
}
public class InterfacePractice {
    public static void main(String[] args) {
        C1 c1Obj = new C1();
        c1Obj.func1(); /// Abstract Method
        c1Obj.func2(); /// Default Method
//        xObj.func3(); // Can't call static with class name

        I1 iObj = new C1();
        iObj.func1(); /// Abstract Method
        iObj.func2(); /// Default Method
//        iObj.func3(); // // Can't call static with class name
        I1.func3(); /// Static Method
    }
}
