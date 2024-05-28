/**
 * 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class FirstMissingPositive {

    // 数组
    // 哈希表
    public int firstMissingPositive(int[] nums) {
        // 🔥鸽巢原理
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        int[] nums = new int[]{1, 2, 0};
        int p = fmp.firstMissingPositive(nums);
        System.out.println(p);

        nums = new int[]{3, 4, -1, 1};
        p = fmp.firstMissingPositive(nums);
        System.out.println(p);

        nums = new int[]{7, 8, 9, 11, 12};
        p = fmp.firstMissingPositive(nums);
        System.out.println(p);
    }
}
