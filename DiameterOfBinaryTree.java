/**
 * 二叉树的直径
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class DiameterOfBinaryTree {

    // 树
    // 深度优先搜索
    // 二叉树
    public int diameterOfBinaryTree(TreeNode root) {
        return innerOp(root);
    }

    private int innerOp(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftD = innerOp(root.left);
        int rightD = innerOp(root.right);

        // 经过root
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        return Math.max(Math.max(leftD, rightD), leftMaxDepth + rightMaxDepth);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    public static void main(String[] args) {
    }
}
