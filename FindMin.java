/**
 * 【寻找旋转排序数组栈的最小值】
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class FindMin {

    // 二分查找
    public int findMin(int[] nums) {
        /*
         * 第一种情况是 nums[pivot]<nums[high]。说明 nums[pivot]是最小值右侧的元素，因此我们可以忽略二分查找区间的右半部分。
         * 第二种情况是 nums[pivot]>nums[high]。说明 nums[pivot]是最小值左侧的元素，因此我们可以忽略二分查找区间的左半部分。
         * 由于数组不包含重复元素，并且只要当前的区间长度不为1，pivot就不会与high重合；而如果当前的区间长度为1，这说明我们已经可以结束二分查找了。
         * 因此不会存在 nums[pivot]=nums[high]的情况。
         * 当二分查找结束时，我们就得到了最小值所在的位置。
         */
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int m = (s + e) / 2;
            if (nums[m] < nums[e]) {
                e = m;
            } else if (nums[m] > nums[e]) {
                s = m + 1;
            }
        }

        return nums[s];
    }

    public static void main(String[] args) {
        FindMin fm = new FindMin();
        int[] nums = new int[]{3, 4, 5, 1, 2};
        int m = fm.findMin(nums);
        System.out.println(m);
    }
}
