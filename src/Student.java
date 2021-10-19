import java.util.Scanner;

public class Student extends User {

    int id;
    String Class;
    static int sId;

    public Student(String name, String pass, int id, String Class) {
        this.name = name;
        this.pass = pass;
        this.id = id;
        this.Class = Class;
    }

    public Student() {
    }

    public int login() {//学生登陆方法
        System.out.println("请输入学号");
        Scanner sc = new Scanner(System.in);
        sId = sc.nextInt();
        System.out.println("请输入密码");
        String pass = sc.next();
        for (Student u : UserCollection.stu) {
            if (u.id == sId && u.pass.equals(pass)) {
                System.out.println("登陆成功！");
                return 1;
            }
        }
        return 0;
    }

    public static void lookCourse() {
        for (Course u : Courses.courses) {
            if (u.type == 0) u.show();
        }
        for (Selection u : Selection.select) {
            if (u.stuId == sId) {
                for (Course v : Courses.courses) {
                    if (v.id == u.classId) v.show();
                }
            }
        }

    }

    public static void selectCourse() {

    }

    public void show() {
        System.out.println(id + " " + name + " " + Class);
    }

    public String toString() {
        return name + " " + pass + " " + id + " " + Class;
    }

    static public void setPassWord(int iid) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入新密码（六位）");
            String xpass1 = sc.next();
            System.out.println("请重复新密码");
            String xpass2 = sc.next();
            if (xpass1.equals(xpass2) && xpass1.length() == 6) {
                for (Student u : UserCollection.stu) {
                    if (u.id == iid) u.pass = xpass1;
                }
                break;
            } else {
                System.out.println("密码不匹配或位数不正确");
                continue;
            }
        }
    }

}
