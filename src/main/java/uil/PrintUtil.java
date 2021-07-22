package uil;

import problem.solution.model.ListNode;

/**
 * @author wangpeng
 * @since 2021-02-03
 */
public class PrintUtil {
    public static String printLinkedList(ListNode node) {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode curr = node;

        while (curr != null) {
            stringBuilder.append(curr.value).append(",");
            curr = curr.next;
        }
        return stringBuilder.toString();
    }

}
