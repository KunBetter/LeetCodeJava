/**
 * 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class FindKthLargest {

    // 数组
    // 分治
    // 快速选择
    // 排序
    // 堆（优先队列）
    public int findKthLargest(int[] nums, int k) {
        return findK(nums, k, 0, nums.length - 1);
    }

    private int findK(int[] nums, int k, int s, int e) {
        if (s >= e) {
            if (s == nums.length - k) {
                return nums[s];
            }
            return -1;
        }
        int pos = kPos(nums, s, e);
        if (pos == nums.length - k) {
            return nums[pos];
        } else if (pos < nums.length - k) {
            return findK(nums, k, pos + 1, e);
        } else {
            return findK(nums, k, s, pos - 1);
        }
    }

    private int kPos(int[] nums, int s, int e) {
        int pivot = nums[e];
        int pos = s - 1;
        int i = s;

        while (i <= e) {
            // 一直与支点进行对比
            if (nums[i] <= pivot) {
                int tmp = nums[pos + 1];
                nums[pos + 1] = nums[i];
                nums[i] = tmp;
                pos++;
            }
            i++;
        }

        return pos;
    }

    public static void main(String[] args) {
        FindKthLargest fk = new FindKthLargest();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        int n = fk.findKthLargest(nums, k);
        System.out.println(n);

        nums = new int[]{2, 1};
        k = 2;
        n = fk.findKthLargest(nums, k);
        System.out.println(n);

        nums = new int[]{3, 1, 2, 4};
        k = 2;
        n = fk.findKthLargest(nums, k);
        System.out.println(n);
    }
}
