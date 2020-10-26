package problem.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangpeng
 * @since 2020-10-21
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        List<ListNode> array = storeList2Array(head);

        ListNode tmpNode = new ListNode();
        tmpNode.next = new ListNode();
        tmpNode.next.next = head;
        for (int i = 0; i < array.size()/2; i++) {
            tmpNode = tmpNode.next.next;
            array.get(i).next = tmpNode.next;
            tmpNode.next = array.get(i);
        }
        if(array.size()%2 == 0){
            tmpNode.next.next = null;
        }else{
            tmpNode.next.next.next = null;
        }
    }

    public List<ListNode> storeList2Array(ListNode head) {
        ListNode tmpNode = head;
        // 为什么要使用LinkedList? 因为不需要考虑扩容
        List<ListNode> array = new LinkedList<>();
        while (tmpNode != null) {
            array.add(0, tmpNode);
            tmpNode = tmpNode.next;
        }
        return array;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


