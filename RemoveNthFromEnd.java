/**
 * 删除链表的倒数第N个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {

    // 链表
    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 前缀结点
        // 快慢指针
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
