import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 【全排列】
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permute {

    /*
     * 可以看作有 n 个排列成一行的空格，我们需要从左往右依此填入题目给定的 n 个数，
     * 每个数只能使用一次。那么很直接的可以想到一种穷举的算法，即从左往右每一个位置都依此尝试填入一个数，
     * 看能不能填完这 n 个空格，在程序中我们可以用「回溯法」来模拟这个过程。
     *
     * 假设我们已经填到第 first个位置，那么 nums数组中 [0,first−1]是已填过的数的集合，
     * [first,n−1]是待填的数的集合。我们肯定是尝试用 [first,n−1]里的数去填第 first个数，假设待填的数的下标为 i，
     * 那么填完以后我们将第 i 个数和第 first个数交换，即能使得在填第 first+1个数的时候 nums数组的 [0,first]部分为已填过的数，
     * [first+1,n−1]为待填的数，回溯的时候交换回来即能完成撤销操作。
     *
     * 举个简单的例子，假设我们有 [2,5,8,9,10]这 5 个数要填入，已经填到第 3 个位置，已经填了 [8,9]两个数，
     * 那么这个数组目前为 [8,9|2,5,10]这样的状态，分隔符区分了左右两个部分。
     * 假设这个位置我们要填 10这个数，为了维护数组，我们将 2 和 10 交换，即能使得数组继续保持分隔符左边的数已经填过，
     * 右边的待填 [8,9,10∣2,5] 。
     */

    // 回溯
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);

        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public static void main(String[] args) {
        Permute p = new Permute();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = p.permute(nums);
        System.out.println(res);
    }
}
