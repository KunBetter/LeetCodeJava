import java.util.ArrayList;
import java.util.List;

/**
 * 【子集】
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class LC_78_SubSets {

    // 位运算
    // 数组
    // 回溯
    public List<List<Integer>> subsets(int[] nums) {
        // 可以直接从前往后遍历，遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC_78_SubSets ss = new LC_78_SubSets();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ans = ss.subsets(nums);
        System.out.println(ans);
    }
}
