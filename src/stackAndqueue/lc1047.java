package stackAndqueue;

import java.util.Stack;

public class lc1047 {
    public String removeDuplicates(String S){
        Stack<Character> stack=new Stack<>();
        String str="";
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (stack.isEmpty() || stack.peek()!=c){
                stack.push(c);
            }else {
                stack.pop();
            }
        }
        while (!stack.isEmpty()){
            str=stack.pop()+str;
        }
        return str;
    }
}
