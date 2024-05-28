import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class BinaryTreeLevelOrder {

    // 树
    // 广度优先搜索
    // 二叉树
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> orders = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.addLast(root);

        while (!deque.isEmpty()) {
            List<Integer> ids = new ArrayList<>();
            List<TreeNode> treeNodes = new ArrayList<>();
            while (!deque.isEmpty()) {
                TreeNode first = deque.pollFirst();
                ids.add(first.val);
                if (first.left != null) {
                    treeNodes.add(first.left);
                }
                if (first.right != null) {
                    treeNodes.add(first.right);
                }
            }
            if (!ids.isEmpty()) {
                orders.add(ids);
            }
            for (TreeNode tn : treeNodes) {
                deque.addLast(tn);
            }
        }

        return orders;
    }

    public static void main(String[] args) {
    }
}
