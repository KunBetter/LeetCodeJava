/**
 * 【从前序、中序遍历序列构造二叉树】
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class BuildBinaryTree {

    // 树
    // 数组
    // 哈希表
    // 分治
    // 二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        return innerBuild(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode innerBuild(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[ps]);

        int rootIndex = -1;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == preorder[ps]) {
                rootIndex = i;
                break;
            }
        }

        if (rootIndex == -1) {
            return null;
        }

        node.left = innerBuild(preorder, ps + 1, ps + rootIndex - is, inorder, is, rootIndex - 1);
        node.right = innerBuild(preorder, ps + rootIndex - is + 1, pe, inorder, rootIndex + 1, ie);

        return node;
    }

    public static void main(String[] args) {
        BuildBinaryTree bt = new BuildBinaryTree();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = bt.buildTree(preorder, inorder);
        System.out.println(root.val);
    }
}
