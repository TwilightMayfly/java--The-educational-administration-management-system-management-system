import java.io.*;
import java.util.Vector;

public class Selection {
    public int classId;
    public int stuId;
    public int teaId;
    public static Vector<Selection> select = new Vector<>();

    Selection() {
    }

    Selection(int a, int b, int c) {
        this.classId = a;
        this.stuId = b;
        this.teaId = c;
    }

    public static void readSelection() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./Selection.txt")));
            String data = null;

            //把属性分别读入到相应的变量中
            while ((data = br.readLine()) != null) {
                String[] ps = data.split(" ");
                int classId = Integer.parseInt(ps[0]);
                int stuId = Integer.parseInt(ps[1]);
                int teaId = Integer.parseInt(ps[2]);
                Selection.select.add(new Selection(classId, stuId, teaId));
            }
            br.close();//关闭文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveSelection() {
        File file = new File("./Selection.txt");
        try {
            if (!file.exists()) {
                //创建新文件
                file.createNewFile();
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            //遍历列表
            for (int i = 0; i < Selection.select.size(); i++) {
                out.write(Selection.select.get(i).toString() + "\r\n");
            }
            out.flush();//压入文件
            out.close();//关闭文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return classId + " " + stuId + " " + teaId;
    }
}
