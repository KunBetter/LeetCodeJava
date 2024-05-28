/**
 * 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityElement {

    // 数组
    // 哈希表
    // 分治
    // 计数
    // 排序
    public int majorityElement(int[] nums) {
        // 摩尔投票法： 核心理念为 票数正负抵消 。此方法时间和空间复杂度分别为 O(N) 和 O(1) ，为本题的最佳解法。
        int cnt = 0;
        int candidate = 0;
        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
            }

            if (num == candidate) {
                cnt++;
            } else {
                cnt--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = new int[]{3, 2, 3};
        int num = me.majorityElement(nums);
        System.out.println(num);

        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        num = me.majorityElement(nums);
        System.out.println(num);
    }
}
