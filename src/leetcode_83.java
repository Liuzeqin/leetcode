import java.util.List;

public class leetcode_83 {
    /**
     * 题目：去除排序链表重复元素
     */


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null) {
            ListNode cur = node;
            while(cur.next != null && cur.next.val == node.val) cur = cur.next;
            node.next = cur.next;
            node = node.next;
        }
        return head;
    }
}
