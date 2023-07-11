public class trial {
    public static void main(String[] args) {
        String s1 = "Hello".toString();
        String s2 = (String)"Hello";
        String s3 = "Hello";
        System.out.println(s1==s2);
        System.out.println(s2==s3);
        System.out.println(s1==s3);

        int a=129;
        byte b=127;
                b= (byte)a;
        System.out.println(a);
        System.out.println(b);

    }
}
