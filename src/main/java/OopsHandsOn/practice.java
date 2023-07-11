package OopsHandsOn;

public class practice {
    practice(){
        System.out.println("Constructor");
    }
    static {
        System.out.println("Static block");
    }


    public static void main(String[] args) {
//        practice p = new practice();
        new practice();
    }
}
