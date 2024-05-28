/**
 * 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class GetIntersectionNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 哈希表
    // 链表
    // 双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        // 让2个指针走一样的距离，消除步行差，那就一定可以一起走到相交点
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    private static ListNode newList(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode ptr = head;

        int i = 1;
        while (i < nums.length) {
            ListNode curNode = new ListNode(nums[i]);
            ptr.next = curNode;
            ptr = curNode;
            i++;
        }

        return head;
    }

    public static void main(String[] args) {
        GetIntersectionNode in = new GetIntersectionNode();
        int[] listA = new int[]{4, 1, 8, 4, 5};
        int[] listB = new int[]{5, 6, 1, 8, 4, 5};

        ListNode listAHead = newList(listA);
        ListNode listBHead = newList(listB);

        ListNode intersectionNode = in.getIntersectionNode(listAHead, listBHead);
        System.out.println(intersectionNode);
    }
}
