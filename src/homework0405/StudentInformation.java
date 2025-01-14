package homework0405;

import java.util.ArrayList;

//定义学生类
public class StudentInformation {
    //	存储学生总人数
    public static ArrayList<StudentInformation> all_student=new ArrayList<>();
    //  存储排序后的数据
    public static ArrayList<StudentInformation> sort_student=new ArrayList<>();

    private  String ID;//学号
    private  String Name;//姓名
    private  double Score;//成绩

    //用于实例化
    public StudentInformation() {
    }

    public StudentInformation(String ID,String Name,double Score) {
        this.ID=ID;
        this.Name=Name;
        this.Score=Score;
    }


    //获得数据
    public String get_ID() {
        return ID;
    }
    public String get_Name() {
        return Name;
    }
    public double get_Score() {
        return Score;
    }
}