import java.util.Vector;

public class ElectiveCourses extends Course {
    int maxNum;//最大人数

    //默认构造函数
    public ElectiveCourses() {
    }

    //构造函数
    public ElectiveCourses(int id, String name, int type, int teaId, int sNum, int maxNum) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.teaId = teaId;
        for (Teacher u : UserCollection.tea) {
            if (u.workId == teaId) this.teacher = u.name;
        }
        this.sNum = sNum;
        this.maxNum = maxNum;


    }

    //显示函数
    public void show() {
        System.out.print(id + "  " + name + "  选修");
        System.out.println("  " + teacher + "  " + sNum + " " + maxNum);
    }

    public String toString() {
        return super.toString() + " " + this.maxNum;
    }
}
