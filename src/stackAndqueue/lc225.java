package stackAndqueue;

import java.util.LinkedList;
import java.util.Queue;

public class lc225 {
    Queue<Integer> queueIn;

    public lc225() {
        queueIn = new LinkedList<>();
    }
    public void push(int x){
        queueIn.add(x);
    }

    public int pop(){
        rePostion();
        return queueIn.poll();
    }

    public int top(){
        rePostion();
        int result = queueIn.poll();
        queueIn.add(result);
        return result;
    }

    public boolean empty(){
        return queueIn.isEmpty();
    }


    public void rePostion(){
        int size = queueIn.size();
        size--;
        while (size-->0){
            Integer poll = queueIn.poll();
            queueIn.add(poll);
        }
    }

}
