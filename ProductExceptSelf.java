import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 */
public class ProductExceptSelf {

    // 数组
    // 前缀和
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        // 🔥核心思路：分别计算元素左侧的元素乘积、右侧元素的乘积，再相乘得出最终结果

        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        ProductExceptSelf pes = new ProductExceptSelf();
        int[] nums = new int[]{1, 2, 3, 4};
        int[] res = pes.productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }
}
