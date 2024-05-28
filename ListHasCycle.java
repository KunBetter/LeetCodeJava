/**
 * 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class ListHasCycle {

    // 哈希表
    // 链表
    // 双指针
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        // 🔥快慢指针
        ListNode fast = head;
        ListNode slow = fast;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListHasCycle lhc = new ListHasCycle();
        int[] nums = new int[]{3, 2, 0, -4, 2};
        ListNode head = ListUtils.newList(nums);
        boolean res = lhc.hasCycle(head);
        System.out.println(res);
    }
}
