import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: wangpeng
 * @Date: 2020-03-01 22:33
 */
public class QueueStackImp {

    private Queue<Integer> queueA = new LinkedList<>();
    private Queue<Integer> queueB = new LinkedList<>();


    /** Initialize your data structure here. */
    public QueueStackImp() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queueA.isEmpty()){
            queueB.add(x);
        }else{
            queueA.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       if(queueA.isEmpty()){
           return transfer(queueB ,queueA , false);
       }else{
           return transfer(queueA , queueA , false);
       }
    }

    /** Get the top element. */
    public int top() {
        if(queueA.isEmpty()){
            return transfer(queueB ,queueA , true);
        }else{
            return transfer(queueA , queueA , true);
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return  queueA.isEmpty()&&queueB.isEmpty();
    }

    private Integer transfer(Queue a ,Queue b ,boolean lastTransfer){
        int length = a.size();
        length --;
        for(int i  = 0 ; i< length ; i++){
            b.add(a.poll());
        }
        Integer  ele = (Integer)a.poll();

        if(lastTransfer){
            b.add(ele);
        }
        return ele;
    }


}
