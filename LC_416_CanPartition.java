/**
 * 【分割等和子集】
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class LC_416_CanPartition {

    // 动态规划
    public boolean canPartition(int[] nums) {
        // 状态转移方程：
        // 初始条件：
        // 边界条件：递推终止的条件.
        // 状态和状态变量：
        // 是否具备最优子结构：有
        // 动态规划问题存在「重叠子问题」.需要使用「备忘录」或者「DP table」来优化穷举过程，避免不必要的计算。

        int s = 0;
        for (int num : nums) {
            s += num;
        }
        if (s % 2 != 0) {
            return false;
        }
        s /= 2;
        int n = nums.length;
        boolean[][] f = new boolean[n + 1][s + 1];
        f[0][0] = true;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = 0; j <= s; j++) {
                f[i + 1][j] = j >= x && f[i][j - x] || f[i][j];
            }
        }
        return f[n][s];
    }

    public static void main(String[] args) {
        LC_416_CanPartition cp = new LC_416_CanPartition();
        int[] nums = new int[]{1, 5, 11, 5};
        boolean flag = cp.canPartition(nums);
        System.out.println(flag);

        nums = new int[]{1, 2, 3, 5};
        flag = cp.canPartition(nums);
        System.out.println(flag);

        nums = new int[]{3, 3, 3, 4, 5};
        flag = cp.canPartition(nums);
        System.out.println(flag);
    }
}
