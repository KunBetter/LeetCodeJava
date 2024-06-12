/**
 * 【打家劫舍】
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，
 * 一夜之内能够偷窃到的最高金额。
 */
public class Rob {

    // 动态规划
    public int rob(int[] nums) {
        // 状态转移方程：dp[i] = max{dp[i-2]+nums[i],dp[i-1]}
        // 初始条件：dp[0] = nums[0],dp[1] = max{nums[0],nums[1]}
        // 边界条件：递推终止的条件.
        // 状态和状态变量：
        // 是否具备最优子结构：有
        // 动态规划问题存在「重叠子问题」.需要使用「备忘录」或者「DP table」来优化穷举过程，避免不必要的计算。

        /*
         * 如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？对于第 k(k>2)间房屋，有两个选项：
         * 1、偷窃第k间房屋，那么就不能偷窃第k−1间房屋，偷窃总金额为前k−2间房屋的最高总金额与第k间房屋的金额之和。
         * 2、不偷窃第k间房屋，偷窃总金额为前k−1间房屋的最高总金额。
         * 在两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额即为前k间房屋能偷窃到的最高总金额。
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Rob r = new Rob();
        int[] nums = new int[]{1, 2, 3, 1};
        int cnt = r.rob(nums);
        System.out.println(cnt);

        nums = new int[]{2, 7, 9, 3, 1};
        cnt = r.rob(nums);
        System.out.println(cnt);
    }
}
