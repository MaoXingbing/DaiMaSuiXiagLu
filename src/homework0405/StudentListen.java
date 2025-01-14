package homework0405;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

//  创建鼠标监听类
public class StudentListen implements ActionListener {
    JButton jbutton_1;
    JButton jbutton_2;
    JButton jbutton_3;
    JTextField jtextfield[];

    public StudentListen(JButton jbutton_1, JButton jbutton_2, JButton jbutton_3, JTextField[] jtextfield) {    //构造函数，传入监听信息
        this.jbutton_1=jbutton_1;
        this.jbutton_2=jbutton_2;
        this.jbutton_3=jbutton_3;
        this.jtextfield=jtextfield;
    }

    //  创建两个存入的文件
    File StudentFile=new File("D:\\Homework4\\homework4\\src\\homework0405\\Student.txt");
    File SortFile=new File("D:\\Homework4\\homework-4\\src\\homework0405\\Sort.txt");

    @Override
    public void actionPerformed(ActionEvent e) {
//		点击了提交按钮
        if(e.getSource()==jbutton_1) {
//			判断标志
            boolean mark = false;
//			判断学号是否重复
            int k=0;
            for(k = 0;k < StudentInformation.all_student.size(); k++) {
                if(jtextfield[0].getText().equals(StudentInformation.all_student.get(k).get_ID())) {
//					学号重复
                    mark = false;
//					提示
                    JOptionPane.showMessageDialog(jbutton_1, "学号重复！\n添加学生失败！","消息提示",JOptionPane.WARNING_MESSAGE);
                    break;
                }
            }
            if(k == StudentInformation.all_student.size()) {
                mark = true;
            }
//			mark=true则添加学生信息
            if(mark) {
                StudentInformation student=new StudentInformation(jtextfield[0].getText(), jtextfield[1].getText(), Double.parseDouble(jtextfield[2].getText()));
//				将学生对象加入总对象中
                StudentInformation.all_student.add(student);
                JOptionPane.showMessageDialog(jbutton_1, "添加学生成功！！！", "提示",JOptionPane.PLAIN_MESSAGE);
            }
            for(int i = 0; i < jtextfield.length; i++) {
                jtextfield[i].setText("");
            }
        }
        //  点了保存按钮
        else if(e.getSource()==jbutton_2){
            //建立输出
            FileOutputStream out=null;
            try {
                out =new FileOutputStream(StudentFile);
                String student;
                for(int i=0; i < StudentInformation.all_student.size(); i++) {
                    //创建缓冲区,写入数据
                    student =StudentInformation.all_student.get(i).get_ID()+"   ";
                    byte buffer[] =student.getBytes();
                    out.write(buffer);
                    student =StudentInformation.all_student.get(i).get_Name()+"   ";
                    byte buffer1[] = student.getBytes();
                    out.write(buffer1);
                    student =StudentInformation.all_student.get(i).get_Score()+"   ";
                    byte buffer2[] = student.getBytes();
                    out.write(buffer2);
                    //换行
                    out.write('\n');
                }
                JOptionPane.showMessageDialog(null, "保存成功！", "提示",JOptionPane.PLAIN_MESSAGE);
            }catch (Exception ex) {
                ex.printStackTrace();
            }finally {
                try {
                    if(out!=null) {
                        out.close();
                    }
                }
                catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        //  点了排序按钮
        else if(e.getSource()==jbutton_3){
            BufferedReader br= null;//打开一个输入流，然后准备读入数据
            try {
                br = new BufferedReader(new FileReader(StudentFile));
                String line=null; //读入的每行
                while((line=br.readLine())!=null){  //如果不是什么都没有就进行处理
                    String[] elements=line.split("   ");  //使用split函数对于读到的文本进行处理
                    StudentInformation student=new StudentInformation(elements[0],elements[1],Double.parseDouble(elements[2]));//构造学生，添加学生信息
                    StudentInformation.sort_student.add(student);//添加学生信息
                }
                br.close();//关闭读入流
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            //  冒泡排序
            StudentInformation Student;
            for(int i = 0; i<StudentInformation.sort_student.size()-1; i++) {
                for(int j = 0; j<StudentInformation.sort_student.size()-1; j++) {
                    if(StudentInformation.sort_student.get(j).get_Score() < StudentInformation.sort_student.get(j+1).get_Score()) {
                        Student = StudentInformation.sort_student.get(j);
                        StudentInformation.sort_student.set(j, StudentInformation.sort_student.get(j+1));
                        StudentInformation.sort_student.set(j+1, Student);
                    }
                }
            }

            // 找出最大值 最小值  并计算平均值
            double average, sum =0.0 ;
            double max = StudentInformation.sort_student.get(0).get_Score(),
                    min = StudentInformation.sort_student.get(0).get_Score();
            for(int i = 0; i < StudentInformation.sort_student.size(); i++) {
                sum += StudentInformation.sort_student.get(i).get_Score();
                if(StudentInformation.sort_student.get(i).get_Score() > max){
                    max = StudentInformation.sort_student.get(i).get_Score();
                }
                if(StudentInformation.sort_student.get(i).get_Score() < min){
                    min = StudentInformation.sort_student.get(i).get_Score();
                }
            }
            average = sum / StudentInformation.sort_student.size();

            //  把排序好的数据存入新文件
            FileOutputStream Out = null;
            try {
                Out =new FileOutputStream(SortFile);
                String student;
                for(int i=0; i < StudentInformation.sort_student.size(); i++) {
                    //创建缓冲区,写入数据
                    student =StudentInformation.sort_student.get(i).get_ID()+"   ";
                    byte buffer[] =student.getBytes();
                    Out.write(buffer);
                    student =StudentInformation.sort_student.get(i).get_Name()+"   ";
                    byte buffer1[] = student.getBytes();
                    Out.write(buffer1);
                    student =StudentInformation.sort_student.get(i).get_Score()+"   ";
                    byte buffer2[] = student.getBytes();
                    Out.write(buffer2);
                    //换行
                    Out.write('\n');
                }
                //换行
                Out.write('\n');
                Out.write('\n');
                String explain = "平均分 ：" + average + "  "  + "最大值 ： " + max + " " + "最小值 ： " + min;
                byte buf[] =explain.getBytes();
                Out.write(buf);

                JOptionPane.showMessageDialog(null,"排序成功！","提示",JOptionPane.PLAIN_MESSAGE);
            }catch (Exception ex) {
                ex.printStackTrace();
            }finally {
                try {
                    if(Out!=null) {
                        Out.close();
                    }
                }
                catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

