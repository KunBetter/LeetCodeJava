import java.util.*;

/**
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */

/**
 * 回溯法（back tracking）（探索与回溯法）是一种选优搜索法，又称为试探法，按选优条件向前搜索，
 * 以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，
 * 这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。
 * <p>
 * 深度优先遍历
 * <p>
 * 回溯算法说白了就是穷举法。不过回溯算法使用剪枝函数，
 * 剪去一些不可能到达 最终状态（即答案状态）的节点，从而减少状态空间树节点的生成。
 * <p>
 * 三个要素：选择 (Options)，限制 (Restraints)，结束条件 (Termination)。
 */
public class GenerateParenthesis {

    // 字符串
    // 动态规划
    // 回溯
    List<String> list = new ArrayList();

    /**
     * 每次选一个括号，要么选左，要么选右
     * 可以画出一颗二叉树
     * 答案就在叶子节点上
     * <p>
     * 终止条件：用完左括号&&用完右括号
     * 剪枝：左括号用的比右括号多，肯定不满足
     */

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return list;
    }

    public void dfs(int leftCount, int rightCount, String res) {
        // 左括号用的比右括号多，剪枝
        if (rightCount < leftCount) {
            return;
        }
        // 终止条件
        if (leftCount == 0 && rightCount == 0) {
            list.add(res);
            return;
        }
        if (leftCount != 0) {
            dfs(leftCount - 1, rightCount, res + "(");
        }
        if (rightCount != 0) {
            dfs(leftCount, rightCount - 1, res + ")");
        }
    }

    public List<String> generateParenthesis2(int n) {
        if (n == 1) {
            return Collections.singletonList("()");
        }
        HashSet<String> set = new HashSet<>();
        for (String str : generateParenthesis2(n - 1)) {
            for (int i = 0; i <= str.length() / 2; i++) {
                set.add(str.substring(0, i) + "()" + str.substring(i));
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        int n = 3;
        List<String> res = gp.generateParenthesis2(n);
        System.out.println(res);
    }
}
