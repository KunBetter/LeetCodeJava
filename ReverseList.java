/**
 * 翻转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode next = cur.next;
        ListNode pre = null;

        while (next != null) {
            ListNode nextNext = next.next;
            next.next = cur;
            cur.next = pre;

            pre = cur;
            cur = next;
            next = nextNext;
        }

        return cur;
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
        ReverseList rl = new ReverseList();
        int[] list = new int[]{1, 2, 3, 4, 5};

        ListNode listNode = newList(list);

        ListNode head = rl.reverseList(listNode);
        System.out.println(head);
    }
}
