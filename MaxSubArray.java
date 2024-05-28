/**
 * 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray {

    // 数组
    // 分治
    // 动态规划
    public int maxSubArray(int[] nums) {
        int total = nums[0];
        int preNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (preNum < 0) {
                preNum = 0;
            }
            preNum += nums[i];
            total = Math.max(total, preNum);
        }

        return total;
    }

    public static void main(String[] args) {
        MaxSubArray msa = new MaxSubArray();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int total = msa.maxSubArray(nums);
        System.out.println(total);

        nums = new int[]{-1};
        total = msa.maxSubArray(nums);
        System.out.println(total);

        nums = new int[]{5, 4, -1, 7, 8};
        total = msa.maxSubArray(nums);
        System.out.println(total);

        nums = new int[]{-2, 1};
        total = msa.maxSubArray(nums);
        System.out.println(total);
    }
}
