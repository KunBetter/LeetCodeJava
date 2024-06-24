/**
 * 【K个一组翻转链表】
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class LC_25_ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 先进行丈量
        ListNode ptr = head;
        int i = 0;
        while (i < k - 1) {
            if (ptr.next == null) {
                break;
            }
            ptr = ptr.next;
            i++;
        }

        if (i != k - 1) {
            return head;
        }

        // 重点
        ListNode nextKHead = ptr.next;

        // 翻转
        ListNode cur = head;
        ListNode pre = null;
        while (cur != nextKHead) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 重点
        head.next = reverseKGroup(nextKHead, k);

        return ptr;
    }
}
