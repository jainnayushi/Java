package OopsHandsOn;
// covariant return type
class E{
    E get(){return this;}
}

class F extends E{
    @Override
    F get(){return this;}
    void message(){System.out.println("welcome to covariant return type");}

    public static void main(String args[]){
        new F().get().message();
    }
}    
