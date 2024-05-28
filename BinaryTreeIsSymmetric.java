/**
 * 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class BinaryTreeIsSymmetric {

    // 树
    // 深度优先搜索
    // 广度优先搜索
    // 二叉树
    public boolean isSymmetric(TreeNode root) {
        return root == null || travel(root.left, root.right);
    }

    private boolean travel(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return travel(left.left, right.right) && travel(left.right, right.left);
    }

    public static void main(String[] args) {
    }
}
