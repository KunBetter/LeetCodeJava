import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class InOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 栈
    // 树
    // 深度优先搜索
    // 二叉树
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        inner(root, res);

        return res;
    }

    public void inner(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inner(node.left, res);
        res.add(node.val);
        inner(node.right, res);
    }

    public static void main(String[] args) {
    }
}
