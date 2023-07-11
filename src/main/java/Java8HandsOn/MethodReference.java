package Java8HandsOn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class User{
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
        System.out.println("Constructor called");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int comparatorInstanceFunc(User u1, User u2){
        return u1.getId()-u2.getId();
    }

    public static int comparatorStaticFunc(User u1, User u2){
        return u1.getId()-u2.getId();
    }

    public static List<User> getUsersList(){
        List<User> list = new ArrayList<>();
        list.add(new User(5, "Ayushi"));
        list.add(new User(2, "Dyushi"));
        list.add(new User(1, "Byushi"));
        list.add(new User(6, "Eyushi"));
        list.add(new User(7, "Cyushi"));
        return list;
    }
}
public class MethodReference {
    public static void main(String[] args) {
        List<User> userList = User.getUsersList();

        Comparator<User> comparatorLambdaFunc = (u1,u2) -> u1.getName().compareTo(u2.getName());

        System.out.println("Sort by Name - lambda");
        Collections.sort(userList, comparatorLambdaFunc);
        System.out.println(userList);

        System.out.println("Sort by Id - Instance Method Reference");
        Collections.sort(userList, new User()::comparatorInstanceFunc);
        System.out.println(userList);

        System.out.println("Sort by Name - Static Method Reference");
        Collections.sort(userList, User::comparatorStaticFunc);
        System.out.println(userList);




    }
}
