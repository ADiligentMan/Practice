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
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        return  prev;
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
        head = new ReverseLinkedList().reverseList(head);
        printLinkedList(head);
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
