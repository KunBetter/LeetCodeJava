/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {

    // 递归
    // 链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }


    public static void main(String[] args) {
        MergeTwoLists mtl = new MergeTwoLists();
        int[] l1 = new int[]{1, 2, 4};
        int[] l2 = new int[]{1, 3, 4};
        ListNode head1 = ListUtils.newList(l1);
        ListNode head2 = ListUtils.newList(l2);
        ListNode head = mtl.mergeTwoLists(head1, head2);
        System.out.println(head);
    }
}
