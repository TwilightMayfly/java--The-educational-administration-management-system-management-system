import java.util.Scanner;

public class User {
    String name;
    String pass;

    public void show() {
        System.out.println("用户名：" + name);
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User() {
    }

    static public void setPassWord(int iid) {

    }
}
