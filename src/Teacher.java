import org.omg.CORBA.PUBLIC_MEMBER;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class Teacher extends User {
    int workId;
    String level;
    static int tId;

    public Teacher(String name, String pass, int id, String level) {
        this.name = name;
        this.pass = pass;
        this.workId = id;
        this.level = level;
    }

    public Teacher() {
    }

    public int login() {//教授登陆方法
        System.out.println("请输入工号");
        Scanner sc = new Scanner(System.in);
        tId = sc.nextInt();
        System.out.println("请输入密码");
        String pass = sc.next();
        for (Teacher u : UserCollection.tea) {
            if (u.workId == tId && u.pass.equals(pass)) {
                System.out.println("登陆成功！");
                return 1;
            }
        }
        return 0;
    }

    public void show() {
        System.out.println(workId + " " + name + " " + level);
    }

    public String toString() {
        return name + " " + pass + " " + workId + " " + level;
    }

    public static void lookCourse() {
        for (Course u : Courses.courses) {
            if (u.teaId == tId) u.show();
        }

    }

    public static void look() {
        lookCourse();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (Course u : Courses.courses) {
            if (u.id == a) {
                if (u.type == 0) {
                    UserCollection c = new UserCollection();
                    c.showStudent();
                } else {
                    for (Selection v : Selection.select) {
                        if (v.classId == a) {
                            for (Student z : UserCollection.stu) {
                                if (z.id == v.stuId) z.show();
                            }
                        }
                    }
                }
            }
        }
    }

    static public void setPassWord(int iid) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入新密码（六位）");
            String xpass1 = sc.next();
            System.out.println("请重复新密码");
            String xpass2 = sc.next();
            if (xpass1.equals(xpass2) && xpass1.length() == 6) {
                for (Teacher u : UserCollection.tea) {
                    if (u.workId == iid) u.pass = xpass1;
                }
                break;
            } else {
                System.out.println("密码不匹配或位数不正确");
                continue;
            }
        }
    }
}
