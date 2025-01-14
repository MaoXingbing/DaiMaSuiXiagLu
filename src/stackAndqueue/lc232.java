package stackAndqueue;

import java.util.Stack;

public class lc232 {

    Stack<Integer> satackIn;
    Stack<Integer> stackOut;

    public  lc232(){
        satackIn=new Stack<>();
        stackOut=new Stack<>();
    }

    public void push(int x){
        satackIn.push(x);
    }



    public int pop(){
        dumpstackIn();
        return stackOut.pop();
    }

    public int peek(){
        dumpstackIn();
        return stackOut.peek();
    }
    public boolean empty(){
        return satackIn.isEmpty()&&stackOut.isEmpty();
    }

    private  void dumpstackIn(){
        if (!stackOut.isEmpty()){
            return;
        }
        while (!satackIn.isEmpty()){

            stackOut.push(satackIn.pop());

        }

    }
}
