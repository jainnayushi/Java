package OopsHandsOn;

class H{
    H(){
        System.out.println("2. Parent class constructor invoked");
    }
}

class B3 extends H{
    B3(){
        super();
        System.out.println("4. Child class constructor invoked");
    }

    B3(int a){
        super();
        System.out.println("4. Child class constructor invoked "+a);
    }
    static {
        System.out.println("1. Static block invoked");
    }
    {System.out.println("3. Instance initializer block invoked");}

    public static void main(String args[]){
        B3 b1=new B3();
        System.out.println();
        B3 b2=new B3(10);
    }
}
