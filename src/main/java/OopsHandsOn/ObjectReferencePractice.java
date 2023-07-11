// If parent is reference of child's object - Only parent's method can be accessed
//But in case of overriding, child gets priority
// Child can't be reference of parent

package OopsHandsOn;
interface A{
    void func1();
    void func2();
}
interface B extends A{
    void func3();
    void func4();
}
abstract class C implements B{ // abstract class because it's not implementing all funcs of parent interface
    public void func3(){
        System.out.println("Class C - func3");
    }
}
class D extends C implements B{ // concrete class
    public void func1(){
        System.out.println("Class D - func1");
    }
    public void func2(){
        System.out.println("Class D - func2");
    }
    public void func3(){
        System.out.println("Class D - func3");
    }
    public void func4(){
        System.out.println("Class D - func4");
    }
}
class X{
    public void func(){
        System.out.println("Class X - func");
    }
    public void funcX(){
        System.out.println("Class X - funcX");
    }
}
class Y extends X{
    public void func(){
        System.out.println("Class Y - func");
    }
    public void funcY(){
        System.out.println("Class Y - funcY");
    }
}
class M{
    void common(){
        System.out.println("Class M - common");
    }
    void funcM(){
        System.out.println("Class M - funcM");
    }
}
class N extends M{
    void common(){
        System.out.println("Class N - common");
    }
    void funcM(){
        System.out.println("Class N - funcM");
    }
}
public class ObjectReferencePractice {
    public static void main(String[] args){
        System.out.println("Reference of Class D itself");
        D objD = new D();
        objD.func1(); ///Class D - func1
        objD.func2(); ///Class D - func2
        objD.func3(); ///Class D - func3
        objD.func4(); ///Class D - func4
        System.out.println("Reference of Class C");
        C objC = new D();
        objC.func1(); ///Class D - func1
        objC.func2(); ///Class D - func2
        objC.func3(); ///Class D - func3
        objC.func4(); ///Class D - func4
        System.out.println("Reference of Class B");
        B objB = new D();
        objB.func1(); ///Class D - func1
        objB.func2(); ///Class D - func2
        objB.func3(); ///Class D - func3
        objB.func4(); ///Class D - func4
        System.out.println("Reference of Class A");
        A objA = new D();
        objA.func1(); ///Class D - func1
        objA.func2(); ///Class D - func2
//        objA.func3(); // Error - Cannot find symbol method func3()
//        objA.func4(); // Error - Cannot find symbol method func4()

        System.out.println();

        System.out.println("Reference of Class X Object of X");
        X objX1 = new X();
        objX1.func(); /// Class X - func
        objX1.funcX(); /// Class X - funcX
//        objX1.funcY(); // Not allowed X does not know about Y's existence
        System.out.println("Reference of Class Y Object of X");
//        Y objY = new X(); // Child can't be a reference of parent's object
        System.out.println("Reference of Class Y Object of Y");
        Y objY = new Y();
        objY.func(); ///Class Y - func
        objY.funcX(); ///Class X - funcX
        objY.funcY(); ///Class Y - funcY
        System.out.println("Reference of Class X Object of Y"); 
        X objX2 = new Y();
        objX2.func(); ///Class Y - func // Method Overriding - Child gets priority
        objX2.funcX(); ///Class X - funcX
//        objX2.funcY(); // If parent is reference of child's object - Only parent's method can be accessed

        System.out.println();

        System.out.println("Reference of Class M Object of M");
        M objM1 = new M();
        objM1.common(); ///Class M - common
        objM1.funcM(); ///Class M - funcM
        System.out.println("Reference of Class N Object of M");
//        N objN = new M(); // Child can't be a reference of parent's object
        System.out.println("Reference of Class N Object of N");
        N objN = new N();
        objN.common(); ///Class N - common
        objN.funcM(); ///Class N - funcM
        System.out.println("Reference of Class M Object of N");
        M objM2 = new N();
        objM2.common(); ///Class N - common // Method Overriding
        objM2.funcM(); ///Class N - funcM // If parent is reference of child's object - Only parent's method can be accessed | But in case of overriding, child gets priority


    }
}
