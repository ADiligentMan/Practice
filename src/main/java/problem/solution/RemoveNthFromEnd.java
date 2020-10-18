package problem.solution;

/**
 * @author wangpeng
 * @since 2020-10-18
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmpNode  = head;
        for (int i = 0; i < n; i++) {
            tmpNode = tmpNode.next;
        }
        // Have n nodes totally.
        if(tmpNode == null){
            return head.next;
        }

        ListNode nodeBefore = head;
        while(tmpNode.next != null){
            tmpNode = tmpNode.next;
            nodeBefore = nodeBefore.next;
        }

        nodeBefore.next = nodeBefore.next.next;
        return head;
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
