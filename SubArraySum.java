import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 */
public class SubArraySum {

    // 数组、哈希表、前缀和
    public int subArraySum(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int preSum = 0;
        int count = 0;

        for (int num : nums) {
            preSum += num;

            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }

            map.merge(preSum, 1, Integer::sum);
        }

        return count;
    }

    public static void main(String[] args) {
        SubArraySum sas = new SubArraySum();
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        int cnt = sas.subArraySum(nums, k);
        System.out.println(cnt);

        nums = new int[]{1, 2, 3};
        k = 3;
        cnt = sas.subArraySum(nums, k);
        System.out.println(cnt);

        nums = new int[]{1};
        k = 0;
        cnt = sas.subArraySum(nums, k);
        System.out.println(cnt);

        nums = new int[]{-1, -1, 1};
        k = 0;
        cnt = sas.subArraySum(nums, k);
        System.out.println(cnt);
    }
}
