import java.util.Arrays;

/**
 * 移动零
 */
public class MoveZeroes {

    // 必须在不复制数组的情况下原地对数组进行操作
    // 双指针、数组
    public void moveZeroes(int[] nums) {
        // 两个游标，一个指向最左侧的0，一个指向第一个非0的数字，两个进行交互
        int left = 0;
        int right = 0;
        while (true) {
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            while (left < nums.length && nums[left] != 0) {
                left++;
            }
            if (right == nums.length || left == nums.length) {
                break;
            }
            // 1、0、1的情况处理，不用交换，right下标往前移动，继续
            if (right < left) {
                right++;
                continue;
            }
            // swap
            // 退出机制
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        mz.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 0};
        mz.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 0, 1};
        mz.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
