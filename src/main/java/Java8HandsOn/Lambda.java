package Java8HandsOn;
interface Message{
    public void printMessage();
}
//1
class MessageClass implements Message{
    @Override
    public void printMessage() {
        System.out.println("printMessage called using Implementing class");
    }
}

public class Lambda {
    public static void main(String[] args) {
        //2
        Message MessageAnonymousClassObj = new Message() {
            @Override
            public void printMessage() {
                System.out.println("printMessage called using Anonymous Class");
            }
        };
        //3
        Message msg = () -> System.out.println("printMessage called using lambda");

        //1
        MessageClass messageClassObj = new MessageClass();
        messageClassObj.printMessage();
        //2
        MessageAnonymousClassObj.printMessage();
        //3
        msg.printMessage();


    }

}
