package problem.solution;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import problem.solution.model.ListNode;
import uil.PrintUtil;

public class ReverseListTest {
    @Test
    public void test1() {
        ReverseList reverseList = new ReverseList();
        ListNode root = new ListNode(0);
        ListNode curr = root;
        for (int i = 1; i < 8; i++) {
            ListNode listNode = new ListNode(i);
            curr.next = listNode;
            curr = curr.next;
        }

        root = reverseList.revere(root, 3, 4);
        String result = PrintUtil.printLinkedList(root);
        Assert.assertEquals(result,"0,1,2,4,3,5,6,7,");

    }

    @Test
    public void test2() {
        ReverseList reverseList = new ReverseList();
        ListNode root = new ListNode(0);
        ListNode curr = root;
        for (int i = 1; i < 8; i++) {
            ListNode listNode = new ListNode(i);
            curr.next = listNode;
            curr = curr.next;
        }

        root = reverseList.revere(root, 0, 4);
        String result = PrintUtil.printLinkedList(root);
        Assert.assertEquals("0,1,2,3,4,5,6,7,",result);

    }




}