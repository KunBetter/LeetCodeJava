/**
 * 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class CanJump {

    // 贪心
    // 数组
    // 动态规划
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        if (nums[0] <= 0) {
            return false;
        }
        // 状态转移方程：当前节点最远能跳的步数 = MAX(当前节点可跳步数, 前一个节点最远能跳的步数-1)
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            if (dp[i] <= 0 && i < nums.length - 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CanJump cj = new CanJump();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        boolean flag = cj.canJump(nums);
        System.out.println(flag);

        nums = new int[]{3, 2, 1, 0, 4};
        flag = cj.canJump(nums);
        System.out.println(flag);

        nums = new int[]{2, 0, 0};
        flag = cj.canJump(nums);
        System.out.println(flag);
    }
}
