public class RequiredCourse extends Course {
    int credit;//学分

    //默认构造函数
    public RequiredCourse() {
    }

    //构造函数
    public RequiredCourse(int id, String name, int type, int teaId, int sNum, int credit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.teaId = teaId;
        for (Teacher u : UserCollection.tea) {
            if (u.workId == teaId) this.teacher = u.name;
        }
        this.sNum = sNum;
        this.credit = credit;
    }

    //显示函数
    public void show() {    //显示
        System.out.print(id + "  " + name + "  必修");
        System.out.println("  " + teacher + "  " + sNum + " " + credit);
    }

    public String toString() {
        return super.toString() + " " + this.credit;
    }
}
