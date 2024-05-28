import java.util.Arrays;

/**
 * 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class RotateArray {

    // 数组
    // 数学
    // 双指针
    public void rotate(int[] nums, int k) {
        if (k <= 0 || nums.length <= 1) {
            return;
        }
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int curNum = nums[start];
            do {
                int next = (current + k) % n;
                int nextNum = nums[next];

                nums[next] = curNum;

                current = next;
                curNum = nextNum;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    // 最优解法
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        ra.rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{-1, -100, 3, 99};
        k = 2;
        ra.rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1};
        k = 1;
        ra.rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2};
        k = 1;
        ra.rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2, 3, 4, 5, 6};
        k = 3;
        ra.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
