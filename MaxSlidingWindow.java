import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class MaxSlidingWindow {
    // 队列
    // 数组
    // 滑动窗口
    // 单调队列
    // 堆（优先队列）

    // 单调队列的基本思想是，维护一个双向队列（deque），遍历序列，仅当一个元素可能成为某个区间最值时才保留它。
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();

        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        if (!deque.isEmpty()) {
            res[0] = deque.getFirst();
        }

        for (int i = k; i < nums.length; i++) {
            if (deque.getFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);

            if (!deque.isEmpty()) {
                res[i - k + 1] = deque.getFirst();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MaxSlidingWindow msw = new MaxSlidingWindow();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] cnt = msw.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(cnt));

        nums = new int[]{1, 3, 1, 2, 0, 5};
        k = 3;
        cnt = msw.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(cnt));
    }
}
