public class ListUtils {

    public static ListNode newList(int[] nums) {
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
}
