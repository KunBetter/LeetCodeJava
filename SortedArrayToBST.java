/**
 * 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵平衡二叉搜索树。
 */
public class SortedArrayToBST {

    // 树
    // 二叉搜索树
    // 数组
    // 分治
    // 二叉树
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = (s + e) / 2;

        TreeNode node = new TreeNode(nums[mid], null, null);

        if (s != e) {
            node.left = sortedArrayToBST(nums, s, mid - 1);
            node.right = sortedArrayToBST(nums, mid + 1, e);
        }

        return node;
    }

    public static void main(String[] args) {
    }
}
