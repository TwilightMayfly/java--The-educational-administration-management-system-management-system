public class Course {
    int id;         //课程编号
    String name;    //课程名称
    int type;       //0为必修，1为选修
    String teacher; //任课教师
    int teaId;
    int sNum;

    public Course(int id, String name, int type, int teaId, int sNum) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.teaId = teaId;
        for (Teacher u : UserCollection.tea) {
            if (u.workId == teaId) this.teacher = u.name;
        }
        this.sNum = sNum;
    }

    public Course() {
    }

    public void show() {    //显示

        System.out.print(id + "  " + name + "  ");
        switch (type) {
            case 0:
                System.out.print("  必修");
                break;
            case 1:
                System.out.print("  选修");
                break;
            default:
                System.out.print("  其他");
        }
        System.out.println("  " + teacher + "  " + sNum);
    }

    public String toString() {
        return id + " " + name + " " + type + " " + teaId + " " + sNum;
    }


}