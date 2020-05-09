package problem.solution; /**
 * @Author: wangpeng
 * @Date: 2020-03-02 09:44
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class ReverserLinkedList {
    public ListNode reverseList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        //store into arraylist
        ListNode it = head ;
        while(it != null){
            list.add(it);
            ListNode listNode = it.next;
            it.next = null;
            it = listNode;


        }

        //read from list reversely
        int size = list.size();
        head = list.get(--size);
        it = head ;
        for(int i = --size ; i > -1 ;i-- ){
            it .next = list.get(i);
            it = it.next;
        }

        return head;
    }

    public static   void  printLinkedList(ListNode head){
        ListNode it = head;
        while(null != it ){
            System.out.print(it.val+",");
            it = it.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode it = head;
        for(int i = 2 ; i <5; i++){
            it.next = new ListNode(i);
            it = it.next;
        }
        printLinkedList(head);
        head = new ReverserLinkedList().reverseList(head);
        printLinkedList(head);
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
