/**
 * 跳跃游戏II
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */
public class JumpGame2 {

    // 贪心
    // 数组
    // 动态规划
    public int jump(int[] nums) {
        // 状态转移方程：
        // 初始条件：
        // 边界条件：递推终止的条件.
        // 状态和状态变量：
        // 是否具备最优子结构
        // 动态规划问题存在「重叠子问题」.需要使用「备忘录」或者「DP table」来优化穷举过程，避免不必要的计算。
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        JumpGame2 jg = new JumpGame2();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        int cnt = jg.jump(nums);
        System.out.println(cnt);

        nums = new int[]{2, 1};
        cnt = jg.jump(nums);
        System.out.println(cnt);

        nums = new int[]{2, 3, 1};
        cnt = jg.jump(nums);
        System.out.println(cnt);

        nums = new int[]{1, 2, 3};
        cnt = jg.jump(nums);
        System.out.println(cnt);

        nums = new int[]{1, 2, 1, 1, 1};
        cnt = jg.jump(nums);
        System.out.println(cnt);
    }
}
