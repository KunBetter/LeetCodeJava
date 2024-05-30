/**
 * 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class SortList {

    // 链表
    // 双指针
    // 分治
    // 排序
    // 归并排序
    public ListNode sortList(ListNode head) {
        // 时间复杂度是O(nlogn) 的排序算法包括归并排序、堆排序和快速排序。
        if (head == null || head.next == null) {
            return head;
        }

        // 归并排序
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(fast);

        ListNode vHead = new ListNode(-1);
        ListNode cur = vHead;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;

        return vHead.next;
    }
}
