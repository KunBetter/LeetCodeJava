/**
 * 【二叉树中的最大路径和】
 * <p>
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class MaxPathSum {

    int ans = Integer.MIN_VALUE;

    // 深度优先搜索
    // 动态规划
    // 二叉树
    public int maxPathSum(TreeNode root) {
        passedNode(root);
        return ans;
    }

    private int passedNode(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int leftMax = passedNode(head.left);
        int rightMax = passedNode(head.right);
        int fullMax = leftMax + head.val + rightMax;
        ans = Math.max(ans, fullMax);
        return Math.max(Math.max(leftMax, rightMax) + head.val, 0);
    }
}
