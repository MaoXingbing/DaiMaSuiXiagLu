package kmp;

import java.util.Scanner;

public class lc28 {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String haystack = sc.nextLine();
    String needle = sc.nextLine();

    int[] next = getNext(needle);
    System.out.println(function(next,haystack,needle));

  }

  private static int function(int[] next, String haystack, String needle) {
    int j=0;
    for (int i = 0; i < haystack.length(); i++) {
      while(j>0&&needle.charAt(j)!=haystack.charAt(i)){
        j=next[j-1];
      }
      if (needle.charAt(j)==haystack.charAt(i)){
        j++;
      }
      if (j==needle.length()){
        return i-needle.length()+1;
      }
    }
    return -1;


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
