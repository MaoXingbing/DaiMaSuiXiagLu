package 字符串;

import java.util.Scanner;

public class kam55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();

        int len = s.length();  //获取字符串长度
        char[] chars = s.toCharArray();
        reverseString(chars, 0, len - 1);  //反转整个字符串
        reverseString(chars, 0, n - 1);  //反转前一段字符串，此时的字符串首尾尾是0,n - 1
        reverseString(chars, n, len - 1);  //反转后一段字符串，此时的字符串首尾尾是n,len - 1

        System.out.println(chars);

    }

    public static void reverseString(char[] ch, int start, int end) {
        //异或法反转字符串，参照题目 344.反转字符串的解释
        while (start < end) {
            ch[start] ^= ch[end];
            ch[end] ^= ch[start];
            ch[start] ^= ch[end];
            start++;
            end--;
        }
    }
   /* public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.nextLine();

        System.out.println(functon(n,str));

    }

    //事件超时
    private static String functon(int n, String str) {
        StringBuilder sb=new StringBuilder();
        sb.append(str.substring(str.length()-n));
        sb.append(str.substring(0,str.length()-n));
        String s = sb.toString();
        String resl = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==32){  //空格的码表是32
                continue;
            }
            resl+=s.charAt(i);
        }
        return  resl;
    }*/
}
