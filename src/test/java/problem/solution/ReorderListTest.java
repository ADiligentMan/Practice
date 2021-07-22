package problem.solution;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import problem.solution.model.ListNode;

class ReorderListTest {

    /**
     * 偶数个
     */
    @Test
    void reorderList1() {
        ReorderList reorderListTest = new ReorderList();
        ListNode head = new ListNode(1);
        ListNode tmpNode = head;
        for (int i = 2; i < 5; i++) {
            tmpNode.next = new ListNode(i);
            tmpNode = tmpNode.next;
        }

        reorderListTest.reorderList(head);
        boolean result = true;
        tmpNode = head;
        int[] resultArr = {1, 4, 2, 3};
        for (int i = 0; i < 4; i++) {
            if (tmpNode.value != resultArr[i]){
                result = false;
                break;
            }
            tmpNode = tmpNode.next;
        }

        Assert.assertTrue(result);
    }

    /**
     * 奇数个
     */
    @Test
    void reorderList2() {
        ReorderList reorderListTest = new ReorderList();
        ListNode head = new ListNode(1);
        ListNode tmpNode = head;
        for (int i = 2; i < 6; i++) {
            tmpNode.next = new ListNode(i);
            tmpNode = tmpNode.next;
        }

        reorderListTest.reorderList(head);
        boolean result = true;
        tmpNode = head;
        int[] resultArr = {1,5,2,4,3};
        for (int i = 0; i < 5; i++) {
            if (tmpNode.value != resultArr[i]){
                result = false;
                break;
            }
            tmpNode = tmpNode.next;
        }

        Assert.assertTrue(result);
    }
}