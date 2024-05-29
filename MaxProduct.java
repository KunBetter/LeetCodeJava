/**
 * 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class MaxProduct {

    // 动态规划
    public int maxProduct(int[] nums) {
        // 状态转移方程：
        // 初始条件：
        // 边界条件：递推终止的条件.
        // 状态和状态变量：
        // 是否具备最优子结构：
        // 动态规划问题存在「重叠子问题」.需要使用「备忘录」或者「DP table」来优化穷举过程，避免不必要的计算。

        // 不要想着一次循环就能解决问题

        /*
        标签：动态规划
        遍历数组时计算当前最大值，不断更新
        令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
        由于存在负数，那么会导致最大的变最小的，最小的变最大的。
        因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
        当负数出现时则imax与imin进行交换再进行下一步计算
         */

        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(max, imax);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxProduct mp = new MaxProduct();
        int[] nums = new int[]{2, 3, -2, 4};
        int res = mp.maxProduct(nums);
        System.out.println(res);

        nums = new int[]{2, 3, -2, 4, 5};
        res = mp.maxProduct(nums);
        System.out.println(res);

        nums = new int[]{-2, 0, -1};
        res = mp.maxProduct(nums);
        System.out.println(res);

        nums = new int[]{-2, 3, -4};
        res = mp.maxProduct(nums);
        System.out.println(res);
    }
}
