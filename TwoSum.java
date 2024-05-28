import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两数之和
 */
public class TwoSum {

    // 数组、哈希
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dic = new HashMap<>();
        List<Integer> idx = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int d = target - nums[i];
            if (!dic.containsKey(nums[i])) {
                dic.put(d, i);
            } else {
                int id = dic.get(nums[i]);
                idx.add(id);
                idx.add(i);
            }
        }

        int[] res = new int[idx.size()];
        for (int i = 0; i < idx.size(); i++) {
            res[i] = idx.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4};
        int target = 4;
        int[] res = TwoSum.twoSum(nums, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
