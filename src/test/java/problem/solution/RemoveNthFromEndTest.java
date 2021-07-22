package problem.solution;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import problem.solution.model.ListNode;

class RemoveNthFromEndTest {
    /**
     * 移除倒数第二个
     */
    @Test
    public void test1() {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode head = getHead();
        ListNode newHead = removeNthFromEnd.removeNthFromEnd(head, 2);

        //not contains 4
        Assert.assertTrue(validate(newHead,4));
    }

    /**
     * 移除倒数第一个
     */
    @Test
    public void test2() {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode head = getHead();
        ListNode newHead = removeNthFromEnd.removeNthFromEnd(head, 1);

        //not contains 5
        Assert.assertTrue(validate(newHead,5));
    }

    /**
     * 移除倒数最后一个
     */
    @Test
    public void test3() {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode head = getHead();
        ListNode newHead = removeNthFromEnd.removeNthFromEnd(head, 6);

        //not contains 6
        Assert.assertTrue(validate(newHead,0));
    }



    private ListNode getHead() {
        ListNode head = new ListNode(0);
        ListNode tmpNode = head;
        for (int i = 1; i < 6; i++) {
            tmpNode.next = new ListNode(i);
            tmpNode = tmpNode.next;
        }
        return head;
    }

    private boolean validate(ListNode head, int nodeNotContained) {
        ListNode tmpNode = head;
        while (tmpNode != null) {
            if(tmpNode.value == nodeNotContained){
                return false;
            }
            tmpNode = tmpNode.next;
        }
        return true;
    }
}