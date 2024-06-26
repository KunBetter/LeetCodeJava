/**
 * 【二叉搜索树中第K小的元素】
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
 * 请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class KThSmallest {

    int index = 0;
    int res = -1;

    // 深度优先搜索
    // 二叉搜索树
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        index++;
        if (index == k) {
            res = root.val;
        }
        dfs(root.right, k);
    }
}
