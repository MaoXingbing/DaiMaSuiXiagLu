package kmp;

import java.util.Scanner;

public class GetNext {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();

        int[] next = getNext(s);
        for (int i : next) {
            System.out.print(i);
        }
    }

    private static int[] getNext(String s) {
        int next[]=new int[s.length()];
        next[0]=0;
        int j=0;
        for (int i = 1; i < s.length(); i++) {
            while (j>0 && s.charAt(j)!=s.charAt(i)){
                j=next[j-1];
            }
            if (s.charAt(j)==s.charAt(i)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
