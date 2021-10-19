import javax.sql.rowset.spi.SyncResolver;
import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class UserCollection {
    static Admin admin = new Admin();
    static Vector<Student> stu = new Vector<>();
    static Vector<Teacher> tea = new Vector<>();

    //添加学生
    public void addStudent() {
        System.out.println("请依次输入姓名，密码，学号和班级");
        Scanner sc = new Scanner(System.in);
        Student a = new Student(sc.next(), sc.next(), sc.nextInt(), sc.next());
        stu.add(a);
        showStudent();
    }

    //删除学生
    public void deleteStudent() {
        if (stu.size() == 0) System.out.println("当前无学生，无法删除");
        else {
            showStudent();
            System.out.println("请输入要删除的学生学号");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            Iterator<Student> iterator = stu.iterator();
            while (iterator.hasNext()) {
                Student next = iterator.next();
                if (next.id == a) {
                    iterator.remove();
                }
            }
            showStudent();
        }
    }

    //显示所有学生信息
    public void showStudent() {
        for (Student u : stu) {
            u.show();
        }
    }

    //添加教师
    public void addTeacher() {
        System.out.println("请依次输入姓名，密码，教工号和级别");
        Scanner sc = new Scanner(System.in);
        Teacher a = new Teacher(sc.next(), sc.next(), sc.nextInt(), sc.next());
        tea.add(a);
        showTeacher();
    }

    //删除教师
    public void deleteTeacher() {
        if (tea.size() == 0) System.out.println("当前无教师，无法删除");
        else {
            showTeacher();
            System.out.println("请输入要删除的教师教工号");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            Iterator<Teacher> iterator = tea.iterator();
            while (iterator.hasNext()) {
                Teacher next = iterator.next();
                if (next.workId == a) {
                    iterator.remove();
                }
            }
        }
    }

    //显示所有教师信息
    public void showTeacher() {
        for (Teacher u : tea) {
            u.show();
        }
    }

    //重置密码
    public void restoreCipher() {
        System.out.println("请输入需要重置学生还是教师：1：学生，2：教师");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a == 1) {
            System.out.println("请输入学生id");
            int b = sc.nextInt();
            for (Student u : stu) {
                if (u.id == b) u.pass = "123456";
            }
        } else {
            System.out.println("请输入教师id");
            int b = sc.nextInt();
            for (Teacher u : tea) {
                if (u.workId == b) u.pass = "123456";
            }
        }
        System.out.println("重置完成");
    }

    //学生读入文件
    public static void readStudent() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./Student.txt")));
            String data = null;

            //把属性分别读入到相应的变量中
            while ((data = br.readLine()) != null) {
                String[] ps = data.split(" ");
                String name = ps[0];
                String pass = ps[1];
                int id = Integer.parseInt(ps[2]);
                String Class = ps[3];
                UserCollection.stu.add(new Student(name, pass, id, Class));
            }
            br.close();//关闭文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //教师读入文件
    public static void readTeacher() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./Teacher.txt")));
            String data = null;

            //把属性分别读入到相应的变量中
            while ((data = br.readLine()) != null) {
                String[] ps = data.split(" ");
                String name = ps[0];
                String pass = ps[1];
                int workId = Integer.parseInt(ps[2]);
                String level = ps[3];
                UserCollection.tea.add(new Teacher(name, pass, workId, level));
            }
            br.close();//关闭文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveStudent() {
        File file = new File("./Student.txt");
        try {
            if (!file.exists()) {
                //创建新文件
                file.createNewFile();
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            //遍历列表
            for (int i = 0; i < UserCollection.stu.size(); i++) {
                out.write(((Student) (UserCollection.stu.get(i))).toString() + "\r\n");
            }
            out.flush();//压入文件
            out.close();//关闭文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveTeacher() {
        File file = new File("./Teacher.txt");
        try {
            if (!file.exists()) {
                //创建新文件
                file.createNewFile();
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            //遍历列表
            for (int i = 0; i < UserCollection.tea.size(); i++) {
                out.write(((Teacher) (UserCollection.tea.get(i))).toString() + "\r\n");
            }
            out.flush();//压入文件
            out.close();//关闭文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
