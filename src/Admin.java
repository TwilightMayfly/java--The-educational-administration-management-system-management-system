import java.util.Scanner;

public class Admin extends User {
    static String pass = "123456";

    public int login() {//管理员登陆方法
        System.out.println("请输入管理员密码");
        Scanner sc = new Scanner(System.in);
        if (sc.next().equals(this.pass)) return 1;
        else return 0;
    }
}
