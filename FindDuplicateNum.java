/**
 * 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class FindDuplicateNum {

    // 位运算
    // 数组
    // 双指针
    // 二分查找
    public int findDuplicate(int[] nums) {
        // 二分查找
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindDuplicateNum fd = new FindDuplicateNum();
        int[] nums = new int[]{1, 3, 4, 2, 2};
        int n = fd.findDuplicate(nums);
        System.out.println(n);
    }
}
