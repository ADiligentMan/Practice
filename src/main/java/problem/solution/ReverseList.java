package problem.solution;


import problem.solution.model.ListNode;

/**
 * @author wangpeng
 * @since 2021-02-03
 */
public class ReverseList {

    public ListNode revere(ListNode root, int idx1, int idx2) {
        ListNode preTail = null;
        ListNode backHead = null;
        
        ListNode curr = root;
        for (int i = 0; i <= idx2; i++) {
            if(i == idx2 ){
                backHead = curr.next;
                curr.next = null;
            }
            if (i == idx1 - 1) {
                preTail = curr;
            }
            curr = curr.next;
        }
        ListNode midTail = preTail == null ? root:preTail.next;
        ListNode midHead = reverseAll(midTail);

        midTail.next = backHead;
        if(preTail != null){
           preTail.next = midHead;
        }

        return root;
    }

    private ListNode reverseAll(ListNode ListNode) {
        ListNode pre = null;
        ListNode curr = ListNode;
        while (curr != null) {
            ListNode nextCurr = ListNode.next;
            curr.next = pre;
            pre = curr;
            curr = nextCurr;
        }
        return pre;
    }
}


