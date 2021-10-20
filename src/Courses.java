import java.io.*;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Courses {
    static Vector<Course> courses = new Vector<>();

    //添加课程
    public void addcourse() {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int type = sc.nextInt();
        int tid = sc.nextInt();
        //不同类型的课程会有不同的构造
        if (type == 0) {
            System.out.println("请输入该课程学分");
            Course a = new RequiredCourse(courses.size() + 1, name, type, tid, UserCollection.stu.size(), sc.nextInt());
            courses.add(a);
        } else {
            System.out.println("请输入该课程最大人数");
            Course a = new ElectiveCourses(courses.size() + 1, name, type, tid, 0, sc.nextInt());
            courses.add(a);
        }
    }

    //添加课程
    public static void addcourse(String name, int type, int teaId, int snum) {
        Course a = new Course(courses.size() + 1, name, type, teaId, snum);
        courses.add(a);
    }

    //显示课程
    public void show() {
        for (Course u : courses) {
            u.show();
        }
    }

    //显示课程
    public void show(Vector<Course> a) {
        for (Course u : a) {
            u.show();
        }
    }


    //排序
    public void sort() {
        Vector<Course> cc = new Vector<>();
        for (int j = 0; j < courses.size(); j++) {
            Course i = new Course(0, "0", 0, 0, 10000);
            for (Course u : courses) {
                if (u.sNum < i.sNum && !cc.contains(u)) {
                    i = u;
                }
            }
            cc.add(i);
        }
        show(cc);
    }

    //修改任课教师
    public void modify() {
        show();
        System.out.println("请输入要修改教师课程编号");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("请输入要改为的教师id");
        int b = sc.nextInt();
        int flag = 0;
        for (Course u : courses) {
            if (u.id == a) {
                u.teaId = b;
                for (Teacher v : UserCollection.tea) {
                    if (v.workId == b) {
                        u.teacher = v.name;
                        flag++;
                    }
                }
            }
        }
        if (flag == 0) System.out.println("课程id或教师id输入错误！");
        else show();
    }

    //删除
    public void delete() {
        if (courses.size() == 0) System.out.println("当前无课程，无法删除");
        else {
            show();
            System.out.println("请输入要删除的课程序号");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            for (Course u : courses) {
                if (u.id == a) courses.remove(u);
            }
            for (Course u : courses) {
                if (u.id > a) u.id--;
            }
            /*for (Selection u : Selection.select) {
                if (u.classId == a) Selection.select.remove(u);
            }*/
            Selection.select.removeIf(next -> next.classId == a);
            for (Selection u : Selection.select) {
                if (u.classId > a) u.classId--;
            }
        }
    }

    //课程写入文件
    public static void saveCourse() {
        File file = new File("./Courses.txt");
        try {
            if (!file.exists()) {
                //创建新文件
                file.createNewFile();
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            //遍历列表
            for (int i = 0; i < Courses.courses.size(); i++) {
                out.write(((Course) (Courses.courses.get(i))).toString() + "\r\n");
            }
            out.flush();//压入文件
            out.close();//关闭文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //课程读入文件
    public static void readCourse() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./Courses.txt")));
            String data = null;

            //把属性分别读入到相应的变量中
            while ((data = br.readLine()) != null) {
                String[] ps = data.split(" ");
                int id = Integer.parseInt(ps[0]);
                String name = ps[1];
                int type = Integer.parseInt(ps[2]);
                int teaId = Integer.parseInt(ps[3]);
                int sNum = Integer.parseInt(ps[4]);
                if (type == 0) {
                    int credit = Integer.parseInt(ps[5]);
                    Courses.courses.add(new RequiredCourse(id, name, type, teaId, sNum, credit));
                } else {
                    int maxstu = Integer.parseInt(ps[5]);
                    Courses.courses.add(new ElectiveCourses(id, name, type, teaId, sNum, maxstu));
                }
            }
            br.close();//关闭文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
