import java.util.Arrays;

/**
 * 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class LengthOfLIS {

    // 数组
    // 二分查找
    // 动态规划
    public int lengthOfLIS(int[] nums) {
        // 状态转移方程：
        // 初始条件：
        // 边界条件：递推终止的条件.
        // 状态和状态变量
        // 是否具备最优子结构
        // 动态规划问题存在「重叠子问题」.需要使用「备忘录」或者「DP table」来优化穷举过程，避免不必要的计算。

        /*
         * 状态定义：
         *
         * dp[i]的值代表 nums 以 nums[i]结尾的最长子序列长度。
         * 转移方程： 设 j∈[0,i)，考虑每轮计算新 dp[i]时，遍历 [0,i)列表区间，做以下判断：
         *
         * 当 nums[i]>nums[j] 时： nums[i]可以接在 nums[j] 之后（此题要求严格递增），此情况下最长上升子序列长度为 dp[j]+1 ；
         * 当 nums[i]<=nums[j] 时： nums[i]无法接在 nums[j]之后，此情况上升子序列不成立，跳过。
         * 上述所有 1. 情况 下计算出的 dp[j]+1 的最大值，为直到 i 的最长上升子序列长度（即 dp[i]）。实现方式为遍历 j 时，每轮执行 dp[i]=max(dp[i],dp[j]+1)。
         * 转移方程： dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)。
         * 初始状态：
         *
         * dp[i] 所有元素置 1，含义是每个元素都至少可以单独成为子序列，此时长度都为 1。
         * 返回值：
         *
         * 返回 dp 列表最大值，即可得到全局最长上升子序列长度。
         * 复杂度分析：
         * 时间复杂度 O(N^2)
         * 空间复杂度 O(N)
         *
         */
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        LengthOfLIS ll = new LengthOfLIS();
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int len = ll.lengthOfLIS(nums);
        System.out.println(len);

        nums = new int[]{4, 10, 4, 3, 8, 9};
        len = ll.lengthOfLIS(nums);
        System.out.println(len);
    }
}
