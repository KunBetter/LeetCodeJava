import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class ThreeSum {

    // 数组、双指针、排序
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            // 当 nums[k] > 0 时直接break跳出：因为 nums[j] >= nums[i] >= nums[k] > 0，
            // 即 3 个元素都大于 0 ，在此固定指针 k 之后不可能再找到结果了。
            if (nums[k] > 0) {
                break;
            }
            // 当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：
            // 因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            // i，j 分设在数组索引(k,len(nums))两端
            int i = k + 1, j = nums.length - 1;
            // 当i < j时循环计算s = nums[k] + nums[i] + nums[j]，并按照以下规则执行双指针移动：
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    // 当s < 0时，i += 1并跳过所有重复的nums[i]
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    // 当s > 0时，j -= 1并跳过所有重复的nums[j]
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    // 当s == 0时，记录组合[k, i, j]至res，
                    // 执行i += 1和j -= 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> idx = ts.threeSum(nums);
        System.out.println(idx);

        nums = new int[]{0, 1, 1};
        idx = ts.threeSum(nums);
        System.out.println(idx);

        nums = new int[]{0, 0, 0};
        idx = ts.threeSum(nums);
        System.out.println(idx);
    }
}
