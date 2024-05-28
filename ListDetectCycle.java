/**
 * 环形链表II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class ListDetectCycle {

    // 哈希表
    // 链表
    // 双指针
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        // 🔥快慢指针
        ListNode fast = head;
        ListNode slow = fast;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                // 🔥从相遇点到入环点的距离加上 n−1圈的环长，恰好等于从链表头部到入环点的距离。
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }

    public static void main(String[] args) {
    }
}
