package stackAndqueue;

import java.util.Stack;

public class lc20 {
    public boolean isval(String s){

        Stack<Character> stack=new Stack<>();
        if (s.length()%2!=0){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='('){
                stack.push(')');
            }else if (c=='{'){
                stack.push('}');
            }else if (c=='['){
                stack.push(']');
            }else if (stack.isEmpty() || stack.peek()!=c){ //
                return false;
            }else {
                //遇到有括号而且相同
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
