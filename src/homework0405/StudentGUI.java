package homework0405;

import javax.swing.*;
import java.awt.*;

public class StudentGUI {
    public static void main(String[] args) {
        //		实例化
        new StudentGUI().init_1();
    }

    //	主界面
    public void init_1() {
        //	定义容器
        JFrame MyJFrame = new JFrame("学生信息管理系统");
        //  定义面板
        JPanel MyJpanel[] = new JPanel[5];
        //	窗口大小
        MyJFrame.setBounds(150,150,400, 220);
        //  窗口布局
        MyJFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        //  窗口不可调整
        MyJFrame.setResizable(false);
        //  定义字体
        Font font=new Font("黑体",Font.PLAIN,15);
        //  添加标题
        JLabel MyJlabel = new JLabel("添 加 学 生 信 息");
        MyJlabel.setFont(font);
        MyJpanel[0] = new JPanel();
        MyJpanel[0].add(MyJlabel);
        MyJFrame.add(MyJpanel[0]);

        String s[] = new String[3];
        s[0] = " 学      号：";
        s[1] = " 姓      名：";
        s[2] = " 成      绩：";
        //	标签
        JLabel jlabel[] = new JLabel[3];
        //	文本框
        JTextField jtextfield[] = new JTextField[3];
        //  实例化
        for (int i = 0; i < 3; i++) {
            MyJpanel[i+1] = new JPanel();
            jlabel[i] = new JLabel(s[i]);
            MyJpanel[i+1].add(jlabel[i]);
            jtextfield[i] = new JTextField(30);
            MyJpanel[i+1].add(jtextfield[i]);
        }
        //	按钮
        JButton jbutton_1 = new JButton("添加");
        JButton jbutton_2 = new JButton("保存");
        JButton jbutton_3 = new JButton("排序");
        //  加入按钮
        MyJpanel[4] = new JPanel();
        MyJpanel[4].add(jbutton_1);
        MyJpanel[4].add(jbutton_2);
        MyJpanel[4].add(jbutton_3);
        //  加入组件
        for (int i = 0; i < 5; i++){
            MyJFrame.add(MyJpanel[i]);
        }
        //	窗口显示
        MyJFrame.setVisible(true);
        //	关闭窗口则退出程序
        MyJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //	注册监听
        StudentListen e = new StudentListen(jbutton_1, jbutton_2, jbutton_3, jtextfield);
        jbutton_1.addActionListener(e);
        jbutton_2.addActionListener(e);
        jbutton_3.addActionListener(e);
    }
}