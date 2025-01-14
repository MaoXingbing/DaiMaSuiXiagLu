package 字符串;

public class lc541 {
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i=0;i< chars.length;i+=2*k){
            if (i+k<=chars.length){
                reverse(chars,i,i+k-1);
            }else{
                reverse(chars,i,chars.length-1);
            }

        }

        return new String(chars);
    }

    private static void reverse(char[]chars, int i, int end) {
        while (i<end){
            char temp=chars[i];
            chars[i]=chars[end];
            chars[end]=temp;
            end--;
            i++;
        }
    }
}
