package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【组合总和】
 * 给你一个无重复元素的整数数组candidates和一个目标整数target，
 * 找出candidates中可以使数字和为目标数target的所有不同组合 ，
 * 并以列表形式返回。你可以按任意顺序返回这些组合。
 * candidates中的同一个数字可以无限制重复被选取。如果至少一个数字的被选数量不同，则两种组合是不同的。
 */
public class LC_39_CombinationSum {

    // 数组
    // 回溯
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> state = new ArrayList<>(); // 状态（子集）
        Arrays.sort(candidates); // 对 candidates 进行排序
        int start = 0; // 遍历起始点
        List<List<Integer>> res = new ArrayList<>(); // 结果列表（子集列表）
        backtrack(state, target, candidates, start, res);
        return res;
    }

    void backtrack(List<Integer> state, int target, int[] choices, int start, List<List<Integer>> res) {
        // 子集和等于 target 时，记录解
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有选择
        // 剪枝二：从 start 开始遍历，避免生成重复子集
        for (int i = start; i < choices.length; i++) {
            // 剪枝一：若子集和超过 target ，则直接结束循环
            // 这是因为数组已排序，后边元素更大，子集和一定超过 target
            if (target - choices[i] < 0) {
                break;
            }
            // 尝试：做出选择，更新 target, start
            state.add(choices[i]);
            // 进行下一轮选择
            backtrack(state, target - choices[i], choices, i, res);
            // 回退：撤销选择，恢复到之前的状态
            state.remove(state.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC_39_CombinationSum cs = new LC_39_CombinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ans = cs.combinationSum(candidates, target);
        System.out.println(ans);

        candidates = new int[]{2, 3, 5};
        target = 8;
        ans = cs.combinationSum(candidates, target);
        System.out.println(ans);
    }
}
