import javax.xml.bind.ValidationEvent;
import java.util.Scanner;
import java.util.Vector;

/*作业：在两次实验内容和工程的基础上实现学生选课系统，具体要求如下：
        1. 系统分为管理员（唯一一个），教师，学生三类用户，实现其三者的登录功能（验证密码）。
        2. 管理员包括功能：添加课程、删除课程、按照选课人数排序，显示课程清单，修改授课教师，显示学生列表、
        显示教师列表，恢复学生和教师初始密码（初始密码为：123456）,添加老师和学生，删除老师和学生。
        3. 教师包括功能：修改登录密码，查看自己所授课程，查看某门所授课程的上课学生列表。
        4. 学生包括功能：修改登录密码，查看自己所上课程，选修课选课。
        5. 课程包括选修课和必修课，必修课的学生所有学生上课，选修课设置最大选课人数属性，在学生选课时进行验
        证。
        6. 课程、教师、学生信息，学生选课信息要求存储在文件里，在下次系统运行时从文件中读取作为系统的基础运
        行数据。
        7. 建立一个菜单，接收不同用户登录系统，并且提供不同用户的功能选择菜单。*/
public class Main {
    public static void main(String[] args) {
        Selection.readSelection();
        UserCollection.readTeacher();
        Courses.readCourse();
        UserCollection.readStudent();
        Menu m = new Menu();
        m.menu();//菜单
        Courses.saveCourse();
        UserCollection.saveStudent();
        UserCollection.saveTeacher();
        Selection.saveSelection();
    }
}