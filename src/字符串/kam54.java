package 字符串;

import java.util.Scanner;

public class kam54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverse(s));
    }

    private static String reverse(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                result.append("number");
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
