/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SearchInsert {

    // 数组
    // 二分查找
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int s = 0, e = n - 1;
        int ans = n;
        while (s <= e) {
            int mid = (s + e) / 2;
            // nums[pos−1] < target ≤ nums[pos]
            // 🔥在一个有序数组中找第一个大于等于 target的下标
            if (target <= nums[mid]) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SearchInsert si = new SearchInsert();
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;
        int pos = si.searchInsert(nums, target);
        System.out.println(pos);

        nums = new int[]{1, 3, 5, 6};
        target = 2;
        pos = si.searchInsert(nums, target);
        System.out.println(pos);

        nums = new int[]{1, 3, 5, 6};
        target = 7;
        pos = si.searchInsert(nums, target);
        System.out.println(pos);
    }
}
