/**
 * 【两数相加】
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        // 每位数字都是按照 逆序 的方式存储的，所有是左对齐的
        ListNode l1_ptr = l1;
        ListNode l2_ptr = l2;

        // 相加之后的个位数
        int addedNum = 0;
        // 进位
        int addToNext = 0;

        ListNode preHead = new ListNode(-1);
        // 🔥 难点
        ListNode ptr = preHead;

        while (l1_ptr != null && l2_ptr != null) {
            int added = l1_ptr.val + l2_ptr.val + addToNext;
            addedNum = added % 10;
            addToNext = added / 10;

            // 🔥 难点
            ptr.next = new ListNode(addedNum);

            l1_ptr = l1_ptr.next;
            l2_ptr = l2_ptr.next;
            ptr = ptr.next;
        }

        while (l1_ptr != null) {
            int added = l1_ptr.val + addToNext;
            addedNum = added % 10;
            addToNext = added / 10;

            ptr.next = new ListNode(addedNum);

            l1_ptr = l1_ptr.next;
            ptr = ptr.next;
        }

        while (l2_ptr != null) {
            int added = l2_ptr.val + addToNext;
            addedNum = added % 10;
            addToNext = added / 10;

            ptr.next = new ListNode(addedNum);

            l2_ptr = l2_ptr.next;
            ptr = ptr.next;
        }

        if (addToNext > 0) {
            ptr.next = new ListNode(addToNext);
        }

        return preHead.next;
    }
}
