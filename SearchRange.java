import java.util.Arrays;

/**
 * 【在排序数组中查找元素的第一个和最后一个位置】
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class SearchRange {

    // 二分查找
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                ans[0] = mid;
                // 继续往左边找
                e = mid - 1;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        s = 0;
        e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                ans[1] = mid;
                // 继续往右边找
                s = mid + 1;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SearchRange sr = new SearchRange();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] index = sr.searchRange(nums, target);
        System.out.println(Arrays.toString(index));

        target = 6;
        index = sr.searchRange(nums, target);
        System.out.println(Arrays.toString(index));
    }
}
