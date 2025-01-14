package 牛客;

import java.util.Scanner;

public class 最少胜利题数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(functin01(s1,s2));

    }

    private static int functin01(String s1, String s2) {
        if (s1.length()==6  || s2.length()==6){
            return -1;
        }else{
            return Math.abs(s1.length()-s2.length())+1;
        }
    }
}
