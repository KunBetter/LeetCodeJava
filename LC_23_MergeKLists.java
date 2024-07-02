/**
 * 【合并K个升序链表】
 */
public class LC_23_MergeKLists {

    // 链表
    // 分治
    // 堆（优先队列）
    // 归并排序

    /*******************************************************************/
    /*******************************************************************/
    /*******************************************************************/
    // 分治合并
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        int n = lists.length;
        if (n == 0) {
            return null;
        } else if (n == 1) {
            return lists[0];
        } else if (n == 2) {
            return merge2Lists(lists[0], lists[1]);
        }

        int leftPartSize = n / 2;
        int rightPartSize = n - n / 2;

        ListNode[] leftPart = new ListNode[leftPartSize];
        ListNode[] rightPart = new ListNode[rightPartSize];

        for (int i = 0; i < leftPartSize; i++) {
            leftPart[i] = lists[i];
        }

        for (int i = 0; i < rightPartSize; i++) {
            rightPart[i] = lists[i + leftPartSize];
        }

        ListNode leftAns = mergeKLists(leftPart);
        ListNode rightAns = mergeKLists(rightPart);

        return merge2Lists(leftAns, rightAns);
    }

    /*******************************************************************/
    /*******************************************************************/
    /*******************************************************************/

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        int n = lists.length;
        if (n == 0) {
            return null;
        } else if (n == 1) {
            return lists[0];
        } else if (n == 2) {
            return merge2Lists(lists[0], lists[1]);
        }

        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        // 加速
        if (left + 1 == right) {
            return merge2Lists(lists[left], lists[right]);
        }

        if (left > right) {
            return null;
        }

        int mid = (left + right) >> 1;

        ListNode leftAns = merge(lists, left, mid);
        ListNode rightAns = merge(lists, mid + 1, right);

        return merge2Lists(leftAns, rightAns);
    }

    /*******************************************************************/
    /*******************************************************************/
    /*******************************************************************/

    private ListNode merge2Lists(ListNode a, ListNode b) {
        ListNode preHead = new ListNode();
        ListNode cur = preHead;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }

        if (a != null) {
            cur.next = a;
        }

        if (b != null) {
            cur.next = b;
        }

        return preHead.next;
    }
}
