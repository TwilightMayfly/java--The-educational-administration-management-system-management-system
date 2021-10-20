import java.util.Scanner;

public class Menu {
    //菜单函数
    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择用户类型：1：管理员，2：学生，3：教师");
        //用户类型选择
        switch (sc.nextInt()) {
            case 1:
                Admin a = new Admin();
                while (a.login() == 0) {
                    System.out.println("管理员密码错误,请选择继续输入密码还是修改用户类型：1：继续输入，2：切换用户类型");
                    int flag = sc.nextInt();
                    if (flag == 2) {
                        menu();
                        return;
                    }
                }
                adminMenu();
                break;
            case 2:
                Student s = new Student();
                while (s.login() == 0) {
                    System.out.println("用户名或密码错误!请选择继续输入密码还是修改用户类型：1：继续输入，2：切换用户类型");
                    int flag = sc.nextInt();
                    if (flag == 2) {
                        menu();
                        return;
                    }
                }
                studentMenu();
                break;
            case 3:
                Teacher t = new Teacher();
                while (t.login() == 0) {
                    System.out.println("用户名或密码错误!请选择继续输入密码还是修改用户类型：1：继续输入，2：切换用户类型");
                    int flag = sc.nextInt();
                    if (flag == 2) {
                        menu();
                        return;
                    }
                }
                teacherMenu();
                break;
            default:
                break;
        }
    }

    //管理员菜单
    public void adminMenu() {
        Scanner sc = new Scanner(System.in);
        int model = 0;
        Courses course = new Courses();
        UserCollection user = new UserCollection();

        boolean judge = true;
        //检测程序是否结束
        while (judge) {
            System.out.println("接下来做什么——0：退出，1：课程新增，2：课程删除，3：显示课程列表，4：按上课人数排序，5：修改任课教师，" +
                    "6：显示学生列表：7：显示教师列表，8：恢复初始密码，9：添加老师或学生，10：删除老师或学生");
            model = sc.nextInt();
            switch (model) {//switch语句选择模式
                case 0://退出
                    judge = false;
                    break;
                case 1://课程新增
                    int flag = 0;
                    do {
                        System.out.println("依次输入名称，类型，教师教工号");
                        course.addcourse();
                        System.out.println("是否继续输入——0：否，1：是");
                        flag = sc.nextInt();
                    } while (flag == 1);
                    break;
                case 2:
                    course.delete();
                    break;
                case 3:
                    course.show();
                    break;
                case 4:
                    course.sort();
                    break;
                case 5:
                    course.modify();
                    break;
                case 6:
                    user.showStudent();
                    break;
                case 7:
                    user.showTeacher();
                    break;
                case 8:
                    user.restoreCipher();
                    break;
                case 9:
                    System.out.println("请输入是要添加学生还是教师：1：学生，2：教师");
                    if (sc.nextInt() == 1) user.addStudent();
                    else user.addTeacher();
                    break;
                case 10:
                    System.out.println("请输入是要删除学生还是教师：1：学生，2：教师");
                    if (sc.nextInt() == 1) user.deleteStudent();
                    else user.deleteTeacher();
                    break;
                default:
                    break;
            }
        }
        System.out.println("成功退出系统");
    }

    //学生菜单
    public void studentMenu() {
        Scanner sc = new Scanner(System.in);
        int model = 0;
        Courses course = new Courses();
        UserCollection user = new UserCollection();
        boolean judge = true;
        while (judge) {//检测程序是否结束
            System.out.println("接下来做什么——0：退出，1：修改登录密码，2：查看所上课程，3：选修课选课");
            model = sc.nextInt();
            switch (model) {
                case 0:
                    judge = false;
                    break;
                case 1:
                    Student.setPassWord(Student.sId);
                    break;
                case 2:
                    Student.lookCourse();
                    break;
                case 3:
                    Student.selectCourse();
                    break;
                default:
                    break;
            }
        }
        System.out.println("成功退出系统");
    }

    public void teacherMenu() {
        Scanner sc = new Scanner(System.in);
        int model = 0;
        Courses course = new Courses();
        UserCollection user = new UserCollection();
        boolean judge = true;
        while (judge) {//检测程序是否结束
            System.out.println("接下来做什么——0：退出，1：修改登录密码，2：查看所授课程，3：查看某门所授课程的上课学生列表");
            model = sc.nextInt();
            switch (model) {
                case 0:
                    judge = false;
                    break;
                case 1:
                    Teacher.setPassWord(Teacher.tId);
                    break;
                case 2:
                    Teacher.lookCourse();
                    break;
                case 3:
                    Teacher.look();
                    break;
                default:
                    break;
            }
        }
        System.out.println("成功退出系统");
    }
}
