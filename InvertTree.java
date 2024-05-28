/**
 * 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class InvertTree {

    // 树
    // 深度优先搜索
    // 广度优先搜索
    // 二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertOp(root);
        return root;
    }

    private void invertOp(TreeNode parent) {
        if (parent == null) {
            return;
        }

        if (parent.left == null && parent.right == null) {
            return;
        }

        if (parent.left == null) {
            parent.left = parent.right;
            parent.right = null;
        } else if (parent.right == null) {
            parent.right = parent.left;
            parent.left = null;
        } else {
            TreeNode tmp = parent.left;
            parent.left = parent.right;
            parent.right = tmp;
        }

        invertOp(parent.left);
        invertOp(parent.right);
    }

    public static void main(String[] args) {
    }
}
